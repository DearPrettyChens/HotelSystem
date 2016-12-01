package businesslogic.bl.availableroombl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
/**
 * 更新酒店最低价格的测试类
 * @author CLL
 * @version
 */
public class SetBestPriceTest {
	AvailableRoom availableRoom;
	@Before
	public void setUp() throws Exception {
		availableRoom=new AvailableRoom();
	}

	@Test
	public void test() {
		ArrayList<AvailableRoomInfoVO> preRoomInfo=availableRoom.getAvailableRoomInfo("000005");
		assertEquals(availableRoom.setBestPrice("000005", 0.8),ResultMessage.SUCCESS);
		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo("000005");
		//第三个参数为允许误差
		assertEquals(0.8*preRoomInfo.get(0).getLowestPrice(),roomInfo.get(0).getLowestPrice(),0.01);
	}


}
