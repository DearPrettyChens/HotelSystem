package dao.driver;

import java.rmi.RemoteException;

import dao.hoteldao.HotelDao;
import dao.impl.HotelDaoImpl;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.City;
import util.TradingArea;

public class HotelDataServiceImpl_Driver {
	public void drive(HotelDao dao) throws RemoteException {
		HotelBasicInfoPO po = new HotelBasicInfoPO(5, "AAAAA", null, "AAAAA", "12345678910", 4, 0, 590, "SSS", "AAA",
				"AAA", "SSS", "RM", null, City.NANJING, TradingArea.HUNANLU);
		System.out.println(dao.addHotelBasicInfo(po));

		po = dao.getHotelBasicInfo("5");
		System.out.println("After add :" + po.getHotelID() + " " + po.getActivityFacility() + " " + po.getAddress()
				+ " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

		RemarkPO remarkPO = new RemarkPO(5, "111", 2, 4.5, "ddd");
		System.out.println(dao.addRemarkInfo(remarkPO));
		po = dao.getHotelBasicInfo("5");
		System.out.println("After add remark :" + po.getHotelID() + " " + po.getActivityFacility() + " "
				+ po.getAddress() + " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

		HotelBestPricePO hotelBestPricePO = new HotelBestPricePO(5, 720);
		dao.setBestPrice(hotelBestPricePO);
		po = dao.getHotelBasicInfo("5");
		System.out.println("After set best price :" + po.getHotelID() + " " + po.getActivityFacility() + " "
				+ po.getAddress() + " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

		po.setAddress("NANJING");
		System.out.println(dao.setHotelBasicInfo(po));
		po = dao.getHotelBasicInfo("5");
		System.out.println("After set basic info :" + po.getHotelID() + " " + po.getActivityFacility() + " "
				+ po.getAddress() + " " + po.getLowestPrice() + " " + po.getRemarkOrderNumber() + " " + po.getScore());

	}

	public static void main(String[] args) throws RemoteException {
		new HotelDataServiceImpl_Driver().drive(HotelDaoImpl.getInstance());
	}
}
