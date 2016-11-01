package businesslogic.blservice.hotelblservice;

import java.util.ArrayList;

import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;

/**
 * HotelOrderService提供接口，用来对查看酒店的订单
 * @author csy
 * @version 1.0
 * 
 */
public interface HotelOrderService {
	/**
	 * 获取酒店的订单列表
	 * @param hotelID String型，传递酒店编号
	 * @return ArrayList<HotelOrderVO>，返回酒店的订单列表给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelOrderVO> getHotelOrderList(String hotelID);
	
	/**
	 * 获取酒店的订单详细信息
	 * @param orderID String型，传递订单编号
	 * @return HotelOrderInfoVO，返回酒店的订单详细信息
	 * @throws 未定
	 *
	 */
	public HotelOrderInfoVO getHotelOrderInfo(String orderID);
}
