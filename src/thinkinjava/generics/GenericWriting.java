package thinkinjava.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 2016/7/5.
 * Email androidBaoCP@163.com
 */
public class GenericWriting {
    private static <T> void writeExact(List<T> list, T item){
        list.add(item);
    }
    private static List<Apple> apples=new ArrayList<>();
    private static List<Fruit> fruits=new ArrayList<>();
    private static void f(){
        writeExact(apples,new Apple());
    }
    private static <T> void writeWithWildcard(List<? super T> list, T item){
        list.add(item);
    }
    private static void f2(){
        writeWithWildcard(apples,new Apple());
        writeWithWildcard(fruits,new Apple());
    }
    public static void main(String[] args){
        f();
        f2();
    }
}
