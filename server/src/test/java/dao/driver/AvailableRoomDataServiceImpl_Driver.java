package dao.driver;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import dao.availableroomdao.AvailableRoomDao;
import dao.impl.AvailableRoomDaoImpl;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;

public class AvailableRoomDataServiceImpl_Driver {
	public void drive(AvailableRoomDao dao) throws RemoteException, ParseException {
		AvailableRoomInfoPO po = new AvailableRoomInfoPO(1, "AAAAA", BedType.BIGBED, 300, 150, 30, 30);
		System.out.println(dao.addAvailableRoomInfo(po));

		ArrayList<AvailableRoomInfoPO> getPOList = dao.getAvailableRoomInfo("1");
		for (AvailableRoomInfoPO each : getPOList) {
			System.out.println(each.getHotelNumber() + " " + each.getRoomType() + " " + each.getBedType() + " "
					+ each.getOriginalNumbers() + " " + each.getCurrentNumber());
		}

		AvailableRoomNumberPO getPO = dao.getAvailableRoomNumber("1", new Date(), BedType.BIGBED);
		System.out.println(getPO.getHotelNumber() + " " + getPO.getBedType() + " " + getPO.getNumber());

		System.out.println(dao.getRoomPrice("1", BedType.BIGBED));

		po.setLowestPrice(200);
		ArrayList<AvailableRoomInfoPO> list = new ArrayList<AvailableRoomInfoPO>();
		list.add(po);
		dao.setBestPrice(list);

		po.setRoomType("bbb");
		System.out.println(dao.modifyAvailableRoomInfo(po));
		getPO = dao.getAvailableRoomNumber("1", new Date(), BedType.BIGBED);
		System.out.println(getPO.getHotelNumber() + " " + getPO.getBedType() + " " + getPO.getNumber());

		//setAvailableRoomNumber是不是只有在入住退房的时候改？
		AvailableRoomNumberPO changePO = new AvailableRoomNumberPO(10, BedType.BIGBED, new Date(), 1);
		System.out.println(dao.setAvailableRoomNumber(changePO));
		getPO = dao.getAvailableRoomNumber("1", new Date(), BedType.BIGBED);
		System.out.println(getPO.getHotelNumber() + " " + getPO.getBedType() + " " + getPO.getNumber());
		
	}

	public static void main(String[] args) throws RemoteException, ParseException {
		new AvailableRoomDataServiceImpl_Driver().drive(AvailableRoomDaoImpl.getInstance());
	}
}
