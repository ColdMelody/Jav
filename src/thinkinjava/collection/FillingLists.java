package thinkinjava.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bill on 2016/7/13.
 * Email androidBaoCP@163.com
 */
public class FillingLists {
    public static void main(String[] args){
        List<StringAddress> list=new ArrayList<>(Collections.nCopies(4,new StringAddress("hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress("world!"));
        System.out.println(list);
    }
}
class StringAddress{
    private String s;
    StringAddress(String s){
        this.s=s;
    }
    public String toString(){
        return super.toString()+" "+s;
    }
}
