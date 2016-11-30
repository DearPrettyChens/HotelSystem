package data.datahelperimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import data.datahelper.UserDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.ClientPO;
import util.ResultMessage;

public class UserDataHelperDatabaseImpl implements UserDataHelper {

	@Override
	public ClientPO getUserPassword(String name) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from ClientPO where user_name=:name";
		Query query = session.createQuery(sql);
		query.setString("name", name);
		List<ClientPO> result = query.list();
		session.close();
		if (result.size() == 0) {
			//无该用户
			return null;
		}
		return result.get(0).copy();
	}

	@Override
	public ResultMessage setUserPassword(ClientPO po) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from ClientPO where user_id = " + po.getUserID());
		List<ClientPO> result = query.list();
		if (result.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		try {
			result.get(0).setPassword(po.getPassword());
			session.update(result.get(0));
			transaction.commit();
		} catch (StaleObjectStateException e) {
			//修改冲突
			//返回结果要求重新提交一次信息
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMITAGAIN;
		} finally {
//			session.getTransaction().commit();
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

}
