package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

import data.datahelper.HotelDataHelper;
import datahelper.databaseutility.HibernateUtil;
import datahelper.databaseutility.ImageUtil;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ImageType;
import util.ResultMessage;

public class HotelDataHelperDatabaseImpl implements HotelDataHelper {

	@Override
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		//按照id取出po
		Query query = session.createQuery("from HotelBasicInfoPO where id = " + Integer.parseInt(hotelID));
		List<HotelBasicInfoPO> list = query.list();
		session.close();
		if (list.size() == 0) {
			return null;
		}
		HotelBasicInfoPO getPO = list.get(0);
		HotelBasicInfoPO retPO = getPO.copy();
		retPO.setHotelImagePath(getPO.getHotelImagePath());
		if (retPO.getHotelImagePath() != null) {
			//根据po内的图片路径设置酒店图片image
			retPO.setHotelImage(ImageUtil.getImage(retPO.getHotelImagePath()));
		}
		return retPO;
	}

	@Override
	public ResultMessage addRemarkInfo(RemarkPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from HotelBasicInfoPO where id = " + Integer.parseInt(po.getHotelID()));
		List<HotelBasicInfoPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		//修改酒店基本信息中的酒店评分
		HotelBasicInfoPO savePO = list.get(0);
		savePO.setScore((savePO.getScore() * savePO.getRemarkOrderNumber() + po.getScore())
				/ (savePO.getRemarkOrderNumber() + 1));
		//增加酒店评论数量
		savePO.setRemarkOrderNumber(savePO.getRemarkOrderNumber() + 1);

		try {
			session.update(savePO);
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		HotelBasicInfoPO savePO = po.copy();
		if (po.getHotelImage() != null) {
			//存储图片 保存路径到数据库
			savePO.setHotelImagePath(ImageUtil.SaveImage(po.getHotelImage(), ImageType.hotelImage));
		}
		try {
			session.save(savePO);
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
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from HotelBasicInfoPO where id = " + po.getHotelID());
		List<HotelBasicInfoPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		//修改酒店基本信息
		HotelBasicInfoPO savePO = list.get(0);
		savePO.setActivityFacility(po.getActivityFacility());
		savePO.setAddress(po.getAddress());
		savePO.setCity(po.getCity());
		savePO.setCommonFacility(po.getCommonFacility());
		savePO.setEnterprises(po.getEnterprises());
		savePO.setIntroduce(po.getIntroduce());
		savePO.setName(po.getName());
		savePO.setRoomFacility(po.getRoomFacility());
		savePO.setScore(po.getScore());
		savePO.setService(po.getService());
		savePO.setStar(po.getStar());
		savePO.setTelephone(po.getTelephone());
		savePO.setTradingArea(po.getTradingArea());
		savePO.setHotelImage(po.getHotelImage());
		if (po.getHotelImage() != null) {
			//修改酒店图片
			savePO.setHotelImagePath(ImageUtil.SaveImage(po.getHotelImage(), ImageType.hotelImage));
		}
		try {
			session.update(savePO);
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setBestPrice(HotelBestPricePO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from HotelBestPricePO where id = " + po.getHotelID());
		List<HotelBestPricePO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		HotelBestPricePO savePO = list.get(0);
		savePO.setBestPrice(po.getBestPrice());
		try {
			session.update(savePO);
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

}
