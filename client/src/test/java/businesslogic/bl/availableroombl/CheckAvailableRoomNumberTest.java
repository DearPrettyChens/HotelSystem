package businesslogic.bl.availableroombl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * 检查可用客房数的测试类
 * @author CLL
 * @version
 */
public class CheckAvailableRoomNumberTest {
	AvailableRoom availableRoom;
	@Before
	public void setUp() throws Exception {
		availableRoom=new AvailableRoom();
	}

	@Test
	public void test1() {
		assertEquals(availableRoom.checkAvailableRoomNumber(new AvailableRoomNumberVO(8,BedType.BIGBED,
				new Date(),"000005")),ResultMessage.SUCCESS);
	}

	@Test
	public void test2() {
		assertEquals(availableRoom.checkAvailableRoomNumber(new AvailableRoomNumberVO(28,BedType.TWOBEDS,
				new Date(),"000005")),ResultMessage.SUCCESS);
	}
	
	@Test
	public void test() {

		assertEquals(availableRoom.checkAvailableRoomNumber(new AvailableRoomNumberVO(18,BedType.FAMILYBED,
				new Date(),"000005")),ResultMessage.SUCCESS);
	}
}
