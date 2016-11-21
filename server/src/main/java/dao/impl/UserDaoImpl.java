package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import dao.userdao.UserDao;
import data.datahelper.UserDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import init.HibernateUtil;
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
	private static UserDaoImpl userDao;
	private DataFactory dataFactory;
	private UserDataHelper userDataHelper;

	public static UserDao getInstance() throws RemoteException {
		if (userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

	private UserDaoImpl() throws RemoteException {
		super();
		if(dataFactory==null){
			dataFactory = new DataFactoryImpl();
			userDataHelper = dataFactory.getUserDataHelper();
		}
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
