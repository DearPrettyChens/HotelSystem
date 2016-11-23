package presentation.ui.searchhotelui.distributecontroller;

import java.util.ArrayList;

import businesslogic.bl.searchhotelbl.SearchHotelController;
import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import util.HotelSortType;
import util.OrderState;
import vo.searchhotelvo.HotelListVO;

/**
 * searchHotel界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class SearchhotelDistributionController {
	private static SearchhotelDistributionController controller=null;
	private SearchHotelBLService searchHotelBLService;
	private SearchhotelDistributionController(){
		searchHotelBLService=SearchHotelController.getInstance();
	}
	public static SearchhotelDistributionController getInstance(){
		if(controller==null){
			controller=new SearchhotelDistributionController();
		}
		return controller;
	}
	
	/**
	 * 获取酒店列表
	 * @param 无
	 * @return  ArrayList<HotelListVO> ，将酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getHotelList(){
		return searchHotelBLService.getHotelList();
	}
	
	/**
	 * 获取特定类型的酒店列表
	 * @param type HotelSortType型，传递列表类型 
	 * @return  ArrayList<HotelListVO> ，将特定类型的酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getSortedHotelList(HotelSortType type){
		return searchHotelBLService.getSortedHotelList(type);
	}
	
	/**
	 * 获取特定类型的预定过的酒店列表
	 * @param type HotelSortType型,orderState OrderState型，传递列表类型 
	 * @return  ArrayList<HotelListVO> ，将特定类型的预定过的酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getBookedHotelList(HotelSortType type,OrderState orderState,String ID){
		return searchHotelBLService.getBookedHotelList(type, orderState, ID);
	}
}