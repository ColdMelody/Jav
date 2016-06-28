package headfirst.injava;


import java.util.Observable;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
public class NewWheatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    NewWheatherData() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurementsChanged(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTempreature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
