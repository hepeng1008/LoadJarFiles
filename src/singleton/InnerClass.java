package singleton;

public class InnerClass {

    private InnerClass(){

    }

    private static class SingletonInstance{
        private static final InnerClass INSTANCE = new InnerClass();
    }

    public static InnerClass getSingleton(){
        return SingletonInstance.INSTANCE;
    }
}
