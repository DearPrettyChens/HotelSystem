package businesslogic.bl.availableroombl;

import businesslogic.blservice.availableroomblservice.AvailableRoomInfoService;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;

public class AvailableRoomInfoController implements AvailableRoomInfoService{
	//持有AvailableRoom引用
	private AvailableRoom availableRoom;
	public AvailableRoomInfoController(){
		availableRoom=new AvailableRoom();
	}
	@Override
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage confirmAvailableRoomInfo(String hotelID, AvailableRoomInfoVO availableRoomInfoVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage setAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage checkAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return null;
	}



}
