package thinkinjava.collection;

import thinkinjava.generics.Generator;

import java.util.ArrayList;

/**
 * 适配器设计模式的一个实例
 * Created by Bill on 2016/7/13.
 * Email androidBaoCP@163.com
 */
class CollectionData<T> extends ArrayList<T> {
    CollectionData(Generator<T> gen, int quantity){
        for (int i=0;i<quantity;i++){
            add(gen.next());
        }
    }
    static <T> CollectionData<T> list(Generator<T> gen,int quantity){
        return new CollectionData<T>(gen,quantity);
    }
}
