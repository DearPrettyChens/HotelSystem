package businesslogic.bl.searchhotelbl;

import util.City;
import util.TradingArea;
import vo.searchhotelvo.HotelSearchInfoVO;

public class mytest {
	public static void main(String[] args) {
		HotelSearchInfoVO hotelSearchInfoVO = new HotelSearchInfoVO("锦江之星大酒店", City.NANJING, TradingArea.XINJIEKOU,
				null, null, null, null, null, null, null, null, null, null, "000022");
		SearchHotel searchHotel = new SearchHotel(hotelSearchInfoVO);
	}
}
