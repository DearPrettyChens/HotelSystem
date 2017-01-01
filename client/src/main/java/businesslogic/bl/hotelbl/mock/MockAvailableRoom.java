package businesslogic.bl.hotelbl.mock;

import businesslogic.bl.availableroombl.AvailableRoom;
import util.BedType;
import vo.availableroomvo.AvailableRoomInfoVO;

/**
 * user的mock类
 * @author Csy
 * @version 1.0
 */
public class MockAvailableRoom{
	/**
	 * 获取酒店的可用房间信息
	 * @param hotelID
	 * @return AvailableRoomInfoVO
	 */
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		// TODO
		return new AvailableRoomInfoVO("0001", "汉庭",BedType.BIGBED, 33,33,1,true);
		
	}
}
