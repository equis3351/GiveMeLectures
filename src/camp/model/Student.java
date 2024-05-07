package camp.model;

import java.util.ArrayList;
import java.util.Arrays;

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

    public String getStudentSubject() {
        return Arrays.toString(studentSubject.toArray());
    }

    // Setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentState(String studentState) {
        this.studentState = studentState;
    }

}