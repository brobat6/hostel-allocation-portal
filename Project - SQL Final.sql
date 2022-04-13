DROP DATABASE IF EXISTS campus;

CREATE DATABASE campus;
USE campus;

-- Lets make a more general database in which there can be multiple boys or girls type hostels.

CREATE TABLE student (
	student_ID 			CHAR(13) 		PRIMARY KEY,
    student_name 		VARCHAR(50) 	NOT NULL,
    gender				CHAR(1)			NOT NULL		CHECK (gender IN ("M", "F")),
    -- pwd					VARCHAR(100)		NOT NULL,
    email_ID 			VARCHAR(40)		UNIQUE, 
    phone_no 			CHAR(10)		UNIQUE
    -- Adding a PASSWORD is pretty important.
);
CREATE TABLE hostel (
	hostel_id			CHAR(2)			PRIMARY KEY,
    hostel_name			VARCHAR(30)		NOT NULL UNIQUE,
    hostel_type			CHAR(1)			NOT NULL		CHECK (hostel_type IN ("M", "F")),
    single_rooms		INT UNSIGNED	DEFAULT '0' NOT NULL,
    double_rooms		INT UNSIGNED	DEFAULT '0' NOT NULL
    -- Remember to create a procedure for derived attribute capacity.
);
CREATE TABLE wing (
	leader_id			CHAR(13)		PRIMARY KEY		REFERENCES student,
    size				INT UNSIGNED	NOT NULL,
    room_type			CHAR(1)			NOT NULL		CHECK (room_type IN ("S", "D"))
    -- Add Wing LOCKED/UNLOCKED functionality later, it won't be too hard.
    -- Add a procedure to change the wing type.
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
	-- Constraint on capacity - 1 or 2
    PRIMARY KEY(hostel_id, room_no)
);
CREATE TABLE lives_in (
	student_id			CHAR(13) 		PRIMARY KEY		REFERENCES student,
    hostel_id			CHAR(2),
    room_no				INT UNSIGNED,
    -- Foreign key constraint on hostel_id and room_no
    FOREIGN KEY(hostel_id, room_no) REFERENCES room(hostel_id, room_no)
);
CREATE TABLE member_of (
	student_id			CHAR(13) 		PRIMARY KEY		REFERENCES student,
    leader_id			CHAR(13)		REFERENCES wing
    -- CHECK (leader_id NOT IN (SELECT student_id FROM member_of)),
    -- CHECK (student_id NOT IN (SELECT leader_id FROM member_of))
    -- a leader should not be a member, and vice versa!
);

