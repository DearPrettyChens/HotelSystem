package presentation.ui.searchhotelui.distributecontroller;

import java.util.ArrayList;

import businesslogic.bl.searchhotelbl.SearchHotelController;
import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
import util.HotelSortType;
import util.OrderState;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

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
	 * 获取特定类型的酒店列表
	 * @param type HotelSortType型，传递列表类型 
	 * @return  ArrayList<HotelListVO> ，将特定类型的酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getSortedHotelList(HotelSearchInfoVO hotelSearchInfoVO){
		return searchHotelBLService.getSortedHotelList(hotelSearchInfoVO);
	}
	
}
