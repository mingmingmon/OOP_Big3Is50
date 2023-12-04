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
    @Override
    public void print() {
        super.print();
        System.out.printf("%dkg %d번\n", kg, count, cal);
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString() + " " + String.format("%d %d", kg, count));
        return result.toString();
    }
    @Override
    public String toGUIString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toGUIString() + String.format("%dkg * %d번", kg, count));
        return result.toString();
    }
}