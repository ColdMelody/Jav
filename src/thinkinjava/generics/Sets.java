package thinkinjava.generics;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bill on 2016/6/28.
 * Email androidBaoCP@163.com
 */
public class Sets {
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<T>(a);
        result.addAll(b);
        return result;
    }
    public static <T> Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }
    public static <T> Set<T> difference(Set<T> superSet,Set<T> sunSet){
        Set<T> result=new HashSet<T>(superSet);
        result.removeAll(sunSet);
        return result;
    }
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a, b),intersection(a, b));
    }
}
