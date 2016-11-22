package dao.driver;

import java.rmi.RemoteException;
import java.util.Date;

import dao.creditdao.CreditDao;
import dao.impl.CreditDaoImpl;
import po.CreditInfoPO;
import po.CreditPO;

public class CreditDataHelperServiceImpl_Driver {
	public void drive(CreditDao dao) throws RemoteException {
		CreditPO po = new CreditPO("CustomerA", 2, 100, 100, "充值", new Date(System.currentTimeMillis()));
		System.out.println(dao.setCredit(po));
		po.setCredit(200);
		System.out.println(dao.setCredit(po));
		CreditInfoPO list = dao.getCreditInfo("2");
		for (CreditPO each : list.getCreditRecords()) {
			System.out.println(
					each.getName() + " " + each.getCreditChange() + " " + each.getCredit() + " " + each.getReason()+" "+each.getTime());
		}
	}

	public static void main(String[] args) throws RemoteException {
		new CreditDataHelperServiceImpl_Driver().drive(CreditDaoImpl.getInstance());
	}
}
