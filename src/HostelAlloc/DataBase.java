package HostelAlloc;

import java.sql.*;

public class DataBase{
	static Connection connect;
	static Statement state;
	static ResultSet rset;
	static String query;
	static String idNumber;
	static Boolean adminAccess;
	static Boolean allocationDone = false;
	
	static void buildConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/campus"; //database name
		String userName = "root";
		String passWord = "8708098282";//////////////////////////
		Class.forName("com.mysql.cj.jdbc.Driver"); //do we have to register everytime ?
		connect = DriverManager.getConnection(url, userName, passWord);
		state = connect.createStatement();
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
		/////////using field password user
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
//		query = "INSERT INTO wing VALUES ('" + idNumber + "', 1, " + roomSize + ");";
//		state.executeUpdate(query);
//		query = "UPDATE student SET leader_ID = '" + idNumber + "' WHERE student_ID = '" + idNumber + "';";
//		state.executeUpdate(query);
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
//		query = "UPDATE wing SET size = " + wingSize+1 + " WHERE leader_ID = '" + leaderIDofWing + "';";
//		state.executeUpdate(query);
//		query = "UPDATE student SET leader_ID = '" + leaderIDofWing + "' WHERE student_ID = '" + idNumber + "';";
//		state.executeUpdate(query);
		query = "CALL join_wing('" + givenWingCode + "', '" + idNumber + "');";
		state.executeUpdate(query);
	}
	static String findWingLeader() throws Exception {
		query = "SELECT leader_id FROM member_of WHERE student_id = '" + idNumber + "';";
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
	static void viewWing() {
		
	}
//	static void addNewUserToDataBase(String userNameToAdd, String passWordToAdd) throws Exception {
//		query = "INSERT INTO dataBaseSnakeGame(userNameUser, passWordUser) VALUES('" + userNameToAdd + "', '" + passWordToAdd + "');";
//		state.executeUpdate(query);
//	}
//	static void loadHighScores() throws Exception {
//		query = "SELECT * FROM highScoresDataBaseEasy;";
//		rset = state.executeQuery(query);
//		for (int i = 1; i <= 5; i++) {
//			rset.next();
//			Main.highScoresTableData0[i-1][1] = rset.getString("UserName");
//			Main.highScoresTableData0[i-1][2] = Integer.toString(rset.getInt("HighScore"));
//		}
//		query = "SELECT * FROM highScoresDataBaseMedium;";
//		rset = state.executeQuery(query);
//		for (int i = 1; i <= 5; i++) {
//			rset.next();
//			Main.highScoresTableData1[i-1][1] = rset.getString("UserName");
//			Main.highScoresTableData1[i-1][2] = Integer.toString(rset.getInt("HighScore"));
//		}
//		query = "SELECT * FROM highScoresDataBaseHard;";
//		rset = state.executeQuery(query);
//		for (int i = 1; i <= 5; i++) {
//			rset.next();
//			Main.highScoresTableData2[i-1][1] = rset.getString("UserName");
//			Main.highScoresTableData2[i-1][2] = Integer.toString(rset.getInt("HighScore"));
//		}
//	}
//	static void updateHighScores(int playerScore, int difficulty) throws Exception {
//		query = "SELECT * FROM dataBaseSnakeGame WHERE userNameUser = '" + userNamePlayer + "';";
//		rset = state.executeQuery(query);
//		rset.next();
//		int presentScore = playerScore;
//		int scores1[] = new int[]{rset.getInt("highScore1"), rset.getInt("highScore2"), rset.getInt("highScore3"), rset.getInt("highScore4"), rset.getInt("highScore5")};
//		for (int i = 0; i<5; i++) {
//			if (presentScore >= scores1[i]) {
//				int temp = scores1[i];
//				scores1[i] = presentScore;
//				presentScore = temp;
//			}
//		}
//		for (int i = 0; i<5; i++) {
//			query = "UPDATE dataBaseSnakeGame SET highScore" + (i+1) + " = " + scores1[i] + " WHERE userNameUser = '" + userNamePlayer + "';";
//			state.executeUpdate(query);
//		}
//		String dataBaseName;
//		if (difficulty == 0) {
//			query = "SELECT * FROM highScoresDataBaseEasy";
//			dataBaseName = "highScoresDataBaseEasy";
//		}
//		else if (difficulty == 1) {
//			query = "SELECT * FROM highScoresDataBaseMedium";
//			dataBaseName = "highScoresDataBaseMedium";
//		}
//		else {
//			query = "SELECT * FROM highScoresDataBaseHard";
//			dataBaseName = "highScoresDataBaseHard";
//		}
//		rset = state.executeQuery(query);
//		presentScore = playerScore;
//		String playerName = userNamePlayer;
//		int scores2[] = new int[5];
//		String userNames2[] = new String[5];
//		System.out.println(playerName);
//		for (int i = 0; i<5; i++) {
//			rset.next();
//			scores2[i] = rset.getInt("HighScore");
//			userNames2[i] = rset.getString("UserName");
//			if (presentScore > scores2[i]) {
//				int temp = scores2[i];
//				String tempname = userNames2[i];
//				scores2[i] = presentScore;
//				userNames2[i] = playerName;
//				presentScore = temp;
//				playerName = tempname;
//			}
//		}
//		for (int i = 0; i<5; i++) {
//			query = "UPDATE " + dataBaseName + " SET HighScore = " + scores2[i] + "  WHERE Ranking = " + (i+1) + ";";
//			state.executeUpdate(query);
//			query = "UPDATE " + dataBaseName + " SET UserName = '" + userNames2[i] + "' WHERE Ranking = " + (i+1) + ";";
//			state.executeUpdate(query);
//		}
//	}
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
