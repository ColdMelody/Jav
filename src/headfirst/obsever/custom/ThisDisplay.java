package headfirst.obsever.custom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */

public class ThisDisplay  implements Subject{

    private List<Observer> list;
    private float temperature;


    ThisDisplay(Subject weatherData){
        list=new ArrayList<>();
        weatherData.register(observer);
    }
    private Observer observer= temperature1 -> {
        ThisDisplay.this.temperature= temperature1;
        display();
    };


    public void display() {
        System.out.println("Current conditions: "+temperature+"F degrees and ");
    }

    @Override
    public void nitifyAlll() {
        for (Observer observer:list){
            observer.update(temperature);
        }
    }

    @Override
    public void register(Observer observer) {
        list.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        int i = list.indexOf(observer);
        if (i >= 0) {
            list.remove(i);
        }
    }
}
