package headfirst.abstractfactory;

import headfirst.simplefactory.Pizza;

/**
 * Created by Bill on 2016/5/23.
 * Email androidBaoCP@163.com
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type){
        Pizza pizza;
        pizza=creatPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    abstract Pizza creatPizza(String type);
}
