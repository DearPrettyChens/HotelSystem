package businesslogic.bl.hotelbl.mock;

import java.util.ArrayList;

import businesslogic.bl.orderbl.OrderList;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

/**
 * order的mock类
 * @author Csy
 * @version 1.0
 */
public class MockOrderList extends OrderList{
	
	/**
	 * 获取特定类型的订单列表
	 * @param typeInfoVO TypeInfoVO型,传递订单类型信息
	 * @return  ArrayList<OrderVO> ，将特定订单列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO vo){
		return new ArrayList<OrderListVO>();
		
	}
}
