package presentation.ui.loginui.viewcontroller;

import presentation.ui.loginui.view.LoginView;
import util.UserType;
/**
 * 控制登录界面跳转的接口
 * @author CLL
 *
 */
public interface LoginViewControllerService {
	/**
	 * 设置界面
	 * @param view
	 */
	public void setView(LoginView view);
	/**
	 * 跳转至各用户的主界面
	 * @param userType
	 */
	public void jumpToUserMainFrame(UserType userType);
	
	/**
	 * 跳转至注册界面Individualregister_JFrame
	 */
	public void jumpToIndividualRegisterView();
	
	/**
	 * 跳转至注册界面Enterpriseregister_JFrame
	 */
	public void jumpToEnterpriseRegisterView();
	
	/**
	 * 用户名或密码错误提示界面
	 */
	public void passwordMistaken();
}
