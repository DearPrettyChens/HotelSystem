package presentation.ui.loginui.viewcontroller;

import javax.swing.JFrame;

import presentation.ui.loginui.view.Enterpriseregister_JFrame;
import presentation.ui.loginui.view.Individualregister_JFrame;
import presentation.ui.loginui.view.login_JFrame;

public class RegisterViewController implements RegisterViewControllerService{
	JFrame view;
	@Override
	public void jumpToLoginView() {
		// TODO Auto-generated method stub
		//关闭当前注册界面，返回到注册界面ornew出一个登录界面（取决于登录跳转到注册时原来的登录界面有无关闭）
		view=new login_JFrame();
	}

	@Override
	public void showRepeatName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPasswordMistaken() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jumpToIndividualRegisterView() {
		view=new Individualregister_JFrame();
	}

	@Override
	public void jumpToEnterpriseRegisterView() {
		view=new Enterpriseregister_JFrame();
	}

}
