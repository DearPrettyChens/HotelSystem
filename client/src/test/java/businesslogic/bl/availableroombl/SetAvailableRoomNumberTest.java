package businesslogic.bl.availableroombl;

import org.junit.Before;
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

//	@Test
//	public void test() {
//		assertEquals(availableRoom.setAvailableRoomNumber(new AvailableRoomNumberVO(8,BedType.BIGBED,
//				new Date(),"000002")),ResultMessage.SUCCESS);
//		ArrayList<AvailableRoomInfoVO> roomInfo=availableRoom.getAvailableRoomInfo("000002");
//		for(int i=0;i<roomInfo.size();i++){
//			if(roomInfo.get(i).getBedType()==BedType.BIGBED){
//				assertEquals(roomInfo.get(i).getCurrentNumber(),8);
//			}
//		}
//	}

}
