package presentation.ui.userui.viewcontroller;
/**
 * 控制用户界面的接口
 * @author CLL
 *
 */
public interface UserViewControllerService {
	/**
	 * 跳转到用户详细信息界面
	 */
	public void jumpToDetailInfoView();
	/**
	 * 跳转到修改用户密码界面
	 */
	public void jumpToChangePasswordView();
	/**
	 * 返回用户主界面
	 */
	public void jumpToMainFrame();
}
