package Server;

import java.util.Scanner;

public class Inbody implements Data {
    String date;
    String time;
    String userID;

    int weight;
    int muscle;
    int fat;

    @Override
    public void scan(Scanner file) {
        date = file.next();
        time = file.next();
        userID = file.next();

        weight = file.nextInt();
        muscle = file.nextInt();
        fat = file.nextInt();

        User user = Main.userHashMap.get(userID);
        user.myInbodyManager.dataList.add(this);
    }
    @Override
    public void print() {
        System.out.printf("%s %s %s\n 체중: %d\n골격근량: %d\n지방: %d\n",
                date, time, userID, weight, muscle, fat);
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %d %d %d", date, time, userID, weight, muscle, fat);
    }
}
