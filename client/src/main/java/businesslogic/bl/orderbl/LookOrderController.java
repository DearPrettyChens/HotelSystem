package businesslogic.bl.orderbl;

import java.util.ArrayList;

import businesslogic.blservice.orderblservice.LookOrderService;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderVO;
import vo.ordervo.TypeInfoVO;

/**
 * Order模块的LookOrderController控制类
 * @author csy
 * @version 1.0
 */
public class LookOrderController implements LookOrderService{

	private OrderList orderList;
	private SingleOrder singleOrder;
	public LookOrderController() {
		orderList=new OrderList();
		singleOrder=new SingleOrder();
	}
	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return singleOrder.getOrderInfo();
	}

	@Override
	public ArrayList<OrderVO> getOrderList(TypeInfoVO typeInfoVO) {
		// TODO Auto-generated method stub
		return orderList.getOrderList(typeInfoVO);
	}

}
