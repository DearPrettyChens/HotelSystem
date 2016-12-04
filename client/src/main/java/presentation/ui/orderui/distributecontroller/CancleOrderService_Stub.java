package presentation.ui.orderui.distributecontroller;

import businesslogic.blservice.orderblservice.CancleOrderService;
import util.ResultMessage;

public class CancleOrderService_Stub implements CancleOrderService{

	@Override
	public ResultMessage setReturnCredit(String orderId, int creditNum) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage cancelOrderConfirm(String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
