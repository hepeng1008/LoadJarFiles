package abstractfactory.prod;

import abstractfactory.intf.Movable;

public class Bus implements Movable{
    @Override
    public void run(double speed) {
        System.out.println("我是一辆公共汽车，我目前的速度是："+speed+"/小时");
    }
}
