package thinkinjava.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException{
        StringReader in=new StringReader(BufferedInputFile.read("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\MemoryInput.java"));
        int c;
        while ((c=in.read())!=-1){
            System.out.print((char)c);
        }
    }
}
