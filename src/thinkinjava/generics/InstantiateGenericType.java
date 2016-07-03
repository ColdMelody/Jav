package thinkinjava.generics;

/**
 * 由于擦除的原因，无法直接new T（），所以用工厂来创建，但对于没有无参构造会报运行时错误
 * Created by Bill on 2016/7/3.
 * Email androidBaoCP@163.com
 */
public class InstantiateGenericType {
    public static void main(String[] args){
        ClassAsFactory<Employee> fe=new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFacyory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi=new ClassAsFactory<>(Integer.class);
        }catch (Exception e){
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
class ClassAsFactory<T>{
    private T x;
    ClassAsFactory(Class<T> kind){
        try {
            x=kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
class Employee{}