package po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.swing.ImageIcon;

import util.OrderState;

/**
 * 订单列表信息po
 * 
 * @author CYF
 * @version 1.0
 */
@Entity
@Table(name = "t_order")
public class OrderListPO implements Serializable {
	// 订单编号
	@Id
	@Column(name = "order_id")
	private String orderNumber;
	// 酒店ID
	@Column(name = "hotel_id")
	private String hotelID;
	// 酒店名称
	@Column(name = "hotel_name")
	private String hotelName;
	// 顾客ID
	@Column(name = "customer_id")
	private String customerID;
	// 顾客用户名
	@Column(name = "customer_name")
	private String customerName;
	// 顾客预定时间
	@Column(name = "reserve_time")
	private java.sql.Timestamp reserveTimeStamp;
	// 订单状态
	@Column(name = "state")
	private String state;
	@Version
	@Column(name = "version")
	private int version;
	// 空方法
	public OrderListPO() {

	}

	// 显示给顾客看的订单列表信息
	public OrderListPO(String orderNumber, String hotelID, String hotelName, String customerName, Date reserveTime,
			OrderState state, ImageIcon hotelIcon) {
		this.setOrderNumber(orderNumber);
		this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
	}

	// 显示给酒店看的订单列表信息，需求规格上没有写
	public OrderListPO(String orderNumber, String customerID, String customerName, Date reserveTime, OrderState state) {
		this.setOrderNumber(orderNumber);
		this.setCustomerID(customerID);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
	}

	// 网站营销人员看到的订单列表信息，需求规格上没有写
	public OrderListPO(String orderNumber, String hotelID, String hotelName, String customerID, String customerName,
			Date reserveTime, OrderState state) {
		this.setOrderNumber(orderNumber);
		this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setCustomerID(customerID);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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

	public OrderState getState() {
		OrderState orderState = null;
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

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public OrderListPO copy() {
		return new OrderListPO(getOrderNumber(), getHotelID(), getHotelName(), getCustomerID(), getCustomerName(),
				getReserveTime(), getState());
	}

}
