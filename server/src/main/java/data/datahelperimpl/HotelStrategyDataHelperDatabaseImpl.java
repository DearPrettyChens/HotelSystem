package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

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
			session.close();
			return null;
		}
		return list.get(0).copy();
	}

	@Override
	public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from HotelStrPO where ( hotel_id = " + po.getHotelID() + ") and ( type = '"
				+ po.getType().getString() + "')");
		List<HotelStrPO> list = query.list();
		if (list.size() == 0) {
			//无策略则新增
			HotelStrPO savePO = new HotelStrPO(po.getHotelID(), po.getAmount(), po.getType(), po.getAmount(),
					po.getEnterprise(), po.getDate());
			try {
				session.save(savePO);
				transaction.commit();
			} catch (StaleObjectStateException e) {
				e.printStackTrace();
				if(transaction!=null){
					transaction.rollback();
				}
				return ResultMessage.CONFLICTIONINSQLNEEDCOMMITAGAIN;
			} finally {
				session.close();
			}
		} else {
			//有策略则修改
			HotelStrPO hotelStrPO = list.get(0);
			hotelStrPO.setAmount(po.getAmount());
			hotelStrPO.setDate(po.getDate());
			hotelStrPO.setDiscount(po.getDiscount());
			hotelStrPO.setEnterprise(po.getEnterprise());
			try {
				session.update(hotelStrPO);
				transaction.commit();
			} catch (StaleObjectStateException e) {
				e.printStackTrace();
				if(transaction!=null){
					transaction.rollback();
				}
				return ResultMessage.CONFLICTIONINSQLNEEDCOMMITAGAIN;
			} finally {
				session.close();
			}
		}
		return ResultMessage.SUCCESS;
	}

}
