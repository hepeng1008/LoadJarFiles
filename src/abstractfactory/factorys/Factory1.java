package abstractfactory.factorys;

import abstractfactory.intf.Flyable;
import abstractfactory.intf.Movable;
import abstractfactory.intf.Writeable;
import abstractfactory.prod.Aircraft;
import abstractfactory.prod.Car;
import abstractfactory.prod.Pen;

public class Factory1 extends AbstractFactory {
    @Override
    public Flyable createFlyable() {
        return new Aircraft();
    }

    @Override
    public Movable createMovable() {
        return new Car();
    }

    @Override
    public Writeable createWriteable() {
        return new Pen();
    }
}
