package businesslogic.bl.searchhotelbl;

import java.util.ArrayList;

import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * SearchHotel模块的控制类
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHotelController implements SearchHotelBLService{
     private static SearchHotelBLService searchHotelController;
     
     private SearchHotelController(){	 
     }
     
     public static SearchHotelBLService getInstance() {
		if(searchHotelController==null){
			searchHotelController=new SearchHotelController();
		}
		return searchHotelController;
	}

	@Override
	public ArrayList<HotelListVO> getSortedHotelList(HotelSearchInfoVO hotelSearchInfoVO) {
		SearchHotel searchHotel=SearchHotel.getInstance(hotelSearchInfoVO);	
		return searchHotel.getHotelList();
	}

	@Override
	public ArrayList<HotelListVO> getCustomerHotelList(String customerID) {
		// TODO Auto-generated method stub
		HotelSearchInfoVO vo = new HotelSearchInfoVO();
		vo.setCustomerID(customerID);
		SearchHotel searchHotel=SearchHotel.getInstance(vo);	
		return searchHotel.getCustomerHotelList(customerID);
	}
 
}
