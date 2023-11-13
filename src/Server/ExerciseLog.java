package Server;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExerciseLog implements Data {
    String logDate;
    String logTime;
    String userID;
    int n;

    Manager<Exercise> exerciseManager = new Manager<>();

    @Override
    public void scan(Scanner file) {
        logDate = file.next();
        logTime = file.next();
        userID = file.next();

        n = file.nextInt();
        for (int i = 0; i < n; i++) {
            int exerciseType = file.nextInt();
            exerciseManager.scan(file, () -> (exerciseType == 1 ? new Cardio() : new Anaerobic()));
        }

        User user = Main.userHashMap.get(userID);
        user.myExerciseLogManager.dataList.add(this);
    }

    @Override
    public void print() {
        System.out.printf("%s %s %s\n", logDate, logTime, userID);
        exerciseManager.printAll();
    }
}
