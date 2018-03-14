package observerpattern.observerpatthernDemo1;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observerList = new ArrayList<>();

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o:observerList){
            o.update(temperature,humidity,pressure);
        }
    }

    /**
     * 更新通知所有观察者
     */

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        notifyObservers();
    }
}
