package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.creditdao.CreditDao;
import po.CreditInfoPO;
import po.CreditPO;
import util.ResultMessage;

public class CreditDaoImpl_Stub extends UnicastRemoteObject implements CreditDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 922853343991423829L;

	public CreditDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage setCredit(CreditPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public CreditInfoPO getCreditInfo(String customerID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
