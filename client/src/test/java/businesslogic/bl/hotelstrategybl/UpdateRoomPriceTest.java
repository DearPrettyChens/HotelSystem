package businesslogic.bl.hotelstrategybl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.hotelstrategybl.mock.MockAvailableRoom;
import businesslogic.bl.hotelstrategybl.mock.MockUser;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelStrVO;

/**
 * 更新酒店房间价格的测试类
 * @author CLL
 * @version
 */
/*public class UpdateRoomPriceTest {
	HotelStrategyInterface hotelStrategyInterface;
	HotelStrVO vo1;
	@Before
	public void setUp() throws Exception {
		hotelStrategyInterface=new HotelBirthStrategy();
		vo1=new HotelStrVO();
	}

	@Test
	public void test() {
		HotelStrategy hotelStrategy=new HotelStrategy();
		assertEquals(hotelStrategy.confirmHotelStrategy(hotelStrategyInterface,vo1),null);
		MockAvailableRoom availableRoom=new MockAvailableRoom();
		MockUser user=new MockUser();
		assertEquals(user.getUserID(null),"000001");
		assertEquals(availableRoom.setBestPrice(user.getUserID(null), 0.8),ResultMessage.SUCCESS);
	}

}*/
