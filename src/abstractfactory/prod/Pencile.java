package abstractfactory.prod;

import abstractfactory.intf.Writeable;

public class Pencile implements Writeable {
    @Override
    public void write(String label) {
        System.out.println("我是一支铅笔，我刚刚写了一句："+label+"。");
    }
}
