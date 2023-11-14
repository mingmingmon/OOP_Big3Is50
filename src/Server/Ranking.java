package Server;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Ranking {
    ArrayList<Rank> rankList = new ArrayList<>();

    static HashMap<String, Comparator<User>> standHashMap = new HashMap<>();

    Ranking() {
        rankList.add(new Rank("3대왕", "3대", "kg 달성",Comparator.comparingInt(User::getBig3).reversed()));
        rankList.add(new Rank("득근왕", "골격근", "kg 증량", Comparator.comparingInt(User::getPowerUp).reversed()));
        rankList.add(new Rank("연소왕", "체지방", "kg 감량",Comparator.comparingInt(User::getBurnFat).reversed()));
        rankList.add(new Rank("출석왕", "총", "일 출석", Comparator.comparingInt(User::getSincerity).reversed()));
    }
    void addUser(User user)
    {
        for (Rank rank : rankList)
            rank.userRankList.add(user);
    }
    void sort() {
        for (Rank rank : rankList)
            rank.sort();
    }
    void print() {
        for (Rank rank : rankList)
            rank.print();
    }
}
