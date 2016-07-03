package thinkinjava.generics;

/**
 * 显式的工厂方法来创建T的对象，这样的话在编译时就会进行检查
 * Created by Bill on 2016/7/3.
 * Email androidBaoCP@163.com
 */
public class FactoryConstraint {
    public static void main(String[] args){
        new Foo2<Integer>(new IntergerFactory());
        new Foo2<Wedget>(new Wedget.Factory());
    }
}
interface FactoryI<T>{
    T create();
}

class Foo2<T>{
    private T x;
    <F extends FactoryI<T>> Foo2(F factory){
        x=factory.create();
    }
}
class IntergerFactory implements FactoryI{

    @Override
    public Object create() {
        return 0;
    }
}
class Wedget{
    static class Factory implements FactoryI<Wedget>{

        @Override
        public Wedget create() {
            return new Wedget();
        }
    }
}
