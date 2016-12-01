package businesslogic.bl.hotelbl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.swing.text.AsyncBoxView.ChildLocator;

import org.junit.Before;
import org.junit.Test;

import util.Children;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;

/**
 * 酒店工作人员查看订单的测试类
 * 
 * @author csy
 * @version 1.0
 */
public class HotelWorkerLookOrderTest {

	ArrayList<HotelOrderVO> hotelOrderVOs;
    HotelOrderInfoVO hotelOrderInfoVO;
	
    @Before
	public void setUp() throws Exception {
		hotelOrderVOs = null;
		hotelOrderInfoVO=null;
	}

	@Test
	public void test() {
		Hotel hotel = new Hotel();
		assertEquals(1,hotel.getHotelOrderList("000005").size());
//		hotel.getHotelOrderInfo("201611030001000001");
		assertEquals(Children.EXIST, hotel.getHotelOrderInfo("00000000001234567890").getHasChild());
	}

}
