package dao.driver;

import java.rmi.RemoteException;

import dao.impl.UserDaoImpl;
import dao.userdao.UserDao;
import po.ClientPO;

public class testuser {
	public void drive(UserDao userDao) throws RemoteException {
//		System.out.println(userDao.getUserPassword("Manager").getType());
		System.out.println(userDao.getUserPassword("小菲菲").getType());
//		ClientPO po = new ClientPO("小菲菲", "feifei", 1);
//		System.out.println(userDao.setPassword(po));

	}

	public static void main(String[] args) throws RemoteException {
		new testuser().drive(UserDaoImpl.getInstance());
	}
}
