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

	ChooseCityandEnterprise_JPanel cp=new ChooseCityandEnterprise_JPanel("jwebf");

	public Test_JFrame(){
		
		
		this.setLayout(null);
		
		this.add(cp);
		
		
		this.setSize(800,600);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String [] args){
		new  Test_JFrame();
		
		
	}

}
