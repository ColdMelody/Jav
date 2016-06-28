package headfirst.strategy;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I am fly with a rocket");
    }
}
