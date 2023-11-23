package Server;

import java.util.Scanner;

public class Cardio extends Exercise {
    int speed;
    int time;
    @Override
    public void scan(Scanner file) {
        super.scan(file);
        exerciseType = 1;
        speed = file.nextInt();
        time = file.nextInt();
    }
    @Override
    public void print() {
        super.print();
        System.out.printf("%dkm/h %d분\n", speed, time, cal);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString() + " " + String.format("%d %d", speed, time));
        return result.toString();
    }
}
