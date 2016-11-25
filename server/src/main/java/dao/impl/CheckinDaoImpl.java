package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.checkindao.CheckinDao;
import data.datahelper.CheckInDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.CheckinInfoPO;
import util.ResultMessage;

/**
 * CheckinDao的实现
 * 
 * @author csy
 *
 */
public class CheckinDaoImpl extends UnicastRemoteObject implements CheckinDao {

	private static final long serialVersionUID = 4215636459437070989L;

	private static CheckinDao checkinDao;
	private DataFactory dataFactory;
	private CheckInDataHelper checkInDataHelper;

	static {
		try {
			checkinDao = new CheckinDaoImpl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CheckinDao getInstance() throws RemoteException {
		return checkinDao;
	}

	private CheckinDaoImpl() throws RemoteException {
		super();
		dataFactory = new DataFactoryImpl();
		checkInDataHelper = dataFactory.getCheckInDataHelper();
	}

	@Override
	public ResultMessage addCheckinInfo(CheckinInfoPO po) throws RemoteException {
		return checkInDataHelper.addCheckinInfo(po);
	}

	@Override
	public CheckinInfoPO getCheckinInfo(String orderID) throws RemoteException {
		return checkInDataHelper.getCheckinInfo(orderID);
	}

	@Override
	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) throws RemoteException {
		return checkInDataHelper.modifyCheckinInfo(po);
	}

}
