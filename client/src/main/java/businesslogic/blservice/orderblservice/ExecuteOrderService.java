package businesslogic.blservice.orderblservice;

import java.util.Date;

import util.ResultMessage;
import vo.ordervo.RemarkVO;

/**
 * ExecuteOrderService提供接口，用来对执行订单的接口，包括评价订单
 * @author csy
 * @version 1.0
 * 
 */
public interface ExecuteOrderService {
	/**
	 * 评价酒店
	 * @param remarkVO RemarkVO型，界面传递过来的评价信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage remarkOrder(RemarkVO remarkVO);
	
	/**
	 * 保存订单实际入住时间
	 * @param time Date型，orderID string型，界面传递过来的实际入住时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */

	public ResultMessage setCheckinTime(Date time,String orderID);
	
	/**
	 * 保存订单实际退房时间
	 * @param time Date型，orderID string型界面传递过来的实际退房时间和订单编号
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setCheckoutTime(Date time,String orderID);
}
