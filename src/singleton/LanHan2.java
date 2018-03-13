package singleton;

public class LanHan2 {

    private static LanHan2 singleton;

    private LanHan2(){

    }
    //缺点1、效率低，2、非线程安全，未使用volatile关键字
    public static synchronized LanHan2 getInstance(){
        if(singleton==null){
            singleton=new LanHan2();
        }
        return singleton;
    }
}
