package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.orderdao.OrderDao;
import data.datahelper.OrderDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import po.TypeInfoPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import util.ResultMessage;

/**
 * OrderDao的实现
 * 
 * @author csy
 *
 */
public class OrderDaoImpl extends UnicastRemoteObject implements OrderDao {

	private static final long serialVersionUID = -6904380473603003697L;
	private static OrderDao orderDao;
	public DataFactory dataFactory;
	public OrderDataHelper orderDataHelper;

	public static OrderDao getInstance() throws RemoteException {
		if(orderDao==null){
			try {
				orderDao = new OrderDaoImpl();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orderDao;
	}

	private OrderDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(),new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
		orderDataHelper = dataFactory.getOrderDataHelper();
	}

	@Override
	public OrderInfoPO getOrderInfo(String orderID) throws RemoteException {
		return orderDataHelper.getOrderInfo(orderID);
	}

	@Override
	public ResultMessage addOrderState(OrderStatePO po) throws RemoteException {
		return orderDataHelper.addOrderState(po);
	}

	@Override
	public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException {
		return orderDataHelper.setOrderRemark(po);
	}

	@Override
	public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException {
		return orderDataHelper.setCheckintime(po);
	}

	@Override
	public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException {
		return orderDataHelper.setCheckouttime(po);
	}

	@Override
	public ResultMessage addOrder(OrderInfoPO po) throws RemoteException {
		return orderDataHelper.addOrder(po);
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(TypeInfoPO po) throws RemoteException {
		return orderDataHelper.getOrderList(po);
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(String hotelID) throws RemoteException {
		return orderDataHelper.getOrderList(hotelID);
	}

}
