package algorithms;

import java.util.Arrays;

/**
 * Created by Bill on 2016/11/18.
 * Email androidBaoCP@163.com
 */
public class Stack<T> {
    private int top = -1;
    private T[] ts;
    private int n;

    @SuppressWarnings("unchecked")
    public Stack(int n) {
        this.n = n;
        ts = (T[]) new Object[n];
    }

    public T pop() {
        if (top < 0) {
            throw new IndexOutOfBoundsException();
        }
        ts[top] = null;
        top--;
        return ts[top];
    }

    public void push(T t) {
        if (top == n - 1) {
            return;
        }
        ts[top + 1] = t;
        top++;
    }

    public String toString() {
        return Arrays.toString(ts);
    }

    public static void main(String... args) {

        Stack<Integer> stack = new Stack<>(5);
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(String.valueOf(1>>2));
    }
}
