package thinkinjava.io;

import java.io.*;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 */
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;
    public SerialCtl(String a,String b){
        this.a="transient "+a;
        this.b="not transient "+b;
    }
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        out.writeObject(b);
    }
    private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
        in.defaultReadObject();
        in.readObject();
    }

    @Override
    public String toString() {
        return a+"\n"+b;
    }

    public static void main(String[] args) throws Exception{
        SerialCtl ctl=new SerialCtl("Test1","Test2");
        System.out.println(ctl);
        ByteArrayOutputStream buf=new ByteArrayOutputStream();
        ObjectOutputStream out=new ObjectOutputStream(buf);
        out.writeObject(ctl);
        ObjectInputStream in=new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl ctl2= (SerialCtl) in.readObject();
        System.out.println(ctl2);
    }
}
