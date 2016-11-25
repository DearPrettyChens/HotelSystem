package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

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
		PersonDetailPO savePO = new PersonDetailPO(personDetailPO.getId(), personDetailPO.getName(),
				personDetailPO.getImage(), personDetailPO.getTelephone(), personDetailPO.getCredit(),
				personDetailPO.getBirthday(), personDetailPO.getEnterpriseName(), personDetailPO.getVIPType(),
				personDetailPO.getPassword(), personDetailPO.getHotelName(), personDetailPO.getUserType());
		if (savePO.getImage() != null) {
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
		return null;
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
		PersonDetailPO retPO = list.get(0).copy();
		if (retPO.getUserImagePosition() != null) {
			retPO.setImage(ImageUtil.getImage(retPO.getUserImagePosition()));
		}
		return retPO;
	}

	@Override
	public ResultMessage setPerson(PersonDetailPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
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
			setPO.setUserImagePosition(ImageUtil.SaveImage(setPO.getImage(), ImageType.userImage));
		}
		try {
			session.update(setPO);
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
