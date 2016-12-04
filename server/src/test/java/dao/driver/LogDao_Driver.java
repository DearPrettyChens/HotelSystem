package dao.driver;

import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;

import dao.logdao.LogDao;
import po.ClientPO;
import rmi.RMIHelper;
import ui.ServerFrame;
import util.UserType;

public class LogDao_Driver {
	public void drive() {
		ClientPO po = new ClientPO("name", "pas", 123, UserType.Customer);
		ServerFrame frame = new ServerFrame();
//		RMIHelper.connect();
//		try {
//			frame.getLogDao().logIn(po);
//		} catch (RemoteException | UnknownHostException | ServerNotActiveException e) {
//			System.out.println("fail");
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		new LogDao_Driver().drive();
	}
}
