package thinkinjava.generics;

/**
 * 实际数组类型是Apple，所以只能安置Apple或Apple的子类
 * Created by Bill on 2016/7/4.
 * Email androidBaoCP@163.com
 */
public class CovariantArrays {
    public static void main(String[] args){
        @SuppressWarnings("MismatchedReadAndWriteOfArray") Fruit[] fruits=new Apple[10];
        fruits[0]=new Apple();
        fruits[1]=new Jonathan();
        try{
            fruits[0]=new Fruit();
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            fruits[0]=new Orange();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}

