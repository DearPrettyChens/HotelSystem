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
    private static ExecuteOrderController controller=null;
    //调用singleOrder里面的方法
	private ExecuteOrderController() {
		singleOrder=new SingleOrder();
	}
	public static ExecuteOrderController getInstance(){
		if(controller==null){
			controller=new ExecuteOrderController();
		}
		return controller;
	}
	@Override
	public ResultMessage remarkOrder(RemarkVO remarkVO) {
		return singleOrder.remarkOrder(remarkVO);
	}

	@Override
	public ResultMessage setCheckinTime(Date time, String orderID) {
		return singleOrder.setCheckinTime(time, orderID);
	}

	@Override
	public ResultMessage setCheckoutTime(Date time, String orderID) {
		return singleOrder.setCheckoutTime(time, orderID);
	}

}
