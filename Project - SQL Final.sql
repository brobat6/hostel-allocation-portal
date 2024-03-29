DROP DATABASE IF EXISTS campus;

CREATE DATABASE campus;
USE campus;

CREATE TABLE student (
	student_ID 			CHAR(13) 		PRIMARY KEY,
    student_name 		VARCHAR(50) 	NOT NULL,
    gender				CHAR(1)			NOT NULL		CHECK (gender IN ("M", "F")),
    email_ID 			VARCHAR(40)		UNIQUE, 
    phone_no 			CHAR(10)		UNIQUE,
    pwd					VARCHAR(40)		NOT NULL
);
CREATE TABLE hostel (
	hostel_id			CHAR(2)			PRIMARY KEY,
    hostel_name			VARCHAR(30)		NOT NULL UNIQUE,
    hostel_type			CHAR(1)			NOT NULL		CHECK (hostel_type IN ("M", "F")),
    single_rooms		INT UNSIGNED	DEFAULT '0' NOT NULL,
    double_rooms		INT UNSIGNED	DEFAULT '0' NOT NULL
);
CREATE TABLE wing (
	leader_id			CHAR(13)		PRIMARY KEY		REFERENCES student,
    size				INT UNSIGNED	NOT NULL,
    room_type			CHAR(1)			NOT NULL		CHECK (room_type IN ("S", "D")),
    wing_code			VARCHAR(50)		UNIQUE NOT NULL
);
CREATE TABLE wing_hostel (
	leader_id			CHAR(13) 		UNIQUE		REFERENCES wing,
    preferred_hostel	CHAR(2)						REFERENCES hostel,
	PRIMARY KEY(leader_id, preferred_hostel)
);
CREATE TABLE room (
	hostel_id			CHAR(2)						REFERENCES hostel,
    room_no				INT UNSIGNED,
    capacity			INT UNSIGNED	NOT NULL	CHECK(capacity IN (1, 2)),
    PRIMARY KEY(hostel_id, room_no)
);
CREATE TABLE lives_in (
	student_id			CHAR(13) 		PRIMARY KEY		REFERENCES student,
    hostel_id			CHAR(2),
    room_no				INT UNSIGNED,
    FOREIGN KEY(hostel_id, room_no) REFERENCES room(hostel_id, room_no)
);
CREATE TABLE member_of (
	student_id			CHAR(13) 		PRIMARY KEY		REFERENCES student,
    leader_id			CHAR(13)		REFERENCES wing
);

DROP PROCEDURE IF EXISTS update_phone_number;
DELIMITER $$
CREATE PROCEDURE update_phone_number(IN q_id CHAR(13), IN q_ph CHAR(10))
	MODIFIES SQL DATA
BEGIN
	UPDATE student SET phone_no = q_ph WHERE student_id = q_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS update_email_id;
DELIMITER $$
CREATE PROCEDURE update_email_id(IN q_id CHAR(13), IN q_email VARCHAR(40))
	MODIFIES SQL DATA
BEGIN
	UPDATE student SET email_ID = q_email WHERE student_id = q_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS create_new_wing;
DELIMITER $$
CREATE PROCEDURE create_new_wing(IN q_id CHAR(13), IN q_type CHAR(1), IN q_code VARCHAR(50))
	COMMENT "Creates a new wing with q_id as wing leader, assuming the student is not in any other wing."
