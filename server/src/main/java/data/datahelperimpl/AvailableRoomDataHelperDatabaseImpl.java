package data.datahelperimpl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.hibernate.loader.custom.CustomLoader.ScalarResultColumnProcessor;
import org.springframework.scheduling.SchedulingException;

import data.datahelper.AvailableRoomDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;

public class AvailableRoomDataHelperDatabaseImpl implements AvailableRoomDataHelper {

	@Override
	public ArrayList<AvailableRoomInfoPO> getAvailableRoomInfo(String hotelID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// 按照酒店id获取po
		Query query = session
				.createQuery("from AvailableRoomInfoPO where ( hotel_id = " + hotelID + " ) and ( date = " + 0 + " )");
		List<AvailableRoomInfoPO> list = query.list();
		session.close();
		if (list.size() == 0) {
			return null;
		}
		ArrayList<AvailableRoomInfoPO> arrayList = new ArrayList<AvailableRoomInfoPO>();
		for (AvailableRoomInfoPO each : list) {
			arrayList.add(each);
		}
		return arrayList;
	}

	@Override
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		// 每次添加七天的可用住房信息
		ArrayList<AvailableRoomInfoPO> weekList = new ArrayList<AvailableRoomInfoPO>();
		AvailableRoomInfoPO firstDay = po.copy();
		AvailableRoomInfoPO secondDay = po.copy();
		AvailableRoomInfoPO thirdDay = po.copy();
		AvailableRoomInfoPO fourthDay = po.copy();
		AvailableRoomInfoPO fifthDay = po.copy();
		AvailableRoomInfoPO sixthDay = po.copy();
		AvailableRoomInfoPO seventhDay = po.copy();
		firstDay.setDateFromNow(0);
		secondDay.setDateFromNow(1);
		thirdDay.setDateFromNow(2);
		fourthDay.setDateFromNow(3);
		fifthDay.setDateFromNow(4);
		sixthDay.setDateFromNow(5);
		seventhDay.setDateFromNow(6);
		weekList.add(firstDay);
		weekList.add(secondDay);
		weekList.add(thirdDay);
		weekList.add(fourthDay);
		weekList.add(fifthDay);
		weekList.add(sixthDay);
		weekList.add(seventhDay);
		for (AvailableRoomInfoPO each : weekList) {
			if (this.Save(each) == ResultMessage.FAIL) {
				return ResultMessage.FAIL;
			}
		}
		return ResultMessage.SUCCESS;
	}

	public ResultMessage Save(AvailableRoomInfoPO po) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(po);
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				session.getTransaction().rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		// 房间床型和酒店ID应当是固定的 可以修改的信息有 房型 总数量 原始价格
		Query query = session.createQuery("from AvailableRoomInfoPO where (hotel_id = " + po.getHotelNumber()
				+ ") and ( bed_type = '" + po.getBedType() + "')");
		List<AvailableRoomInfoPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		// 记录房间数量变化对于当前房间数量的影响
		int numberChange = 0;
		for (AvailableRoomInfoPO each : list) {
			// 修改原始价格 房型 总数量
			each.setOriginalPrice(po.getOriginalPrice());
			each.setRoomType(po.getRoomType());
			numberChange = po.getOriginalNumbers() - each.getOriginalNumbers();
			each.setOriginalNumbers(po.getOriginalNumbers());
			each.setCurrentNumber(each.getCurrentNumber() + numberChange);
			// 判断房间数量是否比当前可用客房数量还要少 防止出现负数（不合理的修改）
			if (each.getCurrentNumber() < 0) {
				session.close();
				return ResultMessage.FAIL;
			}
		}
		try {
			for (AvailableRoomInfoPO each : list) {
				session.update(each);
			}
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				session.getTransaction().rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		// 更新可用住房的数量
		// 第一步 先取出id和日期相同的
		Query query = session.createQuery("from AvailableRoomNumberPO where ( hotel_id = " + po.getHotelNumber()
				+ " ) and ( date = " + po.getDateFromNow() + ")");
		List<AvailableRoomNumberPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.LISTSIZE0;
		}
		// 第二步 找到床型相同的
		AvailableRoomNumberPO changePO = null;
		for (AvailableRoomNumberPO each : list) {
			if (each.getBedType() == po.getBedType()) {
				changePO = each;
			}
		}
		// 判断是否存在
		if (changePO == null) {
			session.close();
			return ResultMessage.FAIL;
		}
		// 修改房间数量
		changePO.setNumber(po.getNumber());
		try {
			session.update(changePO);
			transaction.commit();
		} catch (StaleObjectStateException e) {
			e.printStackTrace();
			if (transaction != null) {
				session.getTransaction().rollback();
			}
			return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
		} finally {
			session.close();
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getRoomPrice(String hotelID, BedType bedType) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// 找到床型与酒店id相同的记录
		Query query = session.createQuery("from AvailableRoomInfoPO where ( hotel_id = " + hotelID
				+ " ) and ( bed_type = '" + bedType.getString() + "')");
		List<AvailableRoomInfoPO> list = query.list();
		session.close();
		if (list.size() == 0) {
			return -1;
		}
		double price = list.get(0).getOriginalPrice();
		return price;
	}

	@Override
	public AvailableRoomNumberPO getAvailableRoomNumber(String hotelID, Date date, BedType type)
			throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		// 先找到酒店id和床型相同的记录
		Query query = session.createQuery("from AvailableRoomNumberPO where ( hotel_id = " + hotelID
				+ " ) and ( bed_type = '" + type.getString() + "')");
		List<AvailableRoomNumberPO> list = query.list();
		session.close();
		if (list.size() == 0) {
			return null;
		}
		AvailableRoomNumberPO retPO = null;
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date);
		for (AvailableRoomNumberPO each : list) {
			c2.setTime(each.getDate());
			if (c2.get(Calendar.YEAR) == c1.get(Calendar.YEAR) && c2.get(Calendar.MONTH) == c1.get(Calendar.MONTH)
					&& c2.get(Calendar.DATE) == c1.get(Calendar.DATE)) {
				retPO = each;
			}
		}
		try {
			return retPO.copy();
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultMessage setBestPrice(ArrayList<AvailableRoomInfoPO> po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query;
		List<AvailableRoomInfoPO> updateList;
		for (AvailableRoomInfoPO each : po) {
			// 找到酒店id和床型相同的记录 再全部修改
			query = session.createQuery("from AvailableRoomInfoPO where (hotel_id = " + each.getHotelNumber()
					+ ") and ( bed_type = '" + each.getBedType().getString() + "')");
			updateList = query.list();
			for (AvailableRoomInfoPO updateEach : updateList) {
				updateEach.setLowestPrice(each.getLowestPrice());
			}
			try {
				for (AvailableRoomInfoPO eachOne : updateList) {
					session.update(eachOne);
				}
				transaction.commit();
			} catch (StaleObjectStateException e) {
				e.printStackTrace();
				if (transaction != null) {
					transaction.rollback();
				}
				return ResultMessage.CONFLICTIONINSQLNEEDCOMMIViewTagAIN;
			} finally {
//				transaction.commit();
				session.close();
			}
		}
		return ResultMessage.SUCCESS;
	}

}
