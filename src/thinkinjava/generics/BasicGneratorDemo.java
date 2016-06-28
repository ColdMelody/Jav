package thinkinjava.generics;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com
 */
public class BasicGneratorDemo {
    public static void main(String[] args){
        Generator<Coffee> gen=BasicGenerator.create(Coffee.class);
        for (int i=0;i<5;i++){
            System.out.println(gen.next());
        }
    }
}
