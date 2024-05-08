package camp;

import camp.model.Score;
import camp.model.Student;
import camp.model.Subject;

import java.util.*;

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
        scoreStore = List.of(
                new Score(
                    sequence(INDEX_TYPE_SCORE),
                    "ST1",
                    "SU1",
                    1,
                    95,
                    SUBJECT_TYPE_MANDATORY
            )

        );
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
                if (Objects.equals(subject.getSubjectType(), SUBJECT_TYPE_MANDATORY)) {
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
            else if (subject.equals("6") && mandatorySubjectCount >= 3){
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
                if (Objects.equals(subject.getSubjectType(), SUBJECT_TYPE_CHOICE)) {
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
            else if (subject.equals("10") && choiceSubjectCount >= 2) {
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
            if (subject.getSubjectId().equals("SU" + id)) {
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
        boolean found = false;

        for (Student student : studentStore) {
            if (Objects.equals(student.getStudentId(), studentId)) {
                found = true;
                System.out.println("\n수강생 정보");
                printStudentStateBar();
                printStudentState(student);

                while (true) {
                    System.out.println("\n수강생의 상태를 입력하세요");
                    System.out.println("1. Green");
                    System.out.println("2. Red");
                    System.out.println("3. Yellow");
                    String newState= sc.next();

                    if (Objects.equals(newState, "1")) {
                        student.setStudentState("Green");

                        System.out.println("\n수강생 정보");
                        printStudentStateBar();
                        printStudentState(student);
                        break;
                    } else if (Objects.equals(newState, "2")) {
                        student.setStudentState("Red");

                        System.out.println("\n수강생 정보");
                        printStudentStateBar();
                        printStudentState(student);
                        break;
                    } else if (Objects.equals(newState, "3")) {
                        student.setStudentState("Yellow");

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

        if (found) {
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
        boolean found = false;

        for (Student student : studentStore) {
            if (Objects.equals(student.getStudentId(), studentId)) {
                System.out.println("\n수강생 정보");
                // 조회 형식은 자유입니다.
                printStudentAllBar();
                printStudentAll(student);

                found = true;
            }
        }

        if (found) {
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
        boolean found = false;

        for (Student student : studentStore) {
            if (Objects.equals(student.getStudentId(), studentId)) {
                System.out.println("\n수강생 정보");
                printStudentNameBar();
                printStudentName(student);

                System.out.print("\n수강생의 이름을 입력하세요 : ");
                String newName= sc.next();
                student.setStudentName(newName);

                System.out.println("\n수강생 정보");
                printStudentNameBar();
                printStudentName(student);

                found = true;
            }
        }

        if (found) {
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
        boolean found = false;
        for (Student student : studentStore) {
            if (Objects.equals(student.getStudentState(), studentState)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println();

            // 조회 형식은 자유입니다.
            printStudentStateBar();
            for (Student student : studentStore) {
                if (Objects.equals(student.getStudentState(), studentState)) {
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
        // 해당 수강생의 점수 기록도 함께 삭제됩니다.
        boolean found = studentStore.removeIf(student -> Objects.equals(student.getStudentId(), studentId));

        if (found) {
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
        Integer testNum;
        // 기능 구현
        while(true) {
            try {
                studentId = getStudentId(); // 관리할 수강생 고유 번호
                subjectId = getSubjectId();
                testNum = getTestNumber();
                if(!checkSavedScore(studentId, subjectId, testNum)){
                    throw new Exception();
                }
                break;
            }catch(Exception e) {
                System.out.println("등록하려는 과목의 회차 점수가 이미 등록되어 있습니다");
            }
        }
        Integer score = getTestScore();
        System.out.println("시험 점수를 등록합니다...");
        scoreStore.add(new Score(sequence(INDEX_TYPE_SCORE), studentId,subjectId, testNum, score, checkSubjectType(subjectId)));
//        for (Subject s : subjectStore) {
//            System.out.println(s.getSubjectId());
//            System.out.println(s.getSubjectType());
//        }
//        for (Score s : scoreStore) {
//            System.out.println(s.getScoreId());
//            System.out.println(s.getGrade());
//            System.out.println(s.getSubjectType());
//        }
        System.out.println("\n점수 등록 성공!");
    }

    private static String getSubjectId() {
        System.out.print("\n등록할 시험 과목의 번호를 입력하시오...");
        return sc.next();
    }

    private static Integer getTestNumber() {
        Integer N;
        while(true){
            try{
                System.out.print("\n시험 회차를 입력하시오...");
                N = Integer.parseInt(sc.next()); //수정
                if( N > 10 || N < 1){
                    throw new Exception();
                }
                break;
            } catch(Exception e){
                System.out.println("회차에 10 초과 및 1 미만의 수가 저장될 수 없습니다");
            }
        }
        return N;
    }

    private static Integer getTestScore() {
        Integer N;
        while(true){
            try{
                System.out.print("\n시험 점수를 입력하시오...");
                N = Integer.parseInt(sc.next()); //수정
                if( N > 100 || N < 0){
                    throw new Exception();
                }
                break;
            } catch(Exception e){
                System.out.println("점수에 100 초과 및 음수가 저장될 수 없습니다"); // 수정
            }
        }
        return  N;
    }

    private static String checkSubjectType(String subjectID){
        for (Subject subject : subjectStore) {
            if (Objects.equals(subject.getSubjectId(),subjectID)){
                return subject.getSubjectType();
            }
        }
        return null;
    }

    private  static  boolean checkSavedScore(String studentId, String subjectId, Integer testNum){
        boolean tf = true;
        if ( !scoreStore.isEmpty()){
            for (Score s : scoreStore){
                if (s.getSubjectId().equals(studentId) && s.getSubjectId().equals(subjectId) && s.getTestNum() == testNum){
                    tf = false;
                    break;
                }
            }
        }
        return tf;
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String subjectName="", subjectType, scoreId;
        int textNum, score, testNum;
        System.out.println("==================================");
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)
        for(Student student : studentStore) {
            if(student.getStudentId().equals(studentId)) {
                System.out.println("1. Java, 2. 객체지향, 3. Spring, 4. JPA, 5. MySQL, 6. 디자인 패턴, 7. Spring Security, 8. Redis, 9.MongoDB");
                System.out.println("학생이 선택한 과목 : " + student.getStudentSubject()); // 학생 과목 출력
                break;
            }
        }
        System.out.print("수정할 과목을 입력하시오...(과목명으로 입력)");
        sc.nextLine();
        boolean flag=true;
        while(flag) {
            subjectName = sc.nextLine();    // 이름으로 받아야함.
            for(Subject subject:subjectStore) {
                if(subject.getSubjectName().equals(subjectName)){
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.println("잘못 입력하였습니다. 다시 입력하시오...");
            }
        }

        //subjectName을 SU1, Su2... 등등 바꿔주기
        ChangeSubjectName changeSubjectName = new ChangeSubjectName();
        subjectName = changeSubjectName.changeSubjectName(subjectName);

        for (Score scorestore : scoreStore) {
            if(scorestore.getStudentId().equals(studentId) && scorestore.getSubjectId().equals(subjectName)) { // 검증: 학생id, 과목이름
                System.out.println("작성된 회차: " + scorestore.getTestNum());
            }
        }
        System.out.print("\n수정할 회차를 입력하시오...");
        testNum = sc.nextInt();

        for (Score scorestore : scoreStore) {
            if(scorestore.getStudentId().equals(studentId) && scorestore.getSubjectId().equals(subjectName) && scorestore.getTestNum()==testNum) { // 검증: 학생id, 과목이름, 회차  // subject == SU1
                System.out.println("기존 시험 점수: " + scorestore.getScore());
            }
        }
        System.out.print("\n수정할 시험 점수를 입력하시오...");
        score = sc.nextInt();
        System.out.println("\n시험 점수를 수정합니다...");
        // 기능 구현
        for (Score scorestore : scoreStore) {
             if(scorestore.getStudentId().equals(studentId) && scorestore.getSubjectId().equals(subjectName) && scorestore.getTestNum()==testNum) { // 검증: 학생id, 과목이름, 회차
                scorestore.setscore(score);
            }
        }
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
        System.out.println("1. Green");
        System.out.println("2. Red");
        System.out.println("3. Yellow");
        return sc.next();
    }

}