package businesslogic.bl.orderbl;

import java.util.ArrayList;

import dao.orderdao.OrderDao;
import vo.ordervo.OrderVO;
import vo.ordervo.TypeInfoVO;
/**
 * Order模块的领域类
 * @author csy
 * @version 1.0
 */
public class OrderList {
	private ArrayList<SingleOrder> singleOrders;
	private OrderDao orderDao;
	public OrderList() {
		
	}
	
	/**
	 * 获取特定类型的订单列表
	 * @param typeInfoVO TypeInfoVO型,传递订单类型信息
	 * @return  ArrayList<OrderVO> ，将特定订单列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<OrderVO> getOrderList(TypeInfoVO vo){
		return null;
		
	}
	
}
