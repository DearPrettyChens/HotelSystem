package businesslogic.bl.searchhotelbl;

import java.util.ArrayList;

import util.HotelSortType;
import util.OrderState;
import vo.searchhotelvo.HotelListVO;

/**
 * 搜索酒店的领域类
 * @author cy
 * @version 1.0
 * 
 */
public class SearchHotel {
	
	private ArrayList<HotelListVO> hotelList;//酒店信息列表
	public SearchHotel(){
		
	}
    public SearchHotel(ArrayList<HotelListVO> hotelList){
		this.hotelList=hotelList;
	}
	
	/**
	 * 得到所有酒店列表信息
	 * @param null
	 * @return ArrayList<HotelListVO>
	 * @throws 未定
	 */
	public ArrayList<HotelListVO> getHotelList() {
		
		return null;
	}

	
	/**
	 * 得到排序后的酒店列表信息
	 * @param HotelSortType type
	 * @return ArrayList<HotelListVO>
	 * @throws 未定
	 */
	public ArrayList<HotelListVO> getSortedHotelList(HotelSortType type) {
	
		return null;
	}

	
	/**
	 * 得到有订单的酒店列表信息
	 * @param HotelSortType type, OrderState orderState
	 * @return  ArrayList<HotelListVO>
	 * @throws 未定
	 */
	public ArrayList<HotelListVO> getBookedHotelList(HotelSortType type, OrderState orderState) {
		
		return null;
	}	
}
