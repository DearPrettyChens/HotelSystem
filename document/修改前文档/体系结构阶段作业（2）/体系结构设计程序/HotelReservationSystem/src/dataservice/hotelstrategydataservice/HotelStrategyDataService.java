package dataservice.hotelstrategydataservice;

import common.HotelStrategyType;
import common.ResultMessage;
import po.HotelStrPO;


/**
 * 负责保存酒店营销策略
 * @author csy
 * @version 1.0
 * 
 */

public interface HotelStrategyDataService {
	public void initial();
	
	/**
	 * 获取特定策略类型的酒店策略信息
	 * @param  hotelID String型,type HotelStrategyType 型，传递酒店编号和酒店策略类型
	 * @return  HotelStrPO 返回特定类型的酒店策略
	 * @throws 无
	 *
	 */
	public HotelStrPO getHotelStrategy(String hotelID,HotelStrategyType type);
	
	/**
	 * 设置酒店策略信息
	 * @param  po HotelStrPO型，传递修改后的酒店策略信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage setHotelStrategy(HotelStrPO po);
}
