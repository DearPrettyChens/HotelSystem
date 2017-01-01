package businesslogic.bl.checkinbl.mock;

import businesslogic.bl.availableroombl.AvailableRoom;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;

public class MockAvailableRoom extends AvailableRoom {
	
	public MockAvailableRoom(){
		super();
	}


	/**
	 * 更新可用房间信息,找到对应的singleavailableroominfo对象并委托给它
	 * 
	 * @param availableRoomNumberVO
	 * @return ResultMessage
	 */
	public ResultMessage setAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO
		return ResultMessage.SUCCESS;
	}
}
