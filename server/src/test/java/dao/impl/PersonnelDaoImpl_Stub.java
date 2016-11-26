package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.personneldao.PersonnelDao;
import po.PersonDetailPO;
import po.PersonListPO;
import util.ResultMessage;
import util.UserType;

public class PersonnelDaoImpl_Stub extends UnicastRemoteObject implements PersonnelDao {

	
	public PersonnelDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage checkUserName(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addPerson(PersonDetailPO personDetailPO) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PersonListPO> getPersonList(UserType userType, String userName, int userID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDetailPO getPersonDetail(int userID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPerson(PersonDetailPO personDetailPO) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
