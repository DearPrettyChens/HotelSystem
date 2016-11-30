package data.datahelperimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

import data.datahelper.CreditDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.CreditInfoPO;
import po.CreditPO;
import util.ResultMessage;

public class CreditInDataHelperDatabaseImpl implements CreditDataHelper {

	@Override
	public ResultMessage setCredit(CreditPO po) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		// Query query = session.createQuery("from CustomerDetailPO where
		// user_id = " + po.getID());
		// List<CustomerDetailPO> customerPOList = query.list();
		// if (customerPOList == null)
		// return ResultMessage.FAIL;
		// customerPOList.get(0).setCredit(po.getCredit());
		// try {
		// session.update(customerPOList.get(0));
		// session.getTransaction().commit();
		// } catch (Exception e) {
		// e.printStackTrace();
		// session.getTransaction().rollback();
		// return ResultMessage.FAIL;
		// }
		CreditPO creditPO = po.copy();
		try {
			session.save(creditPO);
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMITAGAIN;
		} finally {
			// session.getTransaction().commit();
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public CreditInfoPO getCreditInfo(String customerID) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from CreditPO where user_id = " + customerID);
		List<CreditPO> list = query.list();
		List<CreditPO> copyList = new ArrayList<CreditPO>();
		if (list.size() == 0) {
			session.close();
			return null;
		}
		CreditInfoPO po = null;
		try {
			for (CreditPO each : list) {
				copyList.add(each.copy());
			}
			po = new CreditInfoPO(copyList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return po;
	}

}
