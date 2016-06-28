package thinkinjava.stringdemo;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * Created by Bill on 2016/6/1.
 * Email androidBaoCP@163.com
 * Formatter的构造器经过重载可以接受多种输出目的地，不过最常用的还是PrintStream（），OutPrintStream（）和File。
 * 格式化的语法为：%[argument_index$][flags][width][.precision]conversion
 * 默认情况下，数据是右对齐的，但是可以通过使用"-"标志来改变对齐方向。
 * 与width相对的是precision，它用来指明最大尺寸，但是width可以应用于各种类型的数据转换，但是precision则不行，它没法对整形起作用，一般不指明precision
 * 时，默认为6位，过多则四舍五入，太少则补零。
 *
 */
public class Turtle {
    private String name;
    private Formatter formatter;

    public Turtle(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public void move(int x, int y) {
//        PrintStream outAlisas=System.out;
        formatter.format("%s The Turrle is at (%d %d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.out;
        Turtle tommy = new Turtle("Tommy", new Formatter(System.out));
        Turtle terry = new Turtle("Terry", new Formatter(outAlias));
        tommy.move(0, 0);
        terry.move(4, 8);
        tommy.move(1, 5);
        terry.move(0, 3);
    }
}
