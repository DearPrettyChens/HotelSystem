package presentation.ui.userui.view;

import javax.swing.JPanel;

import presentation.ui.userui.viewcontroller.UserViewControllerService;
/**
 * 用户的界面类
 * @author CLL
 *
 */
public class UserView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private UserViewControllerService controller;
	
	public UserView(UserViewControllerService controller){
		this.controller=controller;
	}
}
