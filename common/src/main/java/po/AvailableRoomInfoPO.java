package po;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import util.BedType;

@Entity
@Table(name = "t_availableroom")
public class AvailableRoomInfoPO implements Serializable {

	/**
	 * 当前可用客房信息（AvailableroomPO) 房型、床型、各房型总数量、可用客房数量、原始价格、最低价格、酒店编号
	 * 
	 * @author Cy
	 * @virsion 1.0
	 */
	@Id
	@Column(name = "pri_key")
	private int primaryKey;
	@Column(name = "hotel_id")
	private int hotelNumber;// 酒店编号
	@Column(name = "room_type")
	private String roomType;// 房型
	@Column(name = "bed_type")
	private String bedType;// 床型
	@Column(name = "original_price")
	private double originalPrice;// 原始价格
	@Column(name = "lowest_price")
	private double lowestPrice;// 最低价格
	@Column(name = "original_number")
	private int originalNumber;// 各房型总数量
	@Column(name = "current_number")
	private int currentNumber;// 当前数量
	@Column(name = "date")
	private int dateFromNow;
	@Version
	@Column(name= "version")
	private int version;

	public AvailableRoomInfoPO() {

	}

	public AvailableRoomInfoPO(int hotelNumber, String roomType, BedType bedType, double originalPrice,
			double lowestPrice, int originalNumber, int currentNumber) {
		this.setHotelNumber(hotelNumber);
		this.setRoomType(roomType);
		this.setBedType(bedType);
		this.setOriginalPrice(originalPrice);
		this.setLowestPrice(lowestPrice);
		this.setOriginalNumbers(originalNumber);
		this.setCurrentNumber(currentNumber);
	}

	public int getHotelNumber() {
		return hotelNumber;
	}

	public void setHotelNumber(int hotelNumber) {
		this.hotelNumber = hotelNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public BedType getBedType() {
		BedType type = null;
		switch (bedType) {
		case "BIGBED":
			type = BedType.BIGBED;
			break;
		case "FAMILYBED":
			type = BedType.FAMILYBED;
			break;
		case "FOURBEDS":
			type = BedType.FOURBEDS;
			break;
		case "THREEBEDS":
			type = BedType.THREEBEDS;
			break;
		case "TWOBEDS":
			type = BedType.TWOBEDS;
			break;
		default:
			break;
		}
		return type;
	}

	public void setBedType(BedType bedType) {
		if (bedType != null)
			this.bedType = bedType.getString();
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public int getOriginalNumbers() {
		return originalNumber;
	}

	public void setOriginalNumbers(int originalNumber) {
		this.originalNumber = originalNumber;
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	public AvailableRoomInfoPO copy() {
		return new AvailableRoomInfoPO(getHotelNumber(), getRoomType(), getBedType(), getOriginalPrice(),
				getLowestPrice(), getOriginalNumbers(), getCurrentNumber());
	}

	public int getDateFromNow() {
		return dateFromNow;
	}

	public void setDateFromNow(int dateFromNow) {
		this.dateFromNow = dateFromNow;
	}

	public int getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}

}
