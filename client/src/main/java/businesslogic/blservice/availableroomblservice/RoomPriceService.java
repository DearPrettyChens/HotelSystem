package businesslogic.blservice.availableroomblservice;

import util.BedType;
import util.ResultMessage;

/**
 * 用来更新和获得酒店房间价格的接口
 * @author CLL
 * @version 1.0
 */
public interface RoomPriceService {
	/**
	 * 酒店促销策略变化后，更新各种房型的最低价格
	 * @param discount double型，传递当前可用客房数量信息
	 * @return ResultMessage，保存成功返回SUCCESS，失败返回FIAL,若是由于格式错误，返回具体格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage setBestPrice (String hotelID,double discount);
	
	/**
	 * 订单计算价格的时候，来获取该房型价格

	 * @param hotelID String型,bedType BedType型，传递酒店编号和房间类型
	 * @return double 返回该房型价格
	 * @throws 未定
	 *
	 */
	public double getRoomPrice (String hotelID,BedType bedType);
}
