package businesslogic.searchhotelbl;

import java.util.ArrayList;

import javax.rmi.CORBA.Stub;

import blservice.searchhotelblservice.SearchHotelBLService;
import common.HotelSortType;
import common.OrderState;
import vo.searchhotelvo.HotelListVO;

/**
 * 模拟搜索酒店模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class SearchHotelBL_Driver {
    public void driver(SearchHotelBLService stub) {
    	ArrayList<HotelListVO> hotelListVOs=stub.getHotelList();
    	ArrayList<HotelListVO> hotelListVOs2=stub.getSortedHotelList(HotelSortType.MULTIPLE_HIGH_TO_LOW);
    	ArrayList<HotelListVO> hotelListVOs3=stub.getBookedHotelList(HotelSortType.MULTIPLE_HIGH_TO_LOW, OrderState.HASCANCELED);
	}
	public static void main(String[] args) {
		new SearchHotelBL_Driver().driver(new SearchHotelBL_Stub());

	}

}
