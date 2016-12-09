package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

import data.datahelper.CheckInDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.CheckinInfoPO;
import util.ResultMessage;

public class CheckInDataHelperDatabaseImpl implements CheckInDataHelper {

	@Override
	public ResultMessage addCheckinInfo(CheckinInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		//新增po
		CheckinInfoPO savepo = po.copy();
		try {
			session.save(savepo);
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
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
		session.close();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0).copy();
	}

	@Override
	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		//从数据库取出po
		Query query = session.createQuery("from CheckinInfoPO where order_id = '" + po.getOrdernumber() + "'");
		List<CheckinInfoPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		list.get(0).setCheckouttime(po.getCheckouttime());
		try {
			session.update(list.get(0));
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
		} finally {
			// session.getTransaction().commit();
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

}
