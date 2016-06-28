package thinkinjava.stringdemo;

/**
 * Created by Bill on 2016/6/1.
 * Email androidBaoCP@163.com
 */
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y=5.32261425;
        System.out.println("Row 1:["+x+" "+y+"]");
        System.out.format("Row 1:[%d %f]\n",x,y);
        System.out.printf("Row 1:[%d %f]",x,y);
    }
}
