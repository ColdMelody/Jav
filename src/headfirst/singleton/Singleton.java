package headfirst.singleton;

/**
 * Created by Bill on 2016/6/12.
 * Email androidBaoCP@163.com
 * 一个线程安全的单例模式,使用双加锁
 */

public class Singleton {
    private volatile static Singleton uniqueInstance;
    private Singleton(){
    }
    public static Singleton getUniqueInstance(){
        if (uniqueInstance==null){
            synchronized (Singleton.class){
                if (uniqueInstance==null){
                    uniqueInstance=new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
