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
    ArrayList<String> roomList = new ArrayList<String>();
    query = "SELECT room_no FROM room;";
    rset = state.executeQuery(query);
    while(rset.next()) {
        roomList.add(rset.getString(1));
    }
    ArrayList<Integer> capacityList = new ArrayList<Integer>();
    query = "SELECT capacity FROM room;";
    rset = state.executeQuery(query);
    while(rset.next()) {
        capacityList.add(rset.getString(1)); // change to getInt!
    }
    ArrayList<Integer> roomDoneList = new ArrayList<Integer>(m);

    for(int i = 0; i < n; i++) {
        studentDoneList[i] = SELECT EXISTS(SELECT student_id FROM lives_in WHERE student_id = studentList[i]);
    }
    for(int i = 0; i < m; i++) {
        roomDoneList[i] = SELECT COUNT(student_id) FROM lives_in WHERE hostel_id = hostelList[i] AND room_no = roomList[i];
    }

    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(studentDoneList[i] || (roomDoneList[j] == capacityList[j]) || (genderList[i] != hostelGenderList[j])) continue;
            INSERT INTO lives_in VALUES(studentList[i], hostelList[j], roomList[j]);
            studentDoneList[i] = true;
            roomDoneList[j]++;
        }
    }
}
```
