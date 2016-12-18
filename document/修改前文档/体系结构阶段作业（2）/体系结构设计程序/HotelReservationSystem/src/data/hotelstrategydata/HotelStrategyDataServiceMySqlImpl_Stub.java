package data.hotelstrategydata;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

import common.HotelStrategyType;
import common.ResultMessage;
import common.Strategy;
import dataservice.hotelstrategydataservice.HotelStrategyDataService;
import po.HotelStrPO;

/**
 * 模拟hotelstrategy模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class HotelStrategyDataServiceMySqlImpl_Stub implements HotelStrategyDataService{

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) {
		// TODO Auto-generated method stub
		return new HotelStrPO(new ArrayList<Strategy>());
	}

	@Override
	public ResultMessage setHotelStrategy(HotelStrPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	
}
