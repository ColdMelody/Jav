package thinkinjava.io;


import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 * 使用 transient 控制序列化
 */
public class Login implements Serializable {
    private String userName;
    private transient String password;
    private Login(String userName, String password){
        this.userName=userName;
        this.password=password;
    }

    @Override
    public String toString() {
        return "login info: \n    username: "+userName+"\n    password: "+password;
    }
    public static void main() throws Exception{
        Login a=new Login("hulk","003");
        System.out.println("Login a = "+a);
        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("E:/testio/login.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(2);
        ObjectInputStream i=new ObjectInputStream(new FileInputStream("E:/testio/login.out"));
        a= (Login) i.readObject();
        System.out.println("Login a = "+a);
    }
}
