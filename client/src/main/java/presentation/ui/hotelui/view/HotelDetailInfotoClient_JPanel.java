package presentation.ui.hotelui.view;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
		private JLabel hotelNamejl=new JLabel();
		// 酒店地址
		private String address;
		private JLabel addressjl=new JLabel();
		//酒店图片
		private ImageIcon hotelImage;
		private JLabel hotelImagejl=new JLabel();
		
		//城市
		private City city;
		private JLabel cityjl=new JLabel();
		//商圈
		private TradingArea area;
		private JLabel areajl=new JLabel();
		// 联系方式
		private String telephone;
		private JLabel telephonejl=new JLabel();
		// 星级
		private int star;
		private JLabel starjl=new JLabel();
		// 酒店简介
		private String introduce;
		private JLabel introducejl=new JLabel();
		// 通用设施
		private String commonFacility;
		private JLabel commonFacilityjl=new JLabel();
		// 活动设施
		private String activityFacility;
		private JLabel activityFacilityjl=new JLabel();
		// 服务项目
		private String service;
		private JLabel servicejl=new JLabel();
		// 客房设施
		private String roomFacility;
		private JLabel roomFacilityjl=new JLabel();
		// 合作企业
		private String enterprises;
		private JLabel enterprisesjl=new JLabel();
		// 酒店策略
		private ArrayList<HotelStrVO> hotelStrVO;
		private JLabel hotelStrVOjl=new JLabel();
		
		//评分
		private double remarkNumber;
		private JLabel remarkNumberjl=new JLabel();
		
		
	    //最低价格
		private double lowestPrice;
		private JLabel lowestPricejl=new JLabel();
		
		
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
    	   this.introduce=vo.getIntroduce();
    	   this.commonFacility=vo.getCommonFacility();
    	   this.activityFacility=vo.getActivityFacility();
    	   
    	   this.service=vo.getService();
    	   this.enterprises=vo.getEnterprises();
    	   this.hotelStrVO=vo.getHotelStrVO();
    	   this.lowestPrice=vo.getLowestPrice();
    	   this.roomFacility=vo.getRoomFacility();
    	   this.remarkNumber=vo.getRemarkNumber();
    	   
    	   
    	   
    	   
    	   
			
			
			
			
			
		}


}
