package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.searchhoteldao.SearchHotelDao;
import data.datahelper.SearchHotelDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.HotelListPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
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

	static {
		try {
			searchHotelDao = new SearchHotelDaoImpl();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SearchHotelDao getInstance() throws RemoteException {

		return searchHotelDao;
	}

	private SearchHotelDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
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
