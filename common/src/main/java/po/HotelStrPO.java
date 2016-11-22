package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import util.HotelStrategyType;

/**
 * 传递所有的酒店营销策略
 * 
 * @author CLL @version1.0
 */
@Entity
@Table(name = "hotel_strategy")
public class HotelStrPO implements Serializable {
	@Id
	@Column(name = "str_id")
	private int strid;
	@Column(name = "hotel_id")
	private int hotelID;
	// 数量策略的数量
	@Column(name = "amount")
	private int amount;
	// 策略类型
	@Column(name = "type")
	private String typeInSQL;
	// @Transient
	// private HotelStrategyType type;
	// 折扣值
	@Column(name = "discount")
	private double discount;
	// 合作企业
	@Column(name = "enterprise")
	private String enterpriseInSQL;
	// @Transient
	// private ArrayList<String> enterprise;
	// 优惠日期
	@Column(name = "begin_date")
	private java.sql.Date beginDate;
	@Column(name = "end_date")
	private java.sql.Date endDate;
	// @Transient
	// private java.sql.Date[] dateStamps;

	public HotelStrPO() {
	}

	public HotelStrPO(int hotelID, int amount, HotelStrategyType type, double discount, ArrayList<String> enterprise,
			Date[] date) {
		this.setHotelID(hotelID);
		this.setAmount(amount);
		this.setType(type);
		this.setDiscount(discount);
		this.setEnterprise(enterprise);
		this.setDate(date);
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
		if (typeInSQL == null) {
			return null;
		}
		HotelStrategyType type = null;
		switch (typeInSQL) {
		case "SPECIALTIME":
			type = HotelStrategyType.SPECIALTIME;
			break;
		case "BIRTH":
			type = HotelStrategyType.BIRTH;
			break;
		case "ENTERPRISE":
			type = HotelStrategyType.ENTERPRISE;
			break;
		case "AMOUNT":
			type = HotelStrategyType.AMOUNT;
			break;
		default:
			break;
		}
		return type;
	}

	public void setType(HotelStrategyType type) {
		if (type != null)
			this.typeInSQL = type.getString();
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public ArrayList<String> getEnterprise() {
		if (enterpriseInSQL == null)
			return null;
		String[] strings = enterpriseInSQL.split(" ");
		ArrayList<String> ret = new ArrayList<String>();
		for (String each : strings) {
			ret.add(each);
		}
		return ret;
	}

	public void setEnterprise(ArrayList<String> enterprise) {
		this.enterpriseInSQL = "";
		if (enterprise != null) {
			for (String each : enterprise) {
				enterpriseInSQL += each;
				if (enterprise.get(enterprise.size() - 1) != each) {
					enterpriseInSQL += " ";
				}
			}
		}
	}

	public Date[] getDate() {
		if (beginDate != null && endDate != null) {
			Date[] dates = new Date[2];
			dates[0] = new Date(beginDate.getTime());
			dates[1] = new Date(endDate.getTime());
			return dates;
		} else {
			return null;
		}
	}

	public void setDate(Date[] date) {
		if (date != null && date.length == 2) {
			beginDate = new java.sql.Date(date[0].getTime());
			endDate = new java.sql.Date(date[1].getTime());
		}
	}

	public HotelStrPO copy() {
		return new HotelStrPO(getHotelID(), getAmount(), getType(), getDiscount(), getEnterprise(), getDate());
		
	}
}
