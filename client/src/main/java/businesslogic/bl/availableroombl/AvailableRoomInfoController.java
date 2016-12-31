package businesslogic.bl.availableroombl;

import java.util.ArrayList;

import businesslogic.blservice.availableroomblservice.AvailableRoomInfoService;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;

/**
 * AvailableRoomInfo的控制类
 * 
 * @author CLL
 * @version 1.0
 */
public class AvailableRoomInfoController implements AvailableRoomInfoService{
	//持有AvailableRoom引用
	private AvailableRoom availableRoom;
	private static AvailableRoomInfoController controller=null;
	private AvailableRoomInfoController(){
		availableRoom=new AvailableRoom();
	}
	//实现单件模式
	public static AvailableRoomInfoController getInstance(){
		if(controller==null){
			return controller=new AvailableRoomInfoController();
		}
		else{
			return controller;
		}
	}
	@Override
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID) {
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
		//委托给availableRoom,availableRoomNumberVO
		return availableRoom.checkAvailableRoomNumber(availableRoomNumberVO);
	}



}
