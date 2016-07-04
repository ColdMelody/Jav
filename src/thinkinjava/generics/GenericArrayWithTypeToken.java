package thinkinjava.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 恢复擦除的方法就是在创建泛型时传入类型标记，这在之前的方法中有介绍
 * Created by Bill on 2016/7/4.
 * Email androidBaoCP@163.com
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    private GenericArrayWithTypeToken(int sz, Class<T> type) {
        array = (T[]) Array.newInstance(type,sz);
    }

    private void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    private T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gi = new GenericArrayWithTypeToken<>(10, Integer.class);
        for (int i = 0; i < 10; i++) {
            gi.put(i, i);
        }
        Integer[] ia = gi.rep();
        System.out.println(Arrays.toString(ia));
    }
}
