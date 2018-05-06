package decoratorpattern.demo2;

public class Roujiamo extends Pancake {

    private double price=10;

    Roujiamo(){
        description="肉夹馍";
    }

    @Override
    public double getPrice() {
        return price;
    }
}
