package presentation.ui.checkinui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.checkinui.view.CheckOutPanel;
/**
 * 线上退房处理界面跳转的控制器
 * @author CLL
 *
 */
public class OnlineCheckoutViewController {
	private CheckOutPanel view;
	private static OnlineCheckoutViewController onlineCheckoutViewController;
	 
	public static OnlineCheckoutViewController getInstance(CheckOutPanel checkOutPanel) {
		if(onlineCheckoutViewController==null){
			onlineCheckoutViewController=new OnlineCheckoutViewController(checkOutPanel);
		}return onlineCheckoutViewController;
	}
	
	private OnlineCheckoutViewController(CheckOutPanel panel){
		this.view=panel;
	}
	
	public void jumpToHotelCheckInfoView() {
		view.changeToCheckOutInfoPanel();
		
	}

	
	public void showNotFoundOrder() {
		// TODO Auto-generated method stub
		
	}

	
	public void showNotCheckin() {
		// TODO Auto-generated method stub
		
	}

	
	public void jumpToMainFrame() {
		view.changeToSearchPanel();
		
	}

}
