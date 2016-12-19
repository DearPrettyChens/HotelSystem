package vo.hotelstrategyvo;

import common.HotelStrategyType;
import common.Strategy;

public class HotelBestStrVO {
	
	/**
	 * 酒店最低折扣
	 * @author Cy
	 * @virsion 1.0
	 */
	private Strategy strategy;
	public HotelBestStrVO(){
		
	}
	
    public HotelBestStrVO(Strategy strategy){
    	this.strategy=strategy;
    	
		
	}
    public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	
}
	