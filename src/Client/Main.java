package Client;

import Server.ServerComputer;

public class Main {
    public static void main(String[] args) {
        ServerComputer program = new ServerComputer();
        program.run();
        program.close();
    }
}
