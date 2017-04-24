package headfirst.adapterpattern.objectadapter;

/**
 * Created by Bill on 2017/4/21.
 * Email androidBaoCP@163.com
 */
public class ChineseVolt220 implements Volt220 {
    @Override
    public int getVolt220() {
        return 220;
    }
}
