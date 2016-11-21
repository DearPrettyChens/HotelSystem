package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import util.HotelStrategyType;

/**
 * 传递所有的酒店营销策略
 * 
 * @author CLL @version1.0
 */
public class HotelStrPO implements Serializable {
	private int hotelID;
	// 数量策略的数量
	private int amount;
	// 策略类型
	private HotelStrategyType type;
	// 折扣值
	private double discount;
	// 合作企业
	private ArrayList<String> enterprise;
	// 优惠日期
	private java.sql.Date[] dateStamps;

	public HotelStrPO() {
	}

	public HotelStrPO(int hotelID, int amount, HotelStrategyType type, double discount, ArrayList<String> enterprise,
			Date[] date) {
		this.hotelID = hotelID;
		this.amount = amount;
		this.type = type;
		this.discount = discount;
		this.enterprise = enterprise;
		this.setDate(date);
		;
	}

	public HotelStrPO(int hotelID, int amount, double discount) {
		this.setHotelID(hotelID);
		this.setAmount(amount);
		this.setDiscount(discount);
		this.setType(HotelStrategyType.AMOUNT);
	}

	public HotelStrPO(int hotelID, double discount, ArrayList<String> enterprise) {
		this.setHotelID(hotelID);
		this.setDiscount(discount);
		this.setEnterprise(enterprise);
		this.setType(HotelStrategyType.ENTERPRISE);
	}

	public HotelStrPO(int hotelID, double discount, Date[] date) {
		this.setHotelID(hotelID);
		this.setDiscount(discount);
		this.setDate(date);
		this.setType(HotelStrategyType.ENTERPRISE);
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public ArrayList<String> getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(ArrayList<String> enterprise) {
		this.enterprise = enterprise;
	}

	public Date[] getDate() {
		if (dateStamps == null)
			return null;
		Date[] dates = new Date[dateStamps.length];
		for (int i = 0; i < dates.length; i++) {
			dates[i] = new Date(dateStamps[i].getTime());
		}
		return dates;
	}

	public void setDate(Date[] date) {
		if (date != null) {
			dateStamps = new java.sql.Date[date.length];
			for (int i = 0; i < dateStamps.length; i++) {
				dateStamps[i] = new java.sql.Date(date[i].getTime());
			}
		}
	}

}
