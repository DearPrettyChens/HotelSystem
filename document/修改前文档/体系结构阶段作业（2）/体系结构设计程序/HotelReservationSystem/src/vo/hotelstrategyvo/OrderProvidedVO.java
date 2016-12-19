package vo.hotelstrategyvo;

import common.HotelStrategyType;
import common.Strategy;

public class OrderProvidedVO {
	
	/**
	 * 订单显示最低折扣
	 * @author Cy
	 * @virsion 1.0
	 */
	private Strategy strategy;
	public OrderProvidedVO (){
		
	}
	
    public OrderProvidedVO(Strategy strategy){
    	this.strategy=strategy;
    	
		
	}
    public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	
}
	