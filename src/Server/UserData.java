package Server;
import java.util.*;

public class UserData implements Data{
    Manager<User> userManager = new Manager<>();
    @Override
    public void scan(Scanner file) {
        int userType = file.nextInt();
        userManager.scan(file, () -> (userType == 1 ? new Normal() : new Trainer()));
    }

    @Override
    public void print() {
        userManager.printAll();
    }
}
