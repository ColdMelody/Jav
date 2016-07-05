package thinkinjava.generics;

import java.util.List;

/**
 * 可以使用超类型通配符来将一个对象传递泛型类型中
 * Created by Bill on 2016/7/5.
 * Email androidBaoCP@163.com
 */
public class SuperTypeWildcards {
    static void writeto(List<? super Apple> apples){
        apples.add(new Apple());
        apples.add(new Jonathan());
    }
}
