package HostelAlloc;

import java.sql.*;

public class DataBase{
	static Connection connect;
	static Statement state;
	static ResultSet rset;
	static String query;
	static String userNamePlayer;
	
	static void buildConnection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/first"; //database name
		String userName = "root";
		String passWord = "8708098282";//////////////////////////
		Class.forName("com.mysql.cj.jdbc.Driver"); //do we have to register everytime ?
		connect = DriverManager.getConnection(url, userName, passWord);
		state = connect.createStatement();
	}
	static Boolean checkUserNameAlreadyExists(String userNameCheck) throws Exception {
		query = "SELECT EXISTS("
				+ "  SELECT userNameUser "
				+ "  FROM dataBaseSnakeGame"
				+ "  WHERE userNameUser = '" + userNameCheck + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);
	}
	static Boolean verifyUserNamePassWord(String userNameCheck, String passWordCheck) throws Exception {
		query = "SELECT EXISTS("
				+ "  SELECT userNameUser"
				+ "  FROM dataBaseSnakeGame"
				+ "  WHERE userNameUser = '" + userNameCheck + "' AND"
				+ "  passWordUser = '" + passWordCheck + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);
	}
	static void addNewUserToDataBase(String userNameToAdd, String passWordToAdd) throws Exception {
		query = "INSERT INTO dataBaseSnakeGame(userNameUser, passWordUser) VALUES('" + userNameToAdd + "', '" + passWordToAdd + "');";
		state.executeUpdate(query);
	}
	static void loadHighScores() throws Exception {
		query = "SELECT * FROM highScoresDataBaseEasy;";
		rset = state.executeQuery(query);
		for (int i = 1; i <= 5; i++) {
			rset.next();
			Main.highScoresTableData0[i-1][1] = rset.getString("UserName");
			Main.highScoresTableData0[i-1][2] = Integer.toString(rset.getInt("HighScore"));
		}
		query = "SELECT * FROM highScoresDataBaseMedium;";
		rset = state.executeQuery(query);
		for (int i = 1; i <= 5; i++) {
			rset.next();
			Main.highScoresTableData1[i-1][1] = rset.getString("UserName");
			Main.highScoresTableData1[i-1][2] = Integer.toString(rset.getInt("HighScore"));
		}
		query = "SELECT * FROM highScoresDataBaseHard;";
		rset = state.executeQuery(query);
		for (int i = 1; i <= 5; i++) {
			rset.next();
			Main.highScoresTableData2[i-1][1] = rset.getString("UserName");
			Main.highScoresTableData2[i-1][2] = Integer.toString(rset.getInt("HighScore"));
		}
	}
	static void updateHighScores(int playerScore, int difficulty) throws Exception {
		query = "SELECT * FROM dataBaseSnakeGame WHERE userNameUser = '" + userNamePlayer + "';";
		rset = state.executeQuery(query);
		rset.next();
		int presentScore = playerScore;
		int scores1[] = new int[]{rset.getInt("highScore1"), rset.getInt("highScore2"), rset.getInt("highScore3"), rset.getInt("highScore4"), rset.getInt("highScore5")};
		for (int i = 0; i<5; i++) {
			if (presentScore >= scores1[i]) {
				int temp = scores1[i];
				scores1[i] = presentScore;
				presentScore = temp;
			}
		}
		for (int i = 0; i<5; i++) {
			query = "UPDATE dataBaseSnakeGame SET highScore" + (i+1) + " = " + scores1[i] + " WHERE userNameUser = '" + userNamePlayer + "';";
			state.executeUpdate(query);
		}
		String dataBaseName;
		if (difficulty == 0) {
			query = "SELECT * FROM highScoresDataBaseEasy";
			dataBaseName = "highScoresDataBaseEasy";
		}
		else if (difficulty == 1) {
			query = "SELECT * FROM highScoresDataBaseMedium";
			dataBaseName = "highScoresDataBaseMedium";
		}
		else {
			query = "SELECT * FROM highScoresDataBaseHard";
			dataBaseName = "highScoresDataBaseHard";
		}
		rset = state.executeQuery(query);
		presentScore = playerScore;
		String playerName = userNamePlayer;
		int scores2[] = new int[5];
		String userNames2[] = new String[5];
		System.out.println(playerName);
		for (int i = 0; i<5; i++) {
			rset.next();
			scores2[i] = rset.getInt("HighScore");
			userNames2[i] = rset.getString("UserName");
			if (presentScore > scores2[i]) {
				int temp = scores2[i];
				String tempname = userNames2[i];
				scores2[i] = presentScore;
				userNames2[i] = playerName;
				presentScore = temp;
				playerName = tempname;
			}
		}
		for (int i = 0; i<5; i++) {
			query = "UPDATE " + dataBaseName + " SET HighScore = " + scores2[i] + "  WHERE Ranking = " + (i+1) + ";";
			state.executeUpdate(query);
			query = "UPDATE " + dataBaseName + " SET UserName = '" + userNames2[i] + "' WHERE Ranking = " + (i+1) + ";";
			state.executeUpdate(query);
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
