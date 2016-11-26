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
import po.TypeInfoPO;
import util.ResultMessage;

public class OrderDaoImpl_Stub extends UnicastRemoteObject implements OrderDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -440035251400309532L;

	public OrderDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrderInfoPO getOrderInfo(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(TypeInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrderState(OrderStatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addOrder(OrderInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
