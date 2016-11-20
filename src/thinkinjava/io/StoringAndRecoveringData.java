package thinkinjava.io;

import java.io.*;

/**
 * Created by Bill on 2016/11/20.
 * Email androidBaoCP@163.com
 */
public class StoringAndRecoveringData {
    /*也就是说要记得文件存储的类型和顺序？*/
    public static void main(String[] args) throws IOException{
        DataOutputStream out=new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\Data.txt")));
        out.writeDouble(3.1415926);
        out.writeUTF("That is pi");
        out.writeDouble(1.41413);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\IdeaProjects\\Jva\\src\\thinkinjava\\io\\Data.txt")));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
