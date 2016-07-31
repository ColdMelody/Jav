package thinkinjava.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bill on 2016/7/31.
 * Email androidBaoCP@163.com
 * 产生hashCode示例
 */
public class CountedString {
    private static List<String> created=new ArrayList<>();
    private String s;
    private int id=0;
    public CountedString(String str){
        s=str;
        created.add(s);
        for (String s2:created)
            if (s2.equals(s))
                id++;
    }
    public String toString(){
        return "String: "+s+" id: "+id+" hashCode(): "+hashCode();
    }
    public int hashCode(){
        int result=17;
        result =37*result+s.hashCode();
        result =37*result+id;
        return result;
    }
    public boolean equals(Object o){
        return o instanceof CountedString &&
                s.equals(((CountedString)o).s) &&
                id==((CountedString)o).id;
    }
    public static void main(String[] args){
        Map<CountedString,Integer> map=new HashMap<>();
        CountedString[] cs=new CountedString[5];
        for (int i=0;i<cs.length;i++){
            cs[i] =new CountedString("hi");
            map.put(cs[i],i);
        }
        System.out.println(map);
        for (CountedString cString:cs){
            System.out.println("Look up "+cString);
            System.out.println(map.get(cString));
        }
    }
}
