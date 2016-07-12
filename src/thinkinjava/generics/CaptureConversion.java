package thinkinjava.generics;

/**
 * 参数类型在调用f2的过程中被捕获，因此它可以在对f1的调用中被使用
 * Created by Bill on 2016/7/12.
 * Email androidBaoCP@163.com
 */
public class CaptureConversion {
    static <T> void f1(Holder<T> holder ){
        T t =holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static void f2(Holder<?> holder){
        f1(holder);
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        Holder raw=new Holder<Integer>(1);
        f2(raw);
        Holder rawBasic=new Holder();
        rawBasic.set(new Object());
        f2(rawBasic);
        Holder<?> wildcarded=new Holder<Double>(1.0);
        f2(wildcarded);
    }

}
