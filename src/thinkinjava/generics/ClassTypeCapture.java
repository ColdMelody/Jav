package thinkinjava.generics;

/**
 * 在泛型中无法使用instanceof判断类型信息，这是由于擦除的原因，如果想要判断的话，可以引入类型标签，使用isInstance判断
 * Created by Bill on 2016/7/3.
 * Email androidBaoCP@163.com
 */
public class ClassTypeCapture<T> {
    private Class<T> kind;
    private ClassTypeCapture(Class<T> kind){
        this.kind=kind;
    }
    private boolean f(Object o){
        return kind.isInstance(o);
    }
    public static void main(String[] args){
        ClassTypeCapture<Building> cttl=new ClassTypeCapture<>(Building.class);
        System.out.println(cttl.f(new Building()));
        System.out.println(cttl.f(new House()));
        ClassTypeCapture<House> cttm=new ClassTypeCapture<>(House.class);
        System.out.println(cttm.f(new Building()));
        System.out.println(cttm.f(new House()));
    }
}

class Building{}
class House extends Building{}
