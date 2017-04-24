package headfirst.adapterpattern.objectadapter;

/**
 * Created by Bill on 2017/4/21.
 * Email androidBaoCP@163.com
 * 使用对象适配器，Adaptee是Volt220，目标是Volt5
 */
public class VoltAdapter implements Volt5 {

    private Volt220 volt220;

    private VoltAdapter(Volt220 volt220) {
        this.volt220 = volt220;
    }

    @Override
    public int getVolt5() {
        return volt220.getVolt220()/44;
    }
    public static void main(String[] args) {
        Volt220 mVolt220 = new ChineseVolt220();
        System.out.println("Adaptee: " + mVolt220.getVolt220());
        Volt5 adapterVolt = new VoltAdapter(mVolt220);
        System.out.println("Adapter: " + adapterVolt.getVolt5());
    }
}
