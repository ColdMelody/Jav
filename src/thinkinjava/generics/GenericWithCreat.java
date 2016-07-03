package thinkinjava.generics;

/**
 * Created by Bill on 2016/7/3.
 * Email androidBaoCP@163.com
 */
abstract class GenericWithCreat<T> {
    final T element;
    GenericWithCreat(){
        element=create();
    }
    abstract T create();
}
class X{}
class Creator extends GenericWithCreat<X>{
    X create(){
        return new X();
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}
class CreatorGeneric{
    public static void main(String[] args){
        Creator c=new Creator();
        c.f();
    }
}
