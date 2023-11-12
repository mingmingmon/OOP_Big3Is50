package Server;

import java.util.Scanner;

public class Cardio extends Exercise {
    int time;
    int speed;

    @Override
    public void scan(Scanner file) {
        super.scan(file);
        exerciseType = 1;
        time = file.nextInt();
        speed = file.nextInt();
    }
}
