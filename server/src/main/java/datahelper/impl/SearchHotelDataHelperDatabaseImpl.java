package datahelper.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import data.datahelper.SearchHotelDataHelper;
import po.ClientPO;
import po.HotelListPO;
import util.HotelSortType;

public class SearchHotelDataHelperDatabaseImpl implements SearchHotelDataHelper {

	@Override
	public ArrayList<HotelListPO> getHotelList() {
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String sql = "from HotelListPO";
		Query query = session.createQuery(sql);
		List<HotelListPO> list = query.list();
		ArrayList<HotelListPO> result = new ArrayList<HotelListPO>();
		for (HotelListPO each : list) {
			result.add(each.copy());
		}
		return result;
	}

	@Override
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type) {
		ArrayList<HotelListPO> result = null;
		switch (type) {
		case MULTIPLE_HIGH_TO_LOW:
			result = orderList("id", "asc");
			break;
		case MULTIPLE_LOW_TO_HIGH:
			result = orderList("id", "desc");
			break;
		case PRICE_HIGH_TO_LOW:
			result = orderList("lowestPrice", "desc");
			break;
		case PRICE_LOW_TO_HIGH:
			result = orderList("lowestPrice", "asc");
			break;
		case STARLEVEL_HIGH_TO_LOW:
			result = orderList("star", "desc");
			break;
		case STARLEVEL_LOW_TO_HIGH:
			result = orderList("star", "asc");
			break;
		case SCORE_HIGH_TO_LOW:
			result = orderList("remark", "desc");
			break;
		case SCORE_LOW_TO_HIGH:
			result = orderList("remark", "asc");
			break;
		}
		return result;
	}

	public ArrayList<HotelListPO> orderList(String s1, String order) {
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String hql = "from HotelListPO po order by po." + s1 + " " + order;
		Query query = session.createQuery(hql);
		List<HotelListPO> list = query.list();
		ArrayList<HotelListPO> result = new ArrayList<HotelListPO>();
		for (HotelListPO each : list) {
			result.add(each.copy());
		}
		return result;
	}
}
