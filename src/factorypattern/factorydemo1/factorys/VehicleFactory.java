package factorypattern.factorydemo1.factorys;

import factorypattern.factorydemo1.intf.Movable;

public abstract class VehicleFactory {
    public abstract Movable create();
}
