package businesslogic.bl.searchhotelbl;

import java.util.ArrayList;

import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import util.HotelSortType;
import util.OrderState;
import vo.searchhotelvo.HotelListVO;

/**
 * SearchHotel模块的控制类
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHotelController implements SearchHotelBLService{
     private SearchHotel searchHotel;//持有的credit的引用
     private static SearchHotelBLService searchHotelController;
     
     public SearchHotelController(){
    	 searchHotel=new SearchHotel();
    	 
     }
     
     public static SearchHotelBLService getInstance() {
		if(searchHotelController==null){
			searchHotelController=new SearchHotelController();
		}
		return searchHotelController;
	}
    
	@Override
	public ArrayList<HotelListVO> getHotelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelListVO> getSortedHotelList(HotelSortType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelListVO> getBookedHotelList(HotelSortType type, OrderState orderState,String ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
