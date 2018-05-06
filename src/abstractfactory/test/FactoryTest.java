package abstractfactory.test;

import abstractfactory.factorys.AbstractFactory;
import abstractfactory.factorys.Factory1;
import abstractfactory.intf.Flyable;
import abstractfactory.intf.Movable;
import abstractfactory.intf.Writeable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FactoryTest {

    public static void main(String[] args) {
        AbstractFactory factory = new Factory1();
        Flyable flyable = factory.createFlyable();
        flyable.fly(1589);


        Movable movable = factory.createMovable();
        movable.run(100);

        Writeable writeable = factory.createWriteable();
        writeable.write("Hello world!");

    }
}
