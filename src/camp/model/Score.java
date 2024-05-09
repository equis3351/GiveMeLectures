package camp.model;

public class Score {
    private String scoreId;
    private String studentId;

    private String subjectId;
    private int testNum;    //회차
    private int score;  //점수

    private String subjectType;
    private char grade; //등급
    
    public Score(String seq, String studentId, String subjectId, int testNum, int score, String subjectType){
        this.scoreId = seq;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.testNum = testNum;
        this.score = score;
        this.subjectType = subjectType;
        this.grade = gradeCheck(score, subjectId);
    }

    // Getter
    public String getScoreId() {
        return scoreId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getTestNum() {
        return testNum;
    }

    public int getScore() {
        return score;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public char getGrade() {
        return grade;
    }

    char gradeCheck(int score, String subjectType) {

        char grade;

        if (subjectType.equals("MANDATORY")) {
            if (score >= 95) {
                grade = 'A';
            } else if (score >= 90) {
                grade = 'B';
            } else if (score >= 80) {
                grade = 'C';
            } else if (score >= 70) {
                grade = 'D';
            } else if (score >= 60) {
                grade = 'F';
            } else {
                grade = 'N';
            }
        } else {
            if (score >= 90) {
                grade = 'A';
            } else if (score >= 80) {
                grade = 'B';
            } else if (score >= 70) {
                grade = 'C';
            } else if (score >= 60) {
                grade = 'D';
            } else if (score >= 50) {
                grade = 'F';
            } else {
                grade = 'N';
            }
        }



        return grade;
    }

    // setter
    public void setscore(int score) {
        this.score = score;
    }
}
