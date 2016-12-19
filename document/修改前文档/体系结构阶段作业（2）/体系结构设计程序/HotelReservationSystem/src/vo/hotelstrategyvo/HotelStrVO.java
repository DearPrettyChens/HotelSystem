package vo.hotelstrategyvo;

import java.util.ArrayList;

import common.HotelStrategyType;
import common.Strategy;


public class HotelStrVO {
	/**
	 * hotelStr：
	 *   包含四中折扣信息
	 *   @author Cy
	 *   @virsion 1.0
	 *   
        
	 */
	private ArrayList<Strategy> strategy;
	

	public HotelStrVO(){
		
	}
	
	public  HotelStrVO(ArrayList<Strategy> strategy){
		
		this.strategy=strategy;
		
		
	}
	public ArrayList<Strategy> getStrategy() {
		return strategy;
	}

	public void setStrategy(ArrayList<Strategy> strategy) {
		this.strategy = strategy;
	}
	
	
	
	
	
	
}