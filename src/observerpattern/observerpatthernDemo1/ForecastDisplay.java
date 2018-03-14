package observerpattern.observerpatthernDemo1;

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