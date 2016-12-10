package presentation.ui.tools;

import java.awt.Color;

import javax.swing.JFrame;

import presentation.ui.hotelui.view.client.ChooseCityandEnterprise_JPanel;
import presentation.ui.hotelui.view.client.HotelDetailInfotoClient_JPanel;
import presentation.ui.hotelui.view.client.HotelGeneralInfotoClient_JPanel;
import presentation.ui.hotelui.view.client.HotelListInfo_JPanel;
import presentation.ui.hotelui.view.client.SearchHotelPane_JPanel;
import presentation.ui.hotelui.view.client.SearchHoteltoClient_JPanel;
import util.City;
import util.TradingArea;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 我写来用来测试的
 * @author cy
 * @version 1.0
 * 
 */
public class Test_JFrame extends JFrame{
	

	String s[]=new String[]{"撤销订单"};
	
	
	RoundCornerTextField a=new RoundCornerTextField();
	

	//private HotelGeneralInfotoClient_JPanel   cp=new HotelGeneralInfotoClient_JPanel ("南京国际金鹰酒店","ewf",3,"uicbwiuve我IEvbwiiebiqv全部地区企划vwdqhc近期活动去强化基础去","18962780526",798);
	//HotelDetailInfotoClient_JPanel  cp2=new HotelDetailInfotoClient_JPanel (City.NANJING,TradingArea.HUNANLU,"123456asdfg","123456asdfg","123456asdfg",
			//"123456asdfg","123456asdfg","123456asdfg");

	SearchHoteltoClient_JPanel cp=new SearchHoteltoClient_JPanel(new HotelSearchInfoVO ());
	public Test_JFrame(){
		
		
		this.setLayout(null);
		cp.setBounds(0,0,800,600);
		//this.add(cp);
		
		//cp2.setBounds(0,200,800,400);
		//this.add(cp2);
		
		a.setBounds(200,30,200,20);
		a.setForeground(Color.BLACK);
		this.add(cp);
		
		
		this.setSize(800,600);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String [] args){
		new  Test_JFrame();
		
		
	}

}
