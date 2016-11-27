package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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


	public static CheckinDao getInstance() throws RemoteException {
		if(checkinDao==null){
			checkinDao=new CheckinDaoImpl();
		}
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
