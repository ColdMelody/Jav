package test;

/**
 * Created by Bill on 2016/11/27.
 * Email androidBaoCP@163.com
 */
public class Test {
    public static void main(String[] args){

        System.out.println(Child.B);
    }
}
class Parent{
    public static int A=1;
    static {
        A = 2;
    }
}
class Child extends Parent{
    public static int B = A;
}
