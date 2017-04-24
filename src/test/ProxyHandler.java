package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Bill on 2017/3/6.
 * Email androidBaoCP@163.com
 */
public class ProxyHandler implements InvocationHandler {
    MyProxy real;
    ProxyHandler(MyProxy real){
        this.real=real;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(real,args);
    }
}
