package strategy.strategyDemo2;

public class Client {

    public static void main(String[] args) {
        Player player = new Player();
        player.buy(1000D);
        System.out.println("玩家需要付钱："+player.calLastAmount());
        player = new Player();
        player.buy(2000D);
        System.out.println("玩家需要付钱："+player.calLastAmount());
        player = new Player();
        player.buy(3000D);
        System.out.println("玩家需要付钱："+player.calLastAmount());
        player = new Player();
        player.buy(5000D);
        System.out.println("玩家需要付钱："+player.calLastAmount());
    }
}
