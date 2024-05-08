package camp;

public class ChangeSubjectName {
    public ChangeSubjectName() {
    }

    public String changeSubjectName(String subjectName) {
        switch (subjectName){
            case "Java" :
                return "SU1";
            case "객체지향" : 
                return "SU2";            
            case "Spring" :
                return "SU3";
            case "JPA" :
                return "SU4";
            case "MySQL" :
                return "SU5";
            case "디자인 패턴":
                return "SU6";
            case "Spring Security" :
                return "SU7";
            case "Redis" :
                return "SU8";
            case "MongoDB" :
                return "SU9";
        }
        return "없음";
    }
}
