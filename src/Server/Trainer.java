package Server;

import Server.Data;
import Server.Manager;
import Server.Program;
import Server.User;
import java.util.*;

public class Trainer extends User implements Data {
    ArrayList<String> awards = new ArrayList<>();
    public void scan(Scanner file){
        super.scan(file);
        int n = file.nextInt();
        for (int i = 0; i < n; i++) {
            awards.add(file.next());
        }
        Main.userHashMap.put(id, this);
    }

    public void print(){
        super.print();
        for(String award : awards){
            System.out.print("\t" + award + " ");
        }
        System.out.println("\n");
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
