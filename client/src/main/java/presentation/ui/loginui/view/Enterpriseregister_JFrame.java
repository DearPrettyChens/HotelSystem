package presentation.ui.loginui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import presentation.ui.loginui.viewcontroller.RegisterViewController;
import presentation.ui.loginui.viewcontroller.RegisterViewControllerService;
import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.tools.FileChooseHelper;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.SaveSuccess_JFrame;
import presentation.ui.tools.close_JButton;
import presentation.ui.tools.narrow_JButton;
import util.CustomerType;
import util.ResultMessage;
import util.TransHelper;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

/**
 * 注册企业会员时的界面
 * @author cy
 * @version 1.0
 * 
 */
/**
 * 不确定部分：vo头像get方法未定 line 491 头像部分 imagebutton的监听 不确定
 * 
 * @author CYF
 *
 */
public class Enterpriseregister_JFrame extends JFrame {

	private Font font = new Font("宋体", Font.BOLD, 20);
	private Color color = new Color(69, 140, 116);
	// private Color color=Color.BLACK;

	private close_JButton close_jbutton = new close_JButton();
	private narrow_JButton narrow_jbutton = new narrow_JButton(this);

	private JLabel ninthday_logo = new JLabel();

	private JLabel enterprisetab_JLabel = new JLabel("企业会员注册");
	private JLabel name_JLabel = new JLabel("用户名");
	private JLabel password_JLabel = new JLabel("密码");
	private JLabel confirmpassword_JLabel = new JLabel("确认密码");
	private JLabel tel_JLabel = new JLabel("联系方式");
	private JLabel birthday_JLabel = new JLabel("企业名称");
	private JLabel image_JLabel = new JLabel("头像");
	private JLabel enterprisename_JLabel = new JLabel("企业名称");
	private JLabel realimage_JLabel = new JLabel();

	private MyTextfield name_TextField = new MyTextfield("--2-8位字母、数字或中文--");
	private MyTextfield password_TextField = new MyTextfield("--4-10位字母或数字--");
	private MyTextfield confirmpassword_TextField = new MyTextfield("--再次输入密码--");
	private MyTextfield tel_TextField = new MyTextfield("--11位手机号--");
	private MyTextfield enterprisename_TextField = new MyTextfield("--企业名称--");

	private JLabel registerInfoBesideName = new JLabel();
	private JLabel registerInfoBesidePassword = new JLabel();
	private JLabel registerInfoBesideSecondPassword = new JLabel();
	private JLabel registerInfoBesideTel = new JLabel();
	private JLabel registerInfoBesideEnterpriseName = new JLabel();

	private MyButton confirm_button = new MyButton();
	private MyButton cancle_button = new MyButton();
	private MyButton image_button = new MyButton();

	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();

	private RegisterViewControllerService registerViewController = RegisterViewController.getInstance();

	private boolean nameValid = false;
	private boolean passwordValid = false;
	private boolean telephoneValid = false;

	private String imagePath = "image//logo.png";
	private ImageIcon imageIcon=null;
	
	private JScrollPane scrollPane=new JScrollPane();
	private JPanel panel=new JPanel();
	
	public Enterpriseregister_JFrame() {

		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(null);

		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法
		addScrollPane();
		this.setVisible(true);

	}

	public void addScrollPane() {
		scrollPane.setBounds(300, 250, 700, 350);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}
	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(680, 680));
        panel.setBackground(Color.WHITE);
        
//		realimage_JLabel.setBounds(400, 500, 100, 100);
        realimage_JLabel.setBounds(100, 450, 150, 150);
		ImageIcon icon2 = new ImageIcon("image//clientimage.png");
		icon2 = ImageTool.getScaledImage(icon2, 150);
		realimage_JLabel.setIcon(icon2);
		// this.add(realimage_JLabel);
//		this.getContentPane().add(realimage_JLabel);
		panel.add(realimage_JLabel);
		
		close_jbutton.setBounds(970, 10, 20, 20);
		this.add(close_jbutton);
		narrow_jbutton.setBounds(930, 10, 20, 20);
		this.add(narrow_jbutton);

		enterprisetab_JLabel.setFont(new Font("宋体", Font.BOLD, 30));
		enterprisetab_JLabel.setForeground(color);
		enterprisetab_JLabel.setBounds(400, 180, 200, 70);
		this.add(enterprisetab_JLabel);

//		name_JLabel.setBounds(300, 250, 100, 50);
		name_JLabel.setBounds(0, 20, 100, 50);
		name_JLabel.setForeground(color);
		name_JLabel.setFont(font);
