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
	public void test1() {
		ArrayList<AvailableRoomInfoVO> preRoomInfo=availableRoom.getAvailableRoomInfo("000005");
		assertEquals(availableRoom.setBestPrice("000005", 0.8),ResultMessage.SUCCESS);
		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo("000005");
		//第三个参数为允许误差
		assertEquals(0.8*preRoomInfo.get(0).getOriginalPrice(),roomInfo.get(0).getLowestPrice(),0.01);
	}

	@Test
	public void test2() {
		ArrayList<AvailableRoomInfoVO> preRoomInfo=availableRoom.getAvailableRoomInfo("000003");
		assertEquals(availableRoom.setBestPrice("000003", 0.7),ResultMessage.SUCCESS);
		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo("000003");
		//第三个参数为允许误差
		assertEquals(0.8*preRoomInfo.get(0).getOriginalPrice(),roomInfo.get(0).getLowestPrice(),0.01);
	}
	
	@Test
	public void test3() {
		ArrayList<AvailableRoomInfoVO> preRoomInfo=availableRoom.getAvailableRoomInfo("000004");
		assertEquals(availableRoom.setBestPrice("000004", 0.5),ResultMessage.SUCCESS);
		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo("000004");
		//第三个参数为允许误差
		assertEquals(0.8*preRoomInfo.get(0).getOriginalPrice(),roomInfo.get(0).getLowestPrice(),0.01);
	}
}
