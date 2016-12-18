package businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;

import blservice.orderblservice.OrderBLService;
import common.ResultMessage;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderVO;
import vo.ordervo.RemarkVO;
import vo.ordervo.TypeInfoVO;

/**
 * 模拟订单策略模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class OrderBL_Stub implements OrderBLService {

	@Override
	public ResultMessage checkUserCredit(String CustomerID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkTelephone(String telNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkTime(Date time) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmAddOrder(OrderInfoVO orderInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return new OrderInfoVO();
	}

	@Override
	public ArrayList<OrderVO> getOrderList(TypeInfoVO typeInfoVO) {
		// TODO Auto-generated method stub
		return new ArrayList<OrderVO>();
	}

	@Override
	public ResultMessage cancelOrderConfirm(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage remarkOrder(RemarkVO remarkVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getPrice(String orderID) {
		// TODO Auto-generated method stub
		return 0.5;
	}

	@Override
	public ResultMessage setCheckinTime(Date time) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckoutTime(Date time) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setReturnCredit(int creditNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
