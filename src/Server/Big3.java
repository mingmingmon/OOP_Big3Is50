package Server;

import java.util.Comparator;

public class Big3 extends Rank {
    Big3() {
        rankName = "3대왕";
    }
    @Override
    public void sort() {
        rank.sort(Comparator.comparingInt(User::getBig3).reversed());
    }
    @Override
    public void print() {
    }
}
