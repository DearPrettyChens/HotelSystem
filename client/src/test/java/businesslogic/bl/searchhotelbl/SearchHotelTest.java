package businesslogic.bl.searchhotelbl;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import util.City;
import util.TradingArea;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;


/**
 * 搜索酒店的测试类
 * @author csy
 * @version 1.0
 * 
 */
public class SearchHotelTest {
    SearchHotel searchHotel;
    HotelSearchInfoVO hotelSearchInfoVO;
   
	@Before
	public void setUp(){
		 hotelSearchInfoVO=new HotelSearchInfoVO("锦江之星大酒店", City.NANJING, TradingArea.XINJIEKOU, null, null, null, null, null, null, null, null, null, null, null);
	      searchHotel=new SearchHotel(hotelSearchInfoVO);
	}
	
//	由于要在逻辑层调用hotel模块，还要涉及的数据层，所以未能测试
	@Test
	public void test(){
		ArrayList<HotelListVO>hotelListVOs=searchHotel.getHotelList();
		assertEquals("锦江之星大酒店",hotelListVOs.get(0).getHotelName());
	}

}
