package abstractfactory.prod;

import abstractfactory.intf.Flyable;

public class Fighter implements Flyable {
    @Override
    public void fly(int height) {
        System.out.println("我是一架战斗机，我目前的飞行高度为："+height+"千米");
    }
}
