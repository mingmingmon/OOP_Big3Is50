package Server;

import java.util.ArrayList;
import java.util.Comparator;

public class Rank {
    final int CNT_RANK = 5;

    String rankName;
    ArrayList<User> rank = new ArrayList<>();

    void sort() {
        this.sort();
    }

    void print() {
        System.out.printf("이 달의 %s\n", rankName);
        for (int i = 0; i < CNT_RANK; i++) {
            User user = rank.get(i);
            if (user == null)
                break;


        }
    }
    void printPowerUp() {

    }
}
