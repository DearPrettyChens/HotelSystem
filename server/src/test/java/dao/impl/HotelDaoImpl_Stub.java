package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.hoteldao.HotelDao;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ResultMessage;

public class HotelDaoImpl_Stub extends UnicastRemoteObject implements HotelDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9115636495799217964L;

	public HotelDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addRemarkInfo(RemarkPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setBestPrice(HotelBestPricePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
