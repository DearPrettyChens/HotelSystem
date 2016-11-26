package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.webstrategydao.WebStrategyDao;
import po.GradeRulePO;
import po.WebStrPO;
import util.ResultMessage;
import util.WebStrategyType;

public class WebStrategyDaoImpl_Stub extends UnicastRemoteObject implements WebStrategyDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WebStrategyDaoImpl_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public GradeRulePO getGradeRule() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebStrPO getWebStrategy(WebStrategyType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setGradeRule(GradeRulePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setWebStrategy(WebStrPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
