package Server;

import java.util.Scanner;

public class Anaerobic extends Exercise {
    int kg;
    int count;

    @Override
    public void scan(Scanner file) {
        super.scan(file);
        exerciseType = 2;
        kg = file.nextInt();
        count = file.nextInt();
    }
}