package thinkinjava.io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * Created by Bill on 2016/11/21.
 * Email androidBaoCP@163.com
 */
public class AvailableCharSets {
    public static void main(String[] args){
        SortedMap<String,Charset> charSets=Charset.availableCharsets();
        Iterator<String> it=charSets.keySet().iterator();
        while (it.hasNext()){
            String csName=it.next();
            System.out.println(csName);
            Iterator aliases=charSets.get(csName).aliases().iterator();
        }
    }
}
