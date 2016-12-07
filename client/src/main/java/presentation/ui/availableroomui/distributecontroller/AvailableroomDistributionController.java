package presentation.ui.availableroomui.distributecontroller;

import java.util.ArrayList;

import businesslogic.bl.availableroombl.AvailableRoomInfoController;
import businesslogic.bl.availableroombl.RoomPriceController;
import businesslogic.blservice.availableroomblservice.AvailableRoomInfoService;
import businesslogic.blservice.availableroomblservice.RoomPriceService;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
/**
 * availableroom界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class AvailableroomDistributionController {
	private static AvailableroomDistributionController controller=null;
	private AvailableRoomInfoService availableRoomInfoService;
	private RoomPriceService roomPriceService;
	private AvailableroomDistributionController(){
//		availableRoomInfoService=AvailableRoomInfoController.getInstance();
//		roomPriceService=RoomPriceController.getInstance();
	    availableRoomInfoService=new AvailableRoomInfoService_Stub();
	    roomPriceService=new RoomPriceService_Stub();
	
	}
	public static AvailableroomDistributionController getInstance(){
		if(controller==null){
			controller=new AvailableroomDistributionController();
		}
		return controller;
	}
	
	/**
	 * 获取当天可用客房信息
	 * @param hotelID String型，界面传递过来的酒店编号
	 * @return AvailableRoomInfoVO，将可用客房信息返回给界面，checkin模块，hotel模块
	 * @throws 未定
	 *
	 */
	public ArrayList<AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID){
		return availableRoomInfoService.getAvailableRoomInfo(hotelID);
	}
	
	/**
	 * 确认维护的可用客房信息
	 * @param availableRoomInfoVO AvailableRoomInfoVO型，界面传递过来维护修改后的酒店信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAvailableRoomInfo (String hotelID,AvailableRoomInfoVO availableRoomInfoVO){
		return availableRoomInfoService.confirmAvailableRoomInfo(hotelID, availableRoomInfoVO);
	}
	
	/**
	 * 更新可用客房的信息
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，传递当前可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setAvailableRoomNumber (String hotelID,AvailableRoomNumberVO availableRoomNumberVO){
		return availableRoomInfoService.setAvailableRoomNumber(hotelID, availableRoomNumberVO);
	}
	/**
	 * 检测是否有足够的可用客房数量
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，传递当前可用客房数量信息
	 * @return ResultMessage，如果有足够的房间返回SUCCESS,否则返回NOTENOUGHAVAILABLEROOM
	 * @throws 未定
	 *
	 */
	public ResultMessage checkAvailableRoomNumber (String hotelID,AvailableRoomNumberVO availableRoomNumberVO){
		return availableRoomInfoService.checkAvailableRoomNumber(hotelID, availableRoomNumberVO);
	}
	
	/**
	 * 酒店促销策略变化后，更新各种房型的最低价格
	 * @param discount double型，传递当前可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setBestPrice (String hotelID,double discount){
		return roomPriceService.setBestPrice(hotelID, discount);
	}
	
	/**
	 * 订单计算价格的时候，来获取该房型价格

	 * @param hotelID String型,bedType BedType型，传递酒店编号和房间类型
	 * @return double 返回该房型价格
	 * @throws 未定
	 *
	 */
	public double getRoomPrice (String hotelID,BedType bedType){
		return roomPriceService.getRoomPrice(hotelID, bedType);
	}
}
