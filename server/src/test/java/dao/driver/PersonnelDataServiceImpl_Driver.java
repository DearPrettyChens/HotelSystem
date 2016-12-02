package dao.driver;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.mysql.fabric.xmlrpc.base.Data;

import dao.impl.PersonnelDaoImpl;
import dao.personneldao.PersonnelDao;
import po.PersonDetailPO;
import po.PersonListPO;
import util.CustomerType;
import util.UserType;

public class PersonnelDataServiceImpl_Driver {
	public void drive(PersonnelDao dao) throws RemoteException {
		Image image = null;
		try {
			image = ImageIO.read(new File("/Users/chengyunfei/Documents/红楼/水墨红楼(最好看的一版)/黛玉.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		PersonDetailPO personDetailPO = new PersonDetailPO(0, "CustomerB", new ImageIcon(image), "12345678910", 0,
				new Date(), null, CustomerType.INDIVIDUAL, "123456", null, UserType.Customer);
		System.out.println(dao.addPerson(personDetailPO));
		PersonDetailPO po = dao.getPersonDetail(1);
		System.out.println(po.getName() + " " + po.getId() + " " + po.getCredit());

		System.out.println(dao.checkUserName("CustomerB"));
		System.out.println(dao.checkUserName("CustomerC"));

		personDetailPO.setCredit(10);
		System.out.println(dao.setPerson(personDetailPO));

		po = dao.getPersonDetail(1);
		System.out.println(po.getName() + " " + po.getId() + " " + po.getCredit());

		ArrayList<PersonListPO> list = dao.getPersonList(UserType.Customer, null, 0);
		for (PersonListPO each : list) {
			System.out.println(each.getName());
		}
		list = dao.getPersonList(null, "CustomerB", 0);
		for (PersonListPO each : list) {
			System.out.println(each.getName());
		}
		list = dao.getPersonList(null, null, 9);
		for (PersonListPO each : list) {
			System.out.println(each.getName());
		}

	}

	public void testClientCode(PersonnelDao dao) throws RemoteException {
//		PersonDetailPO personDetailVO2=new PersonDetailPO(0, "小俐俐",   null,"12345678901",0,null, null,null,"xiaolili","锦江之星大酒店", UserType.HotelWorker);
//		Personnel personnel= Personnel.getInstance();
//		System.out.println(dao.addPerson(personDetailVO2));
//		PersonListPO vo1=dao.getPersonList(null,"小俐俐",0).get(0);
//		System.out.println(vo1.getHotelName());
		PersonDetailPO po = dao.getPersonDetail(2);
		System.out.println(po.getId()+" "+po.getBirthday());
	}

	public static void main(String[] args) throws RemoteException {
//		new PersonnelDataServiceImpl_Driver().drive(PersonnelDaoImpl.getInstance());
		new PersonnelDataServiceImpl_Driver().testClientCode(PersonnelDaoImpl.getInstance());
	}
}
