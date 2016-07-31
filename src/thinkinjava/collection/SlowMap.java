package thinkinjava.collection;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by Bill on 2016/7/30.
 * Email androidBaoCP@163.com
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();

    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public V get(Object key) {
        if (!keys.contains(key)) return null;
        return values.get(keys.indexOf(key));
    }

    @NotNull
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry<>(ki.next(), vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<Integer, String> m = new SlowMap<>();
        m.putAll(new CountingMapData(20));
        System.out.println(m);
        System.out.println(m.entrySet());
    }
}
