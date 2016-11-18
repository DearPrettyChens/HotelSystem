package businesslogic.bl.orderbl;

import businesslogic.blservice.orderblservice.CancleOrderService;
import util.OrderState;
import util.ResultMessage;

/**
 * Order模块的CancleOrderController控制类
 * @author csy
 * @version 1.0
 */
public class CancleOrderController implements CancleOrderService{
	private static CancleOrderController controller=null;
	private SingleOrder singleOrder;
    //调用singleOrder里面的方法
	private CancleOrderController() {
		singleOrder=new SingleOrder();
	}
	public static CancleOrderController getInstance(){
		if(controller==null){
			controller=new CancleOrderController();
		}
		return controller;
	}
	@Override
	public ResultMessage setReturnCredit(String orderId,int creditNum) {
		//异常订单撤销
		return singleOrder.setReturnCredit(orderId,creditNum);
	}

	@Override
	public ResultMessage cancelOrderConfirm(String orderID){
		//订单未执行撤销
		return singleOrder.cancelOrderConfirm(orderID);
	}

}
