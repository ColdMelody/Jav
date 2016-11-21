package thinkinjava.io;

import java.io.PrintWriter;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 */
public class ChangeSystemOut {
    public static void main(String[] args){
        PrintWriter out =new PrintWriter(System.out,true);
        out.println("Hello,changpeng");
    }
}
