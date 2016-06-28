package headfirst.simplefactory;

/**
 * Created by Bill on 2016/5/23.
 * Email androidBaoCP@163.com
 */
public class SimplePizzaFactory {
    public Pizza creatPizza(String type){
        Pizza pizza=null;
        if (type.equals("cheese")){
            pizza=new CheesePizza();
        }else if (type.equals("pepperoni")){
            pizza=new PepperoniPizza();
        }else if (type.equals("clam")){
            pizza=new ClamPizza();

        }
        return pizza;
    }
}
