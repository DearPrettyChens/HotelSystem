package presentation.ui.hotelui.view.client;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.hotelui.viewcontroller.MyFootViewController;
import presentation.ui.orderui.view.client.ChooseOrderTypetoClient_JPanel;
import presentation.ui.orderui.view.client.MakeOrdertoClient_JPanel;
import util.ViewTag;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 我的足迹模块的主界面
 * @author csy
 *
 */
public class MyFootView extends JPanel {
	private HotelHasOrdered_JPanel hotelHasOrdered_JPanel;// 浏览酒店列表界面
	private HotelPanetoClient_JPanel hotelPanetoClient_JPanel;// 酒店详细信息界面
	private MakeOrdertoClient_JPanel makeOrdertoClient_JPanel;// 生成订单界面
	private String userID;
	private String userName;
	private MyFootViewController myFootViewController=MyFootViewController.getInstance(this);
    private static MyFootView myFootView;
	
    public static MyFootView getInstance(String userID) {
		if(myFootView==null){
			
			myFootView=new MyFootView(userID);
		}
		return myFootView;
	}
    /**
     * 丢弃当前界面
     */
    public static void destory(){
    	myFootView=null;
    }
    
	
	private MyFootView(String userID) {
		this.userID=userID;
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 800, 600);
		hotelHasOrdered_JPanel=HotelHasOrdered_JPanel.getInstance(userID, ViewTag.MYHOTEL);
	    this.add(hotelHasOrdered_JPanel);
	}

	public void generateNewHotelListView(HotelSearchInfoVO hotelSearchInfoVO) {
		this.removeAll();
		hotelHasOrdered_JPanel=HotelHasOrdered_JPanel.getInstance(userID, ViewTag.MYHOTEL);
	    this.add(hotelHasOrdered_JPanel);
		this.updateUI();
	}

	public void generateNewHotelDetailView(String hotelID) {
		this.removeAll();
		hotelPanetoClient_JPanel = new HotelPanetoClient_JPanel(hotelID, userID, ViewTag.MYHOTEL);
		this.add(hotelPanetoClient_JPanel);
		this.updateUI();
	}

	public void generateNewOrder(String hotelID) {
		this.removeAll();
		makeOrdertoClient_JPanel = new MakeOrdertoClient_JPanel(hotelID, userID,userName, ViewTag.MYHOTEL);
		this.add(makeOrdertoClient_JPanel);
		this.updateUI();
	}

	public void returnToHotelListView() {
		this.removeAll();
		this.add(hotelHasOrdered_JPanel);
		this.updateUI();
	}

	public void returnToHotelDetailView() {
		this.removeAll();
		this.add(hotelPanetoClient_JPanel);
		this.updateUI();
	}

}
