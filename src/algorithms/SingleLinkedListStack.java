package algorithms;

/**
 * Created by Bill on 2016/11/18.
 * Email androidBaoCP@163.com
 */
public class SingleLinkedListStack<E> {
    private SingleLinkedList<E> link;
    public SingleLinkedListStack(){
        link =new SingleLinkedList<E>();
    }
    public void push(E pa){
        link.add(pa);
    }
    public E pop(){
        return link.remove();
    }

    public static void main(String...args){
        SingleLinkedListStack<Integer> stack=new SingleLinkedListStack<>();
        for (int i=0;i<5;i++){
            stack.push(i);
        }
        System.out.println(stack);
        for (int i=0;i<5;i++){
            System.out.println(String.valueOf(stack.pop()));
        }
    }
}
