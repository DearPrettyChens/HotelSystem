package presentation.ui.orderui.distributecontroller;

import java.util.Date;

import businesslogic.blservice.orderblservice.ExecuteOrderService;
import util.ResultMessage;
import vo.ordervo.RemarkVO;

public class ExecuteOrderService_Stub implements ExecuteOrderService{

	@Override
	public ResultMessage remarkOrder(RemarkVO remarkVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckinTime(Date time, String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckoutTime(Date time, String orderID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
