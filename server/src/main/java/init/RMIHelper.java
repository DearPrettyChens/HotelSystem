package init;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

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
import dao.impl.OrderDaoImpl;
import dao.impl.PersonnelDaoImpl;
import dao.impl.SearchHotelDaoImpl;
import dao.impl.UserDaoImpl;
import dao.impl.WebStrategyDaoImpl;
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
	private static int port = RMIconfig.getPort();

	public static void createDAO() throws RemoteException {
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

	public static void relate() {
		try {
			Naming.bind(url + DaoName.AvailableRoomDao.name(), availableRoomDao);
			Naming.bind(url + DaoName.CheckinDao.name(), checkinDao);
			Naming.bind(url + DaoName.CreditDao.name(), creditDao);
			Naming.bind(url + DaoName.HotelDao.name(), hotelDao);
			Naming.bind(url + DaoName.HotelStrategyDao.name(), hotelStrategyDao);
			Naming.bind(url + DaoName.OrderDao.name(), orderDao);
			Naming.bind(url + DaoName.PersonnelDao.name(), personnelDao);
			Naming.bind(url + DaoName.SearchHotelDao.name(), searchHotelDao);
			Naming.bind(url + DaoName.UserDao.name(), userDao);
			Naming.bind(url + DaoName.WebStrategyDao.name(), webStrategyDao);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void connect() {
		try {
			createDAO();
			LocateRegistry.createRegistry(port);
			relate();
			System.out.println("已连接");//为了测试用
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
