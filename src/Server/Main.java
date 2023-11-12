package Server;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Manager<User> userManager = new Manager<>();
    ArrayList<User> userList = new ArrayList<>();

    void run() {
        scanAllFile();
        printUserList();
    }
    void scanAllFile() {
        scanUserFile();
    }
    void scanUserFile() {
        Scanner file = openFile("data/user-data.txt");
        while (file.hasNext()) {
            User user = new User();
            user.scan(file);
            userList.add(user);
        }
    }
    void printUserList() {
        for (User user : userList)
            System.out.println(user);
    }

    Scanner openFile(String relativePath) {
        String absolutePath = Main.class.getResource("").getPath() + relativePath;
        Scanner file = null;
        try {
            file = new Scanner(new File(absolutePath));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", absolutePath);
            System.exit(0);
        }
        return file;
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}