package thinkinjava.collection;

import thinkinjava.generics.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * Created by Bill on 2016/7/20.
 * Email androidBaoCP@163.com
 */
public class QueueBehavior {
    private static int count =10;
    private static <T> void test(Queue<T> queue, Generator<T> gen){
        for(int i=0;i<count;i++){
            queue.offer(gen.next());
        }
        while (queue.peek()!=null){
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }
    private static class Gen implements Generator<String>{
        String[] s=("one two three four five six seven eight nine ten").split(" ");
        int i;
        @Override
        public String next() {
            return s[i++];
        }
    }
    public static void main(String[] args){
        test(new LinkedList<>(),new Gen());
        test(new PriorityQueue<>(),new Gen());
        test(new ArrayBlockingQueue<>(count),new Gen());
        test(new ConcurrentLinkedQueue<>(),new Gen());
        test(new LinkedBlockingQueue<>(),new Gen());
        test(new PriorityBlockingQueue<>(),new Gen());
    }
}
