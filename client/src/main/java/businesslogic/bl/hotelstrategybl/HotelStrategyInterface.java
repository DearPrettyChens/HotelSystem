package businesslogic.bl.hotelstrategybl;

import util.ResultMessage;
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
	 * 确认修改策略
	 * @param hotelStrVO
	 * @return ResultMessage
	 */
	public ResultMessage confirmHotelStrategy(HotelStrVO hotelStrVO);
	
}
