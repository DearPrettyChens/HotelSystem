package po;

import java.io.Serializable;

import util.OrderState;
import util.UserType;

/**
 * 订单类别信息的po类
 * 
 * @author CLL
 * @version 1.0
 */
public class TypeInfoPO implements Serializable{
	// 浏览订单的发起者
	private UserType userType;
	// 浏览订单的状态
	private OrderState orderState;
	// 酒店id
	private String customerID;

	public TypeInfoPO() {

	}

	public TypeInfoPO(UserType userType, OrderState orderState, String customerID) {
		this.setUserType(userType);
		this.setOrderState(orderState);
		this.setCustomerID(customerID);
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
