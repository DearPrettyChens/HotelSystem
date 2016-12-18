package blservice.checkinblservice;

import common.BedType;
import common.ResultMessage;
import vo.checkinvo.AvailableRoomInfoVO;
import vo.checkinvo.AvailableRoomNumberVO;
import vo.checkinvo.CheckinInfoVO;
import vo.checkinvo.OrderInfoVO;
/**
	 * CheckinBLService提供接口，用来对酒店入住退房信息的更新
	 * @author csy
	 * @version 1.0
	 * 
	 */
public interface CheckinBLService {
	/**
	 * 获取订单详细信息
	 * @param orderID String型，界面传递过来的订单编号
	 * @return OrderInfoVO，将订单信息返回给界面
	 * @throws 未定
	 *
	 */
	public OrderInfoVO getOrderInfo(String orderID);
	
	/**
	 * 获取顾客住房信息
	 * @param orderID String型，界面传递过来的订单编号
	 * @return CheckinInfoVO，将顾客住房信息返回给界面
	 * @throws 未定
	 *
	 */
	public CheckinInfoVO getCheckinInfo(String orderID);
	
	/**
	 * 检查身份证格式是否正确
	 * @param ID String型，界面传递过来的身份证号
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回IDFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkIDLength(String ID);
	
	/**
	 * 新增顾客住房信息并自动更新订单信息
	 * @param checkinInfoVO CheckinInfoVO型，界面传递过来的住房信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmCheckinInfo(CheckinInfoVO checkinInfoVO);
	
	/**
	 * 修改顾客住房信息并自动更新订单信息和可用客房信息。
	 * 
	 * @param checkinInfoVO CheckinInfoVO型，界面传递过来的住房信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO checkinInfoVO);
	
	/**
	 * 判断输入的可用客房数量是否超过该类型客房总数
<<<<<<< HEAD
	 * @param bedType BedType型,number String型，界面传递过来的房间类型和房间数量
	 * @return ResultMessage 未超过返回SUCCESS,超过返回FAIL
	 * @throws 未定
	 *
	 */
	public ResultMessage checkAvailableRoomNumber(BedType bedType,String number);

	
	/**
	 * 修改该酒店可用客房信息
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，界面传递过来的可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAvailableRoomNumber(AvailableRoomNumberVO availableRoomNumberVO);
	
	/**
	 * 获取该酒店的可用房间信息
	 * @param 无
	 * @return AvailableRoomInfoVO，返回酒店可用客房信息
	 * @throws 未定
	 *
	 */
	public AvailableRoomInfoVO getAvailableRoomInfo();
	
}
