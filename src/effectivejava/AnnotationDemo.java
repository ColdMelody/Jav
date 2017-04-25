package effectivejava;

/**
 * Created by Bill on 2017/4/25.
 * Email androidBaoCP@163.com
 */
public class AnnotationDemo {
    @Test(name = "main", webSite = "main.com")
    public static void main(String[] args) {
        AnnotationDemo demo = new AnnotationDemo();
        demo.demo();
        System.out.println("This is main method");
    }

    @Test(name = "peng", webSite = "peng.com", vision = 2)
    public void demo() {
        System.out.println("This is a demo method");
    }
}
