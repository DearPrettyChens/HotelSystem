package businesslogic.bl.checkinbl;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.userbl.User;
import dao.availableroomdao.AvailableRoomDao;
import util.BedType;
import util.ResultMessage;
import vo.checkinvo.AvailableRoomInfoVO;
import vo.checkinvo.AvailableRoomNumberVO;
import vo.checkinvo.CheckinInfoVO;
import vo.checkinvo.OrderInfoVO;
/**
 * checkin的领域类
 * @author CLL
 * @version1.0
 */
public class Checkin{
	//数据层的引用
	private AvailableRoomDao availableRoomDao;
	private AvailableRoom availableroom;
	private User user;
	public Checkin(){
		
	}
	/**
	 * 根据订单号获取顾客订单信息
	 * @param orderID
	 * @return OrderInfoVO
	 */
	public OrderInfoVO getOrderInfo(String orderID){
		//TODO 
		//调用ordermock类的方法
		return null;
	}
	/**
	 * 获取查找到的顾客住房信息,委托给checkininfo
	 * @param orderID
	 * @return CheckinInfo
	 */
	public CheckinInfoVO getCheckinInfo(String orderID){
		return null;
	}
	/**
	 * 判断身份证格式是否正确
	 * @param ID
	 * @return ResultMessage
	 */
	public ResultMessage checkIDLength(String ID){
		return null;
	}
	/**
	 * 新增顾客住房信息并自动更新订单信息,委托给checkininfo
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckinInfo(CheckinInfoVO vo){
		CheckinInfo checkinInfo=new CheckinInfo(vo);
		//TODO
		//调用order的checktime方法
		return null;
	}
	/**
	 * 修改顾客住房信息并自动更新订单信息和可用客房信息
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO vo){
		//TODO
		//调用checkinInfo构造函数
		//TODO
		//调用availableroom的setAvailableRoomNumber方法
		//TODO
		//调用order的checktime方法
		return null;
	}
	/**
	 * 判断输入可用客房数量是否超过该类型客房总数
	 * @param bedType
	 * @param number
	 * @return ResultMessage
	 */
	public ResultMessage checkAvailableRoomNumber(String hotelID,BedType bedType,String number){
		//TODO
		//调用availableroom的checkAvailableRoomNumber方法
		return null;
	}
	/**
	 * 系统持久化修改该酒店可用客房信息
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmAvailableRoomNumber(String hotelID,AvailableRoomNumberVO vo){
		//TODO
		//调用availableroom的confirmAvailableRoomInfo方法
		return null;
	}
	/**
	 * 系统返回该酒店的可用房间信息
	 * @return ResultMessage
	 */
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID){
		//TODO
		//调用availableroomgetAvailableRoomInfo方法
		return null;
	}

}
