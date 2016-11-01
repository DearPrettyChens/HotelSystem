package businesslogic.bl.checkinbl;

import businesslogic.blservice.checkinblservice.CheckinBLService;
import util.BedType;
import util.ResultMessage;
import vo.checkinvo.AvailableRoomInfoVO;
import vo.checkinvo.AvailableRoomNumberVO;
import vo.checkinvo.CheckinInfoVO;
import vo.checkinvo.OrderInfoVO;
/**
 * checkin的控制类
 * @author CLL
 * @version1.0
 */
public class CheckinController implements CheckinBLService{
	//持有checkin的引用
	private Checkin checkin;
	
	public CheckinController(){
		checkin=new Checkin();
	}
	

	
	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return checkin.getOrderInfo(orderID);
	}

	@Override
	public CheckinInfoVO getCheckinInfo(String orderID) {
		// TODO Auto-generated method stub
		return checkin.getCheckinInfo(orderID);
	}

	@Override
	public ResultMessage checkIDLength(String ID) {
		// TODO Auto-generated method stub
		return checkin.checkIDLength(ID);
	}

	@Override
	public ResultMessage confirmCheckinInfo(CheckinInfoVO checkinInfoVO) {
		// TODO Auto-generated method stub
		return checkin.confirmCheckinInfo(checkinInfoVO);
	}

	@Override
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO checkinInfoVO) {
		// TODO Auto-generated method stub
		return checkin.confirmCheckoutInfo(checkinInfoVO);
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(String hotelID, BedType bedType, String number) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResultMessage confirmAvailableRoomNumber(String hotelID, AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		// TODO Auto-generated method stub
		return checkin.getAvailableRoomInfo(hotelID);
	}

}
