package singleton;

//可用
public class Ehan2 {

    private static Ehan2 instance=null;
    static{
        instance = new Ehan2();
    }

    private Ehan2(){

    }

    public static Ehan2 getInstance(){
        return instance;
    }
}
