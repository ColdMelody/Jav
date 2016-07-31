package thinkinjava.collection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Bill on 2016/7/30.
 * Email androidBaoCP@163.com
 * <p>为了验证在HashMap中作为key的类必需实现hashCode和equals方法。
 * <p>hashCode并不能总是标识一个类，所以要实现equals方法
 */
public class SpringDetector {

    public static class PreDiction {
        private static Random random = new Random(47);
        private boolean shadow = random.nextDouble() > 0.5;

        public String toString() {
            if (shadow) return "Six more weeks of winter";
            else return "Early String!";
        }
    }

    public static <T extends GroundHog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<GroundHog, PreDiction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) map.put(ghog.newInstance(i), new PreDiction());
        System.out.println("map = " + map);
        GroundHog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if (map.containsKey(gh)) System.out.println(map.get(gh));
        else System.out.println("Key not found: " + gh);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(GroundHog2.class);
    }
}

class GroundHog {
    protected int number;

    public GroundHog(int n) {
        number = n;
    }

    public String toString() {
        return "Groundhog #" + number;
    }
}

class GroundHog2 extends GroundHog {

    public GroundHog2(int n) {
        super(n);
    }

    public int hashCode() {
        return number;
    }

    public boolean equals(Object o) {
        return o instanceof GroundHog2 && (number == ((GroundHog2) o).number);
    }
}
