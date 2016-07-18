package thinkinjava.collection;

import thinkinjava.generics.Generator;

import java.util.Iterator;
import java.util.LinkedHashMap;


/**
 * Created by Bill on 2016/7/18.
 * Email androidBaoCP@163.com
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {
    private MapData(Generator<Pair<K, V>> gen, int quantity){
        for(int i=0;i<quantity;i++){
            Pair<K,V> p=gen.next();
            put(p.key,p.value);
        }
    }
    private MapData(Generator<K> genK, Generator<V> genV, int quantity){
        for(int i=0;i<quantity;i++){
            put(genK.next(),genV.next());
        }
    }
    private MapData(Generator<K> genK, V value, int quantity){
        for(int i=0;i<quantity;i++){
            put(genK.next(),value);
        }
    }
    private MapData(Iterable<K> genK, Generator<V> genV){
        for (K key:genK){
            put(key,genV.next());
        }
    }
    private MapData(Iterable<K> genK, V value){
        for(K key:genK){
            put(key,value);
        }
    }
    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
        return new MapData<K, V>(gen,quantity);
    }
    public static <K,V> MapData<K,V> map(Generator<K> genK,V value,int quantity ){
        return new MapData<K, V>(genK,value,quantity);
    }
    public static <K,V> MapData<K,V> map(Generator<K> genK,Generator<V> genV,int quantity){
        return new MapData<K, V>(genK,genV,quantity);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> genK,Generator<V> genV){
        return new MapData<K, V>(genK,genV);
    }
    public static <K,V> MapData<K,V> map(Iterable<K> genK,V value){
        return new MapData<K, V>(genK,value);
    }
}
