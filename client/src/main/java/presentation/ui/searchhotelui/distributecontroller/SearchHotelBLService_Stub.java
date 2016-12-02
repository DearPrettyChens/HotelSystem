package presentation.ui.searchhotelui.distributecontroller;

import java.util.ArrayList;

import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import po.HotelListPO;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

public class SearchHotelBLService_Stub implements SearchHotelBLService{

	@Override
	public ArrayList<HotelListVO> getSortedHotelList(HotelSearchInfoVO hotelSearchInfoVO) {
		// TODO Auto-generated method stub
		ArrayList<HotelListVO> hotelListVOs= new ArrayList<HotelListVO>();
		HotelListPO hotelListPO=new HotelListPO("锦江之星大酒店", "nanjing", null, 222, 5, 1, 5.0, "12121212121");
		hotelListVOs.add(new HotelListVO(hotelListPO));
		return hotelListVOs;
	}

}
