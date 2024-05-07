package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Objects;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class CampManagementApplication {
    // 데이터 저장소
    private static List<Student> studentStore;
    private static List<Subject> subjectStore;
    private static List<Score> scoreStore;

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    // 메인
    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>(List.of(
                new Student(
                        sequence(INDEX_TYPE_STUDENT),
                        "김우진",
                        new ArrayList<>(Arrays.asList("1", "2", "3", "6", "7"))
                ),
                new Student(
                        sequence(INDEX_TYPE_STUDENT),
                        "남현",
                        new ArrayList<>(Arrays.asList("1", "2", "4", "8", "9"))
                ),
                new Student(
                        sequence(INDEX_TYPE_STUDENT),
                        "이민정",
                        new ArrayList<>(Arrays.asList("1", "4", "5", "6", "7", "9"))
                ),
                new Student(
                        sequence(INDEX_TYPE_STUDENT),
                        "이제범",
                        new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "7", "8"))
                ),
                new Student(
                        sequence(INDEX_TYPE_STUDENT),
                        "조성훈",
                        new ArrayList<>(Arrays.asList("2", "3", "4", "7", "9"))
                )
        ));
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
        scoreStore = new ArrayList<>();
    }

    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT -> {
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            }
            case INDEX_TYPE_SUBJECT -> {
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            }
            default -> {
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
            }
        }
    }

    // 메인뷰
    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> displayStudentView(); // 수강생 관리
                case 2 -> displayScoreView(); // 점수 관리
                case 3 -> flag = false; // 프로그램 종료
                default -> {
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    Thread.sleep(2000);
                }
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }

    // 1. 수강생 관리
    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 수강생 상태 관리");
            System.out.println("4. 수강생 정보 조회");
            System.out.println("5. 수강생 정보 수정");
            System.out.println("6. 상태별 수강생 목록 조회");
            System.out.println("7. 수강생 삭제");
            System.out.println("8. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createStudent(); // 수강생 등록
                case 2 -> inquireStudent(); // 수강생 목록 조회
                case 3 -> updateStudentState(); // 수강생 상태 관리
                case 4 -> inquireStudentInformation(); // 수강생 정보 조회
                case 5 -> updateStudent(); // 수강생 정보 수정
                case 6 -> inquireStudentState(); // 상태별 수강생 목록 조회
                case 7 -> removeStudent(); // 수강생 삭제
                case 8 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        System.out.println("==================================");
        System.out.println("수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();

        // 기능 구현 (필수 과목, 선택 과목)
        // 최소 3개 이상의 필수 과목, 2개 이상의 선택 과목을 선택합니다.
        ArrayList<String> studentSubjects = new ArrayList<>();

        // 필수 과목 선택
        int mandatorySubjectCount = 0;
        while (mandatorySubjectCount < 5) {
            System.out.println("==================================");
            System.out.println("3개 이상의 필수 과목을 선택해주세요.");
            for (int i = 0; i < subjectStore.size(); i++) {
                Subject subject = subjectStore.get(i);
                if (Objects.equals(subject.getSubjectType(), SUBJECT_TYPE_MANDATORY)) {
                    System.out.println((i + 1) + ". " + subject.getSubjectName());
                }
            }
            System.out.println("6. 필수 과목 선택 종료");
            String subject = sc.next();
            if (studentSubjects.contains(subject)) {
                System.out.println("이미 선택된 과목입니다. 다른 과목을 선택해주세요.");
            } else if (subject.equals("6") && mandatorySubjectCount >= 3){
                break;
            } else if (subject.matches("[1-5]")) {
                studentSubjects.add(subject);
                mandatorySubjectCount++;
            } else {
                System.out.println("1부터 5 사이의 숫자를 입력해주세요.");
            }

            System.out.print("선택한 과목 : ");
            for (String selected : studentSubjects) {
                System.out.print(selected + " ");
            }
            System.out.println();

        }

        // 선택 과목 선택
        int choiceSubjectCount = 0;
        while (choiceSubjectCount < 4) {
            System.out.println("==================================");
            System.out.println("2개 이상의 선택 과목을 선택해주세요.");
            for (int i = 0; i < subjectStore.size(); i++) {
                Subject subject = subjectStore.get(i);
                if (Objects.equals(subject.getSubjectType(), SUBJECT_TYPE_CHOICE)) {
                    System.out.println((i + 1) + ". " + subject.getSubjectName());
                }
            }
            System.out.println("10. 선택 과목 선택 종료");
            String subject = sc.next();
            if (studentSubjects.contains(subject)) {
                System.out.println("이미 선택된 과목입니다. 다른 과목을 선택해주세요.");
            } else if (subject.equals("10") && choiceSubjectCount >= 2) {
                break;
            } else if (subject.matches("[6-9]")) {
                studentSubjects.add(subject);
                choiceSubjectCount++;
            } else {
                System.out.println("6부터 9 사이의 숫자를 입력해주세요.");
            }

            System.out.print("선택한 과목 : ");
            for (String selected : studentSubjects) {
                System.out.print(selected + " ");
            }
            System.out.println();

        }

        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName, studentSubjects); // 수강생 인스턴스 생성 예시 코드
        // 기능 구현
        studentStore.add(student);
        System.out.println("수강생 등록 성공!");
    }

    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("==================================");
        System.out.println("수강생 목록을 조회합니다...");
        // 기능 구현
        // 조회 형식은 자유입니다.
        System.out.println("\n등록된 수강생 목록");
        for (Student student : studentStore) {
            System.out.println("ID : " + String.format("%-15s", student.getStudentId()) +
                    "이름 : " + String.format("%-15s", student.getStudentName()) +
                    "수강 과목 : " + student.getStudentSubject());
        }
        System.out.println("\n수강생 목록 조회 성공!");
    }

    // 수강생 상태 관리
    private static void updateStudentState() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("수강생 상태를 관리합니다...");
        // 기능 구현
        System.out.println("\n수강생 상태 관리 성공!");
    }

    // 수강생 정보 조회
    private static void inquireStudentInformation() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("수강생 정보를 조회합니다...");
        // 기능 구현
        boolean found = false;

        for (Student student : studentStore) {
            if (Objects.equals(student.getStudentId(), studentId)) {
                found = true;
                System.out.println("\n수강생 정보");
                System.out.println("ID : " + student.getStudentId());
                System.out.println("이름 : " + student.getStudentName());
                System.out.println("수강 과목 : " + student.getStudentSubject());
            }
        }

        if (!found) {
            System.out.println("해당 ID의 수강생을 찾을 수 없습니다.");
        }

        // 조회 형식은 자유입니다.
        System.out.println("\n수강생 정보 조회 성공!");
    }

    // 수강생 정보 수정
    private static void updateStudent() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("수강생 정보를 수정합니다...");
        // 기능 구현
        // 이름 또는 상태를 입력받아 수정하시면 됩니다.
        System.out.println("\n수강생 정보 수정 성공!");
    }

    // 상태별 수강생 목록 조회
    private static void inquireStudentState() {
        System.out.println("==================================");
        String studentState = getStudentState(); // 조회할 수강생 상태
        System.out.println("상태별 수강생 목록을 조회합니다...");
        // 기능 구현
        // 조회 형식은 자유입니다.
        System.out.println("\n상태별 수강생 목록 조회 성공!");
    }

    // 수강생 삭제
    private static void removeStudent() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("수강생을 삭제합니다...");
        // 기능 구현
        // 해당 수강생의 점수 기록도 함께 삭제됩니다.
        System.out.println("\n수강생 삭제 성공!");
    }

    // 2. 점수 관리
    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 수강생의 과목별 평균 등급 조회");
            System.out.println("5. 특정 상태 수강생들의 필수 과목 평균 등급 조회");
            System.out.println("6. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1 -> createScore(); // 수강생의 과목별 시험 회차 및 점수 등록
                case 2 -> updateRoundScoreBySubject(); // 수강생의 과목별 회차 점수 수정
                case 3 -> inquireRoundGradeBySubject(); // 수강생의 특정 과목 회차별 등급 조회
                case 4 -> inquireAverageGradeBySubject(); // 수강생의 과목별 평균 등급 조회
                case 5 -> inquireAverageGradeBySubjectForSpecificState(); // 특정 상태 수강생들의 필수 과목 평균 등급 조회
                case 6 -> flag = false; // 메인 화면 이동
                default -> {
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                }
            }
        }
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        // 기능 구현
        // 등록하려는 과목의 회차 점수가 이미 등록되어 있다면 등록할 수 없습니다.
        // 과목의 회차 점수가 중복되어 등록될 수 없습니다.
        // 회차에 10 초과 및 1 미만의 수가 저장될 수 없습니다. (회차 범위: 1 ~ 10)
        // 점수에 100 초과 및 음수가 저장될 수 없습니다. (점수 범위: 0 ~ 100)

        // 점수 데이터 타입 : 정수형
        // 점수에 따라 등급이 매겨집니다.
        // 캠프 기간동안 선택한 과목별로 총 10회의 시험을 봅니다.
        System.out.println("\n점수 등록 성공!");
        // 점수를 등록하면 자동으로 등급이 추가 저장됩니다.
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        System.out.println("시험 점수를 수정합니다...");
        // 기능 구현
        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (조회할 특정 과목)
        System.out.println("회차별 등급을 조회합니다...");
        // 기능 구현
        // 조회 형식은 자유입니다.
        System.out.println("\n등급 조회 성공!");
    }

    // 수강생의 과목별 평균 등급 조회
    private static void inquireAverageGradeBySubject() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (과목별 평균 등급)
        System.out.println("과목별 평균 등급을 조회합니다...");
        // 기능 구현
        // 조회 형식은 자유입니다.
        System.out.println("\n평균 등급 조회 성공!");
    }

    // 특정 상태 수강생들의 필수 과목 평균 등급 조회
    private static void inquireAverageGradeBySubjectForSpecificState() {
        System.out.println("==================================");
        String studentState = getStudentState(); // 조회할 수강생 상태
        // 기능 구현 (조회할 특정 상태)
        // 기능 구현 (필수 과목 평균 등급) 
        System.out.println("특정 상태 수강생들의 필수 과목 평균 등급을 조회합니다...");
        // 기능 구현
        // 조회 형식은 자유입니다.
        System.out.println("\n필수 과목 평균 등급 조회 성공!");
    }

    private static String getStudentId() {
        System.out.print("관리할 수강생의 번호를 입력하시오...");
        return "ST" + sc.next();
    }

    private static String getStudentName() {
        System.out.print("관리할 수강생의 이름를 입력하시오...");
        return sc.next();
    }

    private static String getStudentState() {
        System.out.print("조회할 수강생의 상태를 입력하시오...");
        return sc.next();
    }

}