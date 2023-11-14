package Server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager <T extends Data> {
    ArrayList<T> dataList = new ArrayList<>();
    String relativePath;
    Manager() {

    }
    Manager(String relativePath, Factory<T> factory) {
        this.relativePath = relativePath;
        scanAll(relativePath, factory);
    }
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
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T data : dataList)
            result.append(data + "\n");

        if(!result.isEmpty())
            result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    void saveFile() {
        String absolutePath = getAbsolutePath(relativePath);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(absolutePath);
            fileWriter.write(toString());
            fileWriter.close();
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", absolutePath);
            System.exit(0);
        }
    }

    static String getAbsolutePath(String relativePath) {
        return System.getProperty("user.dir") + "\\src\\Server\\" + relativePath;
    }

    Scanner openFile(String relativePath) {
        String absolutePath = getAbsolutePath(relativePath);
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
