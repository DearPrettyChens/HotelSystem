package businesslogic.bl.hotelstrategybl;

import util.ResultMessage;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderProvidedVO;
/**
 * HotelStrategy类
 * @author CYF
 * @version 1.0
 */
public class HotelStrategy {
    /**
     * 获得酒店最佳策略
     * @param orderProvidedVO OrderProvidedVO型
     * @return HotelBestStrVO
     * 需接口：SearchHotelDataService.getHotelList
     */
	public HotelBestStrVO getBestHotelStrategy(OrderProvidedVO orderProvidedVO) {
		return null;
	}
    /**
     * 获取酒店某类型的策略 委托给hotelStrategyInterface
     * @param hotelID String型
     * @param hotelStrategyInterface HotelStrategyInterface型
     * @return HotelStrVO
     * 需接口：SearchHotelDataService. getSortedHotelList
     */
	public HotelStrVO getHotelStrategy(String hotelID, HotelStrategyInterface hotelStrategyInterface) {
		return hotelStrategyInterface.getHotelStrategy(hotelID);
	}
    /**
     * 修改酒店某类型的策略 委托给hotelStrategyInterface
     * @param hotelStrategyInterface
     * @param hotelStrategyInterface HotelStrategyInterface型，hotelStrVO HotelStrVO型
     * @return ResultMessage
     * 需接口：SearchHotelDataService. getBookedHotelList
     * Order.getOrderList
     */
	public ResultMessage confirmHotelStrategy(HotelStrategyInterface hotelStrategyInterface, HotelStrVO hotelStrVO) {
		return hotelStrategyInterface.confirmHotelStrategy(hotelStrVO);
	}
}
