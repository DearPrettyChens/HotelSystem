package vo.ordervo;

import common.OrderState;
import common.UserType;

/**
 * 订单类别信息的vo类
 * @author CLL
 * @version 1.0
 */
public class TypeInfoVO {
	//浏览订单的发起者
	private UserType userType;
	//浏览订单的状态
	private OrderState orderState;
	
	public TypeInfoVO(){
		
	}
	
	public TypeInfoVO(UserType userType,OrderState orderState){
		this.setUserType(userType);
		this.setOrderState(orderState);
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
}
