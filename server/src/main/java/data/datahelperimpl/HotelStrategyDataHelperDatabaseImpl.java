package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import data.datahelper.HotelStrategyDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;

public class HotelStrategyDataHelperDatabaseImpl implements HotelStrategyDataHelper {

	@Override
	public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery(
				"from HotelStrPO where ( hotel_id = " + hotelID + ") and ( type = '" + type.getString() + "')");
		List<HotelStrPO> list = query.list();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0).copy();
	}

	@Override
	public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from HotelStrPO where ( hotel_id = " + po.getHotelID() + ") and ( type = '"
				+ po.getType().getString() + "')");
		List<HotelStrPO> list = query.list();
		if (list.size() == 0) {
			HotelStrPO savePO = new HotelStrPO(po.getHotelID(), po.getAmount(), po.getType(), po.getAmount(),
					po.getEnterprise(), po.getDate());
			try {
				session.save(savePO);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMessage.FAIL;
			} finally {
				session.close();
			}
		} else {
			HotelStrPO hotelStrPO = list.get(0);
			hotelStrPO.setAmount(po.getAmount());
			hotelStrPO.setDate(po.getDate());
			hotelStrPO.setDiscount(po.getDiscount());
			hotelStrPO.setEnterprise(po.getEnterprise());
			try {
				session.update(hotelStrPO);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMessage.FAIL;
			} finally {
				session.close();
			}
		}
		return ResultMessage.SUCCESS;
	}

}
