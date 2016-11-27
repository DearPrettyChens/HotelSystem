package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.creditdao.CreditDao;
import data.datahelper.CreditDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.CreditInfoPO;
import po.CreditPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
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

	public static CreditDao getInstance() throws RemoteException {
		if(creditDao==null){
			try {
				creditDao=new CreditDaoImpl();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return creditDao;
	}

	private CreditDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(),new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
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
