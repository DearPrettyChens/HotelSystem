package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.hotelstrategydao.HotelStrategyDao;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;

public class HotelStrategyDaoImpl_Stub extends UnicastRemoteObject implements HotelStrategyDao{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelStrategyDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
