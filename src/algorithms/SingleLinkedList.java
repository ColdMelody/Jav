package algorithms;

/**
 * Created by Bill on 2016/11/18.
 * Email androidBaoCP@163.com
 */
public class SingleLinkedList<E> {
    private int size=0;
    private GenericsNode<E> head=new GenericsNode<E>();
    public SingleLinkedList(){

    }
    public void add(E data){
        if (size==0)
            head.setData(data);
        else
            head.setNext(head);
            head.setData(data);
        size++;
    }
    @SuppressWarnings("unchecked")
    public E remove(){
        if (size==0){
            throw new IndexOutOfBoundsException();
        }
        E data;
        if (size==1) {
            data = head.getData();
//            head.setData(null);
        }else {
            data=head.getData();
//            head.setData(null);
            head=head.getNext();
        }
        size--;
        return data;
    }


}
