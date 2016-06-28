package thinkinjava.generics;


/**
 * Created by Bill on 2016/6/25.
 * Email androidBaoCP@163.com
 */
public class LinkedStack<T> {
    private class Node {
        T item;
        Node next;

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    //这是一个末端哨兵，用来判断对战何时为空
    private Node top = new Node(null, null);

    private void push(T item) {
        top = new Node(item, top);
    }

    private T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> iss = new LinkedStack<>();
        for (String str : "phasijd ids hnio".split(" ")) {
            iss.push(str);
        }
        String str;
        while ((str = iss.pop()) != null) {
            System.out.println(str);
        }
    }

}
