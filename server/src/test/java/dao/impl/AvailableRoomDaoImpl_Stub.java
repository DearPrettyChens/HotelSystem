package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import dao.availableroomdao.AvailableRoomDao;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;

public class AvailableRoomDaoImpl_Stub extends UnicastRemoteObject implements AvailableRoomDao {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AvailableRoomDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getRoomPrice(String hotelID,BedType bedType) {
		// TODO Auto-generated method stub
		return 100.00;
	}

	@Override
	public ArrayList<AvailableRoomInfoPO> getAvailableRoomInfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvailableRoomNumberPO getAvailableRoomNumber(String hotelID, Date date, BedType type)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setBestPrice(ArrayList<AvailableRoomInfoPO> po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	

}
