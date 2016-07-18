package thinkinjava.array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Bill on 2016/7/18.
 * Email androidBaoCP@163.com
 */
public class IceCream {
    private static Random random=new Random(47);
    private static final String[] FLAVORS={"Chocolate","Strawberry","Vanilla Fudge Swirlop","Mint Chip","Mocha Almond Fudge",
            "Rum Raisin","Praline Cream","Mud Pie"};
    private static String[] flavorSet(int n){
        if (n>FLAVORS.length) {
            throw new IllegalArgumentException("Set too big");
        }
        String[] results=new String[n];
        boolean[] picked=new boolean[FLAVORS.length];
        for (int i=0;i<n;i++){
            int t;
            do {
                t=random.nextInt(FLAVORS.length);
            }while (picked[t]);
            results[i]=FLAVORS[t];
            picked[t]=true;
        }
        return results;
    }
    private static BerylliumSphere[] spheres(int n){
        BerylliumSphere[] spires = new BerylliumSphere[n];
        for (int i=0;i<n;i++){
            spires[i]=new BerylliumSphere();
        }
        return spires;
    }
    public static void main(String[] args){
        for(int i=0;i<7;i++){
            System.out.println(Arrays.toString(flavorSet(3)));
            System.out.println(Arrays.toString(spheres(5)));
        }
    }
}
