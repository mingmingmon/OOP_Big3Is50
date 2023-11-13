package Server;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Manager<User> userManager = new Manager<>();
    Manager<ExerciseLog> exerciseLogManager = new Manager<>();

    void run() {
        scanAllFile();
        userManager.printAll();
    }
    void scanAllFile() {
        userManager.scanAll("data/user-data.txt", () -> new User());
        exerciseLogManager.scanAll("data/user-exercise-log.txt", () -> new ExerciseLog());
    }


    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}