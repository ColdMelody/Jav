package thinkinjava.collection.test;

import thinkinjava.collection.CountingIntegerList;

import java.util.*;

/**
 * Created by Bill on 2016/7/31.
 * Email androidBaoCP@163.com
 */
public class ListPerformance {
    private static Random random=new Random();
    private static int reps=1000;
    private static List<Test<List<Integer>>> tests=new ArrayList<>();
    private static List<Test<LinkedList<Integer>>> qTests=new ArrayList<>();
    static {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int listSize=tp.size;
                for (int i=0;i<loops;i++){
                    container.clear();
                    for (int j=0;j<listSize;j++)
                        container.add(j);
                }
                return loops*listSize;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops*reps;
                int listSize=container.size();
                for (int i=0;i<loops;i++){
                    container.get(random.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops*reps;
                int listSize=container.size();
                for (int i=0;i<container.size();i++)
                    container.set(random.nextInt(listSize),47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                final int LOOPS=1000000;
                int half=container.size()/2;
                ListIterator<Integer> it=container.listIterator(half);
                for (int i=0;i<LOOPS;i++)
                    it.add(47);
                return LOOPS;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                for (int i=0;i<loops;i++)
                    container.add(5,47);
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            int test(List<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for (int i=0;i<loops;i++){
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while (container.size()>5)
                        container.remove(5);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for (int i=0;i<loops;i++){
                    container.clear();
                    for (int j=0;j<size;j++){
                        container.addFirst(47);
                    }
                }
                return loops*size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for (int i=0;i<loops;i++){
                    container.clear();
                    for (int j=0;j<size;j++){
                        container.addLast(47);
                    }
                }
                return loops*size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for (int i=0;i<loops;i++){
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while (container.size()>0)
                        container.removeFirst();
                }
                return loops *size;
            }
        });
        qTests.add(new Test<LinkedList<Integer>>("rmLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam tp) {
                int loops=tp.loops;
                int size=tp.size;
                for (int i=0;i<loops;i++){
                    container.clear();
                    container.addAll(new CountingIntegerList(size));
                    while (container.size()>0)
                        container.removeLast();
                }
                return loops * size;
            }
        });
    }
    static class ListTester extends Tester<List<Integer>>{
        public ListTester(List<Integer> container,List<Test<List<Integer>>> tests){
            super(container,tests);
        }

        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new CountingIntegerList(size));
            return container;
        }
        public static void run(List<Integer> list,List<Test<List<Integer>>> tests){
            new ListTester(list,tests).timedTest();
        }
    }
    public static void main(String[] args){
        if (args.length>0)
            Tester.defaultParams=TestParam.array(args);

    }
}
