package presentation.ui.checkinui.view;

import java.awt.Color;

import javax.swing.JPanel;

import presentation.ui.checkinui.viewcontroller.OnlineCheckinViewController;
import presentation.ui.creditui.view.ClientDepositeSearch_JPanel;
import presentation.ui.creditui.view.Clientdeposite_JPanel;
import vo.hotelvo.HotelOrderInfoVO;

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
	
	public static CheckInPanel getInstance() {
		if(checkInPanel==null){
			checkInPanel=new CheckInPanel();
		}
		return checkInPanel;
	}
	
	private CheckInPanel(){
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
        searchOrderToCheckIn_JPanel=new SearchOrderToCheckIn_JPanel();
        this.add(searchOrderToCheckIn_JPanel);
        this.updateUI();
	}

	/**
	 * 跳到住房信息界面
	 */
	public void changeToCheckInInfoPanel(HotelOrderInfoVO hotelOrderInfoVO) {
		this.removeAll();
		checkInInfo_JPanel=new CheckInInfo_JPanel(hotelOrderInfoVO);
        this.add(checkInInfo_JPanel) ;
		this.updateUI();
	}
	
}
