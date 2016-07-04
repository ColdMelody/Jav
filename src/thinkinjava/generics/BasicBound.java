package thinkinjava.generics;


import java.awt.*;

/**
 * Created by Bill on 2016/7/4.
 * Email androidBaoCP@163.com
 */
interface HasColor {
    Color getColor();
}

class Colored<T extends HasColor> {
    private T item;

    Colored(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    /**
     * 边界允许你调用它的方法
     */
    Color color() {
        return item.getColor();
    }
}

class Dimension {
    int x, y, z;
}
//这样不起作用，类必需位于接口之前
//class ColoredDimesion<T extends HasColor & Dimesion>{}

class ColoredDimesion<T extends Dimension & HasColor> {
    T item;

    ColoredDimesion(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

/**
 * 由于继承，你只能在边界中保有一个类，但是可以有多个接口
 */
class Solid<T extends Dimension & HasColor & Weight> {
    private T item;

    Solid(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }

    Color color() {
        return item.getColor();
    }

    int weight() {
        return item.weight();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBound {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        System.out.println(solid.color());
        System.out.println(solid.weight());
        System.out.println(solid.getY());
        ColoredDimesion<Bounded> cd = new ColoredDimesion<>(new Bounded());
        System.out.println(solid.color());
        System.out.println(solid.getY());
    }
}
