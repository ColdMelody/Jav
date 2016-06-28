package headfirst.strategy;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
public class ThisQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("I am quack");
    }
}
