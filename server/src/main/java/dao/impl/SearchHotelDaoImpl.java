package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.searchhoteldao.SearchHotelDao;
import data.datahelper.SearchHotelDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.HotelListPO;
import util.HotelSortType;

/**
 * SearchHotelDao的实现
 * 
 * @author csy
 *
 */
public class SearchHotelDaoImpl extends UnicastRemoteObject implements SearchHotelDao {

	private static final long serialVersionUID = 1415107901343055249L;
	private static SearchHotelDao searchHotelDao;
	private DataFactory dataFactory;
	private SearchHotelDataHelper searchHotelDataHelper;

	public static SearchHotelDao getInstance() throws RemoteException {
		if(searchHotelDao==null){
			searchHotelDao = new SearchHotelDaoImpl();
		}
		return searchHotelDao;
	}

	private SearchHotelDaoImpl() throws RemoteException {
		super();
		dataFactory = new DataFactoryImpl();
		searchHotelDataHelper = dataFactory.getSearchHotelDataHelper();
	}

	@Override
	public ArrayList<HotelListPO> getHotelList() throws RemoteException {
		return searchHotelDataHelper.getHotelList();
	}

	@Override
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type) throws RemoteException {
		return searchHotelDataHelper.getSortedHotelList(type);
	}

}
