package thinkinjava.collection.test;

import thinkinjava.collection.SimpleHashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 2016/7/31.
 * Email androidBaoCP@163.com
 */
public class TestDemo {
    public static void main(String[] args){
        Test<SimpleHashMap<Integer,String>> test=new Test<SimpleHashMap<Integer, String>>("SimpleHashMap") {
            @Override
            int test(SimpleHashMap<Integer, String> container, TestParam tp) {
                return 0;
            }
        };
        List<Test<SimpleHashMap>> list=new ArrayList<>();
        Tester.run(new SimpleHashMap<Integer,String>(),list);
    }
}
