package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.hoteldao.HotelDao;
import data.datahelper.HotelDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import util.ResultMessage;

/**
 * HotelDao的实现
 * 
 * @author csy
 *
 */
public class HotelDaoImpl extends UnicastRemoteObject implements HotelDao {

	private static final long serialVersionUID = 2276917735276620811L;
	private static HotelDao hotelDao;
	private DataFactory dataFactory;
	private HotelDataHelper hotelDataHelper;

	static {
		try {
			hotelDao = new HotelDaoImpl();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static HotelDao getInstance() throws RemoteException {

		return hotelDao;
	}

	private HotelDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
		hotelDataHelper = dataFactory.getHotelDataHelper();
	}

	@Override
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException {
		return hotelDataHelper.getHotelBasicInfo(hotelID);
	}

	@Override
	public ResultMessage addRemarkInfo(RemarkPO po) throws RemoteException {
		return hotelDataHelper.addRemarkInfo(po);
	}

	@Override
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		return hotelDataHelper.addHotelBasicInfo(po);
	}

	@Override
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		return hotelDataHelper.setHotelBasicInfo(po);
	}

	@Override
	public ResultMessage setBestPrice(HotelBestPricePO po) throws RemoteException {
		return hotelDataHelper.setBestPrice(po);
	}
}
