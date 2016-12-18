package presentation.ui.checkinui.view;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.checkinui.viewcontroller.OnlineCheckinViewController;
import presentation.ui.creditui.view.ClientDepositeSearch_JPanel;
import presentation.ui.creditui.view.Clientdeposite_JPanel;
import vo.hotelvo.HotelOrderInfoVO;
import vo.ordervo.OrderInfoVO;

/**
 * 线上入住的总界面
 * @author csy
 *
 */
public class CheckInPanel extends JPanel {
	private SearchOrderToCheckIn_JPanel searchOrderToCheckIn_JPanel;
	private CheckInInfo_JPanel checkInInfo_JPanel;
	private OnlineCheckinViewController onlineCheckinViewController=OnlineCheckinViewController.getInstance(this);
	private static CheckInPanel checkInPanel;
	private String hotelID;
	
	public static CheckInPanel getInstance(String hotelID) {
		if(checkInPanel==null){
			checkInPanel=new CheckInPanel(hotelID);
		}
		return checkInPanel;
	}
	
	private CheckInPanel(String hotelID){
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
        searchOrderToCheckIn_JPanel=new SearchOrderToCheckIn_JPanel(hotelID);
        this.add(searchOrderToCheckIn_JPanel);
        this.updateUI();
	}

	/**
	 * 跳到住房信息界面
	 */
	public void changeToCheckInInfoPanel(OrderInfoVO orderInfoVO,String hotelID) {
		this.removeAll();
		//checkInInfo_JPanel=new CheckInInfo_JPanel();
		checkInInfo_JPanel=new CheckInInfo_JPanel(orderInfoVO,hotelID);
        this.add(checkInInfo_JPanel) ;
		this.repaint();
	}
	
}
