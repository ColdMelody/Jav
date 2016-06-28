package headfirst.obsever.custom;



/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
 interface Subject {
    void nitifyAlll();
    void register(Observer observer);
    void unregister(Observer observer);
}
