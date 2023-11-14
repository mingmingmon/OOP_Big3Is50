package Server;

import java.util.*;

public class Program implements Data {
    static int count = 0;
    int id;
    String name;
    String date;
    String startTime;
    String endTime;
    int n;

    Manager<User> membersManager = new Manager<>();

    @Override
    public void scan(Scanner file) {
        id = ++count;
        name = file.next();
        date = file.next();
        startTime = file.next();
        endTime = file.next();

        n = file.nextInt();

        for (int i = 0; i < n; i++) {
            String userID = file.next();
            User user = Main.userHashMap.get(userID);
            membersManager.dataList.add(user);
            user.myProgramManager.dataList.add(this);
        }
    }
    @Override
    public void print() {
        System.out.printf("%s %s %s %s\n", name, date, startTime, endTime);
        System.out.print("참여자: ");
        for (User user : membersManager.dataList)
            System.out.printf("%s ", user.nickname);
        System.out.println();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s %s %s %s %d ", name, date, startTime, endTime, n));
        for(User user : membersManager.dataList)
            result.append(user.id + " ");
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}