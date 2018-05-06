package factorypattern.factorydemo1.test;

import factorypattern.factorydemo1.factorys.PlaneFactory;
import factorypattern.factorydemo1.intf.Movable;
import factorypattern.factorydemo1.prod.Broom;
import factorypattern.factorydemo1.simple.SimpleFactory;

public class FactoryTest {

    public static void main(String[] args) {
        //简单工厂模式测试
        SimpleFactory simpleFactory = new SimpleFactory();
        Broom broom = (Broom)simpleFactory.Create(Broom.class);
        broom.run();


        //工厂方法测试
        PlaneFactory planeFactory = new PlaneFactory();
        Movable movable = planeFactory.create();
        movable.run();
    }
}
