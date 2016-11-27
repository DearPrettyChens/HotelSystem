package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import dao.availableroomdao.AvailableRoomDao;
import data.datahelper.AvailableRoomDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import util.BedType;
import util.ResultMessage;

/**
 * AvailableRoomDao的实现
 * 
 * @author csy
 *
 */
public class AvailableRoomDaoImpl extends UnicastRemoteObject implements AvailableRoomDao {

	private static final long serialVersionUID = -572024053152986904L;
	private static AvailableRoomDao availableRoomDao;
	private static DataFactory dataFactory;
	private AvailableRoomDataHelper availableRoomDataHelper;

	public static AvailableRoomDao getInstance() {
		if (availableRoomDao == null) {
			try {
				availableRoomDao = new AvailableRoomDaoImpl();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return availableRoomDao;
	}

	private AvailableRoomDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
		availableRoomDataHelper = dataFactory.getAvailableRoomDataHelper();
	}

	@Override
	public ArrayList<AvailableRoomInfoPO> getAvailableRoomInfo(String hotelID) throws RemoteException {
		return availableRoomDataHelper.getAvailableRoomInfo(hotelID);
	}

	@Override
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		return availableRoomDataHelper.addAvailableRoomInfo(po);
	}

	@Override
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		return availableRoomDataHelper.modifyAvailableRoomInfo(po);
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) throws RemoteException {
		return availableRoomDataHelper.setAvailableRoomNumber(po);
	}

	@Override
	public double getRoomPrice(String hotelID, BedType bedType) throws RemoteException {
		return availableRoomDataHelper.getRoomPrice(hotelID, bedType);
	}

	@Override
	public AvailableRoomNumberPO getAvailableRoomNumber(String hotelID, Date date, BedType type)
			throws RemoteException {
		return availableRoomDataHelper.getAvailableRoomNumber(hotelID, date, type);
	}

	@Override
	public ResultMessage setBestPrice(ArrayList<AvailableRoomInfoPO> po) throws RemoteException {
		return availableRoomDataHelper.setBestPrice(po);
	}

}
