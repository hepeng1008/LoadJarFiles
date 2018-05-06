package decoratorpattern.demo2;

public class Fruit extends Condiment {

    private Pancake pancake;

    @Override
    public double getPrice() {
        return pancake.getPrice()+5;
    }

    @Override
    public String getDescription() {
        return pancake.getDescription()+",蔬菜";
    }

    public Fruit(Pancake pancake){
        this.pancake=pancake;
    }
}
