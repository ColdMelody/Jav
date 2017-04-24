package util;

import java.io.PrintStream;

/**
 * Created by Bill on 2017/2/27.
 * Email androidBaoCP@163.com
 */
public class Print {
    public static void print(Object obj){
        System.out.println(obj);
    }
    public static void print(){
        System.out.println();
    }
    public static void printnb(Object obj){
        System.out.print(obj);
    }
    public static PrintStream printf(String format,Object...args){
        return System.out.printf(format,args);
    }
}
