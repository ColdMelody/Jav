package thinkinjava.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class UsingRandomAccessFile {
    static String file = "E:\\testio\\rtest.txt";

    private static void display() throws IOException {
        /*以只读的方式打开流，即"r"*/
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++) {
            System.out.println("Value " + i + ": " + rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        /*以读写的方式打开流*/
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++) {
            rf.writeDouble(i * 1.414);
        }
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf = new RandomAccessFile(file, "rw");
        rf.seek(5 * 8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
