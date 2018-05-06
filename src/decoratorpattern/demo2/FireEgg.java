package decoratorpattern.demo2;

public class FireEgg extends Condiment {

    private Pancake pancake;
    @Override
    public double getPrice() {
        return pancake.getPrice()+2;
    }

    @Override
    public String getDescription() {
        return pancake.getDescription()+",煎蛋";
    }

    public FireEgg(Pancake pancake){
        this.pancake=pancake;
    }
}
