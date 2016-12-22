package po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import util.BedType;

@Entity
@Table(name = "checkin")
public class CheckinInfoPO implements Serializable {
	/**
	 * 记录酒店入住信息: 1）用户真实姓名 2）身份证号（数字） 3）联系方式（11位手机号） 4）房间号（数字） 5）房间类型
	 * 6）实际入住时间（-年-月-日-时-分） 7）实际退房时间（-年-月-日-时-分） 8）酒店编号 9）订单号
	 * 
	 * @author Cy
	 * @virSion 1.0
	 * 
	 * 
	 */
	@Column(name = "user_real_name")
	private String name;// 用户真实姓名
	@Column(name = "user_id")
	private String ID;// 身份证号（数字
	@Column(name = "user_telephone")
	private String tel;// 联系方式（11位手机号）
	@Column(name = "bed_type")
	private String bedtypeInSQL;
	@Transient
	private BedType bedtype;// 床类型
	@Column(name = "room_type")
	private String roomtype;
	@Column(name = "room_number")
	private String roomnumber;// 房间号（数字
	@Column(name = "checkin_time")
	private java.sql.Timestamp checkintimeStamp;// 实际入住时间（-年-月-日-时-分）
	@Column(name = "checkout_time")
	private java.sql.Timestamp checkouttimeStamp;// 实际退房时间（-年-月-日-时-分)
	@Column(name = "hotel_id")
	private int hotelnumber;// 酒店编号
	@Id
	@Column(name = "order_id")
	private String ordernumber;// 订单号
	@Version
	@Column(name = "version")
	private int version;

	public CheckinInfoPO() {

	}

	public CheckinInfoPO(String name, String ID, String tel, String roomtype, BedType bedtype, String roomnumber,
			java.util.Date checkintime, java.util.Date checkouttime, int hotelnumber, String ordernumber) {
		this.setName(name);
		this.setID(ID);
		this.setTel(tel);
		this.setBedtype(bedtype);
		this.setRoomnumber(roomnumber);
		this.setCheckintime(checkintime);
		this.setCheckouttime(checkouttime);
		this.setHotelnumber(hotelnumber);
		this.setOrdernumber(ordernumber);
		this.setRoomtype(roomtype);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public BedType getBedtype() {

		switch (bedtypeInSQL) {
		case "BIGBED":
			bedtype = BedType.BIGBED;
			break;
		case "TWOBEDS":
			bedtype = BedType.TWOBEDS;
			break;
		case "THREEBEDS":
			bedtype = BedType.THREEBEDS;
			break;
		case "FOURBEDS":
			bedtype = BedType.FOURBEDS;
			break;
		case "FAMILYBED":
			bedtype = BedType.FAMILYBED;
			break;
		}

		return bedtype;
	}

	public void setBedtype(BedType bedtype) {
		this.bedtype = bedtype;
		this.bedtypeInSQL = bedtype.getString();
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public java.util.Date getCheckintime() {
		if (checkintimeStamp == null) {
			return null;
		}
		return new java.util.Date(checkintimeStamp.getTime());
	}

	public void setCheckintime(java.util.Date checkintime) {
		if (checkintime != null)
			this.checkintimeStamp = new java.sql.Timestamp(checkintime.getTime());
	}

	public java.util.Date getCheckouttime() {
		if (checkouttimeStamp == null) {
			return null;
		}
		return new java.util.Date(checkouttimeStamp.getTime());
	}

	public void setCheckouttime(java.util.Date checkouttime) {
		if (checkouttime != null)
			this.checkouttimeStamp = new java.sql.Timestamp(checkouttime.getTime());
	}

	public int getHotelnumber() {
		return hotelnumber;
	}

	public void setHotelnumber(int hotelnumber) {
		this.hotelnumber = hotelnumber;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public CheckinInfoPO copy() {
		return new CheckinInfoPO(name, ID, tel, roomtype, getBedtype(), roomnumber, getCheckintime(), getCheckouttime(),
				hotelnumber, ordernumber);
	}

}
