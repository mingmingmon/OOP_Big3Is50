package Server;

import java.util.Scanner;

public class User implements Data {
    String id; // id가 기본키다.
    String password;

    String name;
    String nickname;
    String phone;
    int gender; // 남자 0, 여자 1

    Manager<ExerciseLog> myExerciseLogManager = new Manager<>();

    @Override
    public void scan(Scanner file) {
        id = file.next();
        password = file.next();
        name = file.next();
        nickname = file.next();
        phone = file.next();
        gender = file.nextInt();

        Main.userHashMap.put(id, this);
    }
    @Override
    public void print() {
        System.out.printf("%s %s %s %s %s %s\n",
                id, password, name, nickname, phone, (gender == 0 ? "남성" : "여성"));
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %d",
                id, password, name, nickname, phone, gender);
    }

    void PrintMyExerciseLog() {
        System.out.printf("%s 회원님의 운동 기록\n", nickname);
        myExerciseLogManager.printAll();
    }
}
