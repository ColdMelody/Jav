package headfirst.obsever.custom;

/**
 * Created by Bill on 2016/5/22.
 * Email androidBaoCP@163.com
 */
public class AnotherObserver implements Observer {
    Subject subject;
    private float temperature;
    AnotherObserver(Subject subject){
        this.subject=subject;
        subject.register(this);
    }
    @Override
    public void update(float temperature) {
        this.temperature=temperature;
        display();
    }
    public void display() {
        System.out.println("Current conditions: "+temperature+"F degrees and ");
    }
    public static void main(String[] args){
        WeatherData weatherData=new WeatherData();
        ThisDisplay display=new ThisDisplay(weatherData);
        AnotherObserver observer=new AnotherObserver(display);
        weatherData.setMeasurementsChanged(5f,5f,5f);
    }
}
