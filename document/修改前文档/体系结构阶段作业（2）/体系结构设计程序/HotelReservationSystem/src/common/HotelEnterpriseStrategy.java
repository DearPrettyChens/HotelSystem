package common;

import java.util.Map;

/**
 * 酒店企业特惠策略
 * @author CLL
 *
 */
public class HotelEnterpriseStrategy extends Strategy {
	private String hotelId;
	//前者为企业名称,后者为该企业对应的折扣值
	private Map<String,Double> discountPolicy;
	private HotelStrategyType type=HotelStrategyType.ENTERPRISE;
	
	public HotelEnterpriseStrategy(String hotelId,Map<String,Double> discountPolicy){
		this.hotelId=hotelId;
		this.setDiscountPolicy(discountPolicy);
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public Map<String,Double> getDiscountPolicy() {
		return discountPolicy;
	}

	public void setDiscountPolicy(Map<String,Double> discountPolicy) {
		this.discountPolicy = discountPolicy;
	}

	public HotelStrategyType getType() {
		return type;
	}

}
