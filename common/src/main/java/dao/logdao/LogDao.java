package dao.logdao;

import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

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
	 * @throws ServerNotActiveException 
	 * @throws UnknownHostException 
	 */
	public ResultMessage logIn(ClientPO po) throws RemoteException, ServerNotActiveException, UnknownHostException;

	/**
	 * 登出方法
	 * @param ClientPO 型
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage logOut(String userName) throws RemoteException;
}
