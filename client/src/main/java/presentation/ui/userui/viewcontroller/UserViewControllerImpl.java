package presentation.ui.userui.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.tools.Hotelworker_JFrame;
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
		// TODO Auto-generated method stub
		switch(userType){
		case Customer:
			//TODO
			break;
		case HotelWorker:
			//未完成酒店工作人员维护个人信息面板
			break;
		default:
			break;
		
		}
	}



	@Override
	public void jumpToMainFrame() {
		mainFrame.removeAll();
	}
}
