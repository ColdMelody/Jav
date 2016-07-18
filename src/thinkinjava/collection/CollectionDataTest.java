package thinkinjava.collection;

import thinkinjava.generics.Generator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Bill on 2016/7/13.
 * Email androidBaoCP@163.com
 */
public class CollectionDataTest {
    public static void main(String[] args){
        Set<String> set=new LinkedHashSet<String>(new CollectionData<>(new Goverment(),15));
        set.addAll(CollectionData.list(new Goverment(),15));
        System.out.println(set);
    }
}
class Goverment implements Generator<String>{
    String[] foundation=("strange woman lying in ponds " +"distributing swords is no basis for a system of "+
                            "geverment").split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}