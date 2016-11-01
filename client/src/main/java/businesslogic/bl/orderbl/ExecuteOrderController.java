package businesslogic.bl.orderbl;

import java.util.Date;

import businesslogic.blservice.orderblservice.ExecuteOrderService;
import util.ResultMessage;
import vo.ordervo.RemarkVO;

/**
 * Order模块的ExecuteOrderController控制类
 * @author csy
 * @version 1.0
 */
public class ExecuteOrderController implements ExecuteOrderService {
    private SingleOrder singleOrder;
    //调用singleOrder里面的方法
	public ExecuteOrderController() {
		singleOrder=new SingleOrder();
	}
	@Override
	public ResultMessage remarkOrder(RemarkVO remarkVO) {
		// TODO Auto-generated method stub
		return singleOrder.remarkOrder(remarkVO);
	}

	@Override
	public ResultMessage setCheckinTime(Date time, String orderID) {
		// TODO Auto-generated method stub
		return singleOrder.setCheckinTime(time, orderID);
	}

	@Override
	public ResultMessage setCheckoutTime(Date time, String orderID) {
		// TODO Auto-generated method stub
		return singleOrder.setCheckoutTime(time, orderID);
	}

}
