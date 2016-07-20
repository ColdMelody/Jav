package thinkinjava.collection;

import java.util.*;

/**
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class Unsupported {
    static void test(String msg,List<String> list){
        System.out.println("----"+msg+"----");
        Collection<String> c=list;
        Collection<String> subList=list.subList(1,5);
        Collection<String> c2=new ArrayList<>(subList);
        try {
            c.retainAll(c2);
        }catch (Exception e){
            //noinspection ThrowablePrintedToSystemOut
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        //asList内部是由数组实现的
        List<String> list= Arrays.asList("A B C D E F".split(" "));
        //若想要避免出现这种情况，应该这么写
//        List<String> list1= new ArrayList<>();
//        list1.addAll(list);
        test("Arrays.asList",list);
    }
}
