package test;

/**
 * Created by Bill on 2017/3/6.
 * Email androidBaoCP@163.com
 */
public class WhoCalled {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() {
        f();
    }

    static void h() {
        g();
    }

    public static void main(String... args) {
        f();
        System.out.println("---------------------------");
        g();
        System.out.println("---------------------------");
        h();
    }
}
