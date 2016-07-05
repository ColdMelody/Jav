package thinkinjava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 实际数组类型是Apple，所以只能安置Apple或Apple的子类
 * Created by Bill on 2016/7/4.
 * Email androidBaoCP@163.com
 */
public class CovariantArrays {
    public static void main(String[] args){
//        @SuppressWarnings("MismatchedReadAndWriteOfArray") Fruit[] fruits=new Apple[10];
//        fruits[0]=new Apple();
//        fruits[1]=new Jonathan();
//        try{
//            fruits[0]=new Fruit();
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        try{
//            fruits[0]=new Orange();
//        }catch (Exception e){
//            System.out.println(e);
//        }
        List<? extends Fruit> flist= Arrays.asList(new Apple());
        //编译器并不能了解这里需要那种Fruit子类型，因此它不会接受任何的Fruit,而在使用contains和indexof时，参数类型是Object，因此不涉及任何通配符，
        //编译器将允许这个调用
//        flist.add(new Apple());
//        flist.add(new Fruit());
        System.out.println(flist.get(0));
        System.out.println(flist.contains(new Apple()));
        System.out.println(flist.indexOf(new Apple()));

    }
}
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

