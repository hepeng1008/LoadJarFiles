package testpackage.semarphoretest;

import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;

class Producer implements Runnable{

    Semaphore empty;
    Semaphore full;
    Semaphore mutex;
    PriorityQueue<Integer> resources;
    int count =0;

    public Producer(Semaphore empty, Semaphore full, Semaphore mutex, PriorityQueue<Integer> resources) {
        this.empty = empty;
        this.full = full;
        this.mutex = mutex;
        this.resources = resources;
    }

    public Producer(Semaphore empty, Semaphore full, Semaphore mutex) {
        this.empty = empty;
        this.full = full;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        while(true){
            try {
                empty.acquire();
                mutex.acquire();
                int id=(count++)%10+1;
                resources.add(id);
                System.out.println("生产者生产"+(id)+"件商品");
                Thread.sleep(10);
                mutex.release();
                full.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Comsuer implements  Runnable{
    Semaphore empty;
    Semaphore full;
    Semaphore mutex;
    PriorityQueue<Integer> resources;

    public Comsuer(Semaphore empty, Semaphore full, Semaphore mutex, PriorityQueue<Integer> resources) {
        this.empty = empty;
        this.full = full;
        this.mutex = mutex;
        this.resources = resources;
    }

    @Override
    public void run() {
        while(true){
            try {
                full.acquire();
                mutex.acquire();
                System.out.println("消费第"+resources.poll()+"件商品");
                Thread.sleep(1000);
                mutex.release();
                empty.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore empty= new Semaphore(10);
        Semaphore full = new Semaphore(0);
        Semaphore mutex = new Semaphore(1);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Producer producer = new Producer(empty,full,mutex,queue);
        new Thread(producer).start();

        for(int i=0;i<100;i++){
            new Thread(new Comsuer(empty,full,mutex,queue)).start();
        }
    }
}
