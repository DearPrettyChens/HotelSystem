package businesslogic.blservice.orderblservice;

import util.ResultMessage;
/**
 * CancleOrderService提供接口,处理撤销订单
 * @author csy
 * @version 1.0
 * 
 */
public interface CancleOrderService {
	
	/**
	 * 撤销订单，如果是异常订单撤销，返还相应的信用值
	 * @param orderID String型，界面传递过来的订单号
	 * @return ResultMessage，撤销成功返回SUCCESS,撤销失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage cancelOrderConfirm (String orderID);
	
	/**
	 * 增加顾客订单总价全部或二分之一的信用值
	 * @param creditNum int 型，界面传递过来的信用值
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setReturnCredit(int creditNum);
}
