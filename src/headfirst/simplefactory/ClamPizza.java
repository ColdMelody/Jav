package headfirst.simplefactory;

/**
 * Created by Bill on 2016/5/23.
 * Email androidBaoCP@163.com
 */
public class ClamPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("clam prepare");
    }

    @Override
    public void bake() {
        System.out.println("calm bake");
    }

    @Override
    public void cut() {
        System.out.println("clam cut");
    }

    @Override
    public void box() {
        System.out.println("clam box");
    }
}
