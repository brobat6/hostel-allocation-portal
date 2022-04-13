```java
void allocateRemainingRooms() {
    
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
    
    ArrayList<Boolean> studentDoneList = new ArrayList<Boolean>(n);

    ArrayList<String> hostelList = new ArrayList<String>();
    query = "SELECT hostel_id FROM room;";
    rset = state.executeQuery(query);
    while(rset.next()) {
        hostelList.add(rset.getString(1));
    }
    
    int m = hostelList.size();
    
    ArrayList<String> hostelGenderList = new ArrayList<String>(m);
    // iterate on hostelList to get above values
    
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

    ArrayList<Integer> roomDoneList = new ArrayList<Integer>(m);

    for(int i = 0; i < n; i++) {
        query = "SELECT EXISTS(SELECT student_id FROM lives_in WHERE student_id = '" + studentList.get(i) + "');"; 
        rset = state.executeQuery(query); rset.next(); 
        studentDoneList[i] = rset.getBoolean(1);
    }

    for(int i = 0; i < m; i++) {
        query = "SELECT COUNT(student_id) FROM lives_in WHERE hostel_id = '" + hostelList.get(i) + "' AND room_no = " + roomList.get(i) + ";"; 
        rset = state.executeQuery(query); rset.next(); 
        roomDoneList[i] = rset.getInt(1);
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(studentDoneList.get(i) || (roomDoneList.get(j) == capacityList.get(j)) || (genderList.get(i) != hostelGenderList.get(j))) continue;
            query = "INSERT INTO lives_in VALUES( '" + studentList.get(i) + "', '" + hostelList.get(i) + "', " + roomList.get(j) + ");"; 
            state.executeUpdate(query);
            studentDoneList[i] = true;
            roomDoneList[j]++;
        }
    }
}
```
