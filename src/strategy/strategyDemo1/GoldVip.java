package strategy.strategyDemo1;

public class GoldVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice*0.7;
    }
}
