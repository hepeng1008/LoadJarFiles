package factorypattern.factorydemo1.simple;

import factorypattern.factorydemo1.prod.Broom;
import factorypattern.factorydemo1.prod.Plane;

public class SimpleFactory {

    public Object Create(Class<?> clazz){
        if(clazz.getName().equals(Broom.class.getName())){
            return createBroom();
        }else if(clazz.getName().equals(Plane.class.getName())){
            return createPlane();
        }
        return null;
    }

    private Broom createBroom(){
        return new Broom();
    }

    private Plane createPlane(){
        return new Plane();
    }
}
