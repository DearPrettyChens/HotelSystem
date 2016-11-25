package dao.driver;

import java.rmi.RemoteException;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.impl.PersonnelDaoImpl;
import dao.personneldao.PersonnelDao;
import po.PersonDetailPO;
import util.CustomerType;
import util.UserType;

public class PersonnelDataServiceImpl_Driver {
	public void drive(PersonnelDao dao) throws RemoteException {
		PersonDetailPO personDetailPO = new PersonDetailPO(0, "CustomerB", null, "12345678910", 0, new Date(), null,
				CustomerType.INDIVIDUAL, "123456", null, UserType.Customer);
		System.out.println(dao.addPerson(personDetailPO));
		PersonDetailPO po = dao.getPersonDetail(1);
		System.out.println(po.getName() + " " + po.getId() + " " + po.getCredit());

		System.out.println(dao.checkUserName("CustomerB"));
		System.out.println(dao.checkUserName("CustomerC"));

		personDetailPO.setCredit(10);
		System.out.println(dao.setPerson(personDetailPO));

		po = dao.getPersonDetail(1);
		System.out.println(po.getName() + " " + po.getId() + " " + po.getCredit());
		
	}

	public static void main(String[] args) throws RemoteException {
		new PersonnelDataServiceImpl_Driver().drive(PersonnelDaoImpl.getInstance());
	}
}
