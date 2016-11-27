package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.userdao.UserDao;
import data.datahelper.UserDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.ClientPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import util.ResultMessage;

/**
 * UserDao的实现
 * 
 * @author csy
 *
 */
public class UserDaoImpl extends  UnicastRemoteObject implements UserDao {

	private static final long serialVersionUID = 2151592669947030124L;
	private static UserDao userDao;
	private static DataFactory dataFactory;
	private UserDataHelper userDataHelper;


	public static UserDao getInstance() throws RemoteException {
		if(userDao==null){
			try {
				userDao = new UserDaoImpl();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userDao;
	}

	private UserDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(),new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
		userDataHelper = dataFactory.getUserDataHelper();
	}

	@Override
	public ClientPO getUserPassword(String name) throws RemoteException {
		return userDataHelper.getUserPassword(name);
	}

	@Override
	public ResultMessage setPassword(ClientPO po) throws RemoteException {
		return userDataHelper.setUserPassword(po);
	}

}
