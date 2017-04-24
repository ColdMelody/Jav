package thinkinjava.generics;


/**
 * Created by Bill on 2017/3/14.
 * Email androidBaoCP@163.com
 */
public class SelfBounding {
    public static void main(String[] args) {
        A a = new A();
        a.set(new A());
        a = a.get();
        a = a.set(new A()).get();
        C c = new C();
        c = c.setAndGet(new C());
    }
}

// 自限定的类型，语法比较诡异。称为CRG,其本质是：基类用到导出类替代其参数
class SelfBounded<T extends SelfBounded<T>> {
    private T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        System.out.println(element.getClass().getSimpleName());
        return element;
    }
}

// 自限定的类型使用的就是这种继承关系的类
class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
}

class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}
