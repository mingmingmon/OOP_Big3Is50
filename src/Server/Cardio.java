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
        System.out.printf("%dkm/h로 %d분동안 태운 칼로리: %d\n", speed, time, cal);
    }
}
