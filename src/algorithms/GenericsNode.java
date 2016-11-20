package algorithms;

/**
 * Created by Bill on 2016/11/18.
 * Email androidBaoCP@163.com
 */
public class GenericsNode<T> {
    private T data;
    private GenericsNode<T> next;
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data=data;
    }
    public void setNext(GenericsNode<T> next){
        this.next=next;
    }
    public GenericsNode getNext(){
        return next;
    }
}
