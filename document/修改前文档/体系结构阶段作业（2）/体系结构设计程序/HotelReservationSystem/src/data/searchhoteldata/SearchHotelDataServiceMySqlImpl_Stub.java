package data.searchhoteldata;

import java.util.ArrayList;

import common.HotelSortType;
import dataservice.searchhoteldataservice.SearchHotelDataService;
import po.HotelListPO;

/**
 * 模拟searchhotel模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class SearchHotelDataServiceMySqlImpl_Stub implements SearchHotelDataService {

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HotelListPO> getHotelList() {
		// TODO Auto-generated method stub
		return new ArrayList<HotelListPO>();
	}

	@Override
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type) {
		// TODO Auto-generated method stub
		return new  ArrayList<HotelListPO>();
	}

	
}
