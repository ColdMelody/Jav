package test;



class SuperClass{
    static {
        System.out.println("SuperClass init!");
    }
    public static int value = 123;
}
class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init!");
    }
}
class ConstClass{
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world!";
}
/**
 * 被动使用类字段演示三：
 * 非主动使用类字段演示
 */
public class NoInitialization {
    public static void main(String...args){
        System.out.println(ConstClass.HELLOWORLD);
    }
}
