package thinkinjava.array;


import java.util.Arrays;

/**
 * Created by Bill on 2016/7/18.
 * Email androidBaoCP@163.com
 */
public class ArrayOptions {
    public static void main(String[] args){
        BerylliumSphere[] a;
        BerylliumSphere[] b=new BerylliumSphere[5];
        System.out.println("b:  "+ Arrays.toString(b));
        BerylliumSphere[] c=new BerylliumSphere[4];
        for (int i =0;i<c.length;i++)
            if(c[i]==null)
                c[i]=new BerylliumSphere();
        BerylliumSphere[] d={new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        a=new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
        System.out.println("a.length: "+a.length);
        System.out.println("d.length: "+d.length);
        a=d;
        System.out.println("a.lenght: "+a.length);

    }
}
