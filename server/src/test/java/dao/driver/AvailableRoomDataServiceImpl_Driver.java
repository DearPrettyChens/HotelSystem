package dao.driver;

import java.rmi.RemoteException;

import dao.availableroomdao.AvailableRoomDao;
import dao.impl.AvailableRoomDaoImpl;

public class AvailableRoomDataServiceImpl_Driver {
	public void drive(AvailableRoomDao dao) {

	}

	public static void main(String[] args) throws RemoteException {
		new AvailableRoomDataServiceImpl_Driver().drive(AvailableRoomDaoImpl.getInstance());
	}
}
