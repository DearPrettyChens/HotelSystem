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
import ui.ServerPanel;
import util.ResultMessage;

public class LogDaoImpl extends UnicastRemoteObject implements LogDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3318229575335063154L;
	// private static final ServerPanel ServerPanel = null;
	private static LogDao logDao;
	private ServerPanel panel;

	public static LogDao getInstance() {
		if (logDao == null) {
			try {
				logDao = new LogDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return logDao;
	}

	private LogDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
//		this.setPanel(panel);
	}

	public void setPanel(ServerPanel panel) {
		this.panel = panel;
	}

	@Override
	public void logIn(ClientPO po) throws RemoteException, ServerNotActiveException, UnknownHostException {
		String clienthost = RemoteServer.getClientHost();
		InetAddress ia = java.net.InetAddress.getByName(clienthost);
		String clientIp = ia.getHostAddress();
		LogInfo info = new LogInfo(po.getUserName(), po.getPassword(), po.getType().getString(), clientIp);
		panel.addList(info);
	}

	@Override
	public ResultMessage logOut(ClientPO po) throws RemoteException {
		String userName = po.getUserName();
		return panel.deleteList(userName);
	}
}
