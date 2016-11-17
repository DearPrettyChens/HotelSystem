package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.creditdao.CreditDao;
import po.CreditInfoPO;
import po.CreditPO;
import util.ResultMessage;

/**
 * CheckinDao的实现
 * 
 * @author csy
 *
 */
public class CreditDaoImpl extends UnicastRemoteObject implements CreditDao {

	private static final long serialVersionUID = -6481742211743463639L;
	private static CreditDao creditDao;

	public static CreditDao getInstance() throws RemoteException {
		if (creditDao == null) {
			creditDao = new CreditDaoImpl();
		}
		return creditDao;
	}

	private CreditDaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage setCredit(CreditPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditInfoPO getCreditInfo(String customerID) {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD:server/src/main/java/dao/impl/CreditDaoImpl.java
	@Override
	public CreditInfoPO getCreditInfoByName(String customerName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
=======
>>>>>>> origin/master:server/src/main/java/dao/creditdaoimpl/CreditDaoImpl.java
}
