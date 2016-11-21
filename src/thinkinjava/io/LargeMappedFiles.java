package thinkinjava.io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 */
public class LargeMappedFiles {

    public static void main(String[] args) throws IOException {
        int length = 0x8FFFFFF;
        MappedByteBuffer out = new RandomAccessFile("E:\\testio\\test.dat", "rw")
                .getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        System.out.println("Finished writing");
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.println((char) out.get(i));
        }
    }
}
