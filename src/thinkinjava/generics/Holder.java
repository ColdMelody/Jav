package thinkinjava.generics;


/**
 * Created by Bill on 2016/7/5.
 * Email androidBaoCP@163.com
 */
public class Holder<T> {
    private T value;
    public Holder(){}
    private Holder(T value){
        this.value=value;
    }
    private void set(T value){
        this.value=value;
    }
    private T get(){
        return value;
    }
    private boolean euqals(Object o){
        return value.equals(o);
    }
    public static void main(String[] args){
        Holder<Apple> apple=new Holder<>(new Apple());
        Apple d=apple.get();
        apple.set(d);
        Holder<? extends Fruit> fruit=apple;
        Fruit p=fruit.get();
        try{
            Orange c= (Orange) fruit.get();
        }catch (Exception e){
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }
        System.out.println(fruit.euqals(d));
    }

}
