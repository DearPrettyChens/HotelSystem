package presentation.ui.loginui.viewcontroller;


import javax.swing.JFrame;

import presentation.ui.loginui.view.newclient_JFrame;
import presentation.ui.personnelui.view.Webmannger_JFrame;
import presentation.ui.tools.Hotelworker_JFrame;
import presentation.ui.tools.WebMarketMan_JFrame;
import util.UserType;
/**
 * 登录界面跳转的控制器
 * @author CLL
 *
 */
public class LoginViewController implements LoginViewControllerService{
	JFrame frame;
	
	@Override
	public void jumpToUserMainFrame(UserType userType) {
		switch(userType){
		case Customer:
			//TODO
			break;
		case HotelWorker:
			frame=new Hotelworker_JFrame();
			break;
		case Manager:
			frame=new Webmannger_JFrame();
			break;
		case WebMarketMan:
			frame=new WebMarketMan_JFrame();
			break;
		default:
			break;
		
		}
	}

	@Override
	public void passwordMistaken() {
		// TODO Auto-generated method stub
	}

	@Override
	public void jumpToRegisterView() {
		frame=new newclient_JFrame();
	}

}
