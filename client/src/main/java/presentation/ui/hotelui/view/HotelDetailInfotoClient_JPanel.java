package presentation.ui.hotelui.view;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import util.City;
import util.TradingArea;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderVO;

/**
 * @author cy
 * @version 1.0
 * 
 */
public class HotelDetailInfotoClient_JPanel {
	
		// 酒店名称
		private String hotelName;
		// 酒店地址
		private String address;
		//酒店图片
		private ImageIcon hotelImage;
		//城市
		private City city;
		//商圈
		private TradingArea area;
		// 联系方式
		private String telephone;
		// 星级
		private int star;
		// 酒店简介
		private String introduce;
		// 通用设施
		private String commonFacility;
		// 活动设施
		private String activityFacility;
		// 服务项目
		private String service;
		// 客房设施
		private String roomFacility;
		// 合作企业
		private String enterprises;
		// 酒店策略
		private ArrayList<HotelStrVO> hotelStrVO;
		
		//评分
		private double remarkNumber;
		
		
	    //最低价格
		private double lowestPrice;
		
		
		public HotelDetailInfotoClient_JPanel(){
			
			
			
			
			
		}
		
       public HotelDetailInfotoClient_JPanel(HotelDetailInfoVO vo){
    	    
    	   this.address=vo.getAddress();
    	   this.city=vo.getCity();
    	   this.hotelName=vo.getHotelName();
    	   this.hotelImage=vo.getHotelImage();
    	   this.area=vo.getArea();
    	   
    	   this.telephone=vo.getTelephone();
    	   this.star=vo.getStar();
    	   this.
    	   
			
			
			
			
			
		}


}
