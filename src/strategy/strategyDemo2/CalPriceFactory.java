package strategy.strategyDemo2;

public class CalPriceFactory {
    private CalPriceFactory(){}

    public static CalPrice createCalPrice(Player customer){
        if(customer.getTotalAmound()>3000){
            return new GoldVip();
        }else if(customer.getTotalAmound()>2000){
            return new SuperVip();
        }else if(customer.getTotalAmound()>1000){
            return new Vip();
        }else{
            return new Orgnic();
        }
    }
}
