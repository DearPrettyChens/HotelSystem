package presentation.ui.loginui.view;

import java.awt.Color;
import java.awt.Container;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import com.jhlabs.image.TextureFilter;

import presentation.ui.loginui.distributecontroller.LoginDistributionController;
import presentation.ui.loginui.viewcontroller.LoginViewController;
import presentation.ui.loginui.viewcontroller.LoginViewControllerService;
import presentation.ui.tools.*;
import util.ResultMessage;
import util.UserType;

/**
 * 登录界面
 * 
 * @author cy
 * @version 1.0
 * 
 */
/**
 * 新增逻辑 
 * 不确定部分：登录信息是否还有别的情况 line 144
 * @author CYF
 *
 */
public class login_JFrame extends JFrame {

	private name_JTextField name = new name_JTextField();// 登录时姓名填写区域
	private password_JPasswordFeild password = new password_JPasswordFeild();// 密码区域
	private close_JButton close_jbutton = new close_JButton();// 关闭窗口按钮
	private narrow_JButton narrow_jbutton = new narrow_JButton(this);// 最小化窗口按钮
	private login_JButton jb = new login_JButton();// 登录按钮
	private newclient_JLabel jl = new newclient_JLabel();// 是否没有账户标签
     
	
	private JPanel jp=new JPanel();
	
	
	private JLabel loginimagejl=new JLabel(new ImageIcon("image/loginback.gif"));
	
	private JLabel loginFailBesideName = new JLabel();//登录名旁边的提示信息
	private JLabel loginFailBesidePassword = new JLabel();//密码旁边的提示信息
	private UserType type;
	
	private LoginViewControllerService controller;

	private LoginDistributionController loginDistributionController = LoginDistributionController.getInstance();

	private Timer timer;
	public login_JFrame() {
		controller = new LoginViewController();

		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);

		this.setLayout(null);

		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法

		this.setVisible(true);

	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	class myTask extends TimerTask{

		@Override
		public void run() {
			jp.setVisible(true);	
			repaint();
		}
		
	}
	public void addComp() {
		
		loginimagejl.setBounds(0,0,400,300);
		jp.add(loginimagejl);
		//loginimagejl.setVisible(false);
		
		
		jp.setLayout(null);
		jp.setBackground(Color.WHITE);
		jp.setBounds(300,360,400,400);

		jp.add(loginimagejl);
		this.add(jp);
		jp.setVisible(false);
		
		close_jbutton.setBounds(970, 10, 20, 20);
		this.add(close_jbutton);
		narrow_jbutton.setBounds(930, 10, 20, 20);
		this.add(narrow_jbutton);

		name.setBounds(400, 450, 200, 40);
		this.add(name);
		loginFailBesideName.setBounds(620, 450, 300, 40);
		loginFailBesideName.setForeground(Color.RED);
		loginFailBesideName.setFont(new Font("宋体",Font.PLAIN, 16));
		this.add(loginFailBesideName);
		
		password.setBounds(400, 500, 200, 40);
		this.add(password);
		loginFailBesidePassword.setBounds(620,500,300,40);
		loginFailBesidePassword.setForeground(Color.RED);
		loginFailBesidePassword.setFont(new Font("宋体",Font.PLAIN, 16));
		this.add(loginFailBesidePassword);
		
		
		
		
		jb.setBounds(400, 550, 200, 40);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginFailBesideName.setText("");
				loginFailBesidePassword.setText("");
				if((name.getText().length()==0)&&(password.getPassword().length==0)){
					loginFailBesideName.setText("用户名未输入！");
					loginFailBesidePassword.setText("密码未输入！");
				}else if(name.getText().length()==0){
					loginFailBesideName.setText("用户名未输入！");
				}else if(password.getPassword().length==0){
					loginFailBesidePassword.setText("密码未输入！");
				}else{
					timer = new Timer();
					timer.schedule(new myTask(), 0, 5000);
//					System.out.println(jp.isVisible());
					ResultMessage loginMessage = loginDistributionController.login(name.getText(),
							new String(password.getPassword()).trim());	
					JFrame frame=new SaveSuccess_JFrame();
//					jp.setVisible(true);
//					System.out.println(new Date());
					type = null;
					if(loginMessage==ResultMessage.Customer){
						type = UserType.Customer;
					}else if(loginMessage == ResultMessage.Manager){
						type = UserType.Manager;
					}else if(loginMessage == ResultMessage.HotelWorker){
						type = UserType.HotelWorker;
					}else if(loginMessage == ResultMessage.WebMarketMan){
						type = UserType.WebMarketMan;
					}
					if(type!=null){
					
//					
//						controller.jumpToUserMainFrame(type,name.getText(),
//								loginDistributionController.getUserID(name.getText()));
//					
						changeJFrame();
	                    frame.dispose();
						dispose();
					}else{
						if(loginMessage == ResultMessage.PASSWORDERROR){
							loginFailBesidePassword.setText("密码错误！");
						}else if(loginMessage == ResultMessage.USERHASLOGGEDIN){
							loginFailBesideName.setText("用户已经登入！");
						}else if(loginMessage == ResultMessage.USERNOTEXIST){
							loginFailBesideName.setText("用户不存在！");
						}else{
							//应该没有别的情况了吧？
						}
					}
				}
			}
		});
		this.add(jb);

		jl.setBounds(500, 590, 200, 40);
		this.add(jl);

	}
	
	public void changeJFrame(){
//		System.out.println(new Date());
		controller.jumpToUserMainFrame(type,name.getText(),
				loginDistributionController.getUserID(name.getText()));
//		System.out.println(new Date());
//		System.out.println("end");
		timer.cancel();
//		System.out.println(new Date());
		this.remove(jp);
//		jp.setVisible(false);
//		System.out.println(new Date());
	//	this.dispose();
	//	this.repaint();
	}

	/**
	 * 设置背景图片
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void setBak() {

		((JPanel) this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("image//bg2.png");
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

	}

	public static void main(String[] args) {
		login_JFrame s = new login_JFrame();

	}

}
