package abstractfactory.factorys;

import abstractfactory.intf.Flyable;
import abstractfactory.intf.Movable;
import abstractfactory.intf.Writeable;

public abstract class AbstractFactory {

    public abstract Flyable createFlyable();

    public abstract Movable createMovable();

    public abstract Writeable createWriteable();
}
