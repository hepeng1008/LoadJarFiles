package abstractfactory.prod;

import abstractfactory.intf.Movable;

public class Car implements Movable{
    @Override
    public void run(double speed) {
        System.out.println("我是一辆小汽车，我目前的时速是："+speed+"/小时");
    }
}
