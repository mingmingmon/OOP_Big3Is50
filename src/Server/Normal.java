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


}
