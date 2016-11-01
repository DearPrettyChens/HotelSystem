package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import util.HotelStrategyType;
/**
 * 传递所有的酒店营销策略
 * @author CLL
 * @version1.0
 */
public class HotelStrPO implements Serializable{
	private String hotelID;
	//数量策略的数量
	private int amount;
	//策略类型
    private HotelStrategyType type;
    //折扣值
    private double discount;
    //合作企业
    private ArrayList <String> enterprise;
    //优惠日期
    private Date[] date;
	
	public HotelStrPO(){
	}

	public HotelStrPO(String hotelID, int amount, double discount) {
		this.setHotelID(hotelID);
		this.setAmount(amount);
		this.setDiscount(discount);
		this.setType(HotelStrategyType.AMOUNT);
	}

	public HotelStrPO(String hotelID, double discount, ArrayList<String> enterprise) {
		this.setHotelID(hotelID);
		this.setDiscount(discount);
		this.setEnterprise(enterprise);
		this.setType(HotelStrategyType.ENTERPRISE);
	}

	public HotelStrPO(String hotelID, double discount, Date[] date) {
		this.setHotelID(hotelID);
		this.setDiscount(discount);
        this.setDate(date);
		this.setType(HotelStrategyType.ENTERPRISE);
	}
	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
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
		return date;
	}

	public void setDate(Date[] date) {
		this.date = date;
	}

}
