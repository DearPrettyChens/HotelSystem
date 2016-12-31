package po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import util.BedType;
import util.Children;
import util.OrderState;

/**
 * 订单信息的PO类
 * 
 * @author CYF
 * @version 1.0
 */
@Entity
@Table(name = "new_order")
public class OrderInfoPO implements Serializable {
	// 顾客编号
	@Column(name = "customer_id")
	private String customerID;
	// 订单编号
	@Id
	@Column(name = "order_id")
	private String orderID;
	// 顾客生成订单时填写的顾客姓名
	@Column(name = "customer_name")
	private String customerName;
	// 入住人姓名
	@Column(name = "live_in_person_name")
	private String liveinPersonName;
	// 入住人联系方式
	@Column(name = "live_in_person_telephone")
	private String liveinPersonTelephone;
	// 酒店名称
	@Column(name = "hotel_name")
	private String hotelName;
	// 酒店ID
	@Column(name = "hotel_id")
	private String hotelID;
	// 酒店联系方式
	@Column(name = "hotel_telephone")
	private String hotelTelephone;
	// 预定房型
	@Column(name = "room_type")
	private String roomType;
	// 预定床型
	@Column(name = "bed_type")
	private String bedType;
	// 预定房间数量
	@Column(name = "amount")
	private int amount;
	// 预定时间
	@Column(name = "reserve_time")
	private java.sql.Timestamp reserveTimeStamp;
	// 入住人数
	@Column(name = "number_of_people")
	private int NumberOfPeople;
	// 有无儿童
	@Column(name = "has_children")
	private String hasChild;
	// 是否评价
	@Column(name = "has_remarked")
	private boolean hasRemarked;
	// 预计入住时间
	@Column(name = "expected_checkin_time")
	private java.sql.Timestamp expectedCheckInTimeStamp;
	// 预计退房时间
	@Column(name = "expected_checkout_time")
	private java.sql.Timestamp expectedCheckOutTimeStamp;

	// 最晚入住时间,下订单时计算产生
	@Column(name = "late_checkin_time")
	private java.sql.Timestamp lateCheckInTimeStamp;
	// 实际入住时间
	@Column(name = "actual_checkin_time")
	private java.sql.Timestamp actualCheckInTimeStamp;
	// 实际退房时间
	@Column(name = "actual_checkout_time")
	private java.sql.Timestamp actualCheckOutTimeStamp;
	// 订单价格
	@Column(name = "price")
	private double price;
	// 订单状态
	@Column(name = "state")
	private String state;
	// 撤销时间
	@Column(name = "cancle_time")
	private java.sql.Timestamp cancleTimeStamp;
	@Version
	@Column(name = "version")
	private int version;

	// 空方法
	public OrderInfoPO() {

	}

	// 查看所有订单信息
	public OrderInfoPO(String customerID, String orderID, String customerName, String liveinPersonName,
			String liveinPersonTelephone, String hotelName, String hotelID, String hotelTelephone, String roomType,
			BedType bedType, int amount, Date reserveTime, int numberOfPeople, Children hasChild, boolean hasRemarked,
			Date expectedCheckInTime, Date expectedCheckOutTime, Date lateCheckInTime, Date actualCheckInTime,
			Date actualCheckOutTime, double price, OrderState state, Date cancleTime) {
		this.setCustomerID(customerID);
		this.setOrderID(orderID);
		this.setCustomerName(customerName);
		this.setLiveinPersonName(liveinPersonName);
		this.setLiveinPersonTelephone(liveinPersonTelephone);
		this.setHotelName(hotelName);
		this.setHotelID(hotelID);
		this.setHotelTelephone(hotelTelephone);
		this.setRoomType(roomType);
		this.setBedType(bedType);
		this.setAmount(amount);
		this.setReserveTime(reserveTime);
		this.setNumberOfPeople(numberOfPeople);
		this.setHasChild(hasChild);
		this.setHasRemarked(hasRemarked);
		this.setExpectedCheckInTime(expectedCheckInTime);
		this.setExpectedCheckOutTime(expectedCheckOutTime);
		this.setLateCheckInTime(lateCheckInTime);
		this.setActualCheckInTime(actualCheckInTime);
		this.setActuarCheckOutTime(actualCheckOutTime);
		this.setPrice(price);
		this.setState(state);
		this.setCancleTime(cancleTime);
	}

