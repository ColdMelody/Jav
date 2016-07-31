package thinkinjava.collection;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by Bill on 2016/7/30.
 * Email androidBaoCP@163.com
 * 一个简单的散列Map
 */
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    private static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        //计算桶位的分布
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            //利用LinkedList保存Entry
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index]) {
            //具有相同桶位的key进行equals比较
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        }
        return null;
    }

    @NotNull
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mPair : bucket)
                set.add(mPair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<Integer, String> m = new SimpleHashMap<>();
        m.putAll(new CountingMapData(20));
        System.out.println(m);
        System.out.println(m.entrySet());
    }
}
