package businesslogic.availableroombl;

import blservice.availableroomblservice.AvailableRoomBLService;

import common.BedType;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * 模拟可用房间模块界面层与逻辑层交互的实现
 * @author CLL
 *
 */
public class AvailableRoomBL_Driver {
	public void drive(AvailableRoomBLService stub){
		AvailableRoomInfoVO availableRoomInfoVO=stub.getAvailableRoomInfo("0001");
		AvailableRoomNumberVO availableRoomNumberVO=new AvailableRoomNumberVO();
		System.out.println(stub.confirmAvailableRoomInfo(availableRoomInfoVO));
		System.out.println(stub.setAvailableRoomNumber(availableRoomNumberVO));
		System.out.println(stub.setBestPrice(0.9));
		System.out.println(stub.getRoomPrice("0001", BedType.BIGBED));
		System.out.println(stub.checkAvailableRoomNumber(availableRoomNumberVO));
	}
	
	public static void main(String[] args){
		new AvailableRoomBL_Driver().drive(new AvailableRoomBL_Stub());
	}
}
