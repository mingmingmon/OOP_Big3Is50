package Server;

import java.util.ArrayList;
import java.util.Comparator;

public class Ranking {
    final int CNT_RANK = 5;

    ArrayList<User> rankBig3 = new ArrayList<>();
    ArrayList<User> rankPowerUp = new ArrayList<>();
    ArrayList<User> rankBurningFat = new ArrayList<>();
    ArrayList<User> rankSincerity = new ArrayList<>();

    void addUser(User user) {
        rankBig3.add(user);
        rankPowerUp.add(user);
        rankBurningFat.add(user);
        rankSincerity.add(user);
    }
    void sort() {
        rankBig3.sort(Comparator.comparingInt(User::getBig3).reversed());
        rankPowerUp.sort(Comparator.comparingInt(User::getBig3).reversed());
        rankBurningFat.sort(Comparator.comparingInt(User::getBig3).reversed());
        rankSincerity.sort(Comparator.comparingInt(User::getBig3).reversed());
    }
    void print() {
        printBig3();
        printPowerUp();
    }
    void printBig3() {
        System.out.println("이 달의 3대왕");
        for (int i = 0; i < CNT_RANK; i++) {
            User user = rankBig3.get(i);
            if (user == null)
                break;

            System.out.printf("%d등 %s %d\n", i + 1, user, user.getBig3());
        }
    }
    void printPowerUp() {

    }
}
