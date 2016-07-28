package thinkinjava.collection;

import org.jetbrains.annotations.NotNull;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**这个类主要是介绍一种享元的设计模式，享元模式使对象的一部分可以被具体化，因此，我们可以更加高效的在外部表中查找对象的一份或者
 * 整体。我们可以继承容器类的abstract类来实现自定义容器用以实现享元。但本例并没有完全实现享元，因为使用的linkedHashSet，而不是自定义的Set
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class CountingMapData extends AbstractMap<Integer,String> {
    private int size;
    private static String[] chars="A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    CountingMapData(int size){
        this.size= size < 0? 0: size;
    }
    private static class Entry implements Map.Entry<Integer,String>{
        int index;
        Entry(int index){
            this.index=index;
        }
        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index%chars.length]+Integer.toString(index/chars.length);
        }

        @Override
        public String setValue(String value) {
            throw  new UnsupportedOperationException();
        }

        @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
        public boolean equals(Object o){
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    @NotNull
    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        Set<Map.Entry<Integer,String>> entries=new LinkedHashSet<>();
        for (int i =0;i<size;i++){
            entries.add(new Entry(i));
        }
        return entries;
    }
    public static void main(String[] args){
        System.out.println(new CountingMapData(60));
    }
}
