package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

import data.datahelper.PersonnelDataHelper;
import datahelper.databaseutility.HibernateUtil;
import datahelper.databaseutility.ImageUtil;
import po.PersonDetailPO;
import po.PersonListPO;
import util.ImageType;
import util.ResultMessage;
import util.UserType;

public class PersonnelDataHelperDatabaseImpl implements PersonnelDataHelper {

	@Override
	public ResultMessage addPerson(PersonDetailPO personDetailPO) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		PersonDetailPO savePO = personDetailPO.copy();
		// new PersonDetailPO(personDetailPO.getId(), personDetailPO.getName(),
		// personDetailPO.getImage(), personDetailPO.getTelephone(),
		// personDetailPO.getCredit(),
		// personDetailPO.getBirthday(), personDetailPO.getEnterpriseName(),
		// personDetailPO.getVIPType(),
		// personDetailPO.getPassword(), personDetailPO.getHotelName(),
		// personDetailPO.getUserType());
		if (savePO.getImage() != null) {
			// 图片保存到服务器端，存储路径到数据库
			savePO.setUserImagePosition(ImageUtil.SaveImage(savePO.getImage(), ImageType.userImage));
		}
		try {
			session.save(savePO);
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return ResultMessage.FAIL;
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<PersonListPO> getPersonList(UserType userType, String userName, int userID)
			throws RemoteException {
		// 三种参数有且仅有一个非空
		ArrayList<PersonListPO> list = new ArrayList<PersonListPO>();
		if (userType != null) {
			list = getPersonListByUserType(userType.getString());
		} else if (userName != null) {
			list = getPersonListByUserName(userName);
		} else {
			list = getPersonListByUserID(userID);
		}
		return list;
	}

	private ArrayList<PersonListPO> getPersonListByUserType(String userType) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from PersonListPO where user_type = '" + userType + "'");
		List<PersonListPO> list = query.list();
		ArrayList<PersonListPO> retList = new ArrayList<PersonListPO>();
		for (PersonListPO each : list) {
			PersonListPO addPO = each.copy();
			addPO.setImageInSQL(each.getImageInSQL());
			//设置图片
			if (addPO.getImageInSQL() != null) {
				addPO.setImage(ImageUtil.getImage(each.getImageInSQL()));
			}
			retList.add(addPO);
		}
		session.close();
		return retList;
	}

	private ArrayList<PersonListPO> getPersonListByUserName(String name) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from PersonListPO where user_name = '" + name + "'");
		List<PersonListPO> list = query.list();
		ArrayList<PersonListPO> retList = new ArrayList<PersonListPO>();
		for (PersonListPO each : list) {
			PersonListPO addPO = each.copy();
			addPO.setImageInSQL(each.getImageInSQL());
			if (addPO.getImageInSQL() != null) {
				//设置图片
				addPO.setImage(ImageUtil.getImage(each.getImageInSQL()));
			}
			retList.add(addPO);
		}
		session.close();
		return retList;
	}

	private ArrayList<PersonListPO> getPersonListByUserID(int userID) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from PersonListPO where user_id = " + userID);
		List<PersonListPO> list = query.list();
		ArrayList<PersonListPO> retList = new ArrayList<PersonListPO>();
		for (PersonListPO each : list) {
			PersonListPO addPO = each.copy();
			addPO.setImageInSQL(each.getImageInSQL());
			if (addPO.getImageInSQL() != null) {
				//设置图片
				addPO.setImage(ImageUtil.getImage(each.getImageInSQL()));
			}
			retList.add(addPO);
		}
		session.close();
		return retList;
	}

	@Override
	public PersonDetailPO getPersonDetail(int userID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from PersonDetailPO where user_id = " + userID);
		List<PersonDetailPO> list = query.list();
		session.close();
		if (list.size() == 0) {
			return null;
		}
		PersonDetailPO po = list.get(0);
		PersonDetailPO retPO = po.copy();
		retPO.setUserImagePosition(po.getUserImagePosition());
		if (retPO.getUserImagePosition() != null) {
			//设置图片
			retPO.setImage(ImageUtil.getImage(retPO.getUserImagePosition()));
		}
		return retPO;
	}

	@Override
	public ResultMessage setPerson(PersonDetailPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from PersonDetailPO where user_id = " + po.getId());
		List<PersonDetailPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		PersonDetailPO setPO = list.get(0);
		setPO.setBirthday(po.getBirthday());
		setPO.setCredit(po.getCredit());
		setPO.setHotelName(po.getHotelName());
		setPO.setEnterpriseName(po.getEnterpriseName());
		setPO.setName(po.getName());
		setPO.setPassword(po.getPassword());
		setPO.setTelephone(po.getTelephone());
		setPO.setImage(po.getImage());
		if (setPO.getImage() != null) {
			//图片存到服务器端
			setPO.setUserImagePosition(ImageUtil.SaveImage(setPO.getImage(), ImageType.userImage));
		}
		try {
			session.update(setPO);
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
	public ResultMessage checkUserName(String userName) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from PersonDetailPO where user_name = '" + userName + "'");
		List<PersonDetailPO> list = query.list();
		session.close();
		if (list.size() != 0) {
			return ResultMessage.USEREXISTED;
		}
		return ResultMessage.SUCCESS;
	}

}
