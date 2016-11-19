package businesslogic.bl.availableroombl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * 修改可用客房数的测试类
 * @author CLL
 * @version
 */
public class SetAvailableRoomNumberTest {
	AvailableRoom availableRoom;
	@Before
	public void setUp() throws Exception {
		availableRoom=new AvailableRoom();
	}

	@Test
	public void test() {
		assertEquals(availableRoom.setAvailableRoomNumber(new AvailableRoomNumberVO(3,BedType.BIGBED,
				new Date(),"000001")),ResultMessage.SUCCESS);
		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo("000001");
		for(int i=0;i<roomInfo.size();i++){
			if(roomInfo.get(i).getBedType()==BedType.BIGBED){
				assertEquals(roomInfo.get(i).getCurrentNumber(),3);
			}
		}
	}

}
