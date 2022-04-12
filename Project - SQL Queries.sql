DROP PROCEDURE IF EXISTS update_phone_number;
DELIMITER $$
CREATE PROCEDURE update_phone_number(IN q_id CHAR(13), IN q_ph CHAR(10))
	MODIFIES SQL DATA
BEGIN
	UPDATE student SET phone_no = q_ph WHERE student_id = q_id;
END$$
DELIMITER ;
CALL update_phone_number("2020A7PS0084P", "8755112934");

DROP PROCEDURE IF EXISTS update_email_id;
DELIMITER $$
CREATE PROCEDURE update_email_id(IN q_id CHAR(13), IN q_email VARCHAR(40))
	MODIFIES SQL DATA
BEGIN
	UPDATE student SET email_ID = q_email WHERE student_id = q_id;
END$$
DELIMITER ;
CALL update_email_id("2020A7PS0084P", "ldrubra8@gmail.com");

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
CREATE PROCEDURE add_preferred_hostel(IN q_id char(13), IN q_hostel char(2))
	COMMENT "Adds a preferred hostel to wing only if the query is called by wing leader, and the hostel is of the same type (boys/girls)"
BEGIN
	-- add additional if statement to do nothing for already existing entry!!!
	if(q_id not in (select leader_id from wing)) then 
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Only wing leaders can add preferred hostels!';
	elseif((select gender from student where student_id=q_id) = "M" and q_hostel = "MR") then
		signal sqlstate '45000' set message_text = 'Please enter only boys\' hostels!';
	elseif((select gender from student where student_id=q_id) = "F" and q_hostel in ("BD", "SK")) then
		signal sqlstate '45000' set message_text = 'Please enter only girls\' hostels!';
	elseif(q_hostel not in (select hostel_id from hostel)) then
		signal sqlstate '45000' set message_text = 'Hostel does not exist!';
	else
		insert into wing_hostel values (q_id, q_hostel);
	end if;
END$$
DELIMITER ;

call create_new_wing("2020A7PS0084P");
call add_preferred_hostel("2020A7PS0084P", "SK");
select * from wing_hostel;

DROP PROCEDURE IF EXISTS add_wing_member;
DELIMITER $$
CREATE PROCEDURE add_wing_member(IN q_leader CHAR(13), IN q_member CHAR(13))
	COMMENT "Add a member to a wing, provided the student is not a member or leader of any other wing" 
BEGIN
	IF(q_leader NOT IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Wing does not exist!';
	ELSEIF(q_member IN (SELECT student_id FROM member_of) OR q_member IN (SELECT leader_id FROM wing)) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Student is already in a wing!';
	ELSE 
		INSERT INTO member_of VALUES (q_member, q_leader);
        SET @temp = (SELECT size FROM wing WHERE leader_id = q_leader);
        SET @temp = @temp + 1;
        UPDATE wing SET size = @temp WHERE leader_id = q_leader;
	END IF;
    -- also need to check for LIMITS of size!! Size cannot exceed certain values, which depends on whether wing is S or D type.
END$$
DELIMITER ;

select * from wing;
select * from member_of;
CALL add_wing_member("2020A7PS0084P", "2020A7PS0083P");