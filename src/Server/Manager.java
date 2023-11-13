package Server;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager <T extends Data> {
    ArrayList<T> dataList = new ArrayList<>();

    void scan(Scanner file, Factory<T> factory) {
        T data = factory.create();
        data.scan(file);
        dataList.add(data);
    }

    void scanAll(String relativePath, Factory<T> factory) {
        Scanner file = openFile(relativePath);
        while (file.hasNext()) {
            T data = factory.create();
            data.scan(file);
            dataList.add(data);
        }
    }
    void printAll() {
        for (T data : dataList)
            data.print();
    }

    Scanner openFile(String relativePath) {
        String absolutePath = Manager.class.getResource("").getPath() + relativePath;
        Scanner file = null;
        try {
            file = new Scanner(new File(absolutePath));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", absolutePath);
            System.exit(0);
        }
        return file;
    }
}
