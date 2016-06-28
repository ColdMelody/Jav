package thinkinjava.generics;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com
 */
public class GenericMethod {
    private <T> void f(T x){
        System.out.println(x.getClass().getSimpleName());
    }
    public static void main(String[] args){
        GenericMethod gm=new GenericMethod();
        gm.f("");
        gm.f(1);
        gm.f(1.1);
        gm.f(1.0f);
        gm.f('c');
        gm.f(gm);
    }
}
