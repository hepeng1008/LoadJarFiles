package observerpattern.observerpatternDemo2.observer;

import observerpattern.observerpatternDemo2.intf.TimerDisplay;
import observerpattern.observerpatternDemo2.intf.TimerObserver;

public class CountDownTimer implements TimerDisplay,TimerObserver {

    private String mName;

    private long mStartStamp;

    private long mCountDownStamp;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public CountDownTimer(String mName, long mCountDownStamp) {
        this.mName = mName;
        this.mCountDownStamp = mCountDownStamp;
        this.mStartStamp=System.currentTimeMillis();
    }

    public long getmStartStamp() {
        return mStartStamp;
    }

    public void setmStartStamp(long mStartStamp) {
        this.mStartStamp = mStartStamp;
    }

    public long getmCountDownStamp() {
        return mCountDownStamp;
    }

    public void setmCountDownStamp(long mCountDownStamp) {
        this.mCountDownStamp = mCountDownStamp;
    }

    public long getmCurrentStamp() {
        return mCurrentStamp;
    }

    public void setmCurrentStamp(long mCurrentStamp) {
        this.mCurrentStamp = mCurrentStamp;
    }

    private long mCurrentStamp=0L;

    @Override
    public void display() {
        if(mCountDownStamp-mStartStamp<=mCountDownStamp){
            System.out.println(getmName()+"还剩"+((mCountDownStamp-(mCurrentStamp-mStartStamp))/1000)+"s");
        }
    }

    @Override
    public void update(long stamp) {
        mCurrentStamp=stamp;
        display();
    }


    public boolean isDone(){
        if(mCurrentStamp-mStartStamp>=mCountDownStamp)
            return true;
        return false;
    }
}
