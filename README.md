```java
void allocateRemainingRooms() {
    ArrayList<String> studentList = new ArrayList<String>();
    query = "SELECT student_id FROM student;";
    rset = state.executeQuery(query);
    while(rset.next()) {
        studentList.add(rset.getString(1));
    }
    int n = studentList.size();
    for(int i = 0; i < n; i++) {
        System.out.println(studentList[i]);
    }
}
```
