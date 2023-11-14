package Server;

import java.util.ArrayList;
import java.util.Scanner;

public class Ranking {
    ArrayList<Rank> rankList = new ArrayList<>();

    Ranking() {
        rankList.add(new Big3());
    }
}
