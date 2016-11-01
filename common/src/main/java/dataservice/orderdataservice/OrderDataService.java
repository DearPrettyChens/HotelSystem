package dataservice.orderdataservice;

import java.util.ArrayList;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;
import util.ResultMessage;

/**
 * OrderDataService提供接口，用来订单数据进行获取、添加、设置操作
 * @author CYF
 * @version 1.0
 * 
 */

public interface OrderDataService {
	/**
	 * 
	 */
	public void initial();
	/**
	 * 获得订单信息
	 * @param orderID String型，用来传递订单ID
	 * @return OrderInfoPO 用来获取订单详细信息
	 * @throws 未定
	 * 
	 */
	public OrderInfoPO getOrderInfo(String orderID);
	/**
	 * 获得订单列表
	 * @param keyword String型，用来传递关键字
	 * @return ArrayList<OrderListPO> 用来获取订单列表信息
	 * @throws 未定
	 */
	public ArrayList<OrderListPO> getOrderList(String keyword);
	/**
	 * 添加订单状态
	 * @param po OrderStatePO型，用来传递订单状态
	 * @return ResultMessage，如果添加成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage addOrderState(OrderStatePO po);
	/**
	 * 设置订单评价
	 * @param po RemarkPO型，用来设置订单评价
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setOrderRemark(RemarkPO po);
	/**
	 * 设置入住时间
	 * @param po CheckTimePO型，用来设置订单入住时间信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setCheckintime(CheckTimePO po);
	/**
	 * 设置退房时间
	 * @param po CheckTimePO型，用来设置订单退房时间信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setCheckouttime(CheckTimePO po);
	/**
	 * 添加订单
	 * @param po OrderInfoPO型，用来传递新增订单信息
	 * @return ResultMessage，如果设置成功返回SUCCESS,否则返回FAIL
	 * @throws 未定
	 */
	public ResultMessage addOrder(OrderInfoPO po);
}
