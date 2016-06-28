package thinkinjava.listdemo;

import java.util.ArrayList;

/**
 * Created by Bill on 2016/6/21.
 * Email androidBaoCP@163.com
 * 在Java SE5之前的容器中由于没有泛型，所以要特别注意类型安全，而且
 * 由于ArrayList保存的是Object类，所以还要转型，但是当add了不同的类时，转型会出异常
 */
public class AppleAndOrangeWithoutGenerics {
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList apples=new ArrayList();
        for (int i=0;i<3;i++){
            apples.add(new Apple());
        }
        apples.add(new Orange());
        for (Object apple : apples) {
            ((Apple) apple).getId();
        }
    }
}

class Apple{
    private static long counter;
    private final long id=counter++;
    long getId(){
        return id;
    }
}
class Orange{}