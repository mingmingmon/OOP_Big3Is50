package Server;

import java.util.Scanner;

public class Normal extends User implements Data{
    @Override
    public void scan(Scanner file) {
        userType = 1;
        super.scan(file);
        Main.userHashMap.put(id, this);
    }
    @Override
    public void print() {
        super.print();
    }

    boolean hasProgram(){
        if(myProgram.dataList == null){
            System.out.println("신청한 프로그램이 없습니다. 프로그램 신청페이지로 이동합니다.\n");
            return false;
        }
        printMyProgram();
        return true;
    }


}
