package testpackage.mapdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Chopsticks {
    public static List<Boolean> chops = new ArrayList<Boolean>();
    static {
        chops.add(false); //为了方便计算，第一个不会参与计算
        chops.add(false);
        chops.add(false);
        chops.add(false);
        chops.add(false);
    }


    public synchronized void getChop() {
        String currentName = Thread.currentThread().getName();
        int index = Integer.parseInt(currentName);
        while (chops.get(index) || chops.get((index + 1)%5)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chops.set(index, true);
        chops.set((index + 1)%5 ,true);
    }


    public synchronized void freeChop() {
        String currentName = Thread.currentThread().getName();
        int index = Integer.parseInt(currentName);
        chops.set(index, false);
        chops.set((index + 1)%5 ,false);
        notifyAll();
    }
}


class PhilosopherThread extends Thread {
    private String name; //线程名称，给哲学家编序号用
    private Chopsticks chopsticks;


    public PhilosopherThread (String name, Chopsticks chopsticks) {
        super(name);
        this.name = name;
        this.chopsticks = chopsticks;
    }


    @Override
    public void run() {
        while (true) {
            chopsticks.getChop();
            System.out.println(Chopsticks.chops);
            System.out.println("Philosopher"+Integer.parseInt(name)+"eating");
            this.eat();
            chopsticks.freeChop();
        }
    }


    public void eat() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class PhilosopherTest {
    public static void main(String[] args) {
        Chopsticks chopsticks = new Chopsticks();
        PhilosopherThread philosopherThread1 = new PhilosopherThread("0", chopsticks);
        PhilosopherThread philosopherThread2 = new PhilosopherThread("1", chopsticks);
        PhilosopherThread philosopherThread3 = new PhilosopherThread("2", chopsticks);
        PhilosopherThread philosopherThread4 = new PhilosopherThread("3", chopsticks);
        PhilosopherThread philosopherThread5 = new PhilosopherThread("4", chopsticks);
        System.out.println("hello world!");

        philosopherThread1.start();
        philosopherThread2.start();
        philosopherThread3.start();
        philosopherThread4.start();
        philosopherThread5.start();
        Semaphore semaphore = new Semaphore(5);
        semaphore.release();
    }
}