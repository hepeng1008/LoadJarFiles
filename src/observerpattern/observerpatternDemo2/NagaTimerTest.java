package observerpattern.observerpatternDemo2;

import observerpattern.observerpatternDemo2.observable.NagaTimer;
import observerpattern.observerpatternDemo2.observer.CountDownTimer;

import java.util.Timer;
import java.util.TimerTask;

public class NagaTimerTest {
    NagaTimer nagaTimer = new NagaTimer();

    public static void main(String[] args) {
        NagaTimerTest test = new NagaTimerTest();
        test.startTimerThread();
    }

    private void startTimerThread() {
        CountDownTimer countDownTimerA = new CountDownTimer("计时器A", 6 * 1000);
        CountDownTimer countDownTimerB = new CountDownTimer("计时器B", 5 * 1000);
        CountDownTimer countDownTimerC = new CountDownTimer("计时器C", 10 * 1000);
        nagaTimer.registerObserver(countDownTimerA);
        nagaTimer.registerObserver(countDownTimerB);
        nagaTimer.registerObserver(countDownTimerC);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                nagaTimer.setMeasurements(System.currentTimeMillis());
            }
        };

        timer.schedule(task, 0, 1000);
    }
}
