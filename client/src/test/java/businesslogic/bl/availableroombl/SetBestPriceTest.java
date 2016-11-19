package businesslogic.bl.availableroombl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
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
		//TODO
		assertEquals(availableRoom.setBestPrice("0001", 0.8),ResultMessage.SUCCESS);
	}

}
