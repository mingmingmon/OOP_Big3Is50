package Server;

import java.util.Scanner;

public class User implements Data {
    int userType; //일반회원 1, 트레이너 2

    String id; // id가 기본키다.
    String password;

    String name;
    String nickname;
    String phone;
    boolean gender; // 남자 0, 여자 1


    Manager<ExerciseLog> myExerciseLogManager = new Manager<>();
    Manager<Program> myProgram = new Manager<>();

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
    public void print() {
        System.out.printf("%s %s %s %s %s %s\n",
                id, password, name, nickname, phone, (gender ? "여성" : "남성"));
        printMyProgram();
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s",
                id, password, name, nickname, phone, (gender ? "여성" : "남성"));
    }

    public void PrintMyExerciseLog() {
        System.out.printf("%s 회원님의 운동 기록\n", nickname);
        myExerciseLogManager.printAll();
    }

    public void printMyProgram(){
        for(Program program : myProgram.dataList){
            //program.print(); 이거 하면 스택 오버플로우 남.
            System.out.printf("\t");
            System.out.println(program.name + " " + program.date);
        }
    }
}
