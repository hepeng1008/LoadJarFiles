package strategy.strategyDemo2;

public class Orgnic implements CalPrice {

    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}
