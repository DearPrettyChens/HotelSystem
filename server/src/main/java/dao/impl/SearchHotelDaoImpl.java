package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.searchhoteldao.SearchHotelDao;
import po.HotelListPO;
import util.HotelSortType;

/**
 *  SearchHotelDao的实现
 * @author csy
 *
 */
public class SearchHotelDaoImpl extends UnicastRemoteObject implements SearchHotelDao{

	private static final long serialVersionUID = 1415107901343055249L;
	private static SearchHotelDao searchHotelDao;
		
	    public static SearchHotelDao getInstance() throws RemoteException {
			if(searchHotelDao==null){
				searchHotelDao=new SearchHotelDaoImpl();
			}
			return searchHotelDao;
		}

	    private SearchHotelDaoImpl() throws RemoteException {
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
