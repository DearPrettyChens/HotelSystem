package po;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import util.BedType;

@Entity
@Table(name = "t_availableroom")
public class AvailableRoomNumberPO implements Serializable {
	/**
	 * 
	 * 
	 * 实现对某一天房间类型的修改
	 * 
	 * @author Cy
	 * @virsion 1.0
	 */
	@Id
	@Column(name = "pri_key")
	private int pri_key;
	@Column(name = "current_number")
	private int number;// 房间数量
	@Column(name = "bed_type")
	private String bedType;// 床型
	@Column(name = "date")
	private int dateFromNow;// 日期
	@Column(name = "hotel_id")
	private int hotelNumber;// 酒店编号
	// private String hotelName;//酒店名字

	public AvailableRoomNumberPO() {

	}

	public AvailableRoomNumberPO(int number, BedType bedType, Date date, int hotelNumber)  {
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

	public Date getDate() {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, dateFromNow);
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String string = sdf.format(date);
		// date=sdf.parse(string);
		return calendar.getTime();
	}

	public void setDate(Date date) {
		if (date != null) {
			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String string1 = sdf.format(today);
			String string2 = sdf.format(date);
			long a=0, b=0;
			try {
				a = sdf.parse(string1).getTime();
				b = sdf.parse(string2).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			this.dateFromNow = (int) ((b - a) / (60 * 60 * 12));
		}
	}

	public int getHotelNumber() {
		return hotelNumber;
	}

	public void setHotelNumber(int hotelNumber) {
		this.hotelNumber = hotelNumber;
	}

	public AvailableRoomNumberPO copy() throws ParseException {
		return new AvailableRoomNumberPO(getNumber(), getBedType(), getDate(), getHotelNumber());
	}

	public int getDateFromNow() {
		return dateFromNow;
	}

	public void setDateFromNow(int dateFromNow) {
		this.dateFromNow = dateFromNow;
	}
}
