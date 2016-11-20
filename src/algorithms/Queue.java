package algorithms;

/**
 * Created by Bill on 2016/11/18.
 * Email androidBaoCP@163.com
 */
public class Queue<T> {
    private int head = 0;
    private int tail = 0;
    private T[] ts;
    private int n;

    @SuppressWarnings("unchecked")
    public Queue(int n) {
        this.n = n;
        ts = (T[]) new Object[n];
    }

    public void enQueue(T t) {
        if (head == tail + 1)
            return;
        ts[tail] = t;
        if (tail == n - 1) {
            tail = -1;
        } else {
            tail++;
        }
    }

    public T deQueue() {
        if (head == -1)
            return null;
        T t = ts[head];
        if (head == n - 1)
            head = 0;
        else
            head++;
        return t;
    }

    public static void main(String... args) {
        Queue<Integer> queue=new Queue<>(5);
        for (int i=0;i<5;i++){
            queue.enQueue(i);
        }
        for (int i=0;i<5;i++){
            System.out.println(queue.deQueue());
        }

    }
}
