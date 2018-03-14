package strategy.strategyDemo3;

import strategy.strategyDemo3.CalPrice;
import strategy.strategyDemo3.PriceRegion;

@PriceRegion(max = 2000,min = 1000)
public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice*0.9;
    }
}
