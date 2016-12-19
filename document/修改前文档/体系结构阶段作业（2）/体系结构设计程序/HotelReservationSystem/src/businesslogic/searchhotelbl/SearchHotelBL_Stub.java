package businesslogic.searchhotelbl;

import java.util.ArrayList;

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
public class SearchHotelBL_Stub implements SearchHotelBLService{

	@Override
	public ArrayList<HotelListVO> getHotelList() {
		// TODO Auto-generated method stub
		return new ArrayList<HotelListVO> ();
	}

	@Override
	public ArrayList<HotelListVO> getSortedHotelList(HotelSortType type) {
		// TODO Auto-generated method stub
		return new ArrayList<HotelListVO>();
	}

	@Override
	public ArrayList<HotelListVO> getBookedHotelList(HotelSortType type,OrderState orderState) {
		// TODO Auto-generated method stub
		return new ArrayList<HotelListVO>();
	}

}
