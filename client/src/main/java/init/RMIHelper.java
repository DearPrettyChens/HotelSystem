package init;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
					availableRoomDao = (AvailableRoomDao) Naming.lookup(url + DaoName.AvailableRoomDao.name());
					checkinDao = (CheckinDao) Naming.lookup(url + DaoName.CheckinDao.name());
					creditDao = (CreditDao) Naming.lookup(url + DaoName.CreditDao.name());
					hotelDao = (HotelDao) Naming.lookup(url + DaoName.HotelDao.name());
					hotelStrategyDao = (HotelStrategyDao) Naming.lookup(url + DaoName.HotelStrategyDao.name());
					orderDao = (OrderDao) Naming.lookup(url + DaoName.OrderDao.name());
					personnelDao = (PersonnelDao) Naming.lookup(url + DaoName.PersonnelDao.name());
					searchHotelDao = (SearchHotelDao) Naming.lookup(url + DaoName.SearchHotelDao.name());
					userDao = (UserDao) Naming.lookup(url + DaoName.UserDao.name());
					webStrategyDao = (WebStrategyDao) Naming.lookup(url + DaoName.WebStrategyDao.name());
				
	            } catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
