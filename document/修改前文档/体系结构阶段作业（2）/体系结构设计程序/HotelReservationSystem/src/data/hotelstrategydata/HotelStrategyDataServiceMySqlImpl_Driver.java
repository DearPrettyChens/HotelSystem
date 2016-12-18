package data.hotelstrategydata;

import common.HotelStrategyType;
import dataservice.hotelstrategydataservice.HotelStrategyDataService;
import po.HotelStrPO;

/**
 * 模拟hotelstrategy模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class HotelStrategyDataServiceMySqlImpl_Driver {

	public void drive(HotelStrategyDataService stub) {
         HotelStrPO hotelStrPO=stub.getHotelStrategy("0001", HotelStrategyType.AMOUNT);
		System.out.println(stub.setHotelStrategy(hotelStrPO));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new HotelStrategyDataServiceMySqlImpl_Driver().drive(new HotelStrategyDataServiceMySqlImpl_Stub());
	}

}
