package presentation.ui.loginui.viewcontroller;


import presentation.ui.loginui.view.LoginView;
import presentation.ui.loginui.view.login_JFrame;
import util.UserType;
/**
 * 登录界面跳转的控制器
 * @author CLL
 *
 */
public class LoginViewControllerImpl implements LoginViewControllerService{
	LoginView view;
	@Override
	public void jumpToUserMainFrame(UserType userType) {
		view.jumpToUserMainFrame(userType);
	}

	@Override
	public void jumpToIndividualRegisterView() {
		view.jumpToIndividualRegisterView();
	}

	@Override
	public void jumpToEnterpriseRegisterView() {
		view.jumpToEnterpriseRegisterView();
	}

	@Override
	public void passwordMistaken() {
		view.passwordMistaken();
	}

	@Override
	public void setView(LoginView view) {
		this.view=view;
	}

}
