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
	public OrderInfoPO getOrderInfo(String orderID) throws RemoteException;

	public ResultMessage addOrderState(OrderStatePO po) throws RemoteException;

	public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException;

	public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException;

	public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException;

	public ResultMessage addOrder(OrderInfoPO po) throws RemoteException;

	public ArrayList<OrderListPO> getOrderList(TypeInfoPO po) throws RemoteException;

	public ArrayList<OrderListPO> getOrderList(String hotelID) throws RemoteException;

}
