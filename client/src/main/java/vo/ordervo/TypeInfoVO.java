package vo.ordervo;

import po.TypeInfoPO;
import util.OrderState;
import util.UserType;

/**
 * 订单类别信息的vo类
 * 
 * @author CLL
 * @version 1.0
 */
public class TypeInfoVO {
	// 浏览订单的发起者
	private UserType userType;
	// 浏览订单的状态
	private OrderState orderState;

	private String customerID;
	// 酒店编号
	// private String hotelID;

	public TypeInfoVO() {

	}

	public TypeInfoVO(UserType userType, OrderState orderState,String customerID) {
		this.setUserType(userType);
		this.setOrderState(orderState);
		this.setCustomerID(customerID);
		// this.setHotelID(hotelID);
	}

	public TypeInfoVO(TypeInfoPO po) {
		this.setUserType(po.getUserType());
		this.setOrderState(po.getOrderState());
		this.setCustomerID(po.getCustomerID());
		// this.setHotelID(po.getHotelID());
	}

	public TypeInfoPO toPO() {
		return new TypeInfoPO(this.userType, this.orderState,this.customerID);
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
