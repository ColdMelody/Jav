package thinkinjava.generics;

import java.util.ArrayList;

/**
 * Created by Bill on 2016/6/28.
 * Email androidBaoCP@163.com
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args){
        Class c1=new ArrayList<String>().getClass();
        Class c2=new ArrayList<Integer>().getClass();
        System.out.println(c1==c2);
    }
}