//		this.add(name_JLabel);
		panel.add(name_JLabel);

//		password_JLabel.setBounds(300, 300, 100, 50);
		password_JLabel.setBounds(0, 100, 100, 50);
		password_JLabel.setForeground(color);
		password_JLabel.setFont(font);
//		this.add(password_JLabel);
		panel.add(password_JLabel);

//		confirmpassword_JLabel.setBounds(300, 350, 100, 50);
		confirmpassword_JLabel.setBounds(0, 180, 100, 50);
		confirmpassword_JLabel.setForeground(color);
		confirmpassword_JLabel.setFont(font);
//		this.add(confirmpassword_JLabel);
		panel.add(confirmpassword_JLabel);

//		tel_JLabel.setBounds(300, 400, 100, 50);
		tel_JLabel.setBounds(0, 260, 100, 50);
		tel_JLabel.setForeground(color);
		tel_JLabel.setFont(font);
//		this.add(tel_JLabel);
		panel.add(tel_JLabel);

		// birthday_JLabel.setBounds(300,450,100,50);
		// birthday_JLabel.setForeground(color);
		// birthday_JLabel.setFont(font);
		// this.add(birthday_JLabel);

//		image_JLabel.setBounds(300, 500, 100, 50);
		image_JLabel.setBounds(0, 420, 100, 50);
		image_JLabel.setForeground(color);
		image_JLabel.setFont(font);
//		this.add(image_JLabel);
		panel.add(image_JLabel);

		enterprisename_JLabel.setBounds(0, 340, 100, 50);
		enterprisename_JLabel.setForeground(color);
		enterprisename_JLabel.setFont(font);
//		this.add(enterprisename_JLabel);
		panel.add(enterprisename_JLabel);

		ImageIcon icon3 = new ImageIcon("image//ninthday.png");
		ninthday_logo.setBounds(300, 10, 400, 150);
		ninthday_logo.setIcon(icon3);
		this.add(ninthday_logo);

//		name_TextField.setBounds(400, 250, 300, 50);
		name_TextField.setBounds(100, 20, 300, 50);
//		this.add(name_TextField);
		panel.add(name_TextField);

//		registerInfoBesideName.setBounds(720, 250, 200, 50);
		registerInfoBesideName.setBounds(420, 20, 200, 50);
		registerInfoBesideName.setForeground(Color.RED);
		registerInfoBesideName.setFont(font);