	// 顾客下订单时的订单信息
	public OrderInfoPO(String orderID, String hotelID, String hotelname, String hotelTel,String customerID, String customerName,
			String liveinPersonName, String liveinPersonTelephone, Date orderTime, Date expectedCheckInTime,
			Date expectedCheckOutTime,Date lateCheckInTime, String roomType, BedType bedType, int amount, int numberOfPeople,
			Children hasChild, double price, OrderState state) {
		this.setOrderID(orderID);
		this.setCustomerID(customerID);
		this.setHotelID(hotelID);
		this.setHotelName(hotelname);
		this.setCustomerName(customerName);
		this.setLiveinPersonName(liveinPersonName);
		this.setLiveinPersonTelephone(liveinPersonTelephone);
		this.setExpectedCheckInTime(expectedCheckInTime);
		this.setExpectedCheckOutTime(expectedCheckOutTime);
		this.setLateCheckInTime(lateCheckInTime);
		this.setRoomType(roomType);
		this.setBedType(bedType);
		this.setAmount(amount);
		this.setNumberOfPeople(numberOfPeople);
		this.setHasChild(hasChild);
		this.setPrice(price);
		this.setState(state);
		this.setReserveTime(orderTime);
		this.hotelTelephone=hotelTel;
	}

	// 顾客在撤销订单前及入住之前查看订单时显示的订单信息
	// 酒店管理人员checkin时获取的订单信息
	// 网站营销人员撤销异常订单时获取的订单信息
	public OrderInfoPO(String orderID, String hotelID, String customerID, String customerName, String liveinPersonName,
			String liveinPersonTelephone, Date expectedCheckInTime, Date expectedCheckOutTime, Date lateCheckInTime,
			String roomType, BedType bedType, int amount, int numberOfPeople, Children hasChild, double price,
			OrderState state) {
		this.setOrderID(orderID);
		this.setCustomerID(customerID);
		this.setHotelID(hotelID);
		this.setCustomerName(customerName);
		this.setLiveinPersonName(liveinPersonName);
		this.setLiveinPersonTelephone(liveinPersonTelephone);
		this.setExpectedCheckInTime(expectedCheckInTime);
		this.setExpectedCheckOutTime(expectedCheckOutTime);
		this.setLateCheckInTime(lateCheckInTime);
		this.setRoomType(roomType);
		this.setBedType(bedType);
		this.setAmount(amount);
		this.setNumberOfPeople(numberOfPeople);
		this.setHasChild(hasChild);
		this.setPrice(price);
		this.setState(state);
	}

