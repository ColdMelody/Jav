package thinkinjava.listdemo;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Bill on 2016/6/2.
 * Email androidBaoCP@163.com
 */
public class AddingGroups {
    public static void main(String[] args){
        ArrayList<Integer> collation= new ArrayList<>(Arrays.asList(1,2,3,4,8));
        Integer[] moreInts={6,7,8,9,10};
        collation.addAll(Arrays.asList(moreInts));
        Collections.addAll(collation,11,12,13,14);
        Collections.addAll(collation,moreInts);

    }
}
