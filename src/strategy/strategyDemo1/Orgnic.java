package strategy.strategyDemo1;

public class Orgnic implements CalPrice {

    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}
