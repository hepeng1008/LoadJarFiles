package strategy.strategyDemo1;

public class Player {

    private Double totalAmound=0D;//客户在鹅厂消费的总额

    public Double getTotalAmound() {
        return totalAmound;
    }

    public void setTotalAmound(Double totalAmound) {
        this.totalAmound = totalAmound;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CalPrice getCalPrice() {
        return calPrice;
    }

    public void setCalPrice(CalPrice calPrice) {
        this.calPrice = calPrice;
    }

    private Double amount=0D; //客户单次消费金额
    private CalPrice calPrice = new Orgnic(); //每个客户
    //都有一个计算价格的策略，初始都是普通计算，即原价

    //客户购买皮肤，就会增加他的总额

    public void buy(Double amout){
        totalAmound+=amout;
        this.amount=amout;
        if(totalAmound>3000){
            calPrice = new GoldVip();
        }else if(totalAmound>2000){
            calPrice = new SuperVip();
        }else if(totalAmound>1000){
            calPrice = new Vip();
        }
    }

    public Double calLastAmount(){
        return calPrice.calPrice(amount);
    }

}
