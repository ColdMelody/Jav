package test;

/**
 * Created by Bill on 2017/3/6.
 * Email androidBaoCP@163.com
 */
public class ProxyReal implements MyProxy{
    public void doSomething(){
        System.out.println("Something");
    }
    public void doSomethingElse(String s){
        System.out.println(s);
    }
}
interface MyProxy{
    void doSomething();
    void doSomethingElse(String s);
}