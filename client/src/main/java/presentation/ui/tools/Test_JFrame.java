package presentation.ui.tools;

import javax.swing.JFrame;

import presentation.ui.hotelui.view.ChooseCityandEnterprise_JPanel;
import presentation.ui.hotelui.view.HotelListInfo_JPanel;
import presentation.ui.hotelui.view.SearchHoteltoClient_JPanel;

/**
 * 我写来用来测试的
 * @author cy
 * @version 1.0
 * 
 */
public class Test_JFrame extends JFrame{
	

	String s[]=new String[]{"撤销订单"};

	//private HotelListInfo_JPanel  cp=new  HotelListInfo_JPanel("南京国际金鹰酒店","ewf",3,"uicbwiuve我IEvbwiiebiqv全部地区企划vwdqhc近期活动去强化基础去","18962780526",4,4,4,s,798);


	SearchHoteltoClient_JPanel cp=new SearchHoteltoClient_JPanel("enrf","rfnp3");
	public Test_JFrame(){
		
		this.setLayout(null);
		cp.setBounds(0,0,800,600);
		this.add(cp);
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	
	public static void main(String [] args){
		new  Test_JFrame();
		
		
	}

}
