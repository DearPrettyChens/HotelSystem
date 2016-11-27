package init;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dao.DaoName;
import dao.availableroomdao.AvailableRoomDao;
import dao.checkindao.CheckinDao;
import dao.creditdao.CreditDao;
import dao.hoteldao.HotelDao;
import dao.hotelstrategydao.HotelStrategyDao;
import dao.orderdao.OrderDao;
import dao.personneldao.PersonnelDao;
import dao.searchhoteldao.SearchHotelDao;
import dao.userdao.UserDao;
import dao.webstrategydao.WebStrategyDao;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;

/**
 * RMI配置
 * @author csy
 *
 */
public class RMIHelper {

	private static AvailableRoomDao availableRoomDao;
	private static CheckinDao checkinDao;
	private static CreditDao creditDao;
	private static HotelDao hotelDao;
	private static HotelStrategyDao hotelStrategyDao;
	private static OrderDao orderDao;
	private static PersonnelDao personnelDao;
	private static SearchHotelDao searchHotelDao;
	private static UserDao userDao;
	private static WebStrategyDao webStrategyDao;
	
	private static String url = RMIconfig.getUrl();

	
	 public static void init() {
		 try {
			 //根据服务器端的IP，端口号和套接字工厂来进行注册
			Registry registry = LocateRegistry.getRegistry(RMIconfig.getIp(),RMIconfig.getPort(),  
					new RMISSLClientSocketFactory());
		 
				availableRoomDao=(AvailableRoomDao) registry.lookup(DaoName.AvailableRoomDao.name());
				checkinDao = (CheckinDao) registry.lookup( DaoName.CheckinDao.name());
				creditDao = (CreditDao) registry.lookup(DaoName.CreditDao.name());
				hotelDao = (HotelDao) registry.lookup(DaoName.HotelDao.name());
				hotelStrategyDao = (HotelStrategyDao) registry.lookup(DaoName.HotelStrategyDao.name());
				orderDao = (OrderDao)registry.lookup(DaoName.OrderDao.name());
				personnelDao = (PersonnelDao) registry.lookup(DaoName.PersonnelDao.name());
				searchHotelDao = (SearchHotelDao) registry.lookup( DaoName.SearchHotelDao.name());
				userDao = (UserDao) registry.lookup( DaoName.UserDao.name());
				webStrategyDao = (WebStrategyDao) registry.lookup( DaoName.WebStrategyDao.name());
				
		 
		 
		 } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		public static AvailableRoomDao getAvailableRoomDao() {
			return availableRoomDao;
		}

		public static CheckinDao getCheckinDao() {
			return checkinDao;
		}

		public static CreditDao getCreditDao() {
			return creditDao;
		}

		public static HotelDao getHotelDao() {
			return hotelDao;
		}

		public static HotelStrategyDao getHotelStrategyDao() {
			return hotelStrategyDao;
		}

		public static OrderDao getOrderDao() {
			return orderDao;
		}

		public static PersonnelDao getPersonnelDao() {
			return personnelDao;
		}

		public static SearchHotelDao getSearchHotelDao() {
			return searchHotelDao;
		}

		public static UserDao getUserDao() {
			return userDao;
		}

		public static WebStrategyDao getWebStrategyDao() {
			return webStrategyDao;
		}

}
