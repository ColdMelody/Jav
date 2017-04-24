package test;

/**
 * Created by Bill on 2017/3/6.
 * Email androidBaoCP@163.com
 */
public class IsInstanceOf {
    public static void main(String[] args){
        Cat cat=new Cat();
        System.out.println((cat instanceof Pet));
        System.out.println(Cat.class.isAssignableFrom(Pet.class));
        System.out.println(Pet.class.isAssignableFrom(Cat.class));
    }
}
class Pet{}
class Cat extends Pet{}
