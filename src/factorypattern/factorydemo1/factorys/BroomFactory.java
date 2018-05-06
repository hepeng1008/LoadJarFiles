package factorypattern.factorydemo1.factorys;

import factorypattern.factorydemo1.intf.Movable;
import factorypattern.factorydemo1.prod.Broom;

public class BroomFactory extends VehicleFactory {
    @Override
    public Movable create() {
        return new Broom();
    }
}
