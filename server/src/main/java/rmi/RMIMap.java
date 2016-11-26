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
import dao.impl.AvailableRoomDaoImpl_Stub;
import dao.impl.CheckinDaoImpl;
import dao.impl.CheckinDaoImpl_Stub;
import dao.impl.CreditDaoImpl;
import dao.impl.CreditDaoImpl_Stub;
import dao.impl.HotelDaoImpl;
import dao.impl.HotelDaoImpl_Stub;
import dao.impl.HotelStrategyDaoImpl;
import dao.impl.HotelStrategyDaoImpl_Stub;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderDaoImpl_Stub;
import dao.impl.PersonnelDaoImpl;
import dao.impl.PersonnelDaoImpl_Stub;
import dao.impl.SearchHotelDaoImpl;
import dao.impl.SearchHotelDaoImpl_Stub;
import dao.impl.UserDaoImpl;
import dao.impl.UserDaoImpl_Stub;
import dao.impl.WebStrategyDaoImpl;
import dao.impl.WebStrategyDaoImpl_Stub;
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
//		createDAO();
		createDAO_Stub();
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
	}

	private void createDAO() throws RemoteException {
		availableRoomDao = AvailableRoomDaoImpl.getInstance();
		checkinDao = CheckinDaoImpl.getInstance();
		creditDao = CreditDaoImpl.getInstance();
		hotelDao = HotelDaoImpl.getInstance();
		hotelStrategyDao = HotelStrategyDaoImpl.getInstance();
		orderDao = OrderDaoImpl.getInstance();
		personnelDao = PersonnelDaoImpl.getInstance();
		searchHotelDao = SearchHotelDaoImpl.getInstance();
		userDao = UserDaoImpl.getInstance();
		webStrategyDao = WebStrategyDaoImpl.getInstance();
	}

	public void createDAO_Stub() throws RemoteException {
		availableRoomDao = new AvailableRoomDaoImpl_Stub();
		checkinDao = new CheckinDaoImpl_Stub();
		creditDao = new CreditDaoImpl_Stub();
		hotelDao = new HotelDaoImpl_Stub();
		hotelStrategyDao =new HotelStrategyDaoImpl_Stub();
		orderDao =new OrderDaoImpl_Stub();
		personnelDao = new PersonnelDaoImpl_Stub();
		searchHotelDao =new SearchHotelDaoImpl_Stub();
		userDao =new UserDaoImpl_Stub();
		webStrategyDao =new WebStrategyDaoImpl_Stub();
	}
	
	public boolean hasNext(){
		return entries.hasNext();
	}
	public void next() {
		entry=entries.next();
	}
	
	public String getDaoName() {
	    String name=entry.getKey();
		return name;
	}
	
	public UnicastRemoteObject getDao() {
		UnicastRemoteObject dao=(UnicastRemoteObject) entry.getValue();
		return dao;
	}
	
}