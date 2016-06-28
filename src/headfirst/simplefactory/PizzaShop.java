package headfirst.simplefactory;

/**
 * Created by Bill on 2016/5/23.
 * Email androidBaoCP@163.com
 */
public class PizzaShop  {
    SimplePizzaFactory factory;
    public PizzaShop(SimplePizzaFactory factory){
        this.factory=factory;
    }
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza=factory.creatPizza(type);
        return pizza;
    }
    public static void main(String[] args){
        SimplePizzaFactory factory=new SimplePizzaFactory();
        PizzaShop shop=new PizzaShop(factory);
        shop.orderPizza("clam");
    }
}
