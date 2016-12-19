package data.hoteldata;

import common.ResultMessage;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;

/**
 * 模拟hotel模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class HotelDataServiceMySqlImpl_Stub implements HotelDataService{

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) {
		// TODO Auto-generated method stub
		return new HotelBasicInfoPO();
	}

	@Override
	public ResultMessage addRemarkInfo(RemarkPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setBestPrice(HotelBestPricePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
}
