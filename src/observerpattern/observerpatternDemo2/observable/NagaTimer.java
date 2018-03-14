package observerpattern.observerpatternDemo2.observable;

import observerpattern.observerpatternDemo2.intf.TimeSubject;
import observerpattern.observerpatternDemo2.intf.TimerObserver;
import observerpattern.observerpatternDemo2.observer.CountDownTimer;

import java.util.ArrayList;

public class NagaTimer implements TimeSubject{

    private long mCurrentStamp=0L;

    private ArrayList<TimerObserver> list = new ArrayList<>();
    @Override
    public void registerObserver(TimerObserver observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(TimerObserver observer) {
            list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        if(list.size()==0){
            return;
        }
        for(int i=0;i<list.size();i++){
            CountDownTimer observer =(CountDownTimer)list.get(i);
            if(observer.isDone()){
                removeObserver(observer);
            }else{
                observer.update(mCurrentStamp);
            }
        }
    }


    private void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(long currentStamp){
        mCurrentStamp=currentStamp;
        measurementsChanged();
    }
}
