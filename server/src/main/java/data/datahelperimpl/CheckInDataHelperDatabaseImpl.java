package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import data.datahelper.CheckInDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.CheckinInfoPO;
import util.ResultMessage;

public class CheckInDataHelperDatabaseImpl implements CheckInDataHelper {

	@Override
	public ResultMessage addCheckinInfo(CheckinInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		CheckinInfoPO savepo = new CheckinInfoPO(po.getName(), po.getID(), po.getTel(), po.getRoomtype(),
				po.getBedtype(), po.getRoomnumber(), po.getCheckintime(), po.getCheckouttime(), po.getHotelnumber(),
				po.getOrdernumber());
		try {
			session.save(savepo);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public CheckinInfoPO getCheckinInfo(String orderID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from CheckinInfoPO where order_id = '" + orderID + "'");
		List<CheckinInfoPO> list = query.list();
		if (list.size() == 0) {
			return null;
		}
		session.close();
		return list.get(0).copy();
	}

	@Override
	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from CheckinInfoPO where order_id = '" + po.getOrdernumber() + "'");
		List<CheckinInfoPO> list = query.list();
		if (list.size() == 0) {
			return ResultMessage.FAIL;
		}
		list.get(0).setCheckouttime(po.getCheckouttime());
		try {
			session.update(list.get(0));
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

}
