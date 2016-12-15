package businesslogic.bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.bl.hotelbl.Hotel;
import dao.orderdao.OrderDao;
import exception.NotFoundHotelException;
import exception.NullHotelIDException;
import init.RMIHelper;
import po.OrderListPO;
import presentation.ui.loginui.view.newclient_JFrame;
import util.OrderState;
import vo.hotelvo.HotelBasicInfoVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

/**
 * Order模块的领域类
 * 
 * @author CLL
 * @version 1.0
 */
public class OrderList {
	// private ArrayList<SingleOrder> singleOrders;
	private OrderDao orderDao;
	private Hotel hotel;
	private static OrderState[] orderStates = OrderState.values();

	public OrderList() {
		RMIHelper.init();
		orderDao = RMIHelper.getOrderDao();
		hotel=new Hotel();
		// orderDao=new OrderDao_Stub();
	}

	/**
	 * 获取特定类型的订单列表
	 * 
	 * @param typeInfoVO
	 *            TypeInfoVO型,传递订单类型信息
	 * @return ArrayList<OrderListVO> ，将特定订单列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO vo) {
		try {
			ArrayList<OrderListPO> orders = new ArrayList<OrderListPO>();
			if (vo.getOrderState() == null) {
				for (int i = 0; i < orderStates.length; i++) {
					vo.setOrderState(orderStates[i]);
					orders.addAll(orderDao.getOrderList(vo.toPO()));
				}
			} else {
				orders = orderDao.getOrderList(vo.toPO());
			}
			ArrayList<OrderListVO> ordersVO = new ArrayList<OrderListVO>();
			for (int i = 0; i < orders.size(); i++) {
				ordersVO.add(new OrderListVO(orders.get(i)));
			}
			for(int i=0;i<ordersVO.size();i++){
				try {
					HotelBasicInfoVO basic=hotel.getHotelBasicInfo(ordersVO.get(i).getHotelID());
					ordersVO.get(i).setHotelIcon(basic.getHotelImage());
				} catch (NotFoundHotelException e) {
					e.printStackTrace();
				}
			}
			return ordersVO;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取该酒店的订单列表
	 * 
	 * @param hotelID
	 * @return ArrayList<OrderListVO> ，将特定订单列表返回给hotel
	 */
	public ArrayList<OrderListVO> getOrderList(String hotelID) throws NullHotelIDException {
		if (hotelID == null) {
			throw new NullHotelIDException();
		}
		try {
			ArrayList<OrderListPO> orders = orderDao.getOrderList(hotelID);
			ArrayList<OrderListVO> ordersVO = new ArrayList<OrderListVO>();
			for (int i = 0; i < orders.size(); i++) {
				ordersVO.add(new OrderListVO(orders.get(i)));
			}
			return ordersVO;
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return null;
	}

}
