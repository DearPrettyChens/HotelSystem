package presentation.ui.loginui.viewcontroller;

import util.UserType;
/**
 * 控制登录界面跳转的接口
 * @author CLL
 *
 */
public interface LoginViewControllerService {

	/**
	 * 跳转至各用户的主界面
	 * @param userType
	 */
	public void jumpToUserMainFrame(UserType userType);
	
	/**
	 * 跳转至选择注册类型界面
	 */
	public void jumpToRegisterView();
	
	/**
	 * 用户名或密码错误提示界面
	 */
	public void passwordMistaken();
}
