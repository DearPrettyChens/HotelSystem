package businesslogic.bl.hotelstrategybl;

import vo.hotelstrategyvo.HotelStrVO;
/**
 * 酒店策略接口类
 * 采用策略模式
 * @author CYF
 * @version 1.0
 */
public interface HotelStrategyInterface {
	/**
	 * 获取酒店策略
	 * @param hotelID String型 
	 * @return HotelStrVO
	 */
	public HotelStrVO getHotelStrategy(String hotelID);
	
	/**
	 * 计算最佳酒店策略时，获得折扣值
	 * @param info
	 * @return
	 */
	public double getDiscount(String info,String hotelID);
}
