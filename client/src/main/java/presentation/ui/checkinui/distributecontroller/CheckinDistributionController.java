package presentation.ui.checkinui.distributecontroller;

import java.util.ArrayList;

import businesslogic.bl.availableroombl.AvailableRoomInfoController;
import businesslogic.bl.checkinbl.CheckinController;
import businesslogic.blservice.availableroomblservice.AvailableRoomInfoService;
import businesslogic.blservice.checkinblservice.CheckinBLService;
import presentation.ui.availableroomui.distributecontroller.AvailableRoomInfoService_Stub;
import util.BedType;
import util.ResultMessage;
import vo.checkinvo.CheckinInfoVO;
import vo.ordervo.OrderInfoVO;
/**
 * checkin界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class CheckinDistributionController {
	private static CheckinDistributionController controller=null;
	private CheckinBLService checkinBLService;
	private AvailableRoomInfoService availableRoomInfoService;
	private CheckinDistributionController(){
		checkinBLService=CheckinController.getInstance();
		availableRoomInfoService=AvailableRoomInfoController.getInstance();
//		checkinBLService=new CheckinBLService_Stub();
//	    availableRoomInfoService=new AvailableRoomInfoService_Stub();
	}
	public static CheckinDistributionController getInstance(){
		if(controller==null){
			controller=new CheckinDistributionController();
		}
		return controller;
	}
	
	/**
	 * 获取订单详细信息
	 * @param orderID String型，界面传递过来的订单编号
	 * @return OrderInfoVO，将订单信息返回给界面
	 * @throws 未定
	 *
	 */
	public OrderInfoVO getOrderInfo(String orderID){
		return checkinBLService.getOrderInfo(orderID);
	}
	
	/**
	 * 获取顾客住房信息
	 * @param orderID String型，界面传递过来的订单编号
	 * @return CheckinInfoVO，将顾客住房信息返回给界面
	 * @throws 未定
	 *
	 */
	public CheckinInfoVO getCheckinInfo(String orderID){
		return checkinBLService.getCheckinInfo(orderID);
	}
	
	/**
	 * 检查身份证格式是否正确
	 * @param ID String型，界面传递过来的身份证号
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回IDFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkIDLength(String ID){
		return checkinBLService.checkIDLength(ID);
	}
	
	/**
	 * 新增顾客住房信息并自动更新订单信息
	 * @param checkinInfoVO CheckinInfoVO型，界面传递过来的住房信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmCheckinInfo(CheckinInfoVO checkinInfoVO){
		return checkinBLService.confirmCheckinInfo(checkinInfoVO);
	}
	
	/**
	 * 修改顾客住房信息并自动更新订单信息和可用客房信息。
	 * 
	 * @param checkinInfoVO CheckinInfoVO型，界面传递过来的住房信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO checkinInfoVO){
		return checkinBLService.confirmCheckoutInfo(checkinInfoVO);
	}
	
	/**
	 * 判断输入的可用客房数量是否超过该类型客房总数
	 * @param bedType BedType型,number String型，界面传递过来的房间类型和房间数量
	 * @return ResultMessage 未超过返回SUCCESS,超过返回FAIL
	 * @throws 未定
	 *
	 */
	public ResultMessage checkAvailableRoomNumber(String hotelID,BedType bedType,int number){
		return checkinBLService.checkAvailableRoomNumber(hotelID, bedType, number);
	}

	
	/**
	 * 修改该酒店可用客房信息
	 * @param availableRoomNumberVO AvailableRoomNumberVO型，界面传递过来的可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAvailableRoomNumber(vo.availableroomvo.AvailableRoomNumberVO availableRoomNumberVO){
		return checkinBLService.confirmAvailableRoomNumber(availableRoomNumberVO);
	}
	
	/**
	 * 获取该酒店的可用房间信息
	 * @param 无
	 * @return AvailableRoomInfoVO，返回酒店可用客房信息
	 * @throws 未定
	 *
	 */
	public ArrayList<vo.availableroomvo.AvailableRoomInfoVO> getAvailableRoomInfo(String hotelID){
		return availableRoomInfoService.getAvailableRoomInfo(hotelID);
	}
	
}

