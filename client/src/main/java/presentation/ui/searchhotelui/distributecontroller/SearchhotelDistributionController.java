package presentation.ui.searchhotelui.distributecontroller;

import java.util.ArrayList;

import businesslogic.bl.searchhotelbl.SearchHotelController;
import businesslogic.blservice.searchhotelblservice.SearchHotelBLService;
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
//		searchHotelBLService=new SearchHotelBLService_Stub();
	}
	public static SearchhotelDistributionController getInstance(){
		if(controller==null){
			controller=new SearchhotelDistributionController();
		}
		return controller;
	}
	

	/**
	 * 获取酒店列表
	 * @param HotelSearchInfoVO
	 * @return  ArrayList<HotelListVO> ，将酒店列表返回给界面
	 * @throws 未定
	 *
	 */
	public ArrayList<HotelListVO> getSortedHotelList(HotelSearchInfoVO hotelSearchInfoVO){
		return searchHotelBLService.getSortedHotelList(hotelSearchInfoVO);
	}
	
	/**
	 * 得到所有顾客预定过的酒店列表信息
	 * 
	 * @param null
	 * @return ArrayList<HotelListVO>
	 * @throws 未定
	 */
	public ArrayList<HotelListVO> getCustomerHotelList(String customerID) {
//		
		return searchHotelBLService.getCustomerHotelList(customerID);
	}
}
