package businesslogic.availableroombl;

import blservice.availableroomblservice.AvailableRoomBLService;

import common.BedType;
import common.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * 模拟可用房间模块界面层与逻辑层交互的实现
 * @author CLL
 *
 */
public class AvailableRoomBL_Stub implements AvailableRoomBLService{

	@Override
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		// TODO Auto-generated method stub
		return new AvailableRoomInfoVO();
	}

	@Override
	public ResultMessage confirmAvailableRoomInfo(AvailableRoomInfoVO availableRoomInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setBestPrice(double discount) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getRoomPrice(String hotelID, BedType bedType) {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