BEGIN
	IF(q_id NOT IN (SELECT student_id FROM student)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student record not found!';
	ELSEIF(q_type NOT IN ("S", "D")) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Invalid wing type, enter S or D only!';
	ELSEIF(q_id IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are already a wing leader!';
	ELSEIF(q_id IN (SELECT student_id FROM member_of)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You are already in a wing!';
	ELSEIF(q_code IN (SELECT wing_code FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Please enter another wing code, this one already exists for another wing!';
	ELSE
		INSERT INTO wing VALUES (q_id, 1, q_type, q_code);
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS join_wing;
DELIMITER $$
CREATE PROCEDURE join_wing(IN q_code VARCHAR(50), IN q_member CHAR(13))
	COMMENT "Join a wing using unique wing code, assuming the student is not part of any other wing."
BEGIN
	IF(q_member NOT IN (SELECT student_id FROM student)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student records not found!';
	ELSEIF(q_member IN (SELECT student_id FROM member_of) OR q_member IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student is already in a wing!';
	ELSEIF(q_code NOT IN (SELECT wing_code FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Wing does not exist!';
	ELSEIF((SELECT gender FROM student WHERE student_id = (SELECT leader_id FROM wing WHERE wing_code = q_code)) != (SELECT gender FROM student WHERE student_id = q_member)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'You cannot join wing of opposite gender!';
	ELSE
		SET @temp = (SELECT size FROM wing WHERE wing_code = q_code);
        SET @temp = @temp + 1;
        SET @wing_type = (SELECT room_type FROM wing WHERE wing_code = q_code);
        IF((@wing_type = "D" AND @temp > 12) OR (@wing_type = "S" AND @temp > 6)) THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Maximum wing size reached!';
        ELSE 
			INSERT INTO member_of VALUES (q_member, (SELECT leader_id FROM wing WHERE wing_code = q_code));
			UPDATE wing SET size = @temp WHERE wing_code = q_code;
		END IF;
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS add_preferred_hostel;
DELIMITER $$
CREATE PROCEDURE add_preferred_hostel(IN q_id CHAR(13), IN q_hostel CHAR(2))
	COMMENT "Adds a preferred hostel to wing only if the query is called by wing leader, and the hostel is of the same type (boys/girls)"
BEGIN
	IF(q_id NOT IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Only wing leaders can add preferred hostels!';
	ELSEIF(q_hostel NOT IN (SELECT hostel_id FROM hostel)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Hostel does not exist!';
	ELSEIF((SELECT COUNT(preferred_hostel) FROM wing_hostel WHERE leader_id = q_id AND preferred_hostel = q_hostel) > 0) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Hostel has already been added!';
    ELSEIF((SELECT gender FROM student WHERE student_id = q_id) != (SELECT hostel_type FROM hostel WHERE hostel_id = q_hostel)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Please enter only valid hostels of the same gender!';
	ELSE
		INSERT INTO wing_hostel VALUES (q_id, q_hostel);
	END IF;
END$$
DELIMITER ;


    
DROP PROCEDURE IF EXISTS add_wing_member;
DELIMITER $$
CREATE PROCEDURE add_wing_member(IN q_leader CHAR(13), IN q_member CHAR(13))
	COMMENT "Add a member to a wing, provided the student is not a member or leader of any other wing" 
BEGIN
	IF(q_leader NOT IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Wing does not exist!';
	ELSEIF(q_member IN (SELECT student_id FROM member_of) OR q_member IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student is already in a wing!';
	ELSEIF((SELECT gender FROM student WHERE student_id = q_leader) != (SELECT gender FROM student WHERE student_id = q_member)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot add members of different gender!';
	ELSE 
        SET @temp = (SELECT size FROM wing WHERE leader_id = q_leader);
        SET @temp = @temp + 1;
        SET @wing_type = (SELECT room_type FROM wing WHERE leader_id = q_leader);
        IF((@wing_type = "D" AND @temp > 8) OR (@wing_type = "S" AND @temp > 4)) THEN
			SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Maximum wing size reached!';
        ELSE 
			INSERT INTO member_of VALUES (q_member, q_leader);
			UPDATE wing SET size = @temp WHERE leader_id = q_leader;
		END IF;
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS change_wing_type;
DELIMITER $$
CREATE PROCEDURE change_wing_type(IN q_leader CHAR(13), IN q_type CHAR(1))
	COMMENT "Change wing type from S (Single) to D (Double), or vice-versa." 
BEGIN
	IF(q_leader NOT IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Wing does not exist!';
	ELSEIF(q_type NOT IN ("S", "D")) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Not a valid wing type!';
	ELSEIF(q_type = "S" AND (SELECT size FROM wing WHERE leader_id = q_leader) > 6) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Wing exceeds maximum wing size for single rooms!';
	ELSE
		UPDATE wing SET room_type = q_type WHERE leader_id = q_leader;
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS allot_room;
DELIMITER $$
CREATE PROCEDURE allot_room(IN q_id CHAR(13), IN q_hostel CHAR(2), IN q_room INT UNSIGNED)
	COMMENT "Allot a room in given hostel to a student"
BEGIN
	IF(q_id NOT IN (SELECT student_id FROM student)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student Records not found!';
	ELSEIF((SELECT hostel_id FROM room WHERE hostel_id = q_hostel AND room_no = q_room) IS NULL) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The given room does not exist!';
	ELSEIF((SELECT student_id FROM lives_in WHERE student_id = q_id) IS NOT NULL) THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student has already been allocated a room!';
	ELSEIF((SELECT student_id FROM lives_in WHERE hostel_id = q_hostel AND room_no = q_room) IS NULL) THEN
		INSERT INTO lives_in VALUES(q_id, q_hostel, q_room);
	ELSEIF((SELECT capacity FROM room WHERE hostel_id = q_hostel AND room_no = q_room) = (SELECT COUNT(student_id) FROM lives_in WHERE hostel_id = q_hostel AND room_no = q_room)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot allocate any more students in given room!';
	ELSE
		INSERT INTO lives_in VALUES(q_id, q_hostel, q_room);
	END IF;
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS swap_rooms;
DELIMITER $$
CREATE PROCEDURE swap_rooms(IN s1 CHAR(13), IN s2 CHAR(13))
	COMMENT "Swap the room numbers of students s1 and s2 after they have been alloted rooms, but only if they are in the same hostel."
BEGIN
	IF(s1 NOT IN (SELECT student_id FROM lives_in) OR s2 NOT IN (SELECT student_id FROM lives_in)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'One or more student(s) have not been alloted rooms yet!';
	ELSEIF((SELECT hostel_id FROM lives_in WHERE student_id = s1) = (SELECT hostel_id FROM lives_in WHERE student_id = s1)) THEN
		SET @room1 = (SELECT room_no FROM lives_in WHERE student_id = s1);
        SET @room2 = (SELECT room_no FROM lives_in WHERE student_id = s2);
        UPDATE lives_in SET room_no = @room2 WHERE student_id = s1;
        UPDATE lives_in SET room_no = @room1 WHERE student_id = s2;
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'The students are not in the same hostel!';
	END IF;
END$$
DELIMITER ;


DROP PROCEDURE IF EXISTS check_if_room_empty;
DELIMITER $$
CREATE PROCEDURE check_if_room_empty(IN q_hostel CHAR(2), IN q_room INT UNSIGNED, OUT result INT)
	COMMENT "Return 1 if the room is empty and 0 otherwise."
BEGIN
	IF((SELECT COUNT(student_id) FROM lives_in WHERE hostel_id = q_hostel AND room_no = q_room) = 0) THEN
		SELECT 1 INTO result;
	ELSE
		SELECT 0 INTO result;
	END IF;
END$$
DELIMITER ;

INSERT INTO student VALUES ("2020A7PS0001P","AISHWARYA SAM","F","f20200001@pilani.bits-pilani.ac.in", NULL, "abcd");
INSERT INTO student VALUES ("2020A7PS0084P","TANVEER SINGH","M","f20200084@pilani.bits-pilani.ac.in", NULL, "brobat");
INSERT INTO student VALUES ("a","UTKARSH","M","f20200981@pilani.bits-pilani.ac.in", NULL, "a");
INSERT INTO student VALUES ("2020A7PS0133P","MRIDUL CHANDAK","M","f20200133@pilani.bits-pilani.ac.in", NULL, "abcd");
INSERT INTO student VALUES ("2020A7PS0980P","MITHIL SHAH","M","f20200980@pilani.bits-pilani.ac.in", NULL, "abcd");
INSERT INTO student VALUES ("2020A7PS0983P","CHIRAG MAHESHWARI","M","f20200983@pilani.bits-pilani.ac.in", NULL, "abcd");
INSERT INTO student VALUES ("2020A7PS0075P","SHREYAS KETKAR","M","f20200075@pilani.bits-pilani.ac.in", NULL, "abcd");

INSERT INTO hostel VALUES("BD", "Budh Bhawan", "M", 60, 80);
INSERT INTO hostel VALUES("SK", "Shankar Bhawan", "M", 70, 110);
INSERT INTO hostel VALUES("MR", "Meera Bhawan", "F", 40, 70);

INSERT INTO room VALUES ("BD",2001,2);
INSERT INTO room VALUES ("BD",2002,2);
INSERT INTO room VALUES ("BD",2003,2);
INSERT INTO room VALUES ("BD",2004,2);
INSERT INTO room VALUES ("BD",1001,1);
INSERT INTO room VALUES ("BD",1002,1);
INSERT INTO room VALUES ("BD",1003,1);
INSERT INTO room VALUES ("BD",1004,1);
INSERT INTO room VALUES ("BD",1005,1);
INSERT INTO room VALUES ("SK",4001,2);
INSERT INTO room VALUES ("SK",4002,2);
INSERT INTO room VALUES ("SK",4003,2);
INSERT INTO room VALUES ("SK",4004,2);
INSERT INTO room VALUES ("SK",3001,1);
INSERT INTO room VALUES ("SK",3002,1);
INSERT INTO room VALUES ("SK",3003,1);
INSERT INTO room VALUES ("SK",3004,1);
INSERT INTO room VALUES ("SK",3005,1);
INSERT INTO room VALUES ("MR",201,2);
INSERT INTO room VALUES ("MR",202,2);
INSERT INTO room VALUES ("MR",101,1);
INSERT INTO room VALUES ("MR",102,1);


-- Queries for each procedure
/*
CALL update_phone_number("2020A7PS0084P", "8477002934");
CALL update_email_id("2020A7PS0084P", "ldrubra8@gmail.com");
CALL create_new_wing("2020A7PS0084P", "S", "sample-wing-001");
CALL add_preferred_hostel("2020A7PS0084P", "SK");
CALL add_wing_member("2020A7PS0084P", "2020A7PS0981P");
CALL change_wing_type("2020A7PS0084P", "S");
CALL allot_room("2020A7PS0981P", "SK", 3001);
CALL allot_room("2020A7PS0084P", "SK", 3002);
CALL swap_rooms("2020A7PS0084P", "2020A7PS0981P");
CALL check_if_room_empty("MR", 201, @res);
*/
CALL create_new_wing("2020A7PS0084P", "S", "sample-wing-001");
CALL add_preferred_hostel("2020A7PS0084P", "SK");
-- CALL add_wing_member("2020A7PS0084P", "2020A7PS0981P"); 
CALL join_wing("sample-wing-001", "a");
CALL create_new_wing("2020A7PS0075P", "D", "x");
CALL add_preferred_hostel("2020A7PS0075P", "BD");
CALL join_wing("x", "2020A7PS0983P");
CALL join_wing("x", "2020A7PS0133P");
CALL join_wing("x", "2020A7PS0980P");
select * from lives_in;
select * from wing;
