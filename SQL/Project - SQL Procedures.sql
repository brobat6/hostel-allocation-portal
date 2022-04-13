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
CREATE PROCEDURE create_new_wing(IN q_id CHAR(13))
	COMMENT "Creates a new wing with q_id as wing leader, assuming the student is not in any other wing."
BEGIN
	IF(q_id NOT IN (SELECT student_id FROM student)) THEN 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student record not found!';
	ELSEIF(q_id NOT IN (SELECT leader_id FROM wing) AND q_id NOT IN (SELECT student_id FROM member_of)) THEN
		INSERT INTO wing VALUES (q_id, "1", "S");
	ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student is already in another wing!';
	END IF;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS add_preferred_hostel;
DELIMITER $$
CREATE PROCEDURE add_preferred_hostel(IN q_id CHAR(13), IN q_hostel CHAR(2))
	COMMENT "Adds a preferred hostel to wing only if the query is called by wing leader, and the hostel is of the same type (boys/girls)"
BEGIN
	-- add additional if statement to do nothing for already existing entry!!!
	IF(q_id NOT IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Only wing leaders can add preferred hostels!';
	ELSEIF(q_hostel NOT IN (SELECT hostel_id FROM hostel)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Hostel does not exist!';
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
        IF((@wing_type = "D" AND @temp > 12) OR (@wing_type = "S" AND @temp > 6)) THEN
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

DROP PROCEDURE IF EXISTS master_allocator;
DELIMITER $$
CREATE PROCEDURE master_allocator()
    COMMENT "The procedure to call for hostel allocation. It will first try to allot sequential rooms 
    in preferred hostels for all wings. After that, it will try to allocate sequential rooms in random hostels 
	for all remaining wings. In the end, all students that are not in wings will be alloted random rooms." 
BEGIN
    
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

-- A procedure to SWAP two allocated rooms between members of the same wing.
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

-- Wing assumptions -> Single Room wing size is 4. Double room wing size is 6.
-- Check if room empty --> Hard code using 4 vairables
-- But, how to ALLOT rooms? How to get students that belong to the wing, in different variables??
DROP PROCEDURE IF EXISTS allot_wing_rooms;
DELIMITER $$
CREATE PROCEDURE allot_wing_rooms(IN q_leader CHAR(13), IN q_hostel CHAR(2), IN q_room INT UNSIGNED)
	COMMENT "Allot the wing a sequence of rooms in the given hostel."
BEGIN
	
END$$
DELIMITER ;
