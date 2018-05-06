package decoratorpattern.demo2;

public class Humberg extends Pancake {

    private double price=20;

    @Override
    public double getPrice() {
        return price;
    }

    Humberg(){
        description="汉堡包";
    }
}
