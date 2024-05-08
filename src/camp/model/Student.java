package camp.model;

import java.util.List;

public class Student {
    private String studentId;
    private String studentName;
    private String studentState;
    private List<Subject> studentSubject;

    public Student(String seq, String studentName, List<Subject> studentSubject) {
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

    public List<Subject> getStudentSubject() {
        return studentSubject;
    }

    // Setter
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentState(String studentState) {
        this.studentState = studentState;
    }

}