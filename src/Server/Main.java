package Server;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")).toString();

    static HashMap<String, User> userHashMap = new HashMap<>();
    static Ranking ranking = new Ranking();

    Manager<UserData> userDataManager = new Manager<>("data\\user-data.txt", () -> new UserData());
    Manager<ExerciseLog> exerciseLogManager = new Manager<>("data\\user-exercise-log.txt", () -> new ExerciseLog());
    Manager<Inbody> inbodyManager = new Manager<>("data\\user-inbody.txt", () -> new Inbody());
    Manager<Program> programManager = new Manager<>("data\\program-data.txt", () -> new Program());

    //Me me = new Me("..\\Client\\my-info.txt");

    void run() {
        ranking.sort();
        ranking.printBig3();
//        System.out.println("---------회원정보-------------");
//        userDataManager.printAll();
//        System.out.println("---------운동기록-------------");
//        exerciseLogManager.printAll();
//        System.out.println("---------회원별 운동기록-------------");
//        for (String key : userHashMap.keySet()) { // 회원 별 운동 기록 출력. 회원 읽고 운동기록 읽어야 출력 가능.
//            User user = userHashMap.get(key);
//            user.PrintMyExerciseLog();
//        }
//        System.out.println("---------프로그램정보-------------");
//        programManager.printAll();

        //System.out.println(inbodyManager);

//        for (String key : userHashMap.keySet()) { // 회원 별 운동 기록 출력. 회원 읽고 운동기록 읽어야 출력 가능.
//            User user = userHashMap.get(key);
//            System.out.println(user);
//            System.out.println(user.myExerciseLogManager);
//            System.out.println(user.myProgramManager);
//            System.out.println(user.myInbodyManager);
//            System.out.println();
//        }
//        System.out.println(programManager);
        finishProgram();
    }
    void finishProgram() {
        userDataManager.saveFile();
        exerciseLogManager.saveFile();
        inbodyManager.saveFile();
        programManager.saveFile();
    }

    static boolean isThisMonth(String date) {
        return today.substring(0, 7).contentEquals(date.substring(0, 7));
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}