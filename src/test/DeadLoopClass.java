package test;

/**
 * Created by Bill on 2016/11/27.
 * Email androidBaoCP@163.com
 */
public class DeadLoopClass {
    static {
        /*如果不加这个if语句，编译器将提示"Initializer does not complete normally"*/
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while(true){

            }
        }
    }
    public static void main(String[] args){
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dic = new DeadLoopClass();
                System.out.println(Thread.currentThread() + "run over");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
