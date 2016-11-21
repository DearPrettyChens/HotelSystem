package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.userdao.UserDao;
import data.datahelper.UserDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryDatabaseImpl;
import po.ClientPO;
import util.ResultMessage;

/**
 * UserDao的实现
 * 
 * @author csy
 *
 */
public class UserDaoImpl extends UnicastRemoteObject implements UserDao {

	private static final long serialVersionUID = 2151592669947030124L;
	private static UserDao userDao;
	private static DataFactory dataFactory;
	private UserDataHelper userDataHelper;

	static {
		try {
			userDao = new UserDaoImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static UserDao getInstance() throws RemoteException {
		return userDao;
	}

	private UserDaoImpl() throws RemoteException {
		super();
		dataFactory = new DataFactoryDatabaseImpl();
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
