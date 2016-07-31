package thinkinjava.collection.test;

/**
 * Created by Bill on 2016/7/31.
 * Email androidBaoCP@163.com
 * 这是一个性能测试框架
 */
public abstract class Test<C> {
    String name;
    public Test(String name){
        this.name=name;
    }
    abstract int test(C container,TestParam tp);
}
