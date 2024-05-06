package camp.model;

import java.util.ArrayList;

public class Student {
    private String studentId;
    private String studentName;
    private String studentState;
    private ArrayList<String> studentSubject;

    public Student(String seq, String studentName, ArrayList<String> studentSubject) {
        this.studentId = seq;
        this.studentName = studentName;
        this.studentState = "Green";
        this.studentSubject = studentSubject;
    }

    // Getter
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentState() {
        return studentState;
    }

    public String getStudentSubject(int index) {
        return studentSubject.get(index);
    }

    // Setter
    public void setStudentId(String studentId) {
        // 수강생의 고유번호는 중복될 수 없습니다.
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentState(String studentState) {
        this.studentState = studentState;
    }

    public void setStudentSubject(String studentSubject) {
        this.studentSubject.add(studentSubject);
    }

    // Inquire
    public void inquireStudent() {

    }

    // Remove
    public void removeStudent() {

    }

}