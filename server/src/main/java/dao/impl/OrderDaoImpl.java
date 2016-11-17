package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.orderdao.OrderDao;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import util.ResultMessage;

/**
 * OrderDao的实现
 * @author csy
 *
 */
public class OrderDaoImpl extends UnicastRemoteObject implements OrderDao {
	
	private static final long serialVersionUID = -6904380473603003697L;
	private static OrderDao orderDao;
		
	    public static OrderDao getInstance() throws RemoteException {
			if(orderDao==null){
				orderDao=new OrderDaoImpl();
			}
			return orderDao;
		}
	    private OrderDaoImpl() throws RemoteException {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public OrderInfoPO getOrderInfo(String orderID) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<OrderListPO> getOrderList(String keyword) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage addOrderState(OrderStatePO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage addOrder(OrderInfoPO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

	
}
