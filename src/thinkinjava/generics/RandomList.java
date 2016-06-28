package thinkinjava.generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com
 */
public class RandomList<T> {
    private ArrayList<T> storage=new ArrayList<>();
    private Random rand=new Random(47);
    private void add(T item){
        storage.add(item);
    }
    private T select(){
        return storage.get(rand.nextInt(storage.size()));
    }
    private int getSize(){
        return storage.size();
    }
    public static void main(String[] args){
        RandomList<String> randomList=new RandomList<>();
        for (String str:("sont sjhoij hsit sjiom shoit sf gtlon so").split(" ")){
            randomList.add(str);
        }
        for (int i=0;i<randomList.getSize();i++){
            System.out.println(randomList.select()+" ");
        }
    }
}
