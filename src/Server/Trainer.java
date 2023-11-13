package Server;

import Server.Data;
import Server.Manager;
import Server.Program;
import Server.User;
import java.util.*;

public class Trainer extends User implements Data {
    ArrayList<String> awards = new ArrayList<>();
    int n;

    @Override
    public void scan(Scanner file){
        super.scan(file);
        userType = 2;

        n = file.nextInt();
        for (int i = 0; i < n; i++) {
            awards.add(file.next());
        }
    }
    @Override
    public void print(){
        super.print();
        for(String award : awards){
            System.out.print(award + " ");
        }
        System.out.println("\n");
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(super.toString() + String.format(" %d ", n));
        for(String award : awards)
            result.append(award + " ");
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    public void printMyProgram(){
        for(Program program : myProgram.dataList){
            program.print();
        }
    }
}