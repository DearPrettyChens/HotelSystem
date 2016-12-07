package presentation.ui.loginui.viewcontroller;

import javax.swing.JFrame;

import presentation.ui.loginui.view.Enterpriseregister_JFrame;
import presentation.ui.loginui.view.Individualregister_JFrame;
import presentation.ui.loginui.view.login_JFrame;
import presentation.ui.loginui.view.newclient_JFrame;

public class RegisterViewController implements RegisterViewControllerService{
	private JFrame view;
	private static RegisterViewController registerViewController;
	private RegisterViewController() {
		super();
	}
	public static RegisterViewController getInstance(){
		if(registerViewController==null){
			registerViewController=new RegisterViewController();
		}
		return registerViewController;
	}
	@Override
	public void jumpToLoginView() {
		// TODO Auto-generated method stub
		//关闭当前注册界面，返回到注册界面ornew出一个登录界面（取决于登录跳转到注册时原来的登录界面有无关闭）
		if(view!=null){
			view.dispose();
		}
	}

	@Override
	public void showRepeatName() {
		
	}

	@Override
	public void showPasswordMistaken() {
		
	}

	@Override
	public void jumpToIndividualRegisterView() {
		view=new Individualregister_JFrame();
	}

	@Override
	public void jumpToEnterpriseRegisterView() {
		view=new Enterpriseregister_JFrame();
	}
	
	@Override
	public void jumpToRegisterChooseFrame() {
		view=new newclient_JFrame();
	}

}
