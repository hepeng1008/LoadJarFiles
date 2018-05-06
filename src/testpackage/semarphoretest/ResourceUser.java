package testpackage.semarphoretest;


import java.util.Random;
import java.util.concurrent.Semaphore;

class ResourceManage{
    static Semaphore toilets = new Semaphore(10);
    static volatile boolean[] toiletpos = new boolean[10];
    static Semaphore mutex=new Semaphore(1);
    static{
        for(int i=0;i<10;i++)
            toiletpos[i]=false;
    }


    public static int getToiletid(){
        int pos=0;
        try {
            toilets.acquire();
            mutex.acquire();
            for(int i=0;i<10;i++){
                if(toiletpos[i]==false){
                    toiletpos[i]=true;
                    pos=i;
                    break;
                }
            }
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return pos;
    }

    public static void releasePos(int id){
        try {
            mutex.acquire();
            toiletpos[id]=false;
            mutex.release();
            toilets.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

public class ResourceUser implements  Runnable{

    int number;

    public ResourceUser(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(new ResourceUser(i+1)).start();
        }
    }

    @Override
    public void run() {
        int id=ResourceManage.getToiletid();
        System.out.println(number+"用户正在使用"+(id+1)+"号位厕所");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResourceManage.releasePos(id);
        System.out.println(number+"用户释放"+(id+1)+"号位厕所");
    }
}
