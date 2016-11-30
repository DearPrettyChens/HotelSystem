package presentation.ui.loginui.viewcontroller;


import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.loginui.view.LoginView;
import presentation.ui.loginui.view.RegisterView;
import presentation.ui.loginui.view.login_JFrame;
import presentation.ui.tools.Hotelworker_JFrame;
import presentation.ui.tools.Webmannger_JFrame;
import presentation.ui.tools.Webstrmaker_JFrame;
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
			frame=new Webstrmaker_JFrame();
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
		frame=new RegisterView();
	}

}
