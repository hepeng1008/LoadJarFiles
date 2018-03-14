package observerpattern.observerpatternDemo1;

import observerpattern.observerpatternDemo1.intf.Observer;
import observerpattern.observerpatternDemo1.observable.WeatherData;
import observerpattern.observerpatternDemo1.observer.CurrentConditionDisplay;
import observerpattern.observerpatternDemo1.observer.ForecastDisplay;
import observerpattern.observerpatternDemo1.observer.StatisticsDisplay;

public class Demo {
    public static void main(String[] args) {
        Observer o1 = new StatisticsDisplay();
        Observer o2 = new CurrentConditionDisplay();
        Observer o3 = new ForecastDisplay();

        WeatherData wd = new WeatherData();

        wd.registerObserver(o1);
        wd.registerObserver(o2);
        wd.registerObserver(o3);

        wd.setMeasurements(27,65,80);
        System.out.println("------------------------------");
        wd.setMeasurements(28,75,90);
        System.out.println("------------------------------");
        System.out.println("Remove Forecast");
        wd.removeObserver(o3);
        wd.setMeasurements(27,65,80);
        System.out.println("------------------------------");
        wd.setMeasurements(28,75,90);
    }
}
