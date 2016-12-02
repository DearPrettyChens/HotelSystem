package dao.logdao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ClientPO;
import util.ResultMessage;
/**
 * 负责登陆与登出
 * @author CYF
 * @version 1.0
 * 
 */
public interface LogDao extends Remote {
	
	/**
	 * 登陆方法
	 * @param ClientPO 型
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage logIn(ClientPO po) throws RemoteException;

	/**
	 * 登出方法
	 * @param ClientPO 型
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage logOut(ClientPO po) throws RemoteException;
	
}
