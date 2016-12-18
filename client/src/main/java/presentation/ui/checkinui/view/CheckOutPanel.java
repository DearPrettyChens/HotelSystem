package presentation.ui.checkinui.view;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.checkinui.viewcontroller.OnlineCheckinViewController;
import presentation.ui.checkinui.viewcontroller.OnlineCheckoutViewController;
import vo.checkinvo.CheckinInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.ordervo.OrderInfoVO;
/**
 * 线上退房的总界面
 * @author csy
 *
 */
public class CheckOutPanel extends JPanel{
	private SearchOrderToCheckOut_JPanel searchOrderToCheckOut_JPanel;
	private CheckOutInfo_JPanel checkOutInfo_JPanel;
	private OnlineCheckoutViewController onlineCheckoutViewController=OnlineCheckoutViewController.getInstance(this);
	private static CheckOutPanel checkOutPanel;
	private String hotelID;
	private HotelOrderInfoVO hotelOrderInfoVO;
	
	public static CheckOutPanel getInstance(String hotelID) {
		if(checkOutPanel==null){
			checkOutPanel=new CheckOutPanel(hotelID);
		}
		return checkOutPanel;
	}
	
	private CheckOutPanel(String hotelID){
		this.hotelID=hotelID;
		this.setLayout(null);
		this.setBackground(Color.white);
		changeToSearchPanel();
		this.setSize(800, 600);
	}

	/**
	 * 跳到搜索订单界面
	 */
	public void changeToSearchPanel() {
        this.removeAll();
        searchOrderToCheckOut_JPanel=new SearchOrderToCheckOut_JPanel(hotelID);
        this.add(searchOrderToCheckOut_JPanel);
        this.updateUI();
	}

	/**
	 * 跳到住房信息界面
	 */
	public void changeToCheckOutInfoPanel(CheckinInfoVO checkinInfoVO,String hotelID) {
		this.removeAll();
		checkOutInfo_JPanel=new CheckOutInfo_JPanel(checkinInfoVO,hotelID);
        this.add(checkOutInfo_JPanel) ;
		this.updateUI();
	}
	
//	public void changeToCheckInInfoPanel(HotelOrderInfoVO hotelOrderInfoVO,String hotelID) {
//		this.removeAll();
//		//checkInInfo_JPanel=new CheckInInfo_JPanel();
//		checkInInfo_JPanel=new CheckInInfo_JPanel(hotelOrderInfoVO,hotelID);
//        this.add(checkInInfo_JPanel) ;
//		this.repaint();
//	}
}
