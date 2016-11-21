package thinkinjava.io;

import java.io.*;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 */
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("E:\\testio\\flie.txt");
        FileLock fileLock = fos.getChannel().tryLock();
        if (fileLock != null) {
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(2000);
            fileLock.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
