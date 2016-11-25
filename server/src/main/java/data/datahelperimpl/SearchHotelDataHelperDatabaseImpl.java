package data.datahelperimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import data.datahelper.SearchHotelDataHelper;
import datahelper.databaseutility.HibernateUtil;
import datahelper.databaseutility.ImageUtil;
import po.ClientPO;
import po.HotelListPO;
import util.HotelSortType;

public class SearchHotelDataHelperDatabaseImpl implements SearchHotelDataHelper {

	String highToLow = "desc";
	String lowToHigh = "asc";

	@SuppressWarnings("unused")
	@Override
	public ArrayList<HotelListPO> getHotelList() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String sql = "from HotelListPO";
		Query query = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<HotelListPO> list = query.list();
		ArrayList<HotelListPO> result = new ArrayList<HotelListPO>();
		session.close();
		if (list.size() == 0) {
			return null;
		}
		for (HotelListPO each : list) {
			result.add(each.copy());
		}
		result = setImage(result);
		return result;
	}

	@Override
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type) {
		ArrayList<HotelListPO> result = null;
		switch (type) {
		case MULTIPLE_HIGH_TO_LOW:
			result = orderList("id", lowToHigh);
			break;
		case MULTIPLE_LOW_TO_HIGH:
			result = orderList("id", highToLow);
			break;
		case PRICE_HIGH_TO_LOW:
			result = orderList("lowestPrice", highToLow);
			break;
		case PRICE_LOW_TO_HIGH:
			result = orderList("lowestPrice", lowToHigh);
			break;
		case STARLEVEL_HIGH_TO_LOW:
			result = orderList("star", highToLow);
			break;
		case STARLEVEL_LOW_TO_HIGH:
			result = orderList("star", lowToHigh);
			break;
		case SCORE_HIGH_TO_LOW:
			result = orderList("remark", highToLow);
			break;
		case SCORE_LOW_TO_HIGH:
			result = orderList("remark", lowToHigh);
			break;
		}
		return result;
	}

	public ArrayList<HotelListPO> orderList(String s1, String order) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		String hql = "from HotelListPO po order by po." + s1 + " " + order;
		Query query = session.createQuery(hql);
		List<HotelListPO> list = query.list();
		ArrayList<HotelListPO> result = new ArrayList<HotelListPO>();
		session.close();
		if (list.size() == 0) {
			return null;
		}
		for (HotelListPO each : list) {
			result.add(each.copy());
		}
		result = setImage(result);
		return result;
	}

	public ArrayList<HotelListPO> setImage(ArrayList<HotelListPO> list) {
		for (HotelListPO each : list) {
			if (each.getHotelImagePath() != null) {
				each.setImage(ImageUtil.getImage(each.getHotelImagePath()));
			}
		}
		return list;
	}
}
