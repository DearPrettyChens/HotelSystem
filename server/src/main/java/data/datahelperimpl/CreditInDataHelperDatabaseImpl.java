package data.datahelperimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import data.datahelper.CreditDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.CreditInfoPO;
import po.CreditPO;
import po.CustomerDetailPO;
import util.ResultMessage;

public class CreditInDataHelperDatabaseImpl implements CreditDataHelper {

	@Override
	public ResultMessage setCredit(CreditPO po) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
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
		CreditPO creditPO = new CreditPO(po.getName(), po.getID(), po.getCredit(), po.getCreditChange(), po.getReason(),
				po.getTime());
		try {
			session.save(creditPO);
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
	public CreditInfoPO getCreditInfo(String customerID) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from CreditPO where user_id = " + customerID);
		List<CreditPO> list = query.list();
		List<CreditPO> copyList = new ArrayList<CreditPO>();
		if (list == null)
			return null;
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
