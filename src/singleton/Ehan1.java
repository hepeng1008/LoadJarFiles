package singleton;

//可用
public class Ehan1 {

    private final static Ehan1 instance = new Ehan1();

    private Ehan1(){

    }

    public static Ehan1 getInstance(){
        return instance;
    }
}
