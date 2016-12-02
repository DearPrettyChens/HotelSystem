package businesslogic.bl.availableroombl;

import util.ResultMessage;

/**
 * AvailableRoom模块的依赖倒置，将hotel的接口放在AvailableRoom中
 * @author csy
 * @version 1.0
 */
public interface HotelInfoAvailService {
	/**
	 * 可用客房模块设置酒店的最低价格
	 * @param price double型，hotelID String型，传递酒店最低价格
	 * @return ResultMessage，设置成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 *
	 */
     public ResultMessage setBestPrice(double price,String hotelID);
}
