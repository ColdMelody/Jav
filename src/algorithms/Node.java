package algorithms;

/**
 * Created by Bill on 2016/11/18.
 * Email androidBaoCP@163.com
 */
public class Node {
    private int data;
    private Node next;
    public Node(int data){
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
