package HostelAlloc;

import java.sql.*;
import java.util.ArrayList;

public class DataBase{
	static Connection connect;
	static Statement state;
	static ResultSet rset;
	static String query;
	static String idNumber;
	static Boolean adminAccess;
	static Boolean allocationDone;
	
	static void buildConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/campus"; //database name
		String userName = "root";
		String passWord = "8708098282";//////////////////////////
		Class.forName("com.mysql.cj.jdbc.Driver"); //do we have to register everytime ?
		connect = DriverManager.getConnection(url, userName, passWord);
		state = connect.createStatement();
	}
	
	static void allocationDoneOrNot() throws Exception {
		query = "SELECT COUNT(*) FROM lives_in";
		rset = state.executeQuery(query);
		rset.next();
		if (rset.getInt(1)==0) {
			allocationDone = false;
		}
		else {
			allocationDone = true;
		}
	}
	
	static Boolean checkIDAlreadyExists(String idCheck) throws Exception {
		query = "SELECT EXISTS("
				+ "  SELECT student_ID "
				+ "  FROM student"
				+ "  WHERE student_ID = '" + idCheck + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);
	}
	
	static Boolean verifyIDPassWord(String idCheck, String passWordCheck) throws Exception {
		query = "SELECT EXISTS("
				+ "  SELECT student_ID"
				+ "  FROM student"
				+ "  WHERE student_ID = '" + idCheck + "' AND"
				+ "  pwd = '" + passWordCheck + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);
	}
	
	static Boolean checkIfInAWing() throws Exception {
		query = "SELECT EXISTS (SELECT leader_id FROM student WHERE student_ID = '" + idNumber + "' AND leader_ID IS NOT NULL);";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);
	}
	
	static void createNewWing(String wingCode, String roomType) throws Exception {
		query = "CALL create_new_wing('" + idNumber + "', '" + roomType + "', '" + wingCode + "');";
		state.executeUpdate(query);
	}
	
	static int checkSizeofWing (String leaderIDofWing) throws Exception {
		query = "SELECT size FROM wing WHERE leader_ID = '" + leaderIDofWing + "';";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getInt(1);
	}
	
	static void joinNewWing(String givenWingCode) throws Exception {
		query = "CALL join_wing('" + givenWingCode + "', '" + idNumber + "');";
		state.executeUpdate(query);
	}
	
	static String findWingLeader() throws Exception {
		query = "SELECT leader_id FROM member_of WHERE (student_id = '" + idNumber + "' OR leader_id = '" + idNumber + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getString(1);
	}
	
	static String findWingCode() throws Exception {
		query = "SELECT wing_code FROM wing WHERE leader_id = '" + findWingLeader() + "';";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getString(1);
	}
	
	static ResultSet viewWing() throws Exception {
		query = "SELECT student_id, student_name FROM student WHERE student_id IN (SELECT student_id FROM member_of WHERE leader_id = '" + findWingLeader() + "');";
		rset = state.executeQuery(query);
		return rset;
	}
	
	static ResultSet viewAllocation() throws Exception {
		query = "SELECT student_id, hostel_id, room_no FROM lives_in WHERE student_id = '" + idNumber + "';";
		rset = state.executeQuery(query);
		return rset;
	}
	
	static String findName(String idNum) throws Exception {
		query = "SELECT student_name FROM student WHERE student_id = '" + idNum + "';";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getString(1);
	}
	
	static void addPreferences(String hostelID) throws Exception {
		query = "CALL add_preferred_hostel('" + idNumber + "', '" + hostelID + "');";
		state.executeUpdate(query);
	}
	
	
	static void allocationofSingleRooms() throws Exception {
		ArrayList<String> wingList = new ArrayList<String>();
		query = "SELECT leader_id from wing_hostel;";
		rset = state.executeQuery(query);
		while (rset.next()) {
			wingList.add(rset.getString(1));
		}
		ArrayList<String> hostelList = new ArrayList<String>();
		query = "SELECT preferred_hostel from wing_hostel;";
		rset = state.executeQuery(query);
		while (rset.next()) {
			hostelList.add(rset.getString(1));
		}
		int n = wingList.size();
		for (int i = 0; i < n; i++) {
			query = "SELECT EXISTS(SELECT student_id FROM lives_in WHERE student_id = '" + wingList.get(i) + "');";
			rset = state.executeQuery(query);
			rset.next();
			if (rset.getBoolean(1)) {
				continue;
			}
			query = "SELECT room_type FROM wing WHERE leader_id = '" + wingList.get(i) + "';";
			rset = state.executeQuery(query);
			rset.next();
			if (rset.getString(1).toUpperCase().equals("D")) {
				continue;
			}
			ArrayList<Integer> roomList = new ArrayList<Integer>();
			query = "SELECT room_no FROM room WHERE hostel_id = '" + hostelList.get(i) + "' AND capacity = 1;";
			rset = state.executeQuery(query);
			while (rset.next()) {
				roomList.add(rset.getInt(1));
			}
			int m = roomList.size();
			query = "SELECT size FROM wing WHERE leader_id = '" + wingList.get(i) + "';";
			rset = state.executeQuery(query);
			rset.next();
			int sz = rset.getInt(1);
			ArrayList<String> memberList = new ArrayList<String>();
			query = "SELECT student_id FROM member_of WHERE leader_id = '" + wingList.get(i) + "';";
			rset = state.executeQuery(query);
			while (rset.next()) {
				memberList.add(rset.getString(1));
			}
			memberList.add(wingList.get(i));
			for(int j = 0; j < m - sz; j++) {
				boolean possible = true;
				for(int k = 0; k < sz; k++) {
					query = "SELECT EXISTS(SELECT room_no FROM lives_in WHERE hostel_id = '" + hostelList.get(i) + "' AND room_no = " + (roomList.get(j) + k) + ");";
					rset = state.executeQuery(query);
					rset.next();
					if (rset.getBoolean(1)) {
						possible = false;
						break;
					}
				}
				if(possible) {
					for(int k = 0; k < sz; k++) {
						query = "INSERT INTO lives_in VALUES( '" + memberList.get(k) + "', '" + hostelList.get(i) + "', " + (roomList.get(j) + k) + ");";
						state.executeUpdate(query);
					}
					break;
				}
			}
		}
	}
	
	static void allocationOfDoubleRooms() throws Exception {
		ArrayList<String> wingList = new ArrayList<String>();
		query = "SELECT leader_id from wing_hostel;";
		rset = state.executeQuery(query);
		while (rset.next()) {
			wingList.add(rset.getString(1));
		}
		ArrayList<String> hostelList = new ArrayList<String>();
		query = "SELECT preferred_hostel from wing_hostel;";
		rset = state.executeQuery(query);
		while (rset.next()) {
			hostelList.add(rset.getString(1));
		}
		int n = wingList.size();
		
		for (int i = 0; i < n; i++) {
			query = "SELECT EXISTS(SELECT student_id FROM lives_in WHERE student_id = '" + wingList.get(i) + "');";
			rset = state.executeQuery(query);
			rset.next();
			if (rset.getBoolean(1)) {
				continue;
			}
			query = "SELECT room_type FROM wing WHERE leader_id = '" + wingList.get(i) + "';";
			rset = state.executeQuery(query);
			rset.next();
			if (rset.getString(1).equals("S")) {
				continue;
			}
			
			ArrayList<Integer> roomList = new ArrayList<Integer>();
			query = "SELECT room_no FROM room WHERE hostel_id = '" + hostelList.get(i) + "' AND capacity = 2;";
			rset = state.executeQuery(query);
			while (rset.next()) {
				roomList.add(rset.getInt(1));
			}
			int m = roomList.size();
			query = "SELECT size FROM wing WHERE leader_id = '" + wingList.get(i) + "';";
			rset = state.executeQuery(query);
			rset.next();
			int sz = rset.getInt(1);
			sz = (sz + 1)/2;
			ArrayList<String> memberList = new ArrayList<String>();
			query = "SELECT student_id FROM member_of WHERE leader_id = '" + wingList.get(i) + "';";
			rset = state.executeQuery(query);
			while (rset.next()) {
				memberList.add(rset.getString(1));
			}
			memberList.add(wingList.get(i));

			for(int j = 0; j < m - sz; j++) {
				boolean possible = true;
				for(int k = 0; k < sz; k++) {
					query = "SELECT EXISTS(SELECT room_no FROM lives_in WHERE hostel_id = '" + hostelList.get(i) + "' AND room_no = " + (roomList.get(j) + k) + ");";
					rset = state.executeQuery(query);
					rset.next();
					if (rset.getBoolean(1)) {
						possible = false;
						break;
					}
				}
				if(possible) {
					for(int k = 0; k < sz; k++) {
						query = "INSERT INTO lives_in VALUES( '" + memberList.get(k*2) + "', '" + hostelList.get(i) + "', " + (roomList.get(j) + k) + ");";
						state.executeUpdate(query);
						query = "INSERT INTO lives_in VALUES( '" + memberList.get(k*2 + 1) + "', '" + hostelList.get(i) + "', " + (roomList.get(j) + k) + ");";
						state.executeUpdate(query);
					}
					break;
				}
			}
		}
	}
	static void allocateRemainingRooms() throws Exception {
		ArrayList<String> studentList = new ArrayList<String>();
	    query = "SELECT student_id FROM student;";
	    rset = state.executeQuery(query);
	    while(rset.next()) {
	        studentList.add(rset.getString(1));
	    }

	    ArrayList<String> genderList = new ArrayList<String>();
	    query = "SELECT gender FROM student;";
	    rset = state.executeQuery(query);
	    while(rset.next()) {
	        genderList.add(rset.getString(1));
	    }
	    
	    int n = studentList.size();

	    ArrayList<String> hostelList = new ArrayList<String>();
	    query = "SELECT hostel_id FROM room;";
	    rset = state.executeQuery(query);
	    while(rset.next()) {
	        hostelList.add(rset.getString(1));
	    }

	    int m = hostelList.size();
	    
	    ArrayList<String> hostelGenderList = new ArrayList<String>();
	    for(int i = 0; i < m; i++) {
	    	if(hostelList.get(i).equals("MR")) {
	    		hostelGenderList.add("F");
	    	} else {
	    		hostelGenderList.add("M");
	    	}
	    }
   
	    ArrayList<Integer> roomList = new ArrayList<Integer>();
	    query = "SELECT room_no FROM room;";
	    rset = state.executeQuery(query);
	    while(rset.next()) {
	        roomList.add(rset.getInt(1));
	    }

	    ArrayList<Integer> capacityList = new ArrayList<Integer>();
	    query = "SELECT capacity FROM room;";
	    rset = state.executeQuery(query);
	    while(rset.next()) {
	        capacityList.add(rset.getInt(1));
	    }
	
	    ArrayList<Boolean> studentDoneList = new ArrayList<Boolean>();
	    ArrayList<Integer> roomDoneList = new ArrayList<Integer>();

	    for(int i = 0; i < n; i++) {
	        query = "SELECT EXISTS(SELECT student_id FROM lives_in WHERE student_id = '" + studentList.get(i) + "');"; 
	        rset = state.executeQuery(query); rset.next();
	        studentDoneList.add(rset.getBoolean(1));
	    }

	    for(int i = 0; i < m; i++) {
	        query = "SELECT COUNT(student_id) FROM lives_in WHERE hostel_id = '" + hostelList.get(i) + "' AND room_no = " + roomList.get(i) + ";"; 
	        rset = state.executeQuery(query); rset.next();
	        roomDoneList.add(rset.getInt(1));
	    }
	    
	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < m; j++) {
	            if(studentDoneList.get(i) || (roomDoneList.get(j) == capacityList.get(j)) || (!genderList.get(i).equals(hostelGenderList.get(j)))) continue;
	        	query = "INSERT INTO lives_in VALUES( '" + studentList.get(i) + "', '" + hostelList.get(j) + "', " + roomList.get(j) + ");"; 
	            state.executeUpdate(query);
	            studentDoneList.set(i,  true);
	            roomDoneList.set(j,  roomDoneList.get(j) + 1);
	        }
	    }
	}
	
	static void makeQuery(String dataBaseQuery) throws Exception {
		rset = state.executeQuery(dataBaseQuery);
		rset.next();
		String name = rset.getString(1);
		
		System.out.println(name);
	}
	
	static void close() throws Exception{
		connect.close();
		state.close();
	}
}
