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
    @Override
    public void print() {
        System.out.printf("%s %s\n", (exerciseType == 1 ? "유산소" : "무산소"), name);
    }
}
