package businesslogic.bl.checkinbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.orderbl.SingleOrder;
import businesslogic.bl.userbl.User;
import dao.availableroomdao.AvailableRoomDao;
import exception.NullHotelIDException;
import exception.NullOrderIDException;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.checkinvo.AvailableRoomInfoVO;
import vo.checkinvo.CheckinInfoVO;
import vo.ordervo.OrderInfoVO;

/**
 * checkin的领域类
 * 
 * @author CLL @version1.0
 */
public class Checkin {
	private AvailableRoom availableRoom;

	public Checkin() {

	}

	/**
	 * 根据订单号获取顾客订单信息
	 * 
	 * @param orderID
	 * @return OrderInfoVO
	 * @throws NullOrderIDException
	 */
	public OrderInfoVO getOrderInfo(String orderID) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}
		SingleOrder singleOrder = new SingleOrder();
		return singleOrder.getOrderInfo(orderID);
	}

	/**
	 * 获取查找到的顾客住房信息,委托给checkininfo
	 * 
	 * @param orderID
	 * @return CheckinInfo
	 */
	public CheckinInfoVO getCheckinInfo(String orderID) throws NullOrderIDException {
		if (orderID == null) {
			throw new NullOrderIDException();
		}
		return new CheckinInfo().getCheckinInfo(orderID);
	}

	/**
	 * 新增顾客住房信息并自动更新订单信息,委托给checkininfo
	 * 
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckinInfo(CheckinInfoVO vo) {
		// 调用checkinInfo
		CheckinInfo checkinInfo = new CheckinInfo(vo);
		return checkinInfo.confirmCheckinInfo();
	}

	/**
	 * 修改顾客住房信息并自动更新订单信息和可用客房信息
	 * 
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO vo) {
		// 调用checkinInfo
		return new CheckinInfo(vo).confirmCheckoutInfo(vo);
	}

	/**
	 * 判断输入客房数量是否超过该类型客房总数
	 * 
	 * @param bedType
	 * @param number
	 * @return ResultMessage
	 * @throws NullHotelIDException
	 */
	public ResultMessage checkAvailableRoomNumber(String hotelID, BedType bedType, int number)
			throws NullHotelIDException {
		if (hotelID == null) {
			throw new NullHotelIDException();
		}
		// 调用availableroom的checkAvailableRoomNumber方法
		availableRoom = new AvailableRoom();
		return availableRoom.checkAvailableRoomNumber(new AvailableRoomNumberVO(number, bedType, new Date(), hotelID));
	}

	/**
	 * 系统持久化修改该酒店可用客房信息
	 * 
	 * @param vo
	 * @return ResultMessage
	 * @throws NullHotelIDException
	 */
	public ResultMessage confirmAvailableRoomNumber(vo.availableroomvo.AvailableRoomNumberVO vo)
			throws NullHotelIDException {
		if (vo.getHotelNumber() == null) {
			throw new NullHotelIDException();
		}
		// 调用availableroom的setAvailableRoomNumber方法
		availableRoom = new AvailableRoom();
		return availableRoom.setAvailableRoomNumber(vo);
	}

	/**
	 * 系统返回该酒店的可用房间信息
	 * 
	 * @return ResultMessage
	 * @throws NullHotelIDException
	 */
	public ArrayList<vo.availableroomvo.AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID)
			throws NullHotelIDException {
		if (hotelID == null) {
			throw new NullHotelIDException();
		}
		// 调用availableroomgetAvailableRoomInfo方法
		availableRoom = new AvailableRoom();
		return availableRoom.getAvailableRoomInfo(hotelID);
	}

}
