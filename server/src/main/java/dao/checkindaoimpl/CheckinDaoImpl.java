package dao.checkindaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.checkindao.CheckinDao;
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

	public static CheckinDao getInstance() throws RemoteException {
		if (checkinDao == null) {
			checkinDao = new CheckinDaoImpl();
		}
		return checkinDao;
	}

	private CheckinDaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage addCheckinInfo(CheckinInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckinInfoPO getCheckinInfo(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
