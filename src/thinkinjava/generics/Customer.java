package thinkinjava.generics;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bill on 2016/6/26.
 * Email androidBaoCP@163.com
 */
class Customer {
    private static long counter=0;
    private final long id=counter++;
    private Customer(){}

    @Override
    public String toString() {
        return "Customer "+id;
    }
    private static Generator<Customer> generator(){
        return Customer::new;
    }
    public static void main(String[] args){
        Queue<Customer> line=new LinkedList<>();
        Generators.fill(line,Customer.generator(),15);
        line.forEach(System.out::println);
    }
}
