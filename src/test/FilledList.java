package test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 2017/3/6.
 * Email androidBaoCP@163.com
 */
public class FilledList<T> {
    private Class<T> type;

    private FilledList(Class<T> type) {
        this.type = type;
    }

    private List<T> create(int n) {
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < n; i++) {
            try {
                result.add(type.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FilledList<CountedInteger> fl = new FilledList<>(CountedInteger.class);
        System.out.println(fl.create(15));

    }
}

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return Long.toString(id);
    }
}
