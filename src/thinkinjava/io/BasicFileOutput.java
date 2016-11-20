package thinkinjava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class BasicFileOutput {
    public static void main(String[] args) throws IOException{
        BufferedReader reader=new BufferedReader(new StringReader(BufferedInputFile.read("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\BasicFileOutput.java")));
        String file = "BasicFileOutput.out";
        PrintWriter writer=new PrintWriter(file);
        int lineCount=1;
        String s;
        while ((s=reader.readLine())!=null){
            writer.println(lineCount++ +": "+s);
        }
        writer.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
