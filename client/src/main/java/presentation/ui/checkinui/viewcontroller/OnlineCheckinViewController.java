package presentation.ui.checkinui.viewcontroller;

import javax.swing.JPanel;

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

}
