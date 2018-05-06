package testpackage.mapdemo;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(){
            @Override
            public void run() {
                for(int i =0;i<100;i++) {
                    try {
                        Thread.sleep(100);
                        if(i==20)
                            synchronized (this){
                                wait();
                            }
                        System.out.println("hello child:"+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        for(int i =0;i<100;i++){
            try {
                Thread.sleep(100);
                System.out.println("hello:"+i);
                if(i==50){
                    synchronized (t){
                        t.notify();
                    }
                    t.join();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
