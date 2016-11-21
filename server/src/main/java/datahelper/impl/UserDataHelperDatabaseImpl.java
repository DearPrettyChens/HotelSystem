package datahelper.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import data.datahelper.UserDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.ClientPO;
import util.ResultMessage;

public class UserDataHelperDatabaseImpl implements UserDataHelper {

	@Override
	public ClientPO getUserPassword(String name) {
		// Configuration cfg = new AnnotationConfiguration();
		// SessionFactory sf = cfg.configure().buildSessionFactory();
		// Session session = sf.openSession();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from ClientPO where user_name=:name";
		Query query = session.createQuery(sql);
		query.setString("name", name);
		List<ClientPO> result = query.list();
		session.close();
		if (result.size() == 0) {
			return null;
		}
		return result.get(0).copy();
	}

	@Override
	public ResultMessage setUserPassword(ClientPO po) {
		// Configuration cfg = new AnnotationConfiguration();
		// SessionFactory sf = cfg.configure().buildSessionFactory();
		// Session session = sf.openSession();
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from ClientPO where user_id = " + po.getUserID());
		List<ClientPO> result = query.list();
		try {
			result.get(0).setPassword(po.getPassword());
			session.update(result.get(0));
		} catch (NullPointerException e) {
			return ResultMessage.FAIL;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

}
