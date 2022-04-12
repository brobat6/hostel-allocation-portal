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
	IF(q_id NOT IN (SELECT leader_id FROM wing) AND q_id NOT IN (SELECT student_id FROM member_of)) THEN
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
	ELSEIF((SELECT gender FROM student WHERE student_id=q_id) = "M" AND q_hostel = "MR") THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Please enter only boys\' hostels!';
	ELSEIF((SELECT gender FROM student WHERE student_id=q_id) = "F" AND q_hostel IN ("BD", "SK")) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Please enter only girls\' hostels!';
	ELSEIF(q_hostel NOT IN (SELECT hostel_id FROM hostel)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Hostel does not exist!';
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



-- A procedure to SWAP two allocated rooms between members of the same wing.
-- A procedure to change wing type from Single to Double or vice versa

