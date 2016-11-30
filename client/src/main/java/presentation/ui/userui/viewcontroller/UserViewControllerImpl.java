package presentation.ui.userui.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.tools.Hotelworker_JFrame;
import presentation.ui.tools.Hotelworkerdetailinfo_JFrame;
import presentation.ui.tools.Webmarketmandetailinfo_JFrame;
import presentation.ui.userui.view.Changepassword_JPanel;
import util.UserType;

/**
 * 用户界面的控制器
 * @author CLL
 *
 */
public class UserViewControllerImpl implements UserViewControllerService{
	private JPanel view;
	private JFrame mainFrame;
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
			//mainFrame.add(new Hotelworkerdetailinfo_JFrame());
			break;
		default:
			break;
		
		}
	}

	@Override
	public void jumpToChangePasswordView() {
		view=new Changepassword_JPanel();
		mainFrame.add(view);
	}

	@Override
	public void jumpToMainFrame() {
		mainFrame.remove(view);
	}
}
