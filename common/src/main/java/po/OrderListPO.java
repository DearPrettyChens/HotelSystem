package po;

import java.io.Serializable;
import java.util.Date;

import javax.swing.ImageIcon;

import util.OrderState;

/**
 * 订单列表信息po
 * @author CYF
 * @version 1.0
 */
public class OrderListPO implements Serializable{
	//订单编号
	private String orderNumber;
	//酒店ID
	private String hotelID;
	//酒店名称
	private String hotelName;
	//顾客ID
	private String customerID;
	//顾客用户名
	private String customerName;
	//顾客预定时间
	private Date reserveTime;
	//订单状态
	private OrderState state;
	//酒店图片
	private ImageIcon hotelIcon;
	//空方法
	public OrderListPO(){
		
	}
	//显示给顾客看的订单列表信息
	public OrderListPO(String orderNumber,String hotelID,String hotelName,String customerName,Date reserveTime,OrderState state,ImageIcon hotelIcon){
		this.setOrderNumber(orderNumber);
		this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
		this.setHotelIcon(hotelIcon);
	}
	//显示给酒店看的订单列表信息，需求规格上没有写
	public OrderListPO(String orderNumber,String customerID,String customerName, Date reserveTime,OrderState state){
		this.setOrderNumber(orderNumber);
		this.setCustomerID(customerID);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
	}
	//网站营销人员看到的订单列表信息，需求规格上没有写
	public OrderListPO(String orderNumber,String hotelID,String hotelName,String customerID,String customerName,Date reserveTime,OrderState state){
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
	public ImageIcon getHotelIcon() {
		return hotelIcon;
	}
	public void setHotelIcon(ImageIcon hotelIcon) {
		this.hotelIcon = hotelIcon;
	}


	

}
