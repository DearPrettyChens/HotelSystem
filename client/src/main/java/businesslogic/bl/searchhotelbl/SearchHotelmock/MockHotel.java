package businesslogic.bl.searchhotelbl.SearchHotelmock;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.hotelbl.Hotel;
import businesslogic.bl.hotelstrategybl.HotelStrategy;
import businesslogic.bl.orderbl.OrderList;
import businesslogic.bl.orderbl.SingleOrder;
import dao.hoteldao.HotelDao;
import exception.NotFoundHotelException;
import util.City;
import util.TradingArea;
import vo.hotelvo.HotelDetailInfoVO;


public class MockHotel {
	

	
	//构造方法
	public MockHotel() {
	}
	
	
	/**
	 * 获取酒店详细信息
	 * @param hotelID String型， customerID String型，传递酒店编号和顾客编号？
	 * @return HotelDetailInfoVO ，将酒店详细信息返回给顾客看
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID,String customerID) throws NotFoundHotelException {
		return new HotelDetailInfoVO("锦江之星大酒店", null, null, TradingArea.XINJIEKOU, "12121212121", 5, null, null, City.NANJING,null, null, null, null,null, null, null, 5.0, null, 100);
	}


}
