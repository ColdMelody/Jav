package thinkinjava.collection;

import java.util.*;

/**
 * Collection的常用方法，可以通过Set和List执行所有的操作，但是不包含get(),因为Set内部自己实现了存储顺序，所以在检查Collection
 * 中的元素是，要使用迭代器。
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class CollectionMethods {
    public static void main(String[] args){
        Collection<String> c=new ArrayList<>();
        c.addAll(Arrays.asList("sjod dsoj sijdoasj d s".split(" ")));
        c.add("ten");
        c.add("eleven");
        System.out.println(c);
        Object[] a=c.toArray();
        String[] strs=c.toArray(new String[0]);
        System.out.println("Collections.max(c)= "+ Collections.max(c));
        System.out.println("Collections.min(c)="+Collections.min(c));

        Collection<String> c2=new ArrayList<>();
        c.addAll(c2);
        System.out.println(c);
        c.removeAll(c2);
        System.out.println(c);
        System.out.println("c.contains(ten)= "+c.contains("ten"));
        //noinspection SuspiciousMethodCalls
        System.out.println("c.contains(c2)= "+c.contains(c2));
        Collection<String> c3=((List<String>)c).subList(3,5);
        c2.retainAll(c3);
        System.out.println(c2);
        c2.removeAll(c3);
        System.out.println(c2);
        c.clear();
        System.out.println(c);
    }
}
