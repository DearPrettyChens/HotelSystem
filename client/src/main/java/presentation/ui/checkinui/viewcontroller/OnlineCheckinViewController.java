package presentation.ui.checkinui.viewcontroller;

import javax.swing.JPanel;
/**
 * 线上入住界面跳转的控制器
 * @author CLL
 *
 */
public class OnlineCheckinViewController implements OnlineCheckinViewControllerService{
	private JPanel view;
	public OnlineCheckinViewController(JPanel panel){
		this.view=panel;
	}
	@Override
	public void jumpToHotelCheckInfoView() {
		// TODO Auto-generated method stub
		//view=new 
	}

	@Override
	public void jumpToMainFrame() {
		view=null;
	}
	
	@Override
	public void showOrderInfo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showNotFoundOrder() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showMistakeInfo() {
		// TODO Auto-generated method stub
		
	}

}
