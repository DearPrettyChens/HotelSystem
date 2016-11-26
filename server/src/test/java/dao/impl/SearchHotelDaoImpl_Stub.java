package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.searchhoteldao.SearchHotelDao;
import po.HotelListPO;
import util.HotelSortType;

public class SearchHotelDaoImpl_Stub extends UnicastRemoteObject implements SearchHotelDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6368461017737885931L;

	public SearchHotelDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<HotelListPO> getHotelList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
