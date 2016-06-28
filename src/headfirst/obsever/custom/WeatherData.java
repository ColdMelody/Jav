package headfirst.obsever.custom;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
public class WeatherData implements Subject {
    private List<Observer> list;
    private float temperature;


    WeatherData() {
        list = new ArrayList<>();
    }

    @Override
    public void nitifyAlll() {
        for (Observer observer : list) {
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

    private void measurementsChanged() {
        nitifyAlll();
    }

    void setMeasurementsChanged(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        measurementsChanged();
    }

}
