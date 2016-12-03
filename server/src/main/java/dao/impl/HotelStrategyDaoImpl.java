package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.hotelstrategydao.HotelStrategyDao;
import data.datahelper.HotelStrategyDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.HotelStrPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import util.HotelStrategyType;
import util.ResultMessage;

/**
 * CheckinDao的实现
 * 
 * @author csy
 *
 */
public class HotelStrategyDaoImpl extends UnicastRemoteObject implements HotelStrategyDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9114882706262722192L;
	private static HotelStrategyDao hotelStrategyDao;
	private DataFactory dataFactory;
	private HotelStrategyDataHelper hotelStrategyDataHelper;

	static {
		try {
			hotelStrategyDao = new HotelStrategyDaoImpl();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HotelStrategyDao getInstance() throws RemoteException {

		return hotelStrategyDao;
	}

	private HotelStrategyDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
		hotelStrategyDataHelper = dataFactory.getHotelStrategyDataHelper();
	}

	@Override
	public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) throws RemoteException {
		return hotelStrategyDataHelper.getHotelStrategy(hotelID, type);
	}

	@Override
	public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException {
		return hotelStrategyDataHelper.setHotelStrategy(po);
	}

}
