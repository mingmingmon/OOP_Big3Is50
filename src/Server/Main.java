package Server;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, User> userHashMap = new HashMap<>();
    Manager<UserData> userDataManagerManager = new Manager<>("data/user-data.txt", () -> new UserData());
    Manager<ExerciseLog> exerciseLogManager = new Manager<>("data/user-exercise-log.txt", () -> new ExerciseLog());
    Manager<Program> programManager = new Manager<>("data/program-data.txt", () -> new Program());

    void run() {
        System.out.println("---------회원정보-------------");
        userDataManagerManager.printAll();
        System.out.println("---------운동기록-------------");
        exerciseLogManager.printAll();
        System.out.println("---------회원별 운동기록-------------");
        for (String key : userHashMap.keySet()) { // 회원 별 운동 기록 출력. 회원 읽고 운동기록 읽어야 출력 가능.
            User user = userHashMap.get(key);
            user.PrintMyExerciseLog();
        }
        System.out.println("---------프로그램정보-------------");
        programManager.printAll();
    }



    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}