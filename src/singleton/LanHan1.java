package singleton;

//多线程下会出现问题
public class LanHan1 {

    private static LanHan1 singleton;

    private LanHan1(){

    }

    public static LanHan1 getInstance(){
        if(singleton==null)
            singleton=new LanHan1();
        return singleton;
    }
}
