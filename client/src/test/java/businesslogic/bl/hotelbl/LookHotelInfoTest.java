package businesslogic.bl.hotelbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.NotFoundHotelException;
import util.City;
import vo.hotelvo.HotelDetailInfoVO;
/**
 * 顾客查看酒店信息的测试类
 * @author csy
 * @version 1.0
 */

public class LookHotelInfoTest {
    HotelDetailInfoVO hotelDetailInfoVO;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() throws NotFoundHotelException {
		Hotel hotel=new Hotel();
		assertEquals(City.NANJING,hotel.getHotelDetailInfo("000003", "000002").getCity());
	}

	@Test
	public void test2() throws NotFoundHotelException {
		Hotel hotel=new Hotel();
		assertEquals(City.NANJING,hotel.getHotelDetailInfo("000005", "000001").getCity());
	}

	@Test
	public void test3() throws NotFoundHotelException {
		Hotel hotel=new Hotel();
		assertEquals(City.NANJING,hotel.getHotelDetailInfo("000006", "000001").getCity());
	}

}
