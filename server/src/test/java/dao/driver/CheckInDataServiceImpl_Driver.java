package dao.driver;

import java.rmi.RemoteException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.checkindao.CheckinDao;
import dao.impl.CheckinDaoImpl;
import net.sf.cglib.core.NamingPolicy;
import po.CheckinInfoPO;
import util.BedType;

public class CheckInDataServiceImpl_Driver {
	public void drive(CheckinDao dao) throws RemoteException {
		CheckinInfoPO po = new CheckinInfoPO("CustomerA", "2", "12345678910", "BigRoom", BedType.BIGBED, "406",
				new Date(), new Date(), 1, "20161121000001000002");
		System.out.println(dao.addCheckinInfo(po));

		po = dao.getCheckinInfo("20161121000001000002");
		System.out.println(po.getName() + " " + po.getID() + " " + po.getTel() + " " + po.getRoomtype() + " "
				+ po.getBedtype() + " " + po.getRoomnumber() + " " + po.getCheckintime() + " " + po.getCheckouttime()
				+ " " + po.getOrdernumber());

		po = new CheckinInfoPO("CustomerA", "2", "12345678910", "BigRoom", BedType.BIGBED, "405", new Date(), null, 1,
				"20161120000001000002");
		System.out.println(dao.addCheckinInfo(po));

		po.setCheckouttime(new Date());
		System.out.println(dao.modifyCheckinInfo(po));
		System.out.println(dao.getCheckinInfo("20161120000001000002").getCheckouttime());
	}

	public static void main(String[] args) throws RemoteException {
		new CheckInDataServiceImpl_Driver().drive(CheckinDaoImpl.getInstance());
	}
}
