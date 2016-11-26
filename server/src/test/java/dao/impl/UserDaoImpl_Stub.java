package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.userdao.UserDao;
import po.ClientPO;
import util.ResultMessage;

public class UserDaoImpl_Stub extends UnicastRemoteObject implements UserDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3109166316472127640L;

	public UserDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClientPO getUserPassword(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setPassword(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
