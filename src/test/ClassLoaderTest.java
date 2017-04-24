package test;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Bill on 2016/11/27.
 * Email androidBaoCP@163.com
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null){
                        return super.loadClass(name);
                    }
                    byte[] bs = new byte[is.available()];
                    is.read(bs);
                    return defineClass(name,bs,0,bs.length);
                }catch (IOException e){
                   throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("test.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof test.ClassLoaderTest);
    }
}
