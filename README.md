# Hostel Allocation Project

### Contributors

Tanveer Singh - [https://github.com/brobat6](https://github.com/brobat6)

Utkarsh Darolia - [https://github.com/Utkarsh-UTK](https://github.com/Utkarsh-UTK)

##	System Requirement Specification

a)	Functional Requirements
Students should be able to:

-	Create a wing and invite their fellow batchmates, or join a wing created by someone else

The wing leader should be able to:

-	Give choice of hostel(s) preferred from a set of hostels 
-	Lock their wing so that others cannot join it until it is unlocked
-	Give choice of single/double rooms preferred

Given a set of wings with hostel preferences, the database system should be able to:

-	Make sure that each student is in maximum one wing, and there is only one wing leader per wing (consistency requirement which can be checked after every operation performed by the students) 
-	Allocate hostels and room numbers in such a way that maximum number of wings get their preferred hostels
-	Allocate a set of room numbers to the wing, after which the wing members can distribute the rooms amongst themselves
-	Randomly allocate the remaining rooms to students that are not in a wing


The administrator should have all privileges to add or delete student records, data about hostels, and so on. These privileges would not be granted to the students.

b)	Data Requirements

-	Information about the students, such as Student_ID, Name, Phone Number, Year such as first/second etc (to ensure that wings are only created between similar year students)
-	Information about the hostels, such as Name, Number of single and double rooms, total capacity
-	Data of room numbers available in each hostel, and whether they are single or double rooms
-	The rest of the information (such as wing sizes and room numbers allocated) will be filled by the students and then allocated by the DBMS.


c)	Assumptions

-	We assume that all hostels are NOT identical, so some hostels may have more rooms or different room numbers.
-	The idea behind the DBMS is to give wings room numbers within a specific range. So, if there is a wing of size 5, they would be granted room numbers from X to X + 4 in the same hostel.
-	Rooms are of two types – single or double. 
-	A wing of single rooms may have a size of maximum 4, and a double wing may have a size of maximum 8.
-	The username and password are given to each student, by the administrator. 
-	The administrator has a special username “admin” and password “abcd” with which they can login and execute the algorithm to randomly allocate wings.
