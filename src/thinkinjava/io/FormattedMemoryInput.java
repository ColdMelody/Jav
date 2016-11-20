package thinkinjava.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.
                read("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\FormattedMemoryInput.java").getBytes()));
        while (in.available() != 0)
            System.out.print((char) in.readByte());
    }
}
