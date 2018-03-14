package strategy.strategyDemo3;

import strategy.strategyDemo3.CalPrice;
import strategy.strategyDemo3.PriceRegion;

@PriceRegion(max=Integer.MAX_VALUE,min = 3000)
public class GoldVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice*0.7;
    }
}
