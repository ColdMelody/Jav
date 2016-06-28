package thinkinjava.generics;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com
 */
//一个泛型的接口，用作生成器，专门用于创建对象
public interface Generator<T> {
    T next();
}
