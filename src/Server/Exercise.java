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
        System.out.printf("[%s산소] %s: ", (exerciseType == 1 ? "유" : "무"), name);
    }
    @Override
    public String toString() {
        return String.format("%d %s", exerciseType, name);
    }
}
