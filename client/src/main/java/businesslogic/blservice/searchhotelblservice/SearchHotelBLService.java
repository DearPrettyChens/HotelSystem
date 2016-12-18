package businesslogic.blservice.searchhotelblservice;

import java.util.ArrayList;

import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;
/**
 * SearchHotelBLService提供接口，用来对酒店的搜索浏览
 * @author csy
 * @version 1.0
 * 
 */
public interface SearchHotelBLService {
	
	/**
	 * 获取特定类型的酒店列表
	 * @param hotelSearchInfoVO HotelSearchInfoVO型，传递搜索信息
	 * @return  ArrayList<HotelListVO> ，将特定类型的酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getSortedHotelList(HotelSearchInfoVO hotelSearchInfoVO);
	
	/**
	 * 得到所有顾客预定过的酒店列表信息
	 * 
	 * @param null
	 * @return ArrayList<HotelListVO>
	 * @throws 未定
	 */
	public ArrayList<HotelListVO> getCustomerHotelList(String customerID);
}
