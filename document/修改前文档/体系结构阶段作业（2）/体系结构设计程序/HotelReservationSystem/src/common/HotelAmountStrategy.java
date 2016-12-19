package common;
/**
 * 酒店数量特惠策略类
 * @author CLL
 *
 */
public class HotelAmountStrategy extends Strategy {
	private double discount;
	private String hotelId;
	private String preferNum;
	private HotelStrategyType type=HotelStrategyType.AMOUNT;
	
	public HotelAmountStrategy(String hotelId,String preferNum,double discount){
		this.hotelId=hotelId;
		this.preferNum=preferNum;
		this.discount=discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getPreferNum() {
		return preferNum;
	}

	public void setPreferNum(String preferNum) {
		this.preferNum = preferNum;
	}

	public HotelStrategyType getType() {
		return type;
	}

}
