# List of things needed

- Eclipse IDE
- Java
- Connector/J https://repo1.maven.org/maven2/mysql/mysql-connector-java/8.0.28/mysql-connector-java-8.0.28.jar
- BITS Pilani Logo PNG 
- Change credentials in DataBase.java
- 
 ```ArrayList<String> wingList = new ArrayList<String>();
		query = "SELECT leader_id from wing_hostel;";
		state.executeQuery(query);
		while (rset.next()) {
			wingList.add(rset.getString(1));
		}
 query = "SELECT EXISTS("
				+ "  SELECT student_ID "
				+ "  FROM student"
				+ "  WHERE student_ID = '" + idCheck + "');";
		rset = state.executeQuery(query);
		rset.next();
		return rset.getBoolean(1);```
