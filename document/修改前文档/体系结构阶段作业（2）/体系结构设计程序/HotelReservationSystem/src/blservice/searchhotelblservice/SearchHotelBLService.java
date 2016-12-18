package blservice.searchhotelblservice;

import java.util.ArrayList;

import common.HotelSortType;
import common.OrderState;
import vo.searchhotelvo.HotelListVO;
/**
 * SearchHotelBLService提供接口，用来对酒店的搜索浏览
 * @author csy
 * @version 1.0
 * 
 */
public interface SearchHotelBLService {
	/**
	 * 获取酒店列表
	 * @param 无
	 * @return  ArrayList<HotelListVO> ，将酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getHotelList();
	
	/**
	 * 获取特定类型的酒店列表
	 * @param type HotelSortType型，传递列表类型 
	 * @return  ArrayList<HotelListVO> ，将特定类型的酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getSortedHotelList(HotelSortType type);
	
	/**
	 * 获取特定类型的预定过的酒店列表
	 * @param type HotelSortType型,orderState OrderState型，传递列表类型 
	 * @return  ArrayList<HotelListVO> ，将特定类型的预定过的酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getBookedHotelList(HotelSortType type,OrderState orderState);

}
