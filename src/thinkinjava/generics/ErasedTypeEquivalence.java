package thinkinjava.generics;

import java.util.ArrayList;

/**
 * Created by Bill on 2016/6/28.
 * Email androidBaoCP@163.com
 */
public class ErasedTypeEquivalence {
    //看似两个不同的类型，其实在java看来是一样的类型，这中间发生了擦除
    public static void main(String[] args){
        Class c1=new ArrayList<String>().getClass();
        Class c2=new ArrayList<Integer>().getClass();
        System.out.println(c1==c2);
    }
}
