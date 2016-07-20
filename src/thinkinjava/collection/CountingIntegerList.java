package thinkinjava.collection;

import java.util.AbstractList;

/**
 * 定制具有任意尺寸的容器
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class CountingIntegerList extends AbstractList<Integer>{

    private int size;
    private CountingIntegerList(int size){
        this.size=size<0?0:size;
    }
    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }
    public static void main(String[] args){
        System.out.println(new CountingIntegerList(30));
    }
}
