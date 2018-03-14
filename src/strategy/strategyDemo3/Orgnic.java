package strategy.strategyDemo3;

import strategy.strategyDemo3.CalPrice;
import strategy.strategyDemo3.PriceRegion;

@PriceRegion(max = 1000,min = 0)
public class Orgnic implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}
