package dao.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import org.junit.experimental.theories.Theories;

import dao.logdao.LogDao;
import po.ClientPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import ui.LogInfo;
import ui.UserPanel;
import util.ResultMessage;

public class LogDaoImpl extends UnicastRemoteObject implements LogDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3318229575335063154L;
	private static LogDao logDao;
	private UserPanel panel;

	static {
		try {
			logDao = new LogDaoImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static LogDao getInstance() {
		return logDao;
	}

	private LogDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
	}

	public void setPanel(UserPanel panel) {
		this.panel = panel;
	}

	@Override
	public ResultMessage logIn(ClientPO po) throws RemoteException, ServerNotActiveException, UnknownHostException {
		String clienthost = RemoteServer.getClientHost();
		InetAddress ia = java.net.InetAddress.getByName(clienthost);
		String clientIp = ia.getHostAddress();
		LogInfo info = new LogInfo(po.getUserName(), po.getPassword(), po.getType().getString(), clientIp);
		return panel.addList(info);
	}

	@Override
	public ResultMessage logOut(String userName) throws RemoteException {
		// String userName = po.getUserName();
		return panel.deleteList(userName);
	}
}
