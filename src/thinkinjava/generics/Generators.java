package thinkinjava.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com
 */
public class Generators {
     static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen, int n){
        for (int i=0;i<n;i++){
            coll.add(gen.next());
        }
        return coll;
    }
    public static void main(String[] args){
        Collection<Coffee> coffees=fill(new ArrayList<>(),new CoffeeGenerator(),4);
        coffees.forEach(System.out::println);
    }
}
