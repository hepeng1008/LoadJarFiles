package strategy.strategyDemo1;

public class SuperVip implements CalPrice{
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice*0.8;
    }
}

