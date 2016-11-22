package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import util.BedType;

public class AvailableRoomNumberPO implements Serializable {
	/**
	 * 
	 * 
	 * 实现对某一天房间类型的修改
	 * 
	 * @author Cy
	 * @virsion 1.0
	 */

	private int number;// 房间数量
	private BedType bedType;// 床型
	private java.sql.Timestamp dateStamp;// 日期
	private int hotelNumber;// 酒店编号
	// private String hotelName;//酒店名字

	public AvailableRoomNumberPO() {

	}

	public AvailableRoomNumberPO(int number, BedType bedType, Date date, int hotelNumber) {
		this.setNumber(number);
		this.setBedType(bedType);
		this.setDate(date);
		this.setHotelNumber(hotelNumber);
		// this.hotelName=hotelName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public BedType getBedType() {
		return bedType;
	}

	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public Date getDate() {
		if (dateStamp == null) {
			return null;
		}
		return new Date(dateStamp.getTime());
	}

	public void setDate(Date date) {
		if (date != null)
			this.dateStamp = new java.sql.Timestamp(date.getTime());
	}

	public int getHotelNumber() {
		return hotelNumber;
	}

	public void setHotelNumber(int hotelNumber) {
		this.hotelNumber = hotelNumber;
	}

}
