package businesslogic.blservice.orderblservice;

import java.util.ArrayList;

import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

/**
 *  LookOrderService提供接口，用来浏览查看订单信息（包括搜索）
 * @author csy
 * @version 1.0
 * 
 */
public interface LookOrderService {
	/**
	 * 获取订单详细信息
	 * @param orderID String型，传递订单号
	 * @return OrderInfoVO ，将订单详细信息返回给界面或hotel模块
	 * @throws 未定
	 *
	 */
	public OrderInfoVO getOrderInfo(String orderID);
	
	/**
	 * 获取特定类型的订单列表
	 * @param typeInfoVO TypeInfoVO型,传递订单类型信息
	 * @return  ArrayList<OrderVO> ，将特定订单列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO typeInfoVO);
	
}
