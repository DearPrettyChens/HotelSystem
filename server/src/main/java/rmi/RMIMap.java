package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import dao.DaoName;
import dao.availableroomdao.AvailableRoomDao;
import dao.checkindao.CheckinDao;
import dao.creditdao.CreditDao;
import dao.hoteldao.HotelDao;
import dao.hotelstrategydao.HotelStrategyDao;
import dao.impl.AvailableRoomDaoImpl;
import dao.impl.CheckinDaoImpl;
import dao.impl.CreditDaoImpl;
import dao.impl.HotelDaoImpl;
import dao.impl.HotelStrategyDaoImpl;
import dao.impl.LogDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.PersonnelDaoImpl;
import dao.impl.SearchHotelDaoImpl;
import dao.impl.UserDaoImpl;
import dao.impl.WebStrategyDaoImpl;
import dao.logdao.LogDao;
import dao.orderdao.OrderDao;
import dao.personneldao.PersonnelDao;
import dao.searchhoteldao.SearchHotelDao;
import dao.userdao.UserDao;
import dao.webstrategydao.WebStrategyDao;

/**
 * 
 * 用于建立对应的dao表，方便遍历，方便修改
 * 运用组合实现Map的功能
 * @author CSY
 *
 */
public class RMIMap {
	private Map<String, Object> map;
	private static RMIMap rmiMap;
	private Iterator<Map.Entry<String,Object>> entries;
	private Map.Entry<String, Object> entry;	
	
	private AvailableRoomDao availableRoomDao;
	private CheckinDao checkinDao;
	private CreditDao creditDao;
	private HotelDao hotelDao;
	private HotelStrategyDao hotelStrategyDao;
	private OrderDao orderDao;
	private PersonnelDao personnelDao;
	private SearchHotelDao searchHotelDao;
	private UserDao userDao;
	private WebStrategyDao webStrategyDao;
	private LogDao logDao;
	
	private static UnicastRemoteObject dao;

	private RMIMap() {
		try {
			map=new ConcurrentHashMap<String, Object>();
			init();
			entries = map.entrySet().iterator();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static RMIMap getInstance() {
		if (rmiMap == null) {
			rmiMap = new RMIMap();
		}
		return rmiMap;
	}

	private void init() throws RemoteException {
		createDAO();
		map.put(DaoName.AvailableRoomDao.name(), availableRoomDao);
		map.put(DaoName.CheckinDao.name(), checkinDao);
		map.put(DaoName.CreditDao.name(), creditDao);
		map.put(DaoName.HotelDao.name(), hotelDao);
		map.put(DaoName.HotelStrategyDao.name(), hotelStrategyDao);
		map.put(DaoName.OrderDao.name(), orderDao);
		map.put(DaoName.PersonnelDao.name(), personnelDao);
		map.put(DaoName.SearchHotelDao.name(), searchHotelDao);
		map.put(DaoName.UserDao.name(), userDao);
		map.put(DaoName.WebStrategyDao.name(), webStrategyDao);
		map.put(DaoName.LogDao.name(), logDao);
	}

	private void createDAO() throws RemoteException {
		availableRoomDao =AvailableRoomDaoImpl.getInstance();
		checkinDao = CheckinDaoImpl.getInstance();
		creditDao = CreditDaoImpl.getInstance();
		hotelDao = HotelDaoImpl.getInstance();
		hotelStrategyDao = HotelStrategyDaoImpl.getInstance();
		orderDao = OrderDaoImpl.getInstance();
		personnelDao = PersonnelDaoImpl.getInstance();
		searchHotelDao = SearchHotelDaoImpl.getInstance();
		userDao = UserDaoImpl.getInstance();
		webStrategyDao = WebStrategyDaoImpl.getInstance();
		logDao = LogDaoImpl.getInstance();
	}


	
	public boolean hasNext(){
		boolean hasNext= entries.hasNext();
		if(!hasNext){
			entries=map.entrySet().iterator();
		}
		return hasNext;
	}
	public void next() {
		entry=entries.next();
	}
	
	public String getDaoName() {
	    String name=entry.getKey();
		return name;
	}
	
	public UnicastRemoteObject getDao() {
//		UnicastRemoteObject 
		dao=(UnicastRemoteObject) entry.getValue();
		return dao;
	}
	
}
