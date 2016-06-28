package thinkinjava.generics;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com
 */
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    private Class[] type = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class};
    private static Random random = new Random(47);

    CoffeeGenerator() {
    }

    private int size = 0;

    private CoffeeGenerator(int sz) {
        size = sz;
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) type[random.nextInt(type.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
        CoffeeGenerator generator = new CoffeeGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.println(generator.next());
        }
        for (Coffee coffee : new CoffeeGenerator(6)) {
            System.out.println(coffee);
        }
    }
}
