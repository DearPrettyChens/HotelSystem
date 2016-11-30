package presentation.ui.loginui.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.loginui.viewcontroller.RegisterViewControllerService;
import presentation.ui.tools.newclient_JFrame;
import util.CustomerType;
/**
 * 用户注册的界面类
 * @author CLL
 *
 */
public class RegisterView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private RegisterViewControllerService controller;
	
	private JFrame registerFrame;
	public RegisterView(){
		//选择注册类型界面
		registerFrame=new newclient_JFrame();
		
	}
}
