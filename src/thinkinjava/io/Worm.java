package thinkinjava.io;

import java.io.*;
import java.util.Random;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 */
public class Worm implements Serializable {
    private static Random random = new Random(47);
    // 使用随机数使序列化的概念更加形象
    private Data[] d = {new Data(random.nextInt(10)), new Data(random.nextInt(10)), new Data(random.nextInt(10))};
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0) {
            next = new Worm(i, (char) (x + 1));
        }
    }

    public Worm() {
        System.out.println("Default constructor");
    }

    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c).append("(");
        for (Data data : d) {
            result.append(data);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        System.out.println("w= " + w);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:\\testio\\worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\testio\\worm.out"));
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        System.out.println(s + "w2 = " + w2);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println(s + "w3 = " + w3);
    }
}

class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
