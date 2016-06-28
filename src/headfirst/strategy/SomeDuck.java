package headfirst.strategy;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
public class SomeDuck extends Duck {

    @Override
    public void display() {
        System.out.println("I am a some duck");
    }
    public  static void main(String[] args){
        Duck duck=new SomeDuck();
        duck.display();
        duck.setFlyBehavior(new FlyWithRocket());
        duck.performFly();
    }
}