//		this.add(registerInfoBesideName);
		panel.add(registerInfoBesideName);

		Document nameDoc = name_TextField.getDocument();
		nameDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				registerInfoBesideName.setText("");
				if (name_TextField.getText().equals("--2-8位字母、数字或中文--") || name_TextField.getText().trim().equals("")) {// ||name_TextField.getText().trim().length()==0){
					nameValid = false;
					registerInfoBesideName.setText("请输入用户名！");
				} else {
					Document document = e.getDocument();
					try {
						String name = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkUserName(name);
						if (message == ResultMessage.USEREXISTED) {
							nameValid = false;
							registerInfoBesideName.setText("用户名已存在！");
						} else if (message == ResultMessage.USERFORMATERROR) {
							nameValid = false;
							registerInfoBesideName.setText("用户名格式错误");
						} else if (message == ResultMessage.SUCCESS) {
							nameValid = true;
							registerInfoBesideName.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				registerInfoBesideName.setText("");
				if (name_TextField.getText().equals("--2-8位字母、数字或中文--") || name_TextField.getText().trim().equals("")) {// ||name_TextField.getText().trim().length()==0){
					nameValid = false;
					registerInfoBesideName.setText("请输入用户名！");
				} else {
					Document document = e.getDocument();
					try {
						String name = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkUserName(name);
						if (message == ResultMessage.USEREXISTED) {
							nameValid = false;
							registerInfoBesideName.setText("用户名已存在！");
						} else if (message == ResultMessage.USERFORMATERROR) {
							nameValid = false;
							registerInfoBesideName.setText("用户名格式错误");
						} else if (message == ResultMessage.SUCCESS) {
							nameValid = true;
							registerInfoBesideName.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				registerInfoBesideName.setText("");
				if (name_TextField.getText().equals("--2-8位字母、数字或中文--") || name_TextField.getText().trim().equals("")) {// ||name_TextField.getText().trim().length()==0){
					nameValid = false;
					registerInfoBesideName.setText("请输入用户名！");
				} else {
					Document document = e.getDocument();
					try {
						String name = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkUserName(name);
						if (message == ResultMessage.USEREXISTED) {
							nameValid = false;
							registerInfoBesideName.setText("用户名已存在！");
						} else if (message == ResultMessage.USERFORMATERROR) {
							nameValid = false;
							registerInfoBesideName.setText("用户名格式错误");
						} else if (message == ResultMessage.SUCCESS) {
							nameValid = true;
							registerInfoBesideName.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

//		password_TextField.setBounds(400, 300, 300, 50);
		password_TextField.setBounds(100, 100, 300, 50);
//		this.add(password_TextField);
		panel.add(password_TextField);
		
//		registerInfoBesidePassword.setBounds(720, 300, 200, 50);
		registerInfoBesidePassword.setBounds(420, 100, 200, 50);
		registerInfoBesidePassword.setForeground(Color.RED);
		registerInfoBesidePassword.setFont(font);
//		this.add(registerInfoBesidePassword);
		panel.add(registerInfoBesidePassword);

		Document passwordDoc = password_TextField.getDocument();
		passwordDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				registerInfoBesidePassword.setText("");
				if (password_TextField.getText().equals("--4-10位字母或数字--")
						|| password_TextField.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					passwordValid = false;
					registerInfoBesidePassword.setText("请输入密码！");
				} else {
					Document document = e.getDocument();
					try {
						String password = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkPassword(password);
						if (message == ResultMessage.PASSWORDFORMATERROR) {
							passwordValid = false;
							registerInfoBesidePassword.setText("密码格式错误");
						} else {
							passwordValid = true;
							registerInfoBesidePassword.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				registerInfoBesidePassword.setText("");
				if (password_TextField.getText().equals("--4-10位字母或数字--")
						|| password_TextField.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					passwordValid = false;
					registerInfoBesidePassword.setText("请输入密码！");
				} else {
					Document document = e.getDocument();
					try {
						String password = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkPassword(password);
						if (message == ResultMessage.PASSWORDFORMATERROR) {
							passwordValid = false;
							registerInfoBesidePassword.setText("密码格式错误");
						} else {
							passwordValid = true;
							registerInfoBesidePassword.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				registerInfoBesidePassword.setText("");
				if (password_TextField.getText().equals("--4-10位字母或数字--")
						|| password_TextField.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					passwordValid = false;
					registerInfoBesidePassword.setText("请输入密码！");
				} else {
					Document document = e.getDocument();
					try {
						String password = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkPassword(password);
						if (message == ResultMessage.PASSWORDFORMATERROR) {
							passwordValid = false;
							registerInfoBesidePassword.setText("密码格式错误");
						} else {
							passwordValid = true;
							registerInfoBesidePassword.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

//		confirmpassword_TextField.setBounds(400, 350, 300, 50);
		confirmpassword_TextField.setBounds(100, 180, 300, 50);
//		this.add(confirmpassword_TextField);
		panel.add(confirmpassword_TextField);

//		registerInfoBesideSecondPassword.setBounds(720, 350, 200, 50);
		registerInfoBesideSecondPassword.setBounds(420, 180, 200, 50);
		registerInfoBesideSecondPassword.setForeground(Color.RED);
		registerInfoBesideSecondPassword.setFont(font);
//		this.add(registerInfoBesideSecondPassword);
		panel.add(registerInfoBesideSecondPassword);

//		tel_TextField.setBounds(400, 400, 300, 50);
		tel_TextField.setBounds(100, 260, 300, 50);
//		this.add(tel_TextField);
		panel.add(tel_TextField);
		
//		registerInfoBesideTel.setBounds(720, 400, 200, 50);
		registerInfoBesideTel.setBounds(420, 260, 200, 50);
		registerInfoBesideTel.setForeground(Color.RED);
		registerInfoBesideTel.setFont(font);
//		this.add(registerInfoBesideTel);
		panel.add(registerInfoBesideTel);

		Document telDoc = tel_TextField.getDocument();
		telDoc.addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				registerInfoBesideTel.setText("");
				if (tel_TextField.getText().equals("--11位手机号--") || tel_TextField.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					telephoneValid = false;
					registerInfoBesideTel.setText("请输入联系方式！");
				} else {
					Document document = e.getDocument();
					try {
						String telephone = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkTel(telephone);
						if (message == ResultMessage.FAIL) {
							telephoneValid = false;
							registerInfoBesideTel.setText("联系方式格式错误");
						} else {
							telephoneValid = true;
							registerInfoBesideTel.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				registerInfoBesideTel.setText("");
				if (tel_TextField.getText().equals("--11位手机号--") || tel_TextField.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					telephoneValid = false;
					registerInfoBesideTel.setText("请输入联系方式！");
				} else {
					Document document = e.getDocument();
					try {
						String telephone = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkTel(telephone);
						if (message == ResultMessage.FAIL) {
							telephoneValid = false;
							registerInfoBesideTel.setText("联系方式格式错误");
						} else {
							telephoneValid = true;
							registerInfoBesideTel.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				registerInfoBesideTel.setText("");
				if (tel_TextField.getText().equals("--11位手机号--") || tel_TextField.getText().trim().equals("")) {// ||password_TextField.getText().trim().length()==0){
					telephoneValid = false;
					registerInfoBesideTel.setText("请输入联系方式！");
				} else {
					Document document = e.getDocument();
					try {
						String telephone = document.getText(0, document.getLength());
						ResultMessage message = personnelDistributionController.checkTel(telephone);
						if (message == ResultMessage.FAIL) {
							telephoneValid = false;
							registerInfoBesideTel.setText("联系方式格式错误");
						} else {
							telephoneValid = true;
							registerInfoBesideTel.setText("√");
						}
					} catch (BadLocationException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

//		enterprisename_TextField.setBounds(400, 450, 300, 50);
		enterprisename_TextField.setBounds(100, 340, 300, 50);
//		this.add(enterprisename_TextField);
		panel.add(enterprisename_TextField);

//		registerInfoBesideEnterpriseName.setBounds(720, 450, 200, 50);
		registerInfoBesideEnterpriseName.setBounds(420, 340, 300, 50);
		registerInfoBesideEnterpriseName.setForeground(Color.RED);
		registerInfoBesideEnterpriseName.setFont(font);
//		this.add(registerInfoBesideEnterpriseName);
		panel.add(registerInfoBesideEnterpriseName);

		confirm_button.setText("确定");
		confirm_button.setBounds(400, 630, 100, 30);
		confirm_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registerInfoBesideEnterpriseName.setText("");
				registerInfoBesideSecondPassword.setText("");
				if (enterprisename_TextField.getText().equals("--企业名称--")
						|| enterprisename_TextField.getText().trim().equals("")) {
					registerInfoBesideEnterpriseName.setText("请输入企业名！");
				} else if ((confirmpassword_TextField.getText().equals("--再次输入密码--"))
						|| (!confirmpassword_TextField.getText().equals(password_TextField.getText()))) {
					registerInfoBesideSecondPassword.setText("两次密码输入不一致！");
				} else if (nameValid && telephoneValid && passwordValid) {
					// vo头像get方法未定
					PersonDetailVO vo = new PersonDetailVO(null, name_TextField.getText(), password_TextField.getText(),
							imageIcon, tel_TextField.getText(), 0, null, enterprisename_TextField.getText(), CustomerType.ENTERPRISE,
							null, UserType.Customer);
					ResultMessage resultMessage = personnelDistributionController.addPerson(vo);
					if (resultMessage == ResultMessage.SUCCESS) {
						new SaveSuccess_JFrame();
						dispose();
					} else {
						new SaveFail_JFrame();
					}
				}
			}
		});
		this.add(confirm_button);
		cancle_button.setText("取消");
		cancle_button.setBounds(600, 630, 100, 30);
		cancle_button.setBounds(600, 630, 100, 30);
		cancle_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registerViewController.jumpToRegisterChooseFrame();
				dispose();
			}
		});
		this.add(cancle_button);
		
		image_button.setText("选取头像");
//		image_button.setBounds(550, 570, 120, 30);
		image_button.setBounds(280, 570, 120, 30);
//		this.add(image_button);
		panel.add(image_button);

		//实现选择图片文件
		image_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path=FileChooseHelper.fileChoose();
				if(path!=null){
					imagePath=path;
					imageIcon=new ImageIcon(imagePath);
					imageIcon=ImageTool.getScaledImage(imageIcon, 150);
					realimage_JLabel.setIcon(imageIcon);
					Enterpriseregister_JFrame.this.realimage_JLabel.updateUI();
				}

			}
		});
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
		ImageIcon img = new ImageIcon("image//bg3.png");
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

	}

	 public static void main(String[] args){
	
	 new Enterpriseregister_JFrame();
	
	
	 }

}
