package headfirst.injava;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
public class ThisConditionsDisplay implements Observer {
    Observable observable;
    private float tempreature;
    private float humidity;

    ThisConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof NewWheatherData) {
            NewWheatherData wheatherData = (NewWheatherData) o;
            this.tempreature = wheatherData.getTempreature();
            this.humidity = wheatherData.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("Current conditions: " + tempreature + "F degrees and " + humidity + "% humidity " + "pressure ");
    }
    public  static void main(String[] args){
        NewWheatherData observable=new NewWheatherData();
        observable.setMeasurementsChanged(5f,10f,5f);
        ThisConditionsDisplay display=new ThisConditionsDisplay(new NewWheatherData());
        display.display();
    }
}
