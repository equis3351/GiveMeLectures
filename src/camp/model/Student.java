package camp.model;

public class Student {
    private String studentId;
    private String studentName;
    private String studentState;
    private String studentSubject;

    public Student(String seq, String studentName) {
        this.studentId = seq;
        this.studentName = studentName;
        this.studentState = "Green";
        this.studentSubject = "";
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
        return studentSubject;
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
        this.studentSubject = studentSubject;
    }

    // Inquire
    public void inquireStudent() {

    }

    // Remove
    public void removeStudent() {

    }

}