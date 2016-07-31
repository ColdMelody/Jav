package thinkinjava.collection;

import java.util.Map;

/**
 * Created by Bill on 2016/7/30.
 * Email androidBaoCP@163.com
 */
public class MapEntry<N, M> implements Map.Entry<N, M> {

    private N key;
    private M value;

    MapEntry(N key, M value) {
        this.key = key;
        this.value = value;
    }

    public N getKey() {
        return key;
    }

    public M getValue() {
        return value;
    }

    public M setValue(M v) {
        M result = value;
        value = v;
        return result;
    }

    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)) return false;
        MapEntry me = (MapEntry) o;
        return (key == null ? me.getKey() == null : key.equals(me.getKey()))
                && (value == null ? me.getValue() == null : value.equals(me.getValue()));
    }

    public String toString() {
        return key + "=" + value;
    }
}

