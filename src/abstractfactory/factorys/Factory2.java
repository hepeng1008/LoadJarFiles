package abstractfactory.factorys;

import abstractfactory.intf.Flyable;
import abstractfactory.intf.Movable;
import abstractfactory.intf.Writeable;
import abstractfactory.prod.*;

public class Factory2 extends AbstractFactory {
    @Override
    public Flyable createFlyable() {
        return new Fighter();
    }

    @Override
    public Movable createMovable() {
        return new Bus();
    }

    @Override
    public Writeable createWriteable() {
        return new Pencile();
    }
}
