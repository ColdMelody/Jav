package thinkinjava.generics;

/**
 * Created by Bill on 2017/3/14.
 * Email androidBaoCP@163.com
 */
public class GenericsAndReturnType {
    void test(Getter g) {
        GenericGetter gg = g.get();
        Getter result = g.get();
    }
}

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {
}

class SimpleGetter implements GenericGetter<SimpleGetter> {

    @Override
    public SimpleGetter get() {
        System.out.println(this.getClass().getSimpleName());
        return this;
    }
}