package thinkinjava.io;

import java.io.*;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 * 使用Externalizable接口控制序列化
 */
public class Blip implements Externalizable {
    private String s;
    private int i;
    public Blip(){
        System.out.println("Default constructor");
    }
    private Blip(String s, int i){
        System.out.println("Blip(String s,int i)");
        this.s=s;
        this.i=i;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip readExternal");
        s=(String)in.readObject();
        i=in.readInt();
    }

    @Override
    public String toString() {
        return s+i;
    }
    public static void main(String...args) throws IOException,ClassNotFoundException{
        System.out.println("Constructing objects:");
        Blip blip=new Blip("A String",47);
        System.out.println(blip);
        ObjectOutputStream o=new ObjectOutputStream(new FileOutputStream("E:\\testio\\blip.out"));
        System.out.println("Saving  object:");
        o.writeObject(blip);
        o.close();
        ObjectInputStream i=new ObjectInputStream(new FileInputStream("E:\\testio\\blip.out"));
        System.out.println("Recovering blip:");
        blip= (Blip) i.readObject();
        System.out.println(blip);
    }
}
