package presentation.ui.checkinui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.checkinui.view.CheckInPanel;
import vo.hotelvo.HotelOrderInfoVO;
import vo.ordervo.OrderInfoVO;
/**
 * 线上入住界面跳转的控制器
 * @author CLL
 *
 */
public class OnlineCheckinViewController{
	private CheckInPanel view;
	private static OnlineCheckinViewController onlineCheckinViewController;
	
	public static OnlineCheckinViewController getInstance(CheckInPanel checkInPanel) {
		if(onlineCheckinViewController==null){
			onlineCheckinViewController=new OnlineCheckinViewController(checkInPanel);
		}return onlineCheckinViewController;
	}
	
	private OnlineCheckinViewController(CheckInPanel panel){
		this.view=panel;
	}
	
	public void jumpToHotelCheckInfoView(OrderInfoVO orderInfoVO,String hotelID) {
		view.changeToCheckInInfoPanel(orderInfoVO,hotelID);
	}

	
	public void jumpToMainFrame() {
		view.changeToSearchPanel();
	}
	
	
	public void showOrderInfo() {
		// TODO Auto-generated method stub
		
	}
	
	public void showNotFoundOrder() {
		// TODO Auto-generated method stub
		
	}
	
	public void showMistakeInfo() {
		// TODO Auto-generated method stub
		
	}

}
