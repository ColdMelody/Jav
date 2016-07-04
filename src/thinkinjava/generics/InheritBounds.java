package thinkinjava.generics;

import java.awt.*;

/**
 * 在继承的每个层次上添加边界限制。在每个层次上添加了边界，现在这些方法被继承<p>
 * 而不用在每个类中重复
 * Created by Bill on 2016/7/4.
 * Email androidBaoCP@163.com
 */
class HoldItem<T>{
    T item;
    HoldItem(T item){
        this.item=item;
    }
    T getItem(){
        return item;
    }
}
class Colored2<T extends HasColor> extends HoldItem<T>{
    Colored2(T item){
        super(item);
    }
    Color color(){
        return item.getColor();
    }
}
class ColoredDimesion2<T extends Dimension & HasColor & Weight> extends Colored2<T>{
    ColoredDimesion2(T item){
        super(item);
    }
    int getX(){
        return item.x;
    }
    int getY(){
        return item.y;
    }
    int getZ(){
        return item.z;
    }
}
class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimesion2<T>{
    Solid2(T item){
        super(item);
    }
    int weight(){
        return item.weight();
    }
}
public class InheritBounds {
    public static void main(String[] args){
        Solid2<Bounded> solid2=new Solid2<>(new Bounded());
        solid2.color();
        solid2.weight();
        solid2.getX();
    }
}
