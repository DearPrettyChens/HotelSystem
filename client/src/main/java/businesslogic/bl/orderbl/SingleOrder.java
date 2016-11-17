package businesslogic.bl.orderbl;

import java.rmi.RemoteException;
import java.util.Date;

import businesslogic.bl.creditbl.Credit;
import businesslogic.bl.hotelbl.Hotel;
import dao.orderdao.OrderDao;
import init.RMIHelper;
import po.OrderStatePO;
import util.OrderState;
import util.ResultMessage;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.RemarkVO;
/**
 * Order模块的领域类
 * @author csy
 * @version 1.0
 */
public class SingleOrder {
	
	OrderDao orderDao;
	private HotelInfoOrderService hotelInfoOrderService;//解决循环依赖
	private Credit credit;
	public SingleOrder() {
		orderDao=RMIHelper.getOrderDao();
	}
	public SingleOrder(Hotel hotel){
		orderDao=RMIHelper.getOrderDao();
		this.hotelInfoOrderService=hotel;
	}
	
	/**
	 * 获取订单详细信息
	 * @param orderID String型，传递订单号
	 * @return OrderInfoVO ，将订单详细信息返回给界面或hotel模块
	 * @throws 未定
	 *
	 */
	public OrderInfoVO getOrderInfo(String orderID){
		try {
			return new OrderInfoVO(orderDao.getOrderInfo(orderID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 添加订单
	 * @param vo OrderInfoVO型，用来传递新增订单信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage addOrder(OrderInfoVO orderInfoVO){
		//TODO
		return null;
		//调用Availableroom.setAvailableRoomNumber更新可用房间数
	    //调用SingleOrder.addOrderState	更新订单状态
	}
	
	/**
	 * 添加订单状态
	 * @param orderstate OrderState型，用来传递订单状态
	 * @return ResultMessage，如果添加成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage addOrderState(OrderState orderState,String orderID){
		try {
			orderDao.addOrderState(new OrderStatePO(orderID,orderState));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
		
	}
	
	/**
	 * 异常订单撤销，返还相应的信用值
	 * @param orderID String型，界面传递过来的订单号 CreditNum String型
	 * @return ResultMessage，撤销成功返回SUCCESS,撤销失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setReturnCredit(String orderID,int CreditNum){
		//TODO
		credit=new Credit();
		return null;
		
		//调用Credit.addCredit异常订单撤销时，恢复顾客的信用值
	}
	/**
	 * 未执行订单撤销，扣除相应的信用值(与最晚执行时间距离6小时之内扣除一半）
	 * @param orderID String型，界面传递过来的订单号 CreditNum String型
	 * @return ResultMessage，撤销成功返回SUCCESS,撤销失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage cancelOrderConfirm(String orderID){
		//TODO
		//调用Credit.cutCredit扣除顾客信用值
		return null;
	}
	/**
	 * 保存订单实际入住时间
	 * @param time Date型，orderID string型，界面传递过来的实际入住时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */

	public ResultMessage setCheckinTime(Date time,String orderID){
		//TODO
		return null;
		//调用Credit.addCredit为顾客增加信用值
	}
	
	/**
	 * 保存订单实际退房时间
	 * @param time Date型，orderID string型界面传递过来的实际退房时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setCheckoutTime(Date time,String orderID){
		//TODO
		return null;
		//调用Availableroom.setAvailableRoomNumber更新可用房间数
	}
	
	/**
	 * 评价酒店
	 * @param remarkVO RemarkVO型，界面传递过来的评价信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage remarkOrder(RemarkVO vo){
		//TODO
		return null;
		//调用HotelInfoOrderService里面的addRemarkInfo方法
	}
}
