package dao.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.impl.SearchHotelDaoImpl;
import dao.searchhoteldao.SearchHotelDao;
import po.HotelListPO;
import util.HotelSortType;

public class SearchHotelDataSercieImpl_Driver {
	public void drive(SearchHotelDao searchHotelDao) throws RemoteException {
		ArrayList<HotelListPO> list = searchHotelDao.getHotelList();
		System.out.println();
		System.out.println("original");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.MULTIPLE_HIGH_TO_LOW);
		System.out.println();
		System.out.println("mutiple high to low");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.MULTIPLE_LOW_TO_HIGH);
		System.out.println();
		System.out.println("mutiple low to high");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.PRICE_HIGH_TO_LOW);
		System.out.println();
		System.out.println("price high to low");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.PRICE_LOW_TO_HIGH);
		System.out.println();
		System.out.println("price low to high");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.SCORE_HIGH_TO_LOW);
		System.out.println();
		System.out.println("score high to low");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.SCORE_LOW_TO_HIGH);
		System.out.println();
		System.out.println("score low to high");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.STARLEVEL_HIGH_TO_LOW);
		System.out.println();
		System.out.println("star high to low");
		print(list);
		list = searchHotelDao.getSortedHotelList(HotelSortType.STARLEVEL_LOW_TO_HIGH);
		System.out.println();
		System.out.println("star low to high");
		print(list);
	}

	public void print(ArrayList<HotelListPO> list) {
		for (HotelListPO each : list) {
			System.out.println(each.getName() + " " + each.getId() + " " + each.getLowestprice() + " "
					+ each.getLocation() + " " + each.getStar() + " ");
		}
	}

	public static void main(String[] args) throws RemoteException {
		new SearchHotelDataSercieImpl_Driver().drive(SearchHotelDaoImpl.getInstance());
	}
}
