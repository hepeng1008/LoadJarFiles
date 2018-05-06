package decoratorpattern.demo2;

public class decoratorTest {

    public static void main(String[] args) {
        Roujiamo roujiamo = new Roujiamo();
        System.out.println(roujiamo.getDescription()+"价格为："+roujiamo.getPrice());
        System.out.println("增加配料");
        FireEgg fireEgg = new FireEgg(roujiamo);
        System.out.println(fireEgg.getDescription()+"价格为："+fireEgg.getPrice());
        System.out.println("增加配料");
        Fruit fruit = new Fruit(fireEgg);
        System.out.println(fruit.getDescription()+"价格为："+fruit.getPrice());

    }
}
