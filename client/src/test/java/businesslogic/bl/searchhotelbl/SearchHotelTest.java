package businesslogic.bl.searchhotelbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import util.City;
import util.HotelSortType;
import util.TradingArea;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 搜索酒店的测试类
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class SearchHotelTest {
	SearchHotel searchHotel;
	HotelSearchInfoVO hotelSearchInfoVO;


	@Test
	public void test1() {
		hotelSearchInfoVO = new HotelSearchInfoVO("锦江之星大酒店", City.NANJING, TradingArea.XINJIEKOU, null, null, null,
				null, null, null, null, null, null, null, "000022");
		searchHotel = new SearchHotel(hotelSearchInfoVO);
		ArrayList<HotelListVO> hotelListVOs = searchHotel.getHotelList();
		assertEquals("锦江之星大酒店", hotelListVOs.get(0).getHotelName());
	}

	@Test
	public void test2() {
		hotelSearchInfoVO = new HotelSearchInfoVO("锦江之星大酒店", City.NANJING, TradingArea.XINJIEKOU, null, null, null,
				null, null, null, null, null, null, HotelSortType.PRICE_HIGH_TO_LOW, "000022");
		searchHotel = new SearchHotel(hotelSearchInfoVO);
		ArrayList<HotelListVO> hotelListVOs = searchHotel.getHotelList();
		assertEquals("锦江之星大酒店", hotelListVOs.get(0).getHotelName());
	}
	@Test
	public void test3() {
		hotelSearchInfoVO = new HotelSearchInfoVO("锦江之星大酒店", City.NANJING, TradingArea.XINJIEKOU, null, new Date(), null,
				null,null, null, null, null, null, HotelSortType.SCORE_LOW_TO_HIGH, "000022");
		searchHotel = new SearchHotel(hotelSearchInfoVO);
		ArrayList<HotelListVO> hotelListVOs = searchHotel.getHotelList();
		assertEquals("锦江之星大酒店", hotelListVOs.get(0).getHotelName());
	}
	@Test
	public void test4() {
		hotelSearchInfoVO = new HotelSearchInfoVO("锦江之星大酒店", City.NANJING, TradingArea.HUNANLU, null, null, null,
				null, null, null, null, null, null, null, "000022");
		searchHotel = new SearchHotel(hotelSearchInfoVO);
		ArrayList<HotelListVO> hotelListVOs = searchHotel.getHotelList();
		assertEquals("锦江之星大酒店", hotelListVOs.get(0).getHotelName());
	}
}
