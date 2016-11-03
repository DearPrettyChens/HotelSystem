package businesslogic.bl.hotelbl.mock;

import java.util.Date;

import businesslogic.bl.orderbl.SingleOrder;
import util.BedType;
import util.Children;
import util.OrderState;
import vo.ordervo.OrderInfoVO;
/**
 * singleorder的mock类
 * @author Csy
 * @version 1.0
 */
public class MockSingleOrder extends SingleOrder {
	/**
	 * 获取订单详细信息
	 * @param orderID String型，传递订单号
	 * @return OrderInfoVO ，将订单详细信息返回给界面或hotel模块
	 * @throws 未定
	 *
	 */
	
	public OrderInfoVO getOrderInfo(){
		return new OrderInfoVO("201610120001000001", "小豆", "12345678901", new Date(), new Date(),  new Date(),"豪华",BedType.BIGBED,1,1, Children.EXIST , OrderState.NOTEXECUTED, new Date());
		
	}
}
