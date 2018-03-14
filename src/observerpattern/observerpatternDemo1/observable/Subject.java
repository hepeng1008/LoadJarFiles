package observerpattern.observerpatternDemo1.observable;


import observerpattern.observerpatternDemo1.intf.Observer;

//被观察者
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();
}
