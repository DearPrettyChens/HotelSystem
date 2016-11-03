package businesslogic.bl.searchhotelbl;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import vo.searchhotelvo.HotelListVO;


/**
 * 搜索酒店的测试类
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHotelTest {
	
	SearchHotelBLService SearchHotelService;
	util.HotelSortType HotelSortType;
	util.OrderState OrderState;
	
	
	
	@Before
	public void setUp(){
	   
		
		
		SearchHotelService=new SearchHotelController();
		
		
		
	
		
		
		
		
	}
	
	
	
	
	@Test
	public void test(){
		
		
		assertEquals(SearchHotelService.getBookedHotelList(HotelSortType, OrderState,"123"),null);
		assertEquals(SearchHotelService.getHotelList(),null);
		assertEquals(SearchHotelService.getSortedHotelList(HotelSortType),null);
		
	}

}
