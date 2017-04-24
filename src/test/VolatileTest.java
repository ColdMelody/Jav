package test;

import java.util.HashMap;

/**
 * Created by Bill on 2016/12/13.
 * Email androidBaoCP@163.com
 */
public class VolatileTest {
    private static volatile boolean test = false;
    private static HashMap<String, String> map;

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            map = new HashMap<>();
            map.put("test", "ok");
            test = true;
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            while (!test) {
                map = null;
            }
        }
    }

    private static void turnOff() {
        test = false;
    }

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        if (map!=null){
            System.out.println(map.get("test"));
        }
        VolatileTest.turnOff();
        try {
            map.get("test");
        }catch (Exception e){
            System.out.println("map is null");
        }
    }
}
