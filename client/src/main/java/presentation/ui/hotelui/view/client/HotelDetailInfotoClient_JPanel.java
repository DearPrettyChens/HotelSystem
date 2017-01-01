package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import presentation.ui.tools.JLabelTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.NewClient_JLabel;
import util.City;
import util.TradingArea;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.hotelstrategyvo.HotelStrVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.hotelvo.HotelOrderVO;

/**
 * 顾客查看的酒店详细信息，在点击酒店详情时出现
 * @author cy
 * @version 1.0
 * 
 */
public class HotelDetailInfotoClient_JPanel  extends JPanel{
	
	
private Font font=new Font("宋体",Font.BOLD, 14);
	
	private Color darkgreen=new Color(52,131,115);
	private Color lightgreen=new Color(180,241,214);
	private Color orange=new Color(231,64,37);
	private Color yellow=new Color(243,150,39);
	
	
	
	
		
		//城市
		private City city;
		private JLabel cityjl=new JLabel();
		//商圈
		private TradingArea area;
		private JLabel areajl=new JLabel();
		
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
		private JLabel strTitlejl=new JLabel();

       public HotelDetailInfotoClient_JPanel(HotelDetailInfoVO vo){
    	    
    	  
    	   this.city=vo.getCity();
    	  
    	   this.area=vo.getArea();
    	   
    	   
    	   this.introduce=vo.getIntroduce();
    	   this.commonFacility=vo.getCommonFacility();
    	   this.activityFacility=vo.getActivityFacility();
    	   
    	   this.service=vo.getService();
    	   this.enterprises=vo.getEnterprises();
    	   this.hotelStrVO=vo.getHotelStrVO();
    	  
    	   this.roomFacility=vo.getRoomFacility();
    	
    	   
    	
    	   this.setSize(800,400);
		   this.setLayout(null);
		   this.setBackground(Color.white);
		   addComp();
			
			
    	   
  
		}

      
		
       
       
	public void addComp() {

		cityjl.setText("城      市：" + city.toChinese());
		cityjl.setFont(font);
		cityjl.setBounds(50, 0, 600, 30);
		this.add(cityjl);

		areajl.setText("商      圈：" + area.getChinese());
		areajl.setFont(font);
		areajl.setBounds(50, 30, 600, 30);
		this.add(areajl);

		introducejl.setText("简      介：" + introduce);
		introducejl.setFont(font);
		introducejl.setBounds(50, 60, 600, 30);
		this.add(introducejl);

		commonFacilityjl.setText("通用设施：" + commonFacility);
		commonFacilityjl.setFont(font);
		commonFacilityjl.setBounds(50, 120, 600, 30);
		this.add(commonFacilityjl);

		activityFacilityjl.setText("活动设施：" + activityFacility);
		activityFacilityjl.setFont(font);
		activityFacilityjl.setBounds(50, 150, 600, 30);
		this.add(activityFacilityjl);

		servicejl.setText("服务设施：" + service);
		servicejl.setFont(font);
		servicejl.setBounds(50, 180, 600, 30);
		this.add(servicejl);

		roomFacilityjl.setText("客房设施：" + roomFacility);
		roomFacilityjl.setFont(font);
		roomFacilityjl.setBounds(50, 210, 600, 30);
		this.add(roomFacilityjl);

		enterprisesjl.setText("合作企业：" + enterprises);
		enterprisesjl.setFont(font);
		enterprisesjl.setBounds(50, 240, 600, 30);
		this.add(enterprisesjl);

		strTitlejl.setText("酒店优惠：");
		strTitlejl.setFont(font);
		strTitlejl.setBounds(50, 270, 70, 30);
		this.add(strTitlejl);
		
		int size = hotelStrVO.size();
		String s = "";
		for (int i = 0; i < size; i++) {
			HotelStrVO tempvo = hotelStrVO.get(i);

			s = s + tempvo.getType().getChinese() + tempvo.getDiscount() + "折;";

		}

		hotelStrVOjl.setFont(font);
		hotelStrVOjl.setBounds(120, 270, 130, 80);
		try {
			JLabelTool.JlabelSetText(hotelStrVOjl, s);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(hotelStrVOjl);

		
	}

}
