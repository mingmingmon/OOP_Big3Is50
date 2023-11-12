package Server;

import java.util.Scanner;

public class Exercise implements Data {
    String name;
    int cal;
    int exerciseType;

    @Override
    public void scan(Scanner file) {
        name = file.next();
    }
}
