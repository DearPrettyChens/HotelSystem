package businesslogic.bl.orderbl;

import java.util.ArrayList;

import businesslogic.blservice.orderblservice.LookOrderService;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

/**
 * Order模块的LookOrderController控制类
 * @author csy
 * @version 1.0
 */
public class LookOrderController implements LookOrderService{
	private static LookOrderController controller=null;
	private OrderList orderList;
	private SingleOrder singleOrder;
	private LookOrderController() {
		orderList=new OrderList();
		singleOrder=new SingleOrder();
	}
	public static LookOrderController getInstance(){
		if(controller==null){
			controller=new LookOrderController();
		}
		return controller;
	}
	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		return singleOrder.getOrderInfo(orderID);
	}

	@Override
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO typeInfoVO) {
		return orderList.getOrderList(typeInfoVO);
	}

}
