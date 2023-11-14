package Server;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Rank {
    final int CNT_RANK = 5;

    String rankName;
    ArrayList<User> userRankList = new ArrayList<>();
    Comparator<User> comparator;

    Rank(String rankName, Comparator<User> comparator) {
        this.rankName = rankName;
        this.comparator = comparator;
    }

    void sort() {
        userRankList.sort(comparator);
    }

    void print() {
        System.out.printf("이 달의 %s\n", rankName);
        for (int i = 0; i < CNT_RANK; i++) {
            User user = userRankList.get(i);
            System.out.printf("[%d등] %s %d\n", i + 1, user.name, user.rankValue.get(rankName));
        }
    }
}
