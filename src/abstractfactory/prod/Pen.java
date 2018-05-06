package abstractfactory.prod;

import abstractfactory.intf.Writeable;

public class Pen implements Writeable {
    @Override
    public void write(String label) {
        System.out.println("我是一支钢笔，我刚刚写下了一句："+label+"。");
    }
}
