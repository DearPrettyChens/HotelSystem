package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.personneldao.PersonnelDao;
import data.datahelper.PersonnelDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.PersonDetailPO;
import po.PersonListPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import util.ResultMessage;
import util.UserType;

/**
 * PersonnelDao的实现
 * 
 * @author csy
 *
 */
public class PersonnelDaoImpl extends UnicastRemoteObject implements PersonnelDao {

	private static final long serialVersionUID = -2906427570970508819L;
	private static PersonnelDao personnelDao;
	private DataFactory dataFactory;
	private PersonnelDataHelper personnelDataHelper;

	static {
		try {
			personnelDao = new PersonnelDaoImpl();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PersonnelDao getInstance() throws RemoteException {

		return personnelDao;
	}

	private PersonnelDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
		personnelDataHelper = dataFactory.getPersonnelDataHelper();
	}

	@Override
	public ResultMessage addPerson(PersonDetailPO personDetailPO) throws RemoteException {
		return personnelDataHelper.addPerson(personDetailPO);
	}

	@Override
	public ArrayList<PersonListPO> getPersonList(UserType userType, String userName, int userID)
			throws RemoteException {
		return personnelDataHelper.getPersonList(userType, userName, userID);
	}

	@Override
	public PersonDetailPO getPersonDetail(int userID) throws RemoteException {
		return personnelDataHelper.getPersonDetail(userID);
	}

	@Override
	public ResultMessage setPerson(PersonDetailPO personDetailPO) throws RemoteException {
		return personnelDataHelper.setPerson(personDetailPO);
	}

	@Override
	public ResultMessage checkUserName(String userName) throws RemoteException {
		return personnelDataHelper.checkUserName(userName);
	}

}
