package presentation.ui.loginui.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.personnelui.view.Searchoradd_JPanel;
import presentation.ui.userui.view.Changepassword_JPanel;
import util.UserType;

/**
 * 控制网站管理人员界面的跳转
 * @author CLL
 *
 */
public class WebManagerMainController {
	private JFrame frame;
	private JPanel view;
	public WebManagerMainController(JFrame frame){
		this.frame=frame;
	}
	public void jumpToWebMarketManManageView(){
		view=new Searchoradd_JPanel(UserType.WebMarketMan);
		frame.add(view);
	}
	
	public void jumpToCustomerManageView(){
		view=new Searchoradd_JPanel(UserType.Customer);
		frame.add(view);
	}
	
	public void jumpToHotelWorkerManageView(){
		view=new Searchoradd_JPanel(UserType.HotelWorker);
		frame.add(view);
	}
	
	public void jumpToChangePasswordView(){
		view=new Changepassword_JPanel();
		frame.add(view);
	}
}
