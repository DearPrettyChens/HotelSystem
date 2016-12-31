package presentation.ui.loginui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.loginui.distributecontroller.LoginDistributionController;
import presentation.ui.loginui.viewcontroller.LoginViewController;
import presentation.ui.loginui.viewcontroller.LoginViewControllerService;
import presentation.ui.tools.Logingif_JFrame;
import presentation.ui.tools.close_JButton;
import presentation.ui.tools.Name_JTextField;
import presentation.ui.tools.Narrow_JButton;
import presentation.ui.tools.NewClient_JLabel;
import presentation.ui.tools.Password_JPasswordFeild;
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
public class Login_JFrame extends JFrame {
	
	private boolean isDragged = false;
	private Point tmp;
	private Point loc;


	private Name_JTextField name = new Name_JTextField();// 登录时姓名填写区域
	private Password_JPasswordFeild password = new Password_JPasswordFeild();// 密码区域
	private close_JButton close_jbutton = new close_JButton();// 关闭窗口按钮
	private Narrow_JButton narrow_jbutton = new Narrow_JButton(this);// 最小化窗口按钮
	private Login_JButton jb = new Login_JButton();// 登录按钮
	private NewClient_JLabel jl = new NewClient_JLabel();// 是否没有账户标签

	private JPanel jp=new JPanel();

	
	private JLabel loginFailBesideName = new JLabel();//登录名旁边的提示信息
	private JLabel loginFailBesidePassword = new JLabel();//密码旁边的提示信息
	private UserType type;
	
	private LoginViewControllerService controller;

	private LoginDistributionController loginDistributionController = LoginDistributionController.getInstance();

	
	public Login_JFrame() {
		
		controller = new LoginViewController();

		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		getContentPane().setLayout(null);
		

		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法
		 this.setDragable();
	
		this.setVisible(true);

	}
	
	
public Login_JFrame(Logingif_JFrame f) {
		
		
		
		
		controller = new LoginViewController();

		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);

		getContentPane().setLayout(null);

		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法
		
		 this.setDragable();
		 

		this.setVisible(true);

	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */

	public void addComp() {
		
		
		
		jp.setLayout(null);
		jp.setBackground(Color.WHITE);
		jp.setBounds(300,360,400,400);

	
		
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
					
					
					
					ResultMessage loginMessage = loginDistributionController.login(name.getText(),
							new String(password.getPassword()).trim());	
					
					

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
					
					
						controller.jumpToUserMainFrame(type,name.getText(),
								loginDistributionController.getUserID(name.getText()));
					  
						
						dispose();
					}else{
						if(loginMessage == ResultMessage.PASSWORDERROR){
							loginFailBesidePassword.setText("密码错误！");
						}else if(loginMessage == ResultMessage.USERHASLOGGEDIN){
							loginFailBesideName.setText("用户已经登入！");
						}else if(loginMessage == ResultMessage.USERNOTEXIST){
							loginFailBesideName.setText("用户不存在！");
						}else{
							
						}
					}
				}
			}
		});
		this.add(jb);

		jl.setBounds(500, 590, 200, 40);
		this.add(jl);

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
		ImageIcon img = new ImageIcon(Login_JFrame.class.getResource("image/bg2.png"));
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

	}


	public void setDragable() {
		this.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				isDragged = false;
			}

			public void mousePressed(MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}

		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				if (isDragged) {
					loc = new Point(getLocation().x + e.getX() - tmp.x, getLocation().y + e.getY() - tmp.y);
					setLocation(loc);
				}
			}
		});
	}
	
}






