package factorypattern.factorydemo1.prod;

import factorypattern.factorydemo1.intf.Movable;

public class Broom implements Movable {
    @Override
    public void run() {
        System.out.println("我是broom");
    }
}
