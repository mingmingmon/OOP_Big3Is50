package Server;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    HashMap<String, User> userHashMap = new HashMap<>();
    Manager<User> userManager = new Manager<>();
    Manager<ExerciseLog> exerciseLogManager = new Manager<>();
    Manager<Program> programManager = new Manager<>();

    void run() {
        scanAllFile();
        userManager.printAll();
        exerciseLogManager.printAll();
    }
    void scanAllFile() {
        userManager.scanAll("data/user-data.txt", () -> new User());
        exerciseLogManager.scanAll("data/user-exercise-log.txt", () -> new ExerciseLog());
        programManager.scanAll("data/program-data.txt", () -> new Program());
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}