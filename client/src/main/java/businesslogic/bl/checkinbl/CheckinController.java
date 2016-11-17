package businesslogic.bl.checkinbl;

import businesslogic.blservice.checkinblservice.CheckinBLService;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.checkinvo.AvailableRoomInfoVO;

import vo.checkinvo.CheckinInfoVO;
import vo.ordervo.OrderInfoVO;
/**
 * checkin的控制类
 * @author CLL
 * @version 1.0
 */
public class CheckinController implements CheckinBLService{
	//持有checkin的引用
	private Checkin checkin;
	private static CheckinController checkinController=null;
	
	private CheckinController(String hotelID){
		checkin=new Checkin(hotelID);
	}
	
	//实现单例模式
	public CheckinController getInstance(String hotelID){
		if(checkinController==null||checkinController.checkin.getHotelID()!=hotelID){
			checkinController=new CheckinController(hotelID);
		}
		return checkinController;
	}

	
	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		return checkin.getOrderInfo(orderID);
	}

	@Override
	public CheckinInfoVO getCheckinInfo(String orderID) {
		return checkin.getCheckinInfo(orderID);
	}
	/**
	 * 检查身份证号码长度18位
	 * @param String
	 * @return ResultMessage
	 */
	@Override
	public ResultMessage checkIDLength(String ID) {
		if(ID.length()==18){
			return ResultMessage.SUCCESS;
		}
		else{
			return ResultMessage.IDFORMATERROR;
		}
		//return checkin.checkIDLength(ID);
	}

	@Override
	public ResultMessage confirmCheckinInfo(CheckinInfoVO checkinInfoVO) {
		return checkin.confirmCheckinInfo(checkinInfoVO);
	}

	@Override
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO checkinInfoVO) {
		return checkin.confirmCheckoutInfo(checkinInfoVO);
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(String hotelID, BedType bedType, int number) {
		return checkin.checkAvailableRoomNumber(hotelID, bedType, number);
	}



	@Override
	public ResultMessage confirmAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO) {
		return checkin.confirmAvailableRoomNumber(availableRoomNumberVO);
	}



	@Override
	public vo.availableroomvo.AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		return checkin.getAvailableRoomInfo(hotelID);
	}

}
