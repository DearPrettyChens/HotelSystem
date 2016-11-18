package businesslogic.blservice.availableroomblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * 用来获取酒店可用住房信息的接口
 * @author CLL
 * @version 1.0
 */
public interface AvailableRoomInfoService {
	/**
	 * 获取当天可用客房信息
	 * @param hotelID String型，界面传递过来的酒店编号
	 * @return AvailableRoomInfoVO，将可用客房信息返回给界面，checkin模块，hotel模块
	 * @throws 未定
	 *
	 */
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID);
	
	/**
	 * 确认维护的可用客房信息
	 * @param availableRoomInfoVO AvailableRoomInfoVO型，界面传递过来维护修改后的酒店信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAvailableRoomInfo (String hotelID,AvailableRoomInfoVO availableRoomInfoVO);
	
	/**
	 * 更新可用客房的信息
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，传递当前可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setAvailableRoomNumber (String hotelID,AvailableRoomNumberVO availableRoomNumberVO);
	/**
	 * 检测是否有足够的可用客房数量
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，传递当前可用客房数量信息
	 * @return ResultMessage，如果有足够的房间返回SUCCESS,否则返回NOTENOUGHAVAILABLEROOM
	 * @throws 未定
	 *
	 */
	public ResultMessage checkAvailableRoomNumber (String hotelID,AvailableRoomNumberVO availableRoomNumberVO);

}
