package test;

import java.lang.reflect.Proxy;

/**
 * Created by Bill on 2017/3/6.
 * Email androidBaoCP@163.com
 */
public class ProxyDemo {
    public static void cosume(MyProxy real){
        real.doSomething();
        real.doSomethingElse("motherfucker");
    }
    public static void main(String[] args){
        ProxyReal real=new ProxyReal();
        cosume(real);
        MyProxy proxyReal= (MyProxy) Proxy.newProxyInstance(ProxyReal.class.getClassLoader(),
                new Class[]{MyProxy.class},
                new ProxyHandler(real));
        cosume(proxyReal);
    }
}
