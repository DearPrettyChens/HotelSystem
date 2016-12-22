package data.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import po.TypeInfoPO;
import util.ResultMessage;

public interface OrderDataHelper {
	/**
	 * 获得订单信息
	 * 
	 * @param orderID
	 *            String型，用来传递订单ID
	 * @return OrderInfoPO 用来获取订单详细信息
	 * @throws 未定
	 * 
	 */
	public OrderInfoPO getOrderInfo(String orderID) throws RemoteException;

	/**
	 * 添加订单状态
	 * 
	 * @param po
	 *            OrderStatePO型，用来传递订单状态
	 * @return ResultMessage，如果添加成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage addOrderState(OrderStatePO po) throws RemoteException;

	/**
	 * 设置订单评价
	 * 
	 * @param po
	 *            RemarkPO型，用来设置订单评价
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException;

	/**
	 * 设置入住时间
	 * 
	 * @param po
	 *            CheckTimePO型，用来设置订单入住时间信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException;

	/**
	 * 设置退房时间
	 * 
	 * @param po
	 *            CheckTimePO型，用来设置订单退房时间信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException;

	/**
	 * 添加订单
	 * 
	 * @param po
	 *            OrderInfoPO型，用来传递新增订单信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage addOrder(OrderInfoPO po) throws RemoteException;

	/**
	 * 获得特定类型订单列表
	 * 
	 * @param po
	 *            TypeInfoPO型，用来传递订单类型信息
	 * @return ArrayList<OrderListPO> 用来获取该类型订单列表信息
	 * @throws 未定
	 */
	public ArrayList<OrderListPO> getOrderList(TypeInfoPO po) throws RemoteException;

	/**
	 * 获得酒店订单列表
	 * 
	 * @param hotelID
	 * @return ArrayList<OrderListPO> 用来获取该酒店订单列表信息
	 * @throws RemoteException
	 */
	public ArrayList<OrderListPO> getOrderList(String hotelID) throws RemoteException;

}
