package factorypattern.factorydemo1.factorys;

import factorypattern.factorydemo1.intf.Movable;
import factorypattern.factorydemo1.prod.Plane;

public class PlaneFactory extends VehicleFactory{
    @Override
    public Movable create() {
        return new Plane();
    }
}
