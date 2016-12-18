package data.orderdata;

import java.util.ArrayList;

import common.ResultMessage;
import dataservice.orderdataservice.OrderDataService;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;

/**
 * 模拟order模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class OrderDataServiceMySqlImpl_Stub implements OrderDataService{

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderInfoPO getOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return new OrderInfoPO();
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(String keyword) {
		// TODO Auto-generated method stub
		return new ArrayList<OrderListPO>();
	}

	@Override
	public ResultMessage addOrderState(OrderStatePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setOrderRemark(RemarkPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckintime(CheckTimePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckouttime(CheckTimePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addOrder(OrderInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	

}
