package blservice.orderblservice;

import java.util.ArrayList;
import java.util.Date;

import common.ResultMessage;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderVO;
import vo.ordervo.RemarkVO;
import vo.ordervo.TypeInfoVO;
/**
 * OrderBLService提供接口，用来对生成订单以及对有关订单状态的操作（执行，撤销，评价），浏览查看订单信息（包括搜索）
 * @author csy
 * @version 1.0
 * 
 */
public interface OrderBLService {
	
	/**
	 * 检测是否有大于0的信用值可生成订单
	 * @param CustomerID String型，传递顾客编号
	 * @return ResultMessage，如果信用值大于0返回SUCCESS,否则返回LACKOFCREDIT
	 * @throws 未定
	 *
	 */
	public ResultMessage checkUserCredit(String CustomerID);
	
	/**
	 * 检查顾客输入的电话格式
	 * @param telNum String型，传递顾客联系方式
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回USERTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTelephone(String telNum);
	
	/**
	 * 检查输入的入住日期的格式
	 * @param time Date型，传递入住日期
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回DATAFORMATERROR,
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTime(Date time);
	
	/**
	 * 新增订单信息
	 * @param orderInfoVO OrderInfoVO型，界面传递过来的订单信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmAddOrder(OrderInfoVO orderInfoVO);
	
	/**
	 * 获取订单详细信息
	 * @param orderID String型，传递订单号
	 * @return OrderInfoVO ，将订单详细信息返回给界面或hotel模块
	 * @throws 未定
	 *
	 */
	public OrderInfoVO getOrderInfo(String orderID);
	
	/**
	 * 获取特定类型的订单列表
	 * @param typeInfoVO TypeInfoVO型,传递订单类型信息
	 * @return  ArrayList<OrderVO> ，将特定订单列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<OrderVO> getOrderList(TypeInfoVO typeInfoVO);
	
	/**
	 * 撤销订单，如果是异常订单撤销，返还相应的信用值
	 * @param orderID String型，界面传递过来的订单号
	 * @return ResultMessage，撤销成功返回SUCCESS,撤销失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage cancelOrderConfirm (String orderID);
	
	/**
	 * 评价酒店
	 * @param remarkVO RemarkVO型，界面传递过来的评价信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage remarkOrder(RemarkVO remarkVO);
	
	/**
	 * 获取订单价格
	 * @param orderID String 型,传递订单号
	 * @return  double ，将订单总价返回给界面
	 * @throws 未定
	 *
	 */
	public double getPrice(String orderID);
	
	/**
	 * 保存订单实际入住时间
<<<<<<< HEAD
	 * @param time Date型，界面传递过来的实际入住时间
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setCheckinTime(Date time);
	
	/**
	 * 保存订单实际退房时间
	 * @param time Date型，界面传递过来的实际退房时间
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setCheckoutTime(Date time);
	
	/**
	 * 增加顾客订单总价全部或二分之一的信用值
	 * @param creditNum int 型，界面传递过来的信用值
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setReturnCredit(int creditNum);
	
}
