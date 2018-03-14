package observerpattern.observerpatthernDemo1;


//被观察者
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
