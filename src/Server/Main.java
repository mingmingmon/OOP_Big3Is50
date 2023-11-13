package Server;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static HashMap<String, User> userHashMap = new HashMap<>();
    Manager<User> userManager = new Manager<>("data\\user-data.txt", () -> new User());
    Manager<ExerciseLog> exerciseLogManager = new Manager<>("data\\user-exercise-log.txt", () -> new ExerciseLog());

    void run() {
        //userManager.printAll();
        for (String key : userHashMap.keySet()) {
            User user = userHashMap.get(key);
            //user.PrintMyExerciseLog();

            //System.out.println(user);
        }

        System.out.println(userManager);
        System.out.println(exerciseLogManager);

//        for (ExerciseLog exerciseLog : exerciseLogManager.dataList) {
//            System.out.println(exerciseLog);
//        }
        finishProgram();
    }
    void finishProgram() {
        userManager.saveFile();
        exerciseLogManager.saveFile();
    }
    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}