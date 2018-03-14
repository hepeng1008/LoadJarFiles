package observerpattern.observerpatternDemo2.intf;

import observerpattern.observerpatternDemo2.observer.CountDownTimer;

public interface TimeSubject {

    public void registerObserver(TimerObserver observer);

    public void removeObserver(TimerObserver observer);

    public void notifyObserver();
}
