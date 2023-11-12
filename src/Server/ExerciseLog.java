package Server;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ExerciseLog implements Data {
    String date;
    String userID;
    int n;
    ArrayList<Exercise> exerciseList = new ArrayList<>();

    @Override
    public void scan(Scanner file) {
        date = file.next();
        userID = file.next();

        n = file.nextInt();
        for (int i = 0; i < n; i++) {
            int exerciseType = file.nextInt();
            Exercise exercise = (exerciseType == 1 ? new Cardio() : new Anaerobic());
            exercise.scan(file);
            exerciseList.add(exercise);
        }
    }
}
