package thinkinjava.generics;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com<br>
 *
 * 一个通用的Generator，这个生成器用来生成某个类的对象，这个类必须具有两个特点：1.它必须声明为public 2.它必须具有无参的共有构造器
 * 一个泛型类应该具有一个create方法，必须过于繁琐的声明
 */
class BasicGenerator<T> implements Generator<T>  {
    private Class<T> type;
    private BasicGenerator(Class<T> type){
        this.type=type;
    }
    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static <T> Generator<T> create(Class<T> type){
        return new BasicGenerator<T>(type);
    }
}
