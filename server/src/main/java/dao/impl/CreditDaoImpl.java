package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.creditdao.CreditDao;
import data.datahelper.CreditDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryDatabaseImpl;
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
	private DataFactory dataFactory;
	private CreditDataHelper creditDataHelper;
	static {
		try {
			creditDao = new CreditDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static CreditDao getInstance() throws RemoteException {
		return creditDao;
	}

	private CreditDaoImpl() throws RemoteException {
		super();
		dataFactory = new DataFactoryDatabaseImpl();
		creditDataHelper = dataFactory.getCreditDataHelper();
	}

	@Override
	public ResultMessage setCredit(CreditPO po) {
		return creditDataHelper.setCredit(po);
	}

	@Override
	public CreditInfoPO getCreditInfo(String customerID) {
		return creditDataHelper.getCreditInfo(customerID);
	}

}
