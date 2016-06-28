package headfirst.simplefactory;

/**
 * Created by Bill on 2016/6/12.
 * Email androidBaoCP@163.com
 * 这是一个原料工厂，用于创建pizza的各种原料，根据依赖倒置原则，每个原料使用方法来创建，这里只给一个简单的实例
 * 使用工厂你会发现和自己创建实例没什么不同，但是我们用工厂实现了类之间的解耦，即，一个类只做一件事情，工厂就负责类的实例化
 */
public interface PizzaIngredientFactory {
    public Dough createDough();

}
