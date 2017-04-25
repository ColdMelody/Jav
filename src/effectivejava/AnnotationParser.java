package effectivejava;

import java.lang.reflect.Method;

/**
 * Created by Bill on 2017/4/25.
 * Email androidBaoCP@163.com
 */
public class AnnotationParser {
    public static void main(String[] args) throws ClassNotFoundException {
        String clazz = "effectivejava.AnnotationDemo";
        Method[] methods = AnnotationParser.class.getClassLoader().loadClass(clazz).getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                System.out.println("Method : " + method);
                System.out.println("name = " + test.name() + "\n"
                        + "webSite = " + test.webSite() + "\n"
                        + "vision = " + test.vision());
            }
        }
    }
}
