package Server;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class ServerComputer {
    static Scanner scanner = new Scanner(System.in);

    static String today = LocalDate.now().toString();

    static HashMap<String, User> userHashMap = new HashMap<>();
    static Ranking rankingSystem = new Ranking();

    Manager<UserData> userDataManager = new Manager<>("data\\user-data.txt", () -> new UserData());
    Manager<ExerciseLog> exerciseLogManager = new Manager<>("data\\user-exercise-log.txt", () -> new ExerciseLog());
    Manager<Inbody> inbodyManager = new Manager<>("data\\user-inbody.txt", () -> new Inbody());
    Manager<Program> programManager = new Manager<>("data\\program-data.txt", () -> new Program());

    //Me me = new Me("..\\Client\\my-info.txt");

    public ServerComputer() {
        startProgram();
    }
    public void run() {
        runProgram();
    }
    public void close() {
        finishProgram();
    }
    void startProgram() {
        rankingSystem.sort();
    }
    void runProgram() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("1. 유저 출력  2. 운동 기록 출력");
            System.out.println("3. 인바디 기록 출력  4. 프로그램 출력");
            System.out.println("5. 이 달의 랭킹  0. 종료");

            int option = Integer.parseInt(input("번호를"));
            switch (option) {
                case 1 -> userDataManager.printAll();
                case 2 -> exerciseLogManager.printAll();
                case 3 -> inbodyManager.printAll();
                case 4 -> programManager.printAll();
                case 5 -> rankingSystem.print();
                case 0 -> isRunning = false;
            }
        }
    }
    void finishProgram() {
        userDataManager.saveFile();
        exerciseLogManager.saveFile();
        inbodyManager.saveFile();
        programManager.saveFile();
    }

    static String input(String comment) {
        System.out.print(comment + " 입력하십시오 > ");
        String str = scanner.next();
        return str;
    }
    static boolean isThisMonth(String date) {
        return today.substring(0, 7).contentEquals(date.substring(0, 7));
    }
    static String getAbsolutePath(String relativePath) {
        return System.getProperty("user.dir") + "\\src\\Server\\" + relativePath;
    }
    static Scanner openFile(String relativePath) {
        String absolutePath = getAbsolutePath(relativePath);
        Scanner file = null;
        try {
            file = new Scanner(new File(absolutePath));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", absolutePath);
            System.exit(0);
        }
        return file;
    }
}