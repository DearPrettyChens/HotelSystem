package presentation.ui.orderui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.bl.orderbl.CancleOrderController;
import businesslogic.bl.orderbl.ExecuteOrderController;
import businesslogic.bl.orderbl.GenerateOrderController;
import businesslogic.bl.orderbl.LookOrderController;
import businesslogic.blservice.orderblservice.CancleOrderService;
import businesslogic.blservice.orderblservice.ExecuteOrderService;
import businesslogic.blservice.orderblservice.GenerateOrderService;
import businesslogic.blservice.orderblservice.LookOrderService;

import exception.NotFoundHotelException;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.RemarkVO;
import vo.ordervo.StrategyVO;
import vo.ordervo.TypeInfoVO;
/**
 * order界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class OrderDistributionController {
	private static OrderDistributionController controller=null;
	private CancleOrderService cancleOrderService;
	private ExecuteOrderService executeOrderService;
	private GenerateOrderService generateOrderService;
	private LookOrderService lookOrderService;
	private OrderDistributionController(){
		cancleOrderService=CancleOrderController.getInstance();
		executeOrderService=ExecuteOrderController.getInstance();
		generateOrderService=GenerateOrderController.getInstance();
		lookOrderService=LookOrderController.getInstance();
//	    cancleOrderService=new CancleOrderService_Stub();
//	    executeOrderService=new ExecuteOrderService_Stub();
//	    generateOrderService=new GenerateOrderService_Stub();
//	    lookOrderService=new LookOrderService_Stub();

	}
	public static OrderDistributionController getInstance(){
		if(controller==null){
			controller=new OrderDistributionController();
		}
		return controller;
	}
	
	/**
	 * 撤销订单，异常订单撤销，返还相应的信用值
	 * @param  orderId String型，creditNum int 界面传递过来的
	 * @return ResultMessage，撤销成功返回SUCCESS,撤销失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setReturnCredit(String orderId,int creditNum){
		return cancleOrderService.setReturnCredit(orderId, creditNum);
	}
	
	/**
	 * 扣除顾客订单总价全部或二分之一的信用值
	 * @param orderID String型，界面传递过来的订单号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage cancelOrderConfirm (String orderID){
		return cancleOrderService.cancelOrderConfirm(orderID);
	}
	
	/**
	 * 评价酒店
	 * @param remarkVO RemarkVO型，界面传递过来的评价信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage remarkOrder(RemarkVO remarkVO){
		return executeOrderService.remarkOrder(remarkVO);
	}
	
	/**
	 * 保存订单实际入住时间
	 * @param time Date型，orderID string型，界面传递过来的实际入住时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */

	public ResultMessage setCheckinTime(Date time,String orderID){
		return executeOrderService.setCheckinTime(time, orderID);
	}
	
	/**
	 * 保存订单实际退房时间
	 * @param time Date型，orderID string型界面传递过来的实际退房时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setCheckoutTime(Date time,String orderID){
		return executeOrderService.setCheckoutTime(time, orderID);
	}
	
	/**
	 * 检测是否有大于0的信用值可生成订单
	 * @param CustomerID String型，传递顾客编号
	 * @return ResultMessage，如果信用值大于0返回SUCCESS,否则返回LACKOFCREDIT
	 * @throws 未定
	 *
	 */
	public ResultMessage checkUserCredit(String CustomerID){
		return generateOrderService.checkUserCredit(CustomerID);
	}
	
	/**
	 * 检查顾客输入的电话格式
	 * @param telNum String型，传递顾客联系方式
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回USERTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTelephone(String telNum){
		return generateOrderService.checkTelephone(telNum);
	}
	
	/**
	 * 检查输入的入住日期的格式
	 * @param time Date型，传递入住日期
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回daoFORMATERROR,
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTime(Date time){
		return generateOrderService.checkTime(time);
	}
	
	/**
	 * 新增订单信息
	 * @param 
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAddOrder(OrderInfoVO orderInfoVO){
		return generateOrderService.confirmAddOrder(orderInfoVO);
	}
	
	/**
	 * 产生优惠信息
	 * @param orderInfoVO OrderInfoVO型，界面传递过来的订单信息
	 * @return 返回策略信息和优惠价格
	 * @throws 未定
	 *
	 */
	public StrategyVO next(OrderInfoVO orderinfovo){
		return generateOrderService.next(orderinfovo);
	}
	
	/**
	 * 生成订单的界面上需要酒店的信息（可用客房+酒店地址电话）
	 * @param hotelID string 型，界面传递过来的酒店编号
	 * @return HotelDetailInfoVO，返回酒店详细信息
	 * @throws NotFoundHotelException 
	 *
	 */
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID) throws NotFoundHotelException{
		return generateOrderService.getHotelDetailInfo(hotelID);
	}
	
	/**
	 * 检查订单上可用客房是否数量足够
	 * @param vo AvailableRoomNumberVO型，传递可用客房数量信息
	 * @return ResultMessage，数量足够返回SUCCESS,数量不够返回NOTENOUGHAVAILABLEROOM,
	 * @throws 未定
	 *
	 */
	public ResultMessage checkAvailableRoomNumber (AvailableRoomNumberVO vo){
		return generateOrderService.checkAvailableRoomNumber(vo);
	}
	
	/**
	 * 获取订单详细信息
	 * @param orderID String型，传递订单号
	 * @return OrderInfoVO ，将订单详细信息返回给界面或hotel模块
	 * @throws 未定
	 *
	 */
	public OrderInfoVO getOrderInfo(String orderID){
		return lookOrderService.getOrderInfo(orderID);
	}
	
	/**
	 * 获取特定类型的订单列表
	 * @param typeInfoVO TypeInfoVO型,传递订单类型信息
	 * @return  ArrayList<OrderVO> ，将特定订单列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO typeInfoVO){
		return lookOrderService.getOrderList(typeInfoVO);
	}
	
}
