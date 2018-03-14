package singleton;

public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton(){}

   public static DoubleCheckSingleton getSingleton(){
        if(singleton==null){
            synchronized (DoubleCheckSingleton.class){

                if(singleton==null)
                    singleton=new DoubleCheckSingleton();
            }
        }
        return singleton;
   }
}
