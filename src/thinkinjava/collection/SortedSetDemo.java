package thinkinjava.collection;

import java.util.*;

/**
 * SortedSet的一些方法简单使用
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class SortedSetDemo {
    public static void main(String[] args){
        SortedSet<String> sortedSet=new TreeSet<>();
        Collections.addAll(sortedSet,"A B C D E F G H".split(" "));
        System.out.println(sortedSet);
        //return the first element of the set
        String low =sortedSet.first();
        //return the last element of the set
        String high=sortedSet.last();
        System.out.println(low);
        System.out.println(high);
        Iterator<String> iterator=sortedSet.iterator();
        for (int i=0;i<=6;i++){
            if (i==3)low=iterator.next();
            if (i==6)high=iterator.next();
            else iterator.next();
        }
        System.out.println(low);
        System.out.println(high);
        //print a child set of thr origin set(high not include)
        System.out.println(sortedSet.subSet(low,high));
        //好吧 我实在翻译不下去了，输出小于high的子集
        System.out.println(sortedSet.headSet(high));
        //和上面的相反，大于或等于
        System.out.println(sortedSet.tailSet(low));
    }
}
