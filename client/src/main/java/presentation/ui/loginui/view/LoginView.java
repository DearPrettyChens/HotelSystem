package presentation.ui.loginui.view;

import javax.swing.JPanel;

import presentation.ui.loginui.viewcontroller.LoginViewControllerService;
import util.UserType;
/**
 * 登录的界面类
 * @author CLL
 *
 */
public class LoginView extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private LoginViewControllerService controller;
	
	private login_JFrame loginFrame;
	
	public LoginView(LoginViewControllerService controller){
		this.controller=controller;
		loginFrame=new login_JFrame();
	}
	
	//逻辑处理

	public void jumpToUserMainFrame(UserType userType) {
		// TODO Auto-generated method stub
	}

	public void jumpToIndividualRegisterView() {
		// TODO Auto-generated method stub
	}

	public void jumpToEnterpriseRegisterView() {
		// TODO Auto-generated method stub
	}

	public void passwordMistaken() {
		// TODO Auto-generated method stub
	}
}
