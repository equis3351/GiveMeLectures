package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.*;

import static java.sql.Types.NULL;

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
        studentStore = new ArrayList<>(List.of(
            new Student(
                    sequence(INDEX_TYPE_STUDENT),
                    "김우진",
                    new ArrayList<>(Arrays.asList(subjectStore.get(0), subjectStore.get(1), subjectStore.get(2), subjectStore.get(5), subjectStore.get(6)))
            ),
            new Student(
                    sequence(INDEX_TYPE_STUDENT),
                    "남현",
                    new ArrayList<>(Arrays.asList(subjectStore.get(0), subjectStore.get(1), subjectStore.get(3), subjectStore.get(7), subjectStore.get(8)))
            ),
            new Student(
                    sequence(INDEX_TYPE_STUDENT),
                    "이민정",
                    new ArrayList<>(Arrays.asList(subjectStore.get(0), subjectStore.get(3), subjectStore.get(4), subjectStore.get(5), subjectStore.get(6), subjectStore.get(8)))
            ),
            new Student(
                    sequence(INDEX_TYPE_STUDENT),
                    "이제범",
                    new ArrayList<>(Arrays.asList(subjectStore.get(0), subjectStore.get(1), subjectStore.get(2), subjectStore.get(3), subjectStore.get(4), subjectStore.get(6), subjectStore.get(7)))
            ),
            new Student(
                    sequence(INDEX_TYPE_STUDENT),
                    "조성훈",
                    new ArrayList<>(Arrays.asList(subjectStore.get(1), subjectStore.get(2), subjectStore.get(3), subjectStore.get(6), subjectStore.get(8)))
            )
        ));
        scoreStore = new ArrayList<>(List.of(
                new Score(

                        sequence(INDEX_TYPE_SCORE),
                        "ST1",
                        "SU1",
                        1,
                        95,
                        SUBJECT_TYPE_MANDATORY),


                new Score(
                        sequence(INDEX_TYPE_SCORE),
                        "ST2",
                        "SU1",
                        1,
                        65,
                        SUBJECT_TYPE_MANDATORY
                ),
                new Score(
                        sequence(INDEX_TYPE_SCORE),
                        "ST4",
                        "SU1",
                        1,
                        45,
                        SUBJECT_TYPE_MANDATORY
                ),
                new Score(
                        sequence(INDEX_TYPE_SCORE),
                        "ST5",
                        "SU1",
                        1,
                        45,
                        SUBJECT_TYPE_MANDATORY
                )

        ));
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
            System.out.println("==================================");
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

        List<Subject> studentSubjects = new ArrayList<>();

        // 필수 과목 선택
        int mandatorySubjectCount = 0; // 선택한 필수 과목 수 초기화

        // 최대 5개의 필수 과목을 선택할 때까지 반복
        while (mandatorySubjectCount < 5) {
            System.out.println("==================================");
            System.out.println("3개 이상의 필수 과목을 선택해주세요.\n");

            // 선택 가능한 필수 과목 목록 출력
            for (int i = 0; i < subjectStore.size(); i++) {
                Subject subject = subjectStore.get(i);
                if (SUBJECT_TYPE_MANDATORY.equals(subject.getSubjectType())) {
                    System.out.println((i + 1) + ". " + subject.getSubjectName());
                }
            }
            System.out.println("6. 필수 과목 선택 종료");

            // 사용자로부터 과목 선택 입력 받기
            String subject = sc.next();

            // 선택한 과목 찾기
            Subject foundSubject = findSubjectById(subject);

            // 이미 선택된 과목인지 확인하고 메시지 출력
            if (studentSubjects.contains(foundSubject)) {
                System.out.println("이미 선택된 과목입니다. 다른 과목을 선택해주세요.\n");
            }
            // 선택 종료 조건 확인
            else if ("6".equals(subject) && mandatorySubjectCount >= 3){
                break;
            }
            // 유효한 선택인지 확인하고 선택한 과목 목록에 추가
            else if (subject.matches("[1-5]")) {
                studentSubjects.add(foundSubject);
                mandatorySubjectCount++;
            }
            // 잘못된 입력 처리
            else {
                System.out.println("1부터 5 사이의 숫자를 입력해주세요.\n");
            }

            // 선택한 과목 목록 출력
            System.out.print("\n선택한 과목\n");
            for (Subject selected : studentSubjects) {
                System.out.println(selected);
            }
            System.out.println();

        }

        // 선택 과목 선택
        int choiceSubjectCount = 0; // 선택한 과목 수 초기화

        // 최대 4개의 선택 과목을 선택할 때까지 반복
        while (choiceSubjectCount < 4) {
            System.out.println("==================================");
            System.out.println("2개 이상의 선택 과목을 선택해주세요.\n");

            // 선택 가능한 과목 목록 출력
            for (int i = 0; i < subjectStore.size(); i++) {
                Subject subject = subjectStore.get(i);
                if (SUBJECT_TYPE_CHOICE.equals(subject.getSubjectType())) {
                    System.out.println((i + 1) + ". " + subject.getSubjectName());
                }
            }
            System.out.println("10. 선택 과목 선택 종료");

            // 사용자로부터 과목 선택 입력 받기
            String subject = sc.next();

            // 선택한 과목 찾기
            Subject foundSubject = findSubjectById(subject);

            // 이미 선택된 과목인지 확인하고 메시지 출력
            if (studentSubjects.contains(foundSubject)) {
                System.out.println("이미 선택된 과목입니다. 다른 과목을 선택해주세요.\n");
            }
            // 선택 종료 조건 확인
            else if ("10".equals(subject) && choiceSubjectCount >= 2) {
                break;
            }
            // 유효한 선택인지 확인하고 선택한 과목 목록에 추가
            else if (subject.matches("[6-9]")) {
                studentSubjects.add(foundSubject);
                choiceSubjectCount++;
            }
            // 잘못된 입력 처리
            else {
                System.out.println("6부터 9 사이의 숫자를 입력해주세요.\n");
            }

            // 선택한 과목 목록 출력
            System.out.print("\n선택한 과목\n");
            for (Subject selected : studentSubjects) {
                System.out.println(selected);
            }
            System.out.println();

        }

        // 수강생 인스턴스 생성 코드
        Student student = new Student(sequence(INDEX_TYPE_STUDENT), studentName, studentSubjects);

        System.out.println("\n수강생 정보");
        printStudentNoStateBar();
        printStudentNoState(student);

        studentStore.add(student);
        System.out.println("\n수강생 등록 성공!");
    }

    // 과목 ID로 과목을 찾는 메서드
    private static Subject findSubjectById(String id) {
        for (Subject subject : subjectStore) {
            if (("SU" + id).equals(subject.getSubjectId())) {
                return subject;
            }
        }
        return null;
    }

    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("==================================");
        System.out.println("수강생 목록을 조회합니다...");
        // 기능 구현
        // 조회 형식은 자유입니다.
        System.out.println("\n등록된 수강생 목록");
        printStudentAllBar();
        for (Student student : studentStore) {
            printStudentAll(student);
        }

        System.out.println("\n수강생 목록 조회 성공!");
    }

    // 수강생 상태 관리
    private static void updateStudentState() {
        System.out.println("==================================");
        System.out.println("수강생 상태를 관리합니다...");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현
        boolean isFound = false;

        for (Student student : studentStore) {
            if (studentId.equals(student.getStudentId())) {
                isFound = true;
                System.out.println("\n수강생 정보");
                printStudentStateBar();
                printStudentState(student);

                while (true) {
                    System.out.println("\n수강생의 상태를 입력하세요");
                    System.out.println("1. Green");
                    System.out.println("2. Red");
                    System.out.println("3. Yellow");
                    String newState= sc.next();

                    if ("1".equals(newState)) {
                        student.updateStudentState("Green");

                        System.out.println("\n수강생 정보");
                        printStudentStateBar();
                        printStudentState(student);
                        break;
                    } else if ("2".equals(newState)) {
                        student.updateStudentState("Red");

                        System.out.println("\n수강생 정보");
                        printStudentStateBar();
                        printStudentState(student);
                        break;
                    } else if ("3".equals(newState)) {
                        student.updateStudentState("Yellow");

                        System.out.println("\n수강생 정보");
                        printStudentStateBar();
                        printStudentState(student);
                        break;
                    } else {
                        System.out.println("1부터 3 사이의 숫자를 입력해주세요.");
                    }
                }
            }
        }

        if (isFound) {
            System.out.println("\n수강생 상태 관리 성공!");
        } else {
            System.out.println("\n해당 ID의 수강생을 찾을 수 없습니다.");
        }

    }

    // 수강생 정보 조회
    private static void inquireStudentInformation() {
        System.out.println("==================================");
        System.out.println("수강생 정보를 조회합니다...");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현
        boolean isFound = false;

        for (Student student : studentStore) {
            if (studentId.equals(student.getStudentId())) {
                System.out.println("\n수강생 정보");
                // 조회 형식은 자유입니다.
                printStudentAllBar();
                printStudentAll(student);

                isFound = true;
            }
        }

        if (isFound) {
            System.out.println("\n수강생 정보 조회 성공!");
        } else {
            System.out.println("\n해당 ID의 수강생을 찾을 수 없습니다.");
        }

    }

    // 수강생 정보 수정
    private static void updateStudent() {
        System.out.println("==================================");
        System.out.println("수강생 정보를 수정합니다...");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현
        // 이름 또는 상태를 입력받아 수정하시면 됩니다.
        boolean isFound = false;

        for (Student student : studentStore) {
            if (studentId.equals(student.getStudentId())) {
                System.out.println("\n수강생 정보");
                printStudentNameBar();
                printStudentName(student);

                System.out.print("\n수강생의 이름을 입력하세요 : ");
                String newName= sc.next();
                student.updateStudentName(newName);

                System.out.println("\n수강생 정보");
                printStudentNameBar();
                printStudentName(student);

                isFound = true;
            }
        }

        if (isFound) {
            System.out.println("\n수강생 정보 수정 성공!");
        } else {
            System.out.println("\n해당 ID의 수강생을 찾을 수 없습니다.");
        }

    }

    // 상태별 수강생 목록 조회
    private static void inquireStudentState() {
        System.out.println("==================================");
        System.out.println("상태별 수강생 목록을 조회합니다...");
        System.out.println("1. Green");
        System.out.println("2. Red");
        System.out.println("3. Yellow");

        String studentState;
        String[] states = {"Green", "Red", "Yellow"};

        while (true) {
            System.out.print("\n조회할 수강생의 상태를 입력하세요...");
            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {
                studentState = states[choice - 1];
                break;
            } else {
                System.out.println("1부터 3 사이의 숫자를 입력해주세요.");
            }
        }

        // 기능 구현
        boolean isFound = false;
        for (Student student : studentStore) {
            if (studentState.equals(student.getStudentState())) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            System.out.println();

            // 조회 형식은 자유입니다.
            printStudentStateBar();
            for (Student student : studentStore) {
                if (studentState.equals(student.getStudentState())) {
                    printStudentState(student);
                }
            }

            System.out.println("\n상태별 수강생 목록 조회 성공!");
        } else {
            System.out.println("\n해당 상태의 수강생을 찾을 수 없습니다.");
        }

    }

    // 수강생 삭제
    private static void removeStudent() {
        System.out.println("==================================");
        System.out.println("수강생을 삭제합니다...");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현
        boolean isFound = studentStore.removeIf(student -> studentId.equals(student.getStudentId()));

        if (isFound) {
            // 해당 수강생의 점수 기록도 함께 삭제됩니다.
            scoreStore.removeIf(score -> studentId.equals(score.getStudentId()));
            System.out.println("\n수강생 삭제 성공!");
        } else {
            System.out.println("\n해당 ID의 수강생을 찾을 수 없습니다.");
        }

    }

    // ID, NAME 출력
    private static void printStudentName(Student student) {
        System.out.printf("%-8s | %s%n",
                student.getStudentId(),
                student.getStudentName());
    }

    private static void printStudentNameBar() {
        System.out.printf("%-8s | %s%n", "ID", "이름");
        System.out.println("-----------------");
    }

    // ID, NAME, STATE 출력
    private static void printStudentState(Student student) {
        int gap = 8;
        if (student.getStudentName().length() == 2) {
            gap = 9;
        } else if (student.getStudentName().length() == 4) {
            gap = 7;
        }
        System.out.printf("%-8s | %-" + gap + "s | %s%n",
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentState());
    }

    private static void printStudentStateBar() {
        System.out.printf("%-8s | %-9s | %s%n", "ID", "이름", "상태");
        System.out.println("------------------------------");
    }

    // ID, NAME, SUBJECT 출력
    private static void printStudentNoState(Student student) {
        int gap = 8;
        if (student.getStudentName().length() == 2) {
            gap = 9;
        } else if (student.getStudentName().length() == 4) {
            gap = 7;
        }
        System.out.printf("%-8s | %-" + gap + "s | %s%n",
                student.getStudentId(),
                student.getStudentName(),
                formatSubjects(student.getStudentSubject()));
    }

    private static void printStudentNoStateBar() {
        System.out.printf("%-8s | %-9s | %s%n", "ID", "이름", "수강 과목");
        System.out.println("-----------------------------------------");
    }

    // ID, NAME, STATE, SUBJECT 출력
    private static void printStudentAll(Student student) {
        int gap = 8;
        if (student.getStudentName().length() == 2) {
            gap = 9;
        } else if (student.getStudentName().length() == 4) {
            gap = 7;
        }
        System.out.printf("%-8s | %-" + gap + "s | %-10s | %s%n",
                student.getStudentId(),
                student.getStudentName(),
                student.getStudentState(),
                formatSubjects(student.getStudentSubject()));
    }

    private static void printStudentAllBar() {
        System.out.printf("%-8s | %-9s | %-9s | %s%n", "ID", "이름", "상태", "수강 과목");
        System.out.println("----------------------------------------------------");
    }

    // 학생이 수강한 과목 목록을 포맷하는 메서드
    private static String formatSubjects(List<Subject> subjects) {
        List<String> subjectNames = new ArrayList<>();
        for (Subject subject : subjects) {
            subjectNames.add(subject.getSubjectName());
        }
        return String.join(", ", subjectNames);
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
        String studentId;
        String subjectId;
        int round;
        // 기능 구현
        while(true) {
            try {
                studentId = getStudentId(); // 관리할 수강생 고유 번호
                String finalStudentId = studentId;
                if (studentStore.stream().noneMatch(s -> finalStudentId.equals(s.getStudentId()))){
                    System.out.println("\n해당 학생이 존재하지 않습니다.");
                    return;
                }

                subjectId = getSubjectId();
                round = getRound();
                if(!checkSavedScore(studentId, subjectId, round)){
                    throw new Exception();
                }
                break;
            }catch(Exception e) {
                System.out.println("등록하려는 과목의 회차 점수가 이미 등록되어 있습니다");
            }
        }
        int score = getTestScore();

        printScoreStateBar();
        printScoreState(studentId, subjectId, round, score);
        System.out.println("시험 점수를 등록합니다...");

        scoreStore.add(new Score(sequence(INDEX_TYPE_SCORE), studentId,subjectId, round, score, checkSubjectType(subjectId)));

        System.out.println("\n점수 등록 성공!");
    }

    private static void printScoreStateBar(){
        System.out.printf("%-8s | %-9s | %-9s | %s%n ", "student", "subject","test", "score");
        System.out.println("------------------------------");
    }

    private static void printScoreState(String A, String B, Integer C, Integer D){
        System.out.printf("%-8s | %-9s | %-9d | %d%n",A,B,C,D);
    }

    private static String getSubjectId() {
        while (true) {
            System.out.print("\n등록할 시험 과목의 번호를 입력하시오...");
            String sub = INDEX_TYPE_SUBJECT+sc.next();
            if(subjectStore.stream().anyMatch(s -> sub.equals(s.getSubjectId()))){
            return sub;}
            System.out.println("\n해당 과목이 존재하지 않습니다...");
        }
    }

    private static int getRound() {
        int n;
        while(true){
            try{
                System.out.print("\n시험 회차를 입력하시오...");
                n = Integer.parseInt(sc.next());
                if( n > 10 || n < 1){
                    throw new Exception();
                }
                break;
            } catch(Exception e){
                System.out.println("회차에 10 초과 및 1 미만의 수가 저장될 수 없습니다");
            }
        }
        return n;
    }

    private static int getTestScore() {
        int n;
        while(true){
            try{
                System.out.print("\n시험 점수를 입력하시오...");
                n = Integer.parseInt(sc.next());
                if( n > 100 || n < 0){
                    throw new Exception();
                }
                break;
            } catch(Exception e){
                System.out.println("점수에 100 초과 및 음수가 저장될 수 없습니다");
            }
        }
        return  n;
    }

    private static String checkSubjectType(String subjectID){
        for (Subject subject : subjectStore) {
            if (subjectID.equals(subject.getSubjectId())){
                return subject.getSubjectType();
            }
        }
        return null;
    }

    private static boolean checkSavedScore(String studentId, String subjectId, Integer round){
        boolean tf = true;
        if ( !scoreStore.isEmpty()){
            for (Score s : scoreStore){
                if (s.getStudentId().equals(studentId) && s.getSubjectId().equals(subjectId) && s.getRound() == round){
                    tf = false;
                    break;
                }
            }
        }
        return tf;
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String subjectId="";
        int score, round=0;
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호

        if (studentStore.stream().noneMatch(s -> studentId.equals(s.getStudentId()))){
            System.out.println("\n해당 학생이 존재하지 않습니다.");
            return;
        }

        // 기능 구현 (수정할 과목 및 회차, 점수)
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("\n1. Java, 2. 객체지향, 3. Spring, 4. JPA, 5. MySQL, 6. 디자인 패턴, 7. Spring Security, 8. Redis, 9.MongoDB");
                System.out.println("학생이 선택한 과목 : " + student.getStudentSubject() + "\n"); // 학생 과목 출력
                break;
            }
        }

        System.out.print("수정할 과목을 입력하시오...");
        sc.nextLine();
        boolean flag = true;
        while (true) {
            subjectId = sc.nextLine(); // 이름으로 받아야함. --> 번호로 받도록 수정
            subjectId = "SU" + subjectId; //subjectId(1, 2...)을 SU1, SU2... 등등 바꿔주기
            for (Score score_store : scoreStore) {
                if (score_store.getSubjectId().equals(subjectId) &&
                        score_store.getRound() != NULL) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                break;
            }

            System.out.print("없는 과목이거나 회차가 존재하지 않습니다.\n\n다시 입력하시오...");
        } // 해당 과목에 대한 회차가 있으면 넘어가도록 수정하기

        flag = true;
        while (true) {
            for (Score score_store : scoreStore) {
                if (score_store.getStudentId().equals(studentId) &&
                        score_store.getSubjectId().equals(subjectId)) // 검증: 학생 id, 과목이름
                {
                    System.out.println("\n작성된 회차: " + score_store.getRound());
                }
            }

            System.out.print("\n수정할 회차를 입력하시오...");
            round = sc.nextInt();
            for (Score score_store : scoreStore) {
                if (score_store.getStudentId().equals(studentId) &&
                        score_store.getSubjectId().equals(subjectId) &&
                        score_store.getRound() == round) { // 검증: 학생 id, 과목이름, 회차
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }

            System.out.print("\n잘못된 입력입니다.");
        }

        for (Score score_store : scoreStore) {
            if (score_store.getStudentId().equals(studentId) &&
                    score_store.getSubjectId().equals(subjectId) &&
                    score_store.getRound() == round) { // 검증: 학생 id, 과목이름, 회차  // subject == SU1
                System.out.println("\n기존 시험 점수 : " + score_store.getScore());
            }
        }

        while (true) {
            System.out.print("\n수정할 시험 점수를 입력하시오...");
            score = sc.nextInt();
            if (score > 100 || score < 0) {
                System.out.print("잘못된 점수입니다.\n");
            } else {
                break;
            }
        }
        System.out.println("\n시험 점수를 수정합니다...");

        // 기능 구현
        for (Score score_store : scoreStore) {
            if (score_store.getStudentId().equals(studentId) &&
                    score_store.getSubjectId().equals(subjectId) &&
                    score_store.getRound() == round) { // 검증: 학생 id, 과목이름, 회차
                score_store.updateScore(score);
            }
        }
        System.out.println("\n점수 수정 성공!");

    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if (studentStore.stream().noneMatch(s -> studentId.equals(s.getStudentId()))){
            System.out.println("\n해당 학생이 존재하지 않습니다.");
            return;
        }

        // 기능 구현 (조회할 특정 과목)
        System.out.println("다음 과목 중에서 회차별 등급을 조회할 과목을 입력해주세요.");

        studentStore.stream().filter((Student stu)-> stu.getStudentId().equals(studentId)).forEach(student -> {
            student.getStudentSubject().forEach(subject -> {
                System.out.print("/ "+subject+" ");
            });
        });
        System.out.print("/\n\n");
        int cnt=0;
        sc.nextLine();
        while(cnt<3) {
            String answer = sc.nextLine();
            if(studentStore.stream().anyMatch((Student student)->{
                return student.getStudentId().equals(studentId) && student.getStudentSubject().stream().anyMatch((Subject subject)-> subject.getSubjectName().equals(answer));
            })) {
                System.out.println("회차별 등급을 조회합니다...\n");
                String subjectId = subjectStore.stream().filter((Subject subject) -> subject.getSubjectName().equals(answer)).findFirst().get().getSubjectId();
                scoreStore.stream()
                        .filter((Score score)-> score.getStudentId().equals(studentId))
                        .filter((Score score)-> score.getSubjectId().equals(subjectId))
                        .sorted(Comparator.comparing(Score::getRound))
                        .forEach((Score score) -> {
                            System.out.println(score.getRound()+"회차 등급 : "+score.getGrade());
                        });
                System.out.println("\n등급 조회 성공!");
                break;
            } else{
                System.out.println("잘못된 입력입니다. 정확한 과목명을 입력해주세요. (재입력 기회 "+(2-cnt)+"회 남았습니다.)");
                cnt+=1;
            }
        }
    }

    // 수강생의 과목별 평균 등급 조회
    private static void inquireAverageGradeBySubject() {
        System.out.println("==================================");
        System.out.println("과목별 평균 등급을 조회합니다...");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        if (studentStore.stream().noneMatch(s -> studentId.equals(s.getStudentId()))){
            System.out.println("\n해당 학생이 존재하지 않습니다.");
            return;
        }

        // 기능 구현 (과목별 평균 등급)
        for (Student student : studentStore) {
            if (student.getStudentId().equals(studentId))  { // studentID 값이 같을때 까지
                System.out.printf("\n%-15s|%s\n", "과목별 평균 등급", "과목 이름");
                System.out.println("---------------------------------------");
                for (Subject subject : student.getStudentSubject()) {
                    String subjectName = subject.getSubjectName(); // 과목 이름 가져오기
                    double averageScore = getAverageScore(subject, studentId);

                    // 조회 형식은 자유입니다.
                    System.out.printf("%-20s|%s\n", averageScore, subjectName);
                }
                break; // 찾았으니 반복문 종료
            }
        }
        System.out.println("\n평균 등급 조회 성공!");
    }

    private static double getAverageScore(Subject subject, String studentId) {
        double totalScore = 0;
        int numberOfScores = 0; // 해당 과목의 점수 개수를 세기 위한 변수!
        for (Score score : scoreStore) {
            String scoreSubjectId = score.getSubjectId(); // score 과목 아이디
            String scoreStudentId = score.getStudentId(); // score 학생 아이디
            if (studentId.equals(scoreStudentId) && subject.getSubjectId().equals(scoreSubjectId)) {
                totalScore += score.getScore();
                numberOfScores++;
            }
        }
        // 평균 계산
        return totalScore / numberOfScores;
    }

    // 특정 상태 수강생들의 필수 과목 평균 등급 조회
    private static void inquireAverageGradeBySubjectForSpecificState() {
        System.out.println("==================================");
        String studentState = getStudentState(); // 조회할 수강생 상태  1.green, 2.red, 3.yellow
        switch (studentState) {
            case "1" : studentState = "Green";
            case "2" : studentState = "Red";
            case "3" : studentState = "Yellow";
        }
        // 기능 구현 (조회할 특정 상태)
        ArrayList<String> studentIdForSpecificState = new ArrayList<>();
        for (Student student : studentStore) {
            if (student.getStudentState().equals(studentState)) {
                studentIdForSpecificState.add(student.getStudentId());   //특정 상태의 학생 아이디를 리스트에 저장
            }
        }
        // 기능 구현 (필수 과목 평균 등급)
        int sum=0;
        double avg=0;
        char grade;
        System.out.println("특정 상태 수강생들의 필수 과목 평균 등급을 조회합니다...");
        for (Score score : scoreStore) {
            for (int i = 0; i < studentIdForSpecificState.size(); i++) {
                if (studentIdForSpecificState.get(i).equals(score.getStudentId()) && SUBJECT_TYPE_MANDATORY.equals(score.getSubjectType())) { // 특정 상태의 필수과목
                    sum += score.getScore();
                }
            }
        }
        avg = (double) sum/studentIdForSpecificState.size();
        if (avg >= 95) {
            grade = 'A';
        } else if (avg >= 90) {
            grade = 'B';
        } else if (avg >= 80) {
            grade = 'C';
        } else if (avg >= 70) {
            grade = 'D';
        } else if (avg >= 60) {
            grade = 'F';
        } else {
            grade = 'N';
        }
        System.out.println(studentState+" 상태의 수강생의 필수 과목 평균 등급: "+grade);

        // 기능 구현
        // 조회 형식은 자유입니다.
        System.out.println("\n필수 과목 평균 등급 조회 성공!");
    }

    private static String getStudentId() {
        System.out.print("관리할 수강생의 번호를 입력하시오...");
        return INDEX_TYPE_STUDENT + sc.next();
    }

    private static String getStudentState() {
        System.out.println("조회할 수강생의 상태를 입력하시오...");
        System.out.println("1. Green");
        System.out.println("2. Red");
        System.out.println("3. Yellow");
        return sc.next();
    }

}