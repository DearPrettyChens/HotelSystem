package businesslogic.bl.availableroombl;

import businesslogic.blservice.availableroomblservice.AvailableRoomInfoService;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;

public class AvailableRoomInfoController implements AvailableRoomInfoService{
	//持有AvailableRoom引用
	private AvailableRoom availableRoom;
	private static AvailableRoomInfoController controller=null;
	public AvailableRoomInfoController(){
		availableRoom=new AvailableRoom();
	}
	//实现单件模式
	public static AvailableRoomInfoController getInstance(){
		if(controller==null){
			return new AvailableRoomInfoController();
		}
		else{
			return controller;
		}
	}
	@Override
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		//委托给availableRoom
		return availableRoom.getAvailableRoomInfo(hotelID);
	}
	@Override
	public ResultMessage confirmAvailableRoomInfo(String hotelID, AvailableRoomInfoVO availableRoomInfoVO) {
		//委托给availableRoom
		return availableRoom.confirmAvailableRoomInfo(hotelID, availableRoomInfoVO);
	}
	@Override
	public ResultMessage setAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		//委托给availableRoom
		return availableRoom.setAvailableRoomNumber(availableRoomNumberVO);
	}
	@Override
	public ResultMessage checkAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		//委托给availableRoom,availableRoomNumberVO中有hotelid貌似不用再传了？
		return availableRoom.checkAvailableRoomNumber(availableRoomNumberVO);
	}



}
