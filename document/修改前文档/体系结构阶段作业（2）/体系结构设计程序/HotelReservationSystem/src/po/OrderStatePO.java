package po;

import java.io.Serializable;

import common.OrderState;

/**
 * 订单状态po
 * 
 * @author CYF
 * @version 1.0
 */
public class OrderStatePO implements Serializable {
	// 订单编号
	private String orderNumber;
	// 订单状态
	private OrderState state;

	// 空方法
	public OrderStatePO() {

	}

	// 订单状态
	public OrderStatePO(String orderNumber, OrderState state) {
		this.setOrderNumber(orderNumber);
		this.setState(state);
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

}
