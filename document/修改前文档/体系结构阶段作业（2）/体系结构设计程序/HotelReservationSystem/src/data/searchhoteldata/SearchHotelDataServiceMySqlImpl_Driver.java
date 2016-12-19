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
public class SearchHotelDataServiceMySqlImpl_Driver {

	public void drive(SearchHotelDataService stub) {
		ArrayList<HotelListPO> hotelListPOs=stub.getHotelList();
		ArrayList<HotelListPO> hotelListPOs2=stub.getSortedHotelList(HotelSortType.MULTIPLE_HIGH_TO_LOW);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new SearchHotelDataServiceMySqlImpl_Driver().drive(new SearchHotelDataServiceMySqlImpl_Stub());
	}

}
