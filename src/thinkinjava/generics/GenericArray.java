package thinkinjava.generics;

/**
 * 没有任何方式可以推翻底层的数组类型，它只能是Object[],具体转换方法，按照之前的方法，传递一个类型标记，在GenericArrayWithTypeToken中有实现
 * Created by Bill on 2016/7/3.
 * Email androidBaoCP@163.com
 */
public class GenericArray<T> {
    private Object[] array;
    private GenericArray(int sz){
        array=new Object[sz];
    }
    private void put(int index, T item){
        array[index]=item;
    }
    @SuppressWarnings("unchecked")
    private T get(int index){
        return (T) array[index];
    }
    @SuppressWarnings("unchecked")
    private T[] rep(){
        return (T[]) array;
    }
    public static void main(String[] args){
        GenericArray<Integer> gi=new GenericArray<>(10);
        for (int i=0;i<10;i++){
            gi.put(i,i);
        }
        for (int i=0;i<10;i++){
            System.out.println(gi.get(i)+" ");
        }
        try{
            Integer[] ia=gi.rep();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
