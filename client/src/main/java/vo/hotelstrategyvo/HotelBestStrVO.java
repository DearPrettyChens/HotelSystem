package vo.hotelstrategyvo;

import util.HotelStrategyType;

public class HotelBestStrVO {

	/** 
	 * 酒店最低折扣
	 * 
	 * @author Cy
	 * @virsion 1.0
	 */
	//酒店编号
	private String hotelID;
	//策略类型
	private HotelStrategyType type;
	//折扣值
	private double discount;

	public HotelBestStrVO() {

	}

	public HotelBestStrVO(HotelStrategyType type) {
		this.type = type;

	}

	public HotelStrategyType getType() {
		return type;
	}

	public void setType(HotelStrategyType type) {
		this.type = type;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

}
