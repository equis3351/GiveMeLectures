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

    // update
    public void updateStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void updateStudentState(String studentState) {
        this.studentState = studentState;
    }

}