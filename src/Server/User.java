package Server;

import java.util.Scanner;

public class User implements Data{
    String id; // id가 기본키다.
    String password;

    String name;
    String nickname;
    String phone;
    boolean gender; // 남자 0, 여자 1

    @Override
    public void scan(Scanner file) {
        id = file.next();
        password = file.next();
        name = file.next();
        nickname = file.next();
        phone = file.next();
        gender = file.next().equals("1");
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                id, password, name, nickname, phone, (gender ? "여성" : "남성"));
    }
}
