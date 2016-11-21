package dao.driver;

import java.rmi.RemoteException;

import dao.impl.UserDaoImpl;
import dao.userdao.UserDao;

import po.ClientPO;

public class UserDataServiceImpl_Driver {
	public void drive(UserDao userDao) throws RemoteException {
		System.out.println(userDao.getUserPassword("Manager").getPassword());
		ClientPO po = new ClientPO("Manager", "123456", 1);
		System.out.println(userDao.setPassword(po));

	}

	public static void main(String[] args) throws RemoteException {
		new UserDataServiceImpl_Driver().drive(UserDaoImpl.getInstance());
	}
}
