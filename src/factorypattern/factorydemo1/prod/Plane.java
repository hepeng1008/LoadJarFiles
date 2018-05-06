package factorypattern.factorydemo1.prod;

import factorypattern.factorydemo1.intf.Movable;

public class Plane implements Movable {
    @Override
    public void run() {
        System.out.println("我是飞机");
    }
}
