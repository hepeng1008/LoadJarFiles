package strategy.strategyDemo3;


import strategy.strategyDemo3.CalPrice;
import strategy.strategyDemo3.PriceRegion;

@PriceRegion(max = 3000,min = 2000)
public class SuperVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice*0.8;
    }
}
