package common;
/**
 * 酒店生日特惠策略类
 * @author CLL
 *
 */
public class HotelBirthStrategy extends Strategy{
	private double discount;
	private String hotelId;
	private HotelStrategyType type=HotelStrategyType.BIRTH;
	
	public HotelBirthStrategy(String hotelId,double discount){
		this.hotelId=hotelId;
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

	public HotelStrategyType getType() {
		return type;
	}


}
