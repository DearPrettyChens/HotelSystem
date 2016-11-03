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
	 * 获取酒店的可用房间信息
	 * 
	 * @param hotelID
	 * @return AvailableRoomInfoVO
	 */
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		// TODO
		String[] roomType = { "双人房", "大床房" };
		BedType[] bedType = { BedType.TWOBEDS, BedType.BIGBED };
		double[] originalPrice = { 512, 256 };
		double[] lowestPrice = { 400, 200 };
		int[] number = { 20, 10 };
		return new AvailableRoomInfoVO("0001", "xx酒店", roomType, bedType, originalPrice, lowestPrice, number);
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
