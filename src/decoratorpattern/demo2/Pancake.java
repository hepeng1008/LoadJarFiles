package decoratorpattern.demo2;

public abstract class Pancake{

    /**
     * 抽象类不能直接实例化，只能继承

     * private 成员无法被继承

     * 所以抽象类的 private 成员无意义

     * 既不能被抽象类自己使用，也不能被子类使用
     */
    String description="我不是一个具体的煎饼";
    public abstract  double getPrice();

    public String getDescription(){
        return description;
    }


}
