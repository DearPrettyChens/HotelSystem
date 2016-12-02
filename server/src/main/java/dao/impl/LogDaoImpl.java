package dao.impl;

import java.rmi.RemoteException;

import dao.logdao.LogDao;
import po.ClientPO;
import util.ResultMessage;

public class LogDaoImpl implements LogDao {

	@Override
	public ResultMessage logIn(ClientPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage logOut(ClientPO po) throws RemoteException {
		return null;
	}
}
