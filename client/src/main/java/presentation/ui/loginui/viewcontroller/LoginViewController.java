package presentation.ui.loginui.viewcontroller;


import javax.swing.JFrame;

import presentation.ui.loginui.view.Client_JFrame;
import presentation.ui.loginui.view.Hotelworker_JFrame;
import presentation.ui.loginui.view.WebMarketMan_JFrame;
import presentation.ui.loginui.view.Webmannger_JFrame;
import presentation.ui.loginui.view.newclient_JFrame;
import util.UserType;
/**
 * 登录界面跳转的控制器
 * @author CLL
 *
 */
public class LoginViewController implements LoginViewControllerService{
	JFrame frame;
	
	@Override
	public void jumpToUserMainFrame(UserType userType,String userName,String userID) {
		switch(userType){
		case Customer:
			frame=Client_JFrame.getInstance(userName,userID);
			break;
		case HotelWorker:
			frame=new Hotelworker_JFrame(userName,userID);
			break;
		case Manager:
			frame=new Webmannger_JFrame(userName,userID);
			break;
		case WebMarketMan:
			frame=new WebMarketMan_JFrame(userName,userID);
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
