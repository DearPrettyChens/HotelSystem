package dao.driver;

import java.rmi.RemoteException;
import java.util.Date;

import dao.hotelstrategydao.HotelStrategyDao;
import dao.impl.HotelDaoImpl;
import dao.impl.HotelStrategyDaoImpl;
import po.HotelStrPO;
import util.HotelStrategyType;

public class HotelStrategyDataServiceImpl_Driver {
	public void drive(HotelStrategyDao dao) throws RemoteException {
		HotelStrPO po = new HotelStrPO(2, 3, 0.5);
		System.out.println(dao.setHotelStrategy(po));
		System.out.println(
				"after add : " + po.getHotelID() + " " + po.getAmount() + " " + po.getDiscount() + " " + po.getType());

		po.setAmount(6);
		po.setDiscount(0.3);
		System.out.println(dao.setHotelStrategy(po));
		System.out.println(
				"after set : " + po.getHotelID() + " " + po.getAmount() + " " + po.getDiscount() + " " + po.getType());

		po = dao.getHotelStrategy("2", HotelStrategyType.AMOUNT);
		System.out.println(
				"after get : " + po.getHotelID() + " " + po.getAmount() + " " + po.getDiscount() + " " + po.getType());
	}

	public void runClientCode(HotelStrategyDao dao) throws RemoteException {
		System.out.println(dao.getHotelStrategy("0005", HotelStrategyType.BIRTH).getDiscount());
	}

	public static void main(String[] args) throws RemoteException {
//		new HotelStrategyDataServiceImpl_Driver().drive(HotelStrategyDaoImpl.getInstance());
		new HotelStrategyDataServiceImpl_Driver().runClientCode(HotelStrategyDaoImpl.getInstance());
	}
}
