package presentation.ui.checkinui.viewcontroller;

import javax.swing.JPanel;
/**
 * 线上退房处理界面跳转的控制器
 * @author CLL
 *
 */
public class OnlineCheckoutViewController implements OnlineCheckoutViewControllerService{
	JPanel view;
	public OnlineCheckoutViewController(JPanel panel){
		this.view=panel;
	}
	@Override
	public void jumpToHotelCheckInfoView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showNotFoundOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showNotCheckin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jumpToMainFrame() {
		view=null;
		
	}

}
