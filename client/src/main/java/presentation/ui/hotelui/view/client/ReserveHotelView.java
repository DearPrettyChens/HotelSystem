package presentation.ui.hotelui.view.client;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.hotelui.viewcontroller.ReserveHotelViewController;
import presentation.ui.orderui.view.client.MakeOrdertoClient_JPanel;
import util.ViewTag;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 预定酒店模块主界面
 * @author csy
 *
 */
public class ReserveHotelView extends JPanel {
	private ChooseCityandEnterprise_JPanel chooseCityandEnterprise_JPanel;//选择城市和商圈界面
	private SearchHotelPane_JPanel searchHotelPane_JPanel;//搜索酒店界面
	private HotelPanetoClient_JPanel hotelPanetoClient_JPanel;// 酒店详细信息界面
	private MakeOrdertoClient_JPanel makeOrdertoClient_JPanel;// 生成订单界面
	private String userID;
	private String customerName;
	private ReserveHotelViewController reserveHotelViewController=ReserveHotelViewController.getInstance(this);
	
	  private static ReserveHotelView reserveHotelView;
		
	    public static ReserveHotelView getInstance(String userID,String userName) {
			if(reserveHotelView==null){
				reserveHotelView=new ReserveHotelView(userID,userName);
			}
			return reserveHotelView;
		}
	    
	    public static void destory(){
	    	reserveHotelView=null;
	    }
	
	private ReserveHotelView(String userID,String userName) {
		this.userID=userID;
		this.customerName=userName;
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 800, 600);
		chooseCityandEnterprise_JPanel=new ChooseCityandEnterprise_JPanel(userID);
	    this.add(chooseCityandEnterprise_JPanel);
	}
	
	public void generateNewHotelListView(HotelSearchInfoVO hotelSearchInfoVO) {
	    this.removeAll();
		searchHotelPane_JPanel=new SearchHotelPane_JPanel(hotelSearchInfoVO,ViewTag.HOTELRESERVERSION);
	    this.add(searchHotelPane_JPanel);
	    this.updateUI();
	}
	
	public void generateNewHotelDetailView(String hotelID){
		this.removeAll();
		hotelPanetoClient_JPanel=new HotelPanetoClient_JPanel(hotelID, userID, ViewTag.HOTELRESERVERSION);
	    this.add(hotelPanetoClient_JPanel);
	    this.updateUI();
	}
	
	public void generateNewOrder(String hotelID){
		this.removeAll();
		makeOrdertoClient_JPanel=new MakeOrdertoClient_JPanel(hotelID,userID,customerName, ViewTag.HOTELRESERVERSION);
	    this.add(makeOrdertoClient_JPanel);
	    this.updateUI();
	}
	
	public void returnToHotelListView(){
		this.removeAll();
		this.add(searchHotelPane_JPanel);
		this.updateUI();
	}
	
	public void returnToHotelDetailView(){
		this.removeAll();
		this.add(hotelPanetoClient_JPanel);
		this.updateUI();
	}
	
	
}
