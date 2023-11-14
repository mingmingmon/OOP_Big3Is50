package Server;

import java.util.Scanner;

public class User implements Data {
    int userType;

    String id; // id가 기본키다.
    String password;

    String name;
    String nickname;
    String phone;
    int gender; // 남자 0, 여자 1

    Manager<ExerciseLog> myExerciseLogManager = new Manager<>();
    Manager<Inbody> myInbodyManager = new Manager<>();
    Manager<Program> myProgramManager = new Manager<>();

    @Override
    public void scan(Scanner file) {
        id = file.next();
        password = file.next();
        name = file.next();
        nickname = file.next();
        phone = file.next();
        gender = file.nextInt();

        Main.userHashMap.put(id, this);
        Main.ranking.addUser(this);
    }
    @Override
    public void print() {
        System.out.printf("%s %s %s %s %s %s\n",
                id, password, name, nickname, phone, (gender == 0 ? "남성" : "여성"));
    }
    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s %d",
                userType, id, password, name, nickname, phone, gender);
    }

    void PrintMyExerciseLog() {
        System.out.printf("%s 회원님의 운동 기록\n", nickname);
        myExerciseLogManager.printAll();
    }
    public void printMyProgram(){
        for(Program program : myProgramManager.dataList){
            program.print();
        }
    }

    public int getBig3() {
        int squat = 0;
        int benchPress = 0;
        int deadLift = 0;

        for (ExerciseLog exerciseLog : myExerciseLogManager.dataList) {
            if(!Main.isThisMonth(exerciseLog.logDate))
                continue;

            for (Exercise exercise : exerciseLog.exerciseManager.dataList) {
                if (exercise.name.contentEquals("스쿼트"))
                    squat = Math.max(squat, ((Anaerobic)exercise).kg);
                if (exercise.name.contentEquals("벤치프레스"))
                    benchPress = Math.max(squat, ((Anaerobic)exercise).kg);
                if (exercise.name.contentEquals("데드리프트"))
                    deadLift = Math.max(squat, ((Anaerobic)exercise).kg);
            }
        }
        return squat + benchPress + deadLift;
    }

}
