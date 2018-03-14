package observerpattern.observerpatternDemo1.observer;

import observerpattern.observerpatternDemo1.intf.DisplayElement;
import observerpattern.observerpatternDemo1.intf.Observer;

public class ForecastDisplay implements Observer,DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        System.out.println("Forecast:"+temperature+"F degreee and "+humidity+"% humidity");

    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }


}
