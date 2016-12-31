package presentation.ui.userui.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.loginui.view.Hotelworker_JFrame;
import presentation.ui.userui.view.Changepassword_JPanel;
import util.UserType;

/**
 * 用户界面的控制器
 * @author CLL
 *
 */
public class UserViewControllerImpl implements UserViewControllerService{
	private JPanel view;
	private JFrame mainFrame;//发起界面跳转的界面对象
	private UserType userType;
	public UserViewControllerImpl(JFrame mainFrame,UserType type){
		this.mainFrame=mainFrame;
		this.userType=type;
	}


	@Override
	public void jumpToDetailInfoView() {

	}



	@Override
	public void jumpToMainFrame() {
		mainFrame.removeAll();
	}
}
