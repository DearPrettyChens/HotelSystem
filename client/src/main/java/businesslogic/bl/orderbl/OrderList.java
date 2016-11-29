package businesslogic.bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.orderdao.OrderDao;
import exception.NullHotelIDException;
import po.OrderListPO;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;
/**
 * Order模块的领域类
 * @author CLL
 * @version 1.0
 */
public class OrderList {
	//private ArrayList<SingleOrder> singleOrders;
	private OrderDao orderDao;
	public OrderList() {
//		orderDao=RMIHelper.getOrderDao();
		orderDao=new OrderDao_Stub();
	}
	
	/**
	 * 获取特定类型的订单列表
	 * @param typeInfoVO TypeInfoVO型,传递订单类型信息
	 * @return  ArrayList<OrderListVO> ，将特定订单列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO vo){
		try {
			ArrayList<OrderListPO> orders=orderDao.getOrderList(vo.toPO());
			ArrayList<OrderListVO> ordersVO=new ArrayList<OrderListVO>();
			for(int i=0;i<orders.size();i++){
				ordersVO.add(new OrderListVO(orders.get(i)));
			}
			return ordersVO;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}	
	/**
	 * 获取该酒店的订单列表
	 * @param hotelID
	 * @return ArrayList<OrderListVO> ，将特定订单列表返回给hotel
	 */
	public ArrayList<OrderListVO> getOrderList(String hotelID)throws NullHotelIDException{
		if(hotelID==null){
			throw new NullHotelIDException();
		}
		try {
			ArrayList<OrderListPO> orders=orderDao.getOrderList(hotelID);
			ArrayList<OrderListVO> ordersVO=new ArrayList<OrderListVO>();
			for(int i=0;i<orders.size();i++){
				ordersVO.add(new OrderListVO(orders.get(i)));
			}
			return ordersVO;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
