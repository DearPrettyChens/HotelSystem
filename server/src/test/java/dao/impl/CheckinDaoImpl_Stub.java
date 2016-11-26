package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.checkindao.CheckinDao;
import po.CheckinInfoPO;
import util.ResultMessage;

public class CheckinDaoImpl_Stub extends UnicastRemoteObject implements CheckinDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckinDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage addCheckinInfo(CheckinInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public CheckinInfoPO getCheckinInfo(String orderID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
