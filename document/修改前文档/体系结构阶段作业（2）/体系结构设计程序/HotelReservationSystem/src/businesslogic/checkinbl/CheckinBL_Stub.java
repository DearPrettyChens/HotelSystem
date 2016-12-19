package businesslogic.checkinbl;

import blservice.checkinblservice.CheckinBLService;

import common.BedType;
import common.ResultMessage;
import vo.checkinvo.AvailableRoomInfoVO;
import vo.checkinvo.AvailableRoomNumberVO;
import vo.checkinvo.CheckinInfoVO;
import vo.checkinvo.OrderInfoVO;
/**
 * 模拟顾客入住退房模块界面层和逻辑层交互的实现
 * @author CLL
 *
 */
public class CheckinBL_Stub implements CheckinBLService{

	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return new OrderInfoVO();
	}

	@Override
	public CheckinInfoVO getCheckinInfo(String orderID) {
		// TODO Auto-generated method stub
		return new CheckinInfoVO();
	}

	@Override
	public ResultMessage checkIDLength(String ID) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmCheckinInfo(CheckinInfoVO checkinInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO checkinInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(BedType bedType, String number) {

		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public AvailableRoomInfoVO getAvailableRoomInfo() {
		// TODO Auto-generated method stub
		return new AvailableRoomInfoVO();
	}

}
