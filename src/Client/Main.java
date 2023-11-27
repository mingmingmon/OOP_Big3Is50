package Client;

import Server.ServerComputer;
import Server.GUI.GUIMain;
import Server.User;

import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in.);

    public static void main(String[] args) {
        ServerComputer program = new ServerComputer();

        String myInfoPath = "..\\Client\\my-info.txt";
        File myFile = new File(ServerComputer.getAbsolutePath(myInfoPath));
        if (!myFile.exists()) {
            System.out.println("회원가입");
            program.joinIn();
        } else {
            System.out.println("로그인");

            Scanner file = ServerComputer.openFile(myInfoPath);
            String userID = file.next();
            User user = ServerComputer.userHashMap.get(userID);

            if (user == null) {
                System.out.println("없는 유저입니다");
            } else {
            }
        }
        //program.run();
        GUIMain.startGUI();
        program.close();
    }
}
