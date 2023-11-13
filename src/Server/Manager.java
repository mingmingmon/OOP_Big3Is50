package Server;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager <T extends Data> {
    ArrayList<T> dataList = new ArrayList<>();

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
            System.out.println(data);
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
