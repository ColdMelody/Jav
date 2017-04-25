package thinkinjava.enumdemo;

/**
 * Created by Bill on 2017/4/22.
 * Email androidBaoCP@163.com
 */
public enum EnumSingleton {
    INSTANCE;
    public void doSomething(){
        System.out.println("0.0");
    }
    public static void main(String[] args){
        System.out.println(INSTANCE);
        System.out.println(INSTANCE.ordinal());
        EnumSingleton.INSTANCE.doSomething();
        System.out.println(INSTANCE.name());
    }
}
