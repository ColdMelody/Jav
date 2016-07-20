package thinkinjava.collection;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class IntPriority extends PriorityQueue<IntPriority.Int> {
    static class Int implements Comparable<Int>{
        int i;
        Random random=new Random(47);
        Int(int n){
            if (n>100)
                throw new UnsupportedOperationException();
            i=random.nextInt(n);
        }
        @Override
        public int compareTo(Int o) {
            if (i>o.i)return +1;
            else if (i==o.i)return 0;
            else return -1;
        }
        public String toString(){
            return i+" ";
        }
    }
    private void pull(int i){
        super.add(new Int(i));
    }
    public static void main(String[] args){
        IntPriority priority=new IntPriority();
        priority.pull(50);
        priority.pull(20);
        priority.pull(45);
        priority.pull(75);
        priority.pull(92);
        while (!priority.isEmpty())
            System.out.println(priority.remove());
    }
}
