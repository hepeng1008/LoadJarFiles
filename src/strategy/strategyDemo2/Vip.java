package strategy.strategyDemo2;

public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice*0.9;
    }
}
