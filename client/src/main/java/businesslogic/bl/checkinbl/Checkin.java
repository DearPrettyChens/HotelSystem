package businesslogic.bl.checkinbl;

import java.util.Date;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.orderbl.SingleOrder;
import businesslogic.bl.userbl.User;
import dao.availableroomdao.AvailableRoomDao;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.checkinvo.AvailableRoomInfoVO;
import vo.checkinvo.CheckinInfoVO;
import vo.ordervo.OrderInfoVO;
/**
 * checkin的领域类
 * @author CLL
 * @version1.0
 */
public class Checkin{
	private AvailableRoom availableRoom;
	private User user;
	private String hotelID;
	public Checkin(String hotelID){
		this.setHotelID(hotelID);
	}
	/**
	 * 根据订单号获取顾客订单信息
	 * @param orderID
	 * @return OrderInfoVO
	 */
	public OrderInfoVO getOrderInfo(String orderID){
		//从order那里获得的vo
		//vo.ordervo.OrderInfoVO orderVO=new SingleOrder().getOrderInfo(orderID);
		//转换成checkin的ordervo
		//OrderInfoVO checkinOrderVO=new OrderInfoVO();
		return new SingleOrder().getOrderInfo(orderID);
	}
	/**
	 * 获取查找到的顾客住房信息,委托给checkininfo
	 * @param orderID
	 * @return CheckinInfo
	 */
	public CheckinInfoVO getCheckinInfo(String orderID){
		return new CheckinInfo().getCheckinInfo(orderID);
	}
	/**
	 * 判断身份证格式是否正确(在controller进行简单判断）
	 * @param ID
	 * @return ResultMessage
	 */
/*	public ResultMessage checkIDLength(String ID){
		return null;
	}*/
	/**
	 * 新增顾客住房信息并自动更新订单信息,委托给checkininfo
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckinInfo(CheckinInfoVO vo){
		//调用checkinInfo
		CheckinInfo checkinInfo=new CheckinInfo(vo);
		return checkinInfo.confirmCheckinInfo();
	}
	/**
	 * 修改顾客住房信息并自动更新订单信息和可用客房信息
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO vo){
		//调用checkinInfo
		return new CheckinInfo().confirmCheckoutInfo(vo);
	}
	/**
	 * 判断输入客房数量是否超过该类型客房总数
	 * @param bedType
	 * @param number
	 * @return ResultMessage
	 */
	public ResultMessage checkAvailableRoomNumber(String hotelID,BedType bedType,int number){
		//调用availableroom的checkAvailableRoomNumber方法
		availableRoom=new AvailableRoom();
		return availableRoom.checkAvailableRoomNumber(new AvailableRoomNumberVO(number,bedType,new Date(),hotelID));
	}
	/**
	 * 系统持久化修改该酒店可用客房信息
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmAvailableRoomNumber(vo.availableroomvo.AvailableRoomNumberVO vo){
		//调用availableroom的setAvailableRoomNumber方法
		availableRoom=new AvailableRoom();
		return availableRoom.setAvailableRoomNumber(vo);
	}
	/**
	 * 系统返回该酒店的可用房间信息
	 * @return ResultMessage
	 */
	public vo.availableroomvo.AvailableRoomInfoVO getAvailableRoomInfo(String hotelID){
		//调用availableroomgetAvailableRoomInfo方法
		availableRoom=new AvailableRoom();
		return availableRoom.getAvailableRoomInfo(hotelID);
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

}