	// 酒店管理人员checkout时获取的订单信息
	public OrderInfoPO(String orderID, String hotelID, String customerID, String customerName, String liveinPersonName,
			String liveinPersonTelephone, Date expectedCheckInTime, Date expectedCheckOutTime, Date lateCheckInTime,
			String roomType, BedType bedType, int amount, int numberOfPeople, Children hasChild, OrderState state,
			Date actualCheckInTime) {
		this.setOrderID(orderID);
		this.setCustomerID(customerID);
		this.setHotelID(hotelID);
		this.setCustomerName(customerName);
		this.setLiveinPersonName(liveinPersonName);
		this.setLiveinPersonTelephone(liveinPersonTelephone);
		this.setExpectedCheckInTime(expectedCheckInTime);
		this.setExpectedCheckOutTime(expectedCheckOutTime);
		this.setLateCheckInTime(lateCheckInTime);
		this.setRoomType(roomType);
		this.setBedType(bedType);
		this.setAmount(amount);
		this.setNumberOfPeople(numberOfPeople);
		this.setHasChild(hasChild);
		this.setState(state);
		this.setActualCheckInTime(actualCheckInTime);
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getHotelTelephone() {
		return hotelTelephone;
	}

	public void setHotelTelephone(String hotelTelephone) {
		this.hotelTelephone = hotelTelephone;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public BedType getBedType() {
		BedType bType = null;
		switch (bedType) {
		case "BIGBED":
			bType = BedType.BIGBED;

			break;
		case "FAMILYBED":
			bType = BedType.FAMILYBED;
			break;
		case "FOURBEDS":
			bType = BedType.FOURBEDS;
			break;
		case "THREEBEDS":
			bType = BedType.THREEBEDS;
			break;
		case "TWOBEDS":
			bType = BedType.TWOBEDS;
			break;
		default:
			break;
		}
		return bType;
	}

	public void setBedType(BedType bedType) {
		if (bedType != null)
			this.bedType = bedType.getString();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getNumberOfPeople() {
		return NumberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		NumberOfPeople = numberOfPeople;
	}

	public Children getHasChild() {
		Children children = null;
		switch (hasChild) {
		case "EXIST":
			children = Children.EXIST;
			break;
		case "NOTEXIST":
			children = Children.NOTEXIST;
			break;
		default:
			break;
		}
		return children;
	}

	public void setHasChild(Children hasChild) {
		if (hasChild != null)
			this.hasChild = hasChild.getString();
	}

	public boolean isHasRemarked() {
		return hasRemarked;
	}

	public void setHasRemarked(boolean hasRemarked) {
		this.hasRemarked = hasRemarked;
	}

	public Date getExpectedCheckInTime() {
		if (expectedCheckInTimeStamp == null) {
			return null;
		}
		return new Date(expectedCheckInTimeStamp.getTime());
	}

	public void setExpectedCheckInTime(Date expectedCheckInTime) {
		if (expectedCheckInTime != null)
			this.expectedCheckInTimeStamp = new java.sql.Timestamp(expectedCheckInTime.getTime());
	}

	public Date getExpectedCheckOutTime() {
		if (expectedCheckOutTimeStamp == null)
			return null;
		return new Date(expectedCheckOutTimeStamp.getTime());
	}

	public void setExpectedCheckOutTime(Date expectedCheckOutTime) {
		if (expectedCheckOutTime != null)
			this.expectedCheckOutTimeStamp = new java.sql.Timestamp(expectedCheckOutTime.getTime());
	}

	public Date getLateCheckInTime() {
		if (lateCheckInTimeStamp == null) {
			return null;
		}
		return new Date(lateCheckInTimeStamp.getTime());
	}

	public void setLateCheckInTime(Date lateCheckInTime) {
		if (lateCheckInTime != null) {
			this.lateCheckInTimeStamp = new java.sql.Timestamp(lateCheckInTime.getTime());
		}
	}

	public Date getActualCheckInTime() {
		if (actualCheckInTimeStamp == null)
			return null;
		return new Date(actualCheckInTimeStamp.getTime());
	}

	public void setActualCheckInTime(Date actualCheckInTime) {
		if (actualCheckInTime != null)
			this.actualCheckInTimeStamp = new java.sql.Timestamp(actualCheckInTime.getTime());
	}

	public Date getActualCheckOutTime() {
		if (actualCheckInTimeStamp == null)
			return null;
		return new Date(actualCheckInTimeStamp.getTime());
	}

	public void setActuarCheckOutTime(Date actualCheckOutTime) {
		if (actualCheckOutTime != null)
			this.actualCheckOutTimeStamp = new java.sql.Timestamp(actualCheckOutTime.getTime());
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderState getState() {
		OrderState orderState = null;
		if (state == null) {
			return null;
		}
		switch (state) {
		case "HASCANCELED":
			orderState = OrderState.HASCANCELED;

			break;
		case "HASREMARKED":
			orderState = OrderState.HASREMARKED;
			break;
		case "NOTEXECUTED":
			orderState = OrderState.NOTEXECUTED;
			break;
		case "NOTREMARKED":
			orderState = OrderState.NOTREMARKED;
			break;
		case "UNUSUAL":
			orderState = OrderState.UNUSUAL;
			break;
		default:
			break;
		}
		return orderState;
	}

	public void setState(OrderState state) {
		if (state != null)
			this.state = state.getString();
	}

	public String getLiveinPersonName() {
		return liveinPersonName;
	}

	public void setLiveinPersonName(String liveinPersonName) {
		this.liveinPersonName = liveinPersonName;
	}

	public String getLiveinPersonTelephone() {
		return liveinPersonTelephone;
	}

	public void setLiveinPersonTelephone(String liveinPersonTelephone) {
		this.liveinPersonTelephone = liveinPersonTelephone;
	}

	public Date getCancleTime() {
		if (cancleTimeStamp == null)
			return null;
		return new Date(cancleTimeStamp.getTime());
	}

	public void setCancleTime(Date cancleTime) {
		if (cancleTime != null)
			this.cancleTimeStamp = new java.sql.Timestamp(cancleTime.getTime());
	}

	public Date getReserveTime() {
		if (reserveTimeStamp == null)
			return null;
		return new Date(reserveTimeStamp.getTime());
	}

	public void setReserveTime(Date reserveTime) {
		if (reserveTime != null)
			this.reserveTimeStamp = new java.sql.Timestamp(reserveTime.getTime());
	}

	public OrderInfoPO copy() {
		return new OrderInfoPO(getCustomerID(), getOrderID(), getCustomerName(), getLiveinPersonName(),
				getLiveinPersonTelephone(), getHotelName(), getHotelID(), getHotelTelephone(), getRoomType(),
				getBedType(), getAmount(), getReserveTime(), getNumberOfPeople(), getHasChild(), isHasRemarked(),
				getExpectedCheckInTime(), getExpectedCheckOutTime(), getLateCheckInTime(), getActualCheckInTime(),
				getActualCheckOutTime(), getPrice(), getState(), getCancleTime());
	}

}
