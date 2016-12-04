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
	private JFrame frame;//发起界面跳转请求的界面对象
	private JPanel view;
	public WebManagerMainController(JFrame frame){
		this.frame=frame;
	}
//	public void jumpToWebMarketManManageView(){
//		frame.remove(view);
//		view=new Searchoradd_JPanel(UserType.WebMarketMan);
//		frame.add(view);
//	}
//	
//	public void jumpToCustomerManageView(){
//		frame.remove(view);
//		view=new Searchoradd_JPanel(UserType.Customer);
//		frame.add(view);
//	}
//	
//	public void jumpToHotelWorkerManageView(){
//		frame.remove(view);
//		view=new Searchoradd_JPanel(UserType.HotelWorker);
//		frame.add(view);
//	}
	
	public void jumpToChangePasswordView(){
		frame.remove(view);
//		view=new Changepassword_JPanel();
		frame.add(view);
	}
}
