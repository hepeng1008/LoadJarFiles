package observerpattern.observerpatthernDemo1.observable;


import observerpattern.observerpatthernDemo1.intf.Observer;

//被观察者
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
