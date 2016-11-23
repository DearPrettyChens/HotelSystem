package dao.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.impl.OrderDaoImpl;
import dao.orderdao.OrderDao;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import po.TypeInfoPO;
import util.BedType;
import util.Children;
import util.OrderState;
import util.UserType;

public class OrderDataServiceImpl_Driver {
	public void drive(OrderDao dao) throws RemoteException {
		OrderInfoPO po = new OrderInfoPO("00000000001234567890", "5", "AAAAA", "2", "CustomerA", "A", "12345678910",
				new Date(), new Date(), new Date(), "BIGROOM", BedType.BIGBED, 3, 3, Children.EXIST, 399,
				OrderState.NOTREMARKED);
		System.out.println(dao.addOrder(po));

		// OrderInfoPO getPO = null;
		po = dao.getOrderInfo(po.getOrderID());
		System.out.println(po.getOrderID() + " " + po.getCustomerID() + " " + po.getCustomerName() + " "
				+ po.getHotelTelephone() + " " + po.getLiveinPersonName() + " " + po.getRoomType() + " "
				+ po.getBedType() + "" + po.getState());
		// Date checkin = Calendar.getInstance();

		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 12, 25, 19, 30);
		// po.setActualCheckInTime(calendar.getTime());
		CheckTimePO checkTimePO = new CheckTimePO(po.getOrderID(), calendar.getTime(), "in");
		System.out.println(dao.setCheckintime(checkTimePO));
		System.out.println(dao.setCheckouttime(checkTimePO));

		po = dao.getOrderInfo(po.getOrderID());
		System.out.println(po.getOrderID() + " " + po.getCustomerID() + " " + po.getCustomerName() + " "
				+ po.getHotelTelephone() + " " + po.getLiveinPersonName() + " " + po.getRoomType() + " "
				+ po.getBedType() + "" + po.getState());

		RemarkPO remarkPO = new RemarkPO("5", po.getOrderID(), "2", 3, "good");
		System.out.println(dao.setOrderRemark(remarkPO));
		po = dao.getOrderInfo(po.getOrderID());
		System.out.println(po.getOrderID() + " " + po.getCustomerID() + " " + po.getCustomerName() + " "
				+ po.getHotelTelephone() + " " + po.getLiveinPersonName() + " " + po.getRoomType() + " "
				+ po.getBedType() + "" + po.getState());

		OrderStatePO orderStatePO = new OrderStatePO(po.getOrderID(), OrderState.HASREMARKED);
		System.out.println(dao.addOrderState(orderStatePO));
		po = dao.getOrderInfo(po.getOrderID());
		System.out.println(po.getOrderID() + " " + po.getCustomerID() + " " + po.getCustomerName() + " "
				+ po.getHotelTelephone() + " " + po.getLiveinPersonName() + " " + po.getRoomType() + " "
				+ po.getBedType() + "" + po.getState());

		ArrayList<OrderListPO> list = dao.getOrderList("5");
		for (OrderListPO each : list) {
			System.out.println(each.getOrderNumber() + " " + each.getCustomerID() + " " + each.getCustomerName() + " "
					+ " " + each.getHotelID() + " " + each.getHotelName());
		}

		TypeInfoPO typeInfoPO = new TypeInfoPO(UserType.Customer, po.getState(), po.getCustomerID());
		ArrayList<OrderListPO> listType = dao.getOrderList(typeInfoPO);
		for (OrderListPO each : listType) {
			System.out.println(each.getOrderNumber() + " " + each.getCustomerID() + " " + each.getCustomerName() + " "
					+ " " + each.getHotelID() + " " + each.getHotelName());
		}

	}

	public static void main(String[] args) throws RemoteException {
		new OrderDataServiceImpl_Driver().drive(OrderDaoImpl.getInstance());
	}
}
