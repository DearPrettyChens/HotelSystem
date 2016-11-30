package presentation.ui.loginui.viewcontroller;
/**
 * 控制注册界面的接口
 * @author CLL
 *
 */
public interface RegisterViewControllerService {
	/**
	 * 跳转到普通会员注册界面
	 */
	public void jumpToIndividualRegisterView();
	/**
	 * 跳转到企业会员注册界面
	 */
	public void jumpToEnterpriseRegisterView();
	/**
	 * 注册成功后跳转到登录界面
	 */
	public void jumpToLoginView();
	
	/**
	 * 用户名已存在的提示框
	 */
	public void showRepeatName();
	
	/**
	 * 输入第二遍密码与第一遍不一致
	 */
	public void showPasswordMistaken();
}
