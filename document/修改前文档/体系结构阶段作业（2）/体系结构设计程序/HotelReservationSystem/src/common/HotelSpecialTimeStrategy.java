package common;

import java.util.Date;
import java.util.Map;

/**
 * 酒店特定时期特惠策略类
 * @author CLL
 *
 */
public class HotelSpecialTimeStrategy extends Strategy {
	private String hotelId;
	//前者为特定日期，后者为当天对应的折扣值
	private Map<Date,Double> discountPolicy;

	private HotelStrategyType type=HotelStrategyType.SPECIALTIME;
	
	public HotelSpecialTimeStrategy(String hotelId,Map<Date,Double> discountPolicy){
		this.hotelId=hotelId;
		this.discountPolicy=discountPolicy;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public Map<Date,Double> getDiscountPolicy() {
		return discountPolicy;
	}

	public void setDiscountPolicy(Map<Date,Double> discountPolicy) {
		this.discountPolicy = discountPolicy;
	}

	public HotelStrategyType getType() {
		return type;
	}

}
