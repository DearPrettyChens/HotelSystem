package data.datahelperimpl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;

import data.datahelper.OrderDataHelper;
import datahelper.databaseutility.HibernateUtil;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import po.TypeInfoPO;
import util.OrderState;
import util.ResultMessage;

public class OrderDataHelperDatabaseImpl implements OrderDataHelper {

	@Override
	public OrderInfoPO getOrderInfo(String orderID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderInfoPO where order_id = '" + orderID + "'");
		List<OrderInfoPO> list = query.list();
		session.close();
		if (list.size() == 0) {
			return null;
		}
		return list.get(0).copy();
	}

	@Override
	public ResultMessage addOrderState(OrderStatePO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from OrderInfoPO where order_id = '" + po.getOrderNumber() + "'");
		List<OrderInfoPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		try {
			OrderInfoPO orderInfoPO = list.get(0);
			orderInfoPO.setState(po.getState());
			session.update(orderInfoPO);
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
	public ResultMessage setOrderRemark(RemarkPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		//修改订单状态 已评价
		Query query = session.createQuery("from OrderInfoPO where order_id = '" + po.getOrderID() + "'");
		List<OrderInfoPO> orderInfoPOlist = query.list();
		//修改评价
		query = session.createQuery("from RemarkPO where order_id = '" + po.getOrderID() + "'");
		List<RemarkPO> remarkPOlist = query.list();
		//无订单信息或无评价信息
		if (orderInfoPOlist.size() == 0 || remarkPOlist.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		try {
			OrderInfoPO orderInfoPO = orderInfoPOlist.get(0);
			orderInfoPO.setHasRemarked(true);
			session.update(orderInfoPO);
			RemarkPO remarkPO = remarkPOlist.get(0);
			remarkPO.setRemark(po.getRemark());
			remarkPO.setScore(po.getScore());
			session.update(remarkPO);
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
	public ResultMessage setCheckintime(CheckTimePO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from OrderInfoPO where order_id = '" + po.getOrderNumber() + "'");
		List<OrderInfoPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		try {
			OrderInfoPO orderInfoPO = list.get(0);
			orderInfoPO.setActualCheckInTime(po.getCheckTime());
			session.update(orderInfoPO);
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
	public ResultMessage setCheckouttime(CheckTimePO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from OrderInfoPO where order_id = '" + po.getOrderNumber() + "'");
		List<OrderInfoPO> list = query.list();
		if (list.size() == 0) {
			session.close();
			return ResultMessage.FAIL;
		}
		try {
			OrderInfoPO orderInfoPO = list.get(0);
			orderInfoPO.setActuarCheckOutTime(po.getCheckTime());
			session.update(orderInfoPO);
			transaction.commit();
		} catch (StaleObjectStateException e) {
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

	@Override
	public ResultMessage addOrder(OrderInfoPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderInfoPO where order_id = '" + po.getOrderID() + "'");
		List<OrderInfoPO> list = query.list();
		//检查订单号是否存在
		if (list.size() != 0) {
			session.close();
			return ResultMessage.ORDERIDHASEXISTED;
		}
		OrderInfoPO savePO = po.copy();
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
	public ArrayList<OrderListPO> getOrderList(TypeInfoPO po) throws RemoteException {
		//按照用户种类获取订单po
		ArrayList<OrderListPO> list = new ArrayList<OrderListPO>();
		switch (po.getUserType()) {
		case Customer:
			list = getOrderListByCustomer(po.getCustomerID(), po.getOrderState());
			break;
		case WebMarketMan:
			list = getOrderListByWebMarketMan(po.getOrderState());
			break;
		default:
			break;
		}
		return list;
	}

	private ArrayList<OrderListPO> getOrderListByCustomer(String string, OrderState state) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderListPO where ( customer_id = '" + string + "' ) and ( state = '"
				+ state.getString() + "' )");
		List<OrderListPO> list = query.list();
		ArrayList<OrderListPO> ret = new ArrayList<OrderListPO>();
		for (OrderListPO each : list) {
			ret.add(each.copy());
		}
		session.close();
		return ret;
	}

	private ArrayList<OrderListPO> getOrderListByWebMarketMan(OrderState state) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderListPO where state = '" + state.getString() + "' ");
		List<OrderListPO> list = query.list();
		ArrayList<OrderListPO> ret = new ArrayList<OrderListPO>();
		for (OrderListPO each : list) {
			ret.add(each.copy());
		}
		session.close();
		return ret;
	}

	@Override
	public ArrayList<OrderListPO> getOrderList(String hotelID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderListPO where hotel_id = '" + hotelID + "' ");
		List<OrderListPO> list = query.list();
		ArrayList<OrderListPO> ret = new ArrayList<OrderListPO>();
		for (OrderListPO each : list) {
			ret.add(each.copy());
		}
		session.close();
		return ret;
	}

}
