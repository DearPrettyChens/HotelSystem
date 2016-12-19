package blservice.availableroomblservice;

import common.BedType;
import common.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;


/**
 * AvailableRoomBLService提供接口，用来对可用客房信息的更新，对客房信息的录入
 * @author csy
 * @version 1.0
 * 
 */

public interface AvailableRoomBLService {
	
	/**
	 * 获取可用客房信息
	 * @param hotelID String型，界面传递过来的酒店编号
	 * @return AvailableRoomInfoVO，将可用客房信息返回给界面，checkin模块，hotel模块
	 * @throws 未定
	 *
	 */
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID);
	
	/**
	 * 确认维护的可用客房信息
	 * @param availableRoomInfoVO AvailableRoomInfoVO型，界面传递过来维护修改后的酒店信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAvailableRoomInfo (AvailableRoomInfoVO availableRoomInfoVO);
	
	/**
	 * 更新可用客房的信息
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，传递当前可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setAvailableRoomNumber (AvailableRoomNumberVO availableRoomNumberVO);
	
	/**
	 * 酒店促销策略变化后，更新各种房型的最低价格
	 * @param discount double型，传递当前可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setBestPrice (double discount);
	
	/**
	 * 订单计算价格的时候，来获取该房型价格

	 * @param hotelID String型,bedType BedType型，传递酒店编号和房间类型
	 * @return double 返回该房型价格
	 * @throws 未定
	 *
	 */
	public double getRoomPrice (String hotelID,BedType bedType);

	
	/**
	 * 检测是否有足够的可用客房数量
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，传递当前可用客房数量信息
	 * @return ResultMessage，如果有足够的房间返回SUCCESS,否则返回NOTENOUGHAVAILABLEROOM
	 * @throws 未定
	 *
	 */
	public ResultMessage checkAvailableRoomNumber (AvailableRoomNumberVO availableRoomNumberVO);

}
