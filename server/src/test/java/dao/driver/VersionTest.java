package dao.driver;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

import datahelper.databaseutility.HibernateUtil;
import po.PersonDetailPO;

public class VersionTest {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Session session2 = HibernateUtil.getSession();
		Transaction transaction1 = session.beginTransaction();
		Transaction transaction2 = session2.beginTransaction();

		try {
			Query query = session.createQuery("from PersonDetailPO where user_id = 10");
			Query query2 = session2.createQuery("from PersonDetailPO where user_id = 10");
			List<PersonDetailPO> list1 = query.list();
			List<PersonDetailPO> list2 = query2.list();
			for (PersonDetailPO each : list1) {
				each.setCredit(each.getCredit() + 10);
				session.update(each);
			}
			transaction1.commit();
			for (PersonDetailPO each : list2) {
				each.setCredit(each.getCredit() + 50);
				session2.update(each);
			}
			 transaction2.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction1 != null) {
				System.out.println("Session1 commit again");
				transaction1.rollback();
			}
			if (transaction2 != null) {
				System.out.println("Session2 commit again");
				transaction2.rollback();
			}
		} finally {
			session.close();
			session2.close();
		}
	}
}
