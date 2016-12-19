package vo.hotelvo;

import java.util.Date;

import common.OrderState;
/**
 * 酒店订单列表里的订单vo
 * @author CYF
 * @version 1.0
 */
public class HotelOrderVO {
	//订单编号
	private String orderID;
	//顾客用户名
	private String customerName;
	//预定时间
	private Date reserveTime;
	//订单状态
	private OrderState state;

	//空方法
	public HotelOrderVO(){
	}
	//酒店订单列表里的订单
	public HotelOrderVO(String orderID, String customerName, Date reserveTime, OrderState state) {
		this.setOrderID(orderID);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
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

	public Date getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}
}
