package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import data.datahelper.HotelDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ResultMessage;

public class HotelDataHelperDatabaseImpl implements HotelDataHelper {

	@Override
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from HotelBasicInfoPO where id = " + hotelID);
		List<HotelBasicInfoPO> list = query.list();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0).copy();
	}

	@Override
	public ResultMessage addRemarkInfo(RemarkPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from HotelBasicInfoPO where id = " + po.getHotelID());
		List<HotelBasicInfoPO> list = query.list();
		if (list.size() == 0) {
			return ResultMessage.FAIL;
		}
		HotelBasicInfoPO savePO = list.get(0);
		savePO.setScore((savePO.getScore() * savePO.getRemarkOrderNumber() + po.getScore())
				/ (savePO.getRemarkOrderNumber() + 1));
		savePO.setRemarkOrderNumber(savePO.getRemarkOrderNumber() + 1);

		try {
			session.update(savePO);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		HotelBasicInfoPO savePO = new HotelBasicInfoPO(po.getHotelID(), po.getName(), po.getHotelImage(),
				po.getAddress(), po.getTelephone(), po.getStar(), po.getScore(), po.getLowestPrice(), po.getIntroduce(),
				po.getCommonFacility(), po.getActivityFacility(), po.getService(), po.getRoomFacility(),
				po.getRemarks(), po.getCity(), po.getTradingArea());
		try {
			session.save(po);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from HotelBasicInfoPO where id = " + po.getHotelID());
		List<HotelBasicInfoPO> list = query.list();
		if (list.size() == 0) {
			return ResultMessage.FAIL;
		}
		HotelBasicInfoPO savePO = list.get(0);
		savePO.setActivityFacility(po.getActivityFacility());
		savePO.setAddress(po.getAddress());
		savePO.setCity(po.getCity());
		savePO.setCommonFacility(po.getCommonFacility());
		savePO.setEnterprises(po.getEnterprises());
		savePO.setHotelImage(po.getHotelImage());
		savePO.setIntroduce(po.getIntroduce());
		savePO.setName(po.getName());
		savePO.setRoomFacility(po.getRoomFacility());
		savePO.setScore(po.getScore());
		savePO.setService(po.getService());
		savePO.setStar(po.getStar());
		savePO.setTelephone(po.getTelephone());
		savePO.setTradingArea(po.getTradingArea());
		try {
			session.update(savePO);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setBestPrice(HotelBestPricePO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from HotelBestPricePO where id = " + po.getHotelID());
		List<HotelBestPricePO> list = query.list();
		if (list.size() == 0) {
			return ResultMessage.FAIL;
		}
		HotelBestPricePO savePO = list.get(0);
		savePO.setBestPrice(po.getBestPrice());
		try {
			session.update(savePO);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

}
