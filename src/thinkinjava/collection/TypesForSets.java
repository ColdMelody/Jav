package thinkinjava.collection;

import org.jetbrains.annotations.NotNull;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 本类是为了证明哪些方法对于某种特定的Set是必需的
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class TypesForSets {
    private static <T> Set<T> fill(Set<T> set, Class<T> type){
        try {
            for (int i=0;i<10;i++)
                set.add(type.getConstructor(int.class).newInstance(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return set;
    }
    private static <T> void test(Set<T> set, Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println(set);
    }
    public static void main(String[] args){
        test(new HashSet<>(),HashType.class);
        test(new LinkedHashSet<>(),HashType.class);
        test(new HashSet<>(),SetType.class);
        test(new HashSet<>(),TreeType.class);
        test(new LinkedHashSet<>(),SetType.class);
        test(new LinkedHashSet<>(),TreeType.class);
        test(new TreeSet<>(),TreeType.class);
        try {
            test(new TreeSet<>(),SetType.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            test(new TreeSet<>(),HashType.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
class SetType{
    int i;
    public SetType(int n){
        i=n;
    }

    public boolean equals(Object obj) {
        return obj instanceof SetType && (i==((SetType)obj).i);
    }

    public String toString() {
        return Integer.toString(i);
    }
}
class HashType extends SetType{

   public HashType(int n) {
        super(n);
    }

    public int hashCode() {
        return i;
    }
}
class TreeType extends SetType implements Comparable<TreeType>{

   public TreeType(int n) {
        super(n);
    }

    public int compareTo(@NotNull TreeType o) {
        return (o.i<i?-1:(o.i==i?0:1));
    }
}