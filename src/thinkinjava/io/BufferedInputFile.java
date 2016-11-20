package thinkinjava.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s).append("\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.print(read("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\BufferedInputFile.java"));
    }
}
