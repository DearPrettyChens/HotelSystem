package businesslogic.bl.availableroombl;

import java.util.ArrayList;

import dao.availableroomdao.AvailableRoomDao;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * AvailableRoom的领域类
 * @author CLL
 * @version 1.0
 */
public class AvailableRoom {
	//可用住房信息列表
	private ArrayList<SingleAvailableRoomInfo> singleAvailableRoomInfoList;
	//数据层的引用
	private AvailableRoomDao availableRoomDao;
	public AvailableRoom(){
		
	}
	
	/**
	 * 获取酒店的可用房间信息
	 * @param hotelID
	 * @return AvailableRoomInfoVO
	 */
	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID) {
		// TODO
		return null;
	}
	/**
	 * 新增酒店房间信息
	 * @param availableRoomInfoVO
	 * @return ResultMessage
	 */
	public ResultMessage confirmAvailableRoomInfo(String hotelID,AvailableRoomInfoVO availableRoomInfoVO) {
		// TODO
		return null;
	}
	/**
	 * 更新可用房间信息,找到对应的singleavailableroominfo对象并委托给它
	 * @param availableRoomNumberVO
	 * @return ResultMessage
	 */
	public ResultMessage setAvailableRoomNumber(String hotelID,AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO
		return null;
	}
	/**
	 * 更新各种房型的最低价格，遍历list，更新其中的房型价格
	 * @param discount
	 * @return ResultMessage
	 */
	public ResultMessage setBestPrice(String hotelID,double discount) {
		// TODO 
		return null;
	}
	/**
	 * 系统返回该房型价格
	 * @param hotelID
	 * @param bedType
	 * @return ResultMessage
	 */
	public double getRoomPrice(String hotelID, BedType bedType) {
		// TODO
		return 0;
	}
	/**
	 * 判断是否有足够的可用客房
	 * @param availableRoomNumberVO
	 * @return ResultMessage
	 */
	public ResultMessage checkAvailableRoomNumber(String hotelID,AvailableRoomNumberVO availableRoomNumberVO) {
		// TODO 
		return null;
	}
}
