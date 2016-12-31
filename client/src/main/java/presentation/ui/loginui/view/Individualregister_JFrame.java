package presentation.ui.loginui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;
import javax.print.Doc;
import javax.sound.midi.ControllerEventListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import org.omg.PortableServer.POAPackage.ServantAlreadyActive;

import presentation.ui.loginui.distributecontroller.RegisterDistributionController;
import presentation.ui.loginui.viewcontroller.RegisterViewController;
import presentation.ui.loginui.viewcontroller.RegisterViewControllerService;
import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.tools.CalendarPanel;
import presentation.ui.tools.FileChooseHelper;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.SaveFail_JFrame;
import presentation.ui.tools.SaveSuccess_JFrame;
import presentation.ui.tools.close_JButton;
import presentation.ui.tools.Name_JTextField;
import presentation.ui.tools.Narrow_JButton;
import util.CustomerType;
import util.ResultMessage;
import util.TransHelper;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

/**
 * 个人用户注册时的界面
 * @author cy
 * @version 1.0
 * 
 */
/**
 * 
 * @author CYF
 *
 */
public class Individualregister_JFrame extends JFrame {
	
	
	private boolean isDragged = false;
	private Point tmp;
	private Point loc;


	private Font font = new Font("宋体", Font.BOLD, 20);
	private Color color = new Color(69, 140, 116);
	// private Color color=Color.BLACK;

	private close_JButton close_jbutton = new close_JButton();
	private Narrow_JButton narrow_jbutton = new Narrow_JButton(this);

	private JLabel ninthday_logo = new JLabel();

	private JLabel individualtab_JLabel = new JLabel("普通会员注册");
	private JLabel name_JLabel = new JLabel("用户名");
	private JLabel password_JLabel = new JLabel("密码");
	private JLabel confirmpassword_JLabel = new JLabel("确认密码");
	private JLabel tel_JLabel = new JLabel("联系方式");
	private JLabel birthday_JLabel = new JLabel("生日");
	private JLabel image_JLabel = new JLabel("头像");
	private JLabel realimage_JLabel = new JLabel();
	private String imagePath = "image//logo.png";

	private MyTextfield name_TextField = new MyTextfield("--2-8位字母、数字或中文--");
	private MyTextfield password_TextField = new MyTextfield("--4-10位字母或数字--");
	private MyTextfield confirmpassword_TextField = new MyTextfield("--再次输入密码--");
	private MyTextfield tel_TextField = new MyTextfield("--11位手机号--");
	private MyTextfield birthday_TextField = new MyTextfield("--请选择日期--");

	private JLabel registerInfoBesideName = new JLabel();
	private JLabel registerInfoBesidePassword = new JLabel();
	private JLabel registerInfoBesideSecondPassword = new JLabel();
	private JLabel registerInfoBesideTel = new JLabel();
	private JLabel registerInfoBesideBirth = new JLabel();

	private MyButton confirm_button = new MyButton();
	private MyButton cancle_button = new MyButton();
	private MyButton image_button = new MyButton();

	private boolean nameValid = false;
	private boolean passwordValid = false;
	private boolean telephoneValid = false;
	// boolean birthdayValide = false;

	private ImageIcon imageIcon=null;
	private CalendarPanel p = new CalendarPanel(birthday_TextField, "yyyy-MM-dd");

	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();

	private RegisterViewControllerService registerViewController = RegisterViewController.getInstance();

	private JScrollPane scrollPane=new JScrollPane();
	private JPanel panel=new JPanel();
	
	public Individualregister_JFrame() {

		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(null);

		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法
	    addScrollPane();
	    this.setDragable();
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
		
		birthday_TextField.setBounds(100, 340, 300, 50);

		panel.add(birthday_TextField);
		// this.add(jp);
		p.initCalendarPanel();
		JLabel l = new JLabel("日历面板");
		p.add(l);
		panel.add(p);
		// this.getContentPane().add(txt1);

		registerInfoBesideBirth.setBounds(420, 340, 300, 50);
		registerInfoBesideBirth.setForeground(Color.RED);
		registerInfoBesideBirth.setFont(font);
		panel.add(registerInfoBesideBirth);

		realimage_JLabel.setBounds(100, 450, 150, 150);
		ImageIcon icon2 = new ImageIcon(Individualregister_JFrame.class.getResource(imagePath));
		icon2 = ImageTool.getScaledImage(icon2, 150);
		realimage_JLabel.setIcon(icon2);
		panel.add(realimage_JLabel);
		// this.getContentPane().add(realimage_JLabel);

		close_jbutton.setBounds(970, 10, 20, 20);
		this.add(close_jbutton);
		narrow_jbutton.setBounds(930, 10, 20, 20);
		this.add(narrow_jbutton);

		individualtab_JLabel.setFont(new Font("宋体", Font.BOLD, 30));
		individualtab_JLabel.setForeground(color);
		individualtab_JLabel.setBounds(400, 180, 200, 70);
		this.add(individualtab_JLabel);

		name_JLabel.setBounds(0, 20, 100, 50);
		name_JLabel.setForeground(color);
		name_JLabel.setFont(font);
		panel.add(name_JLabel);

		password_JLabel.setBounds(0, 100, 100, 50);
		password_JLabel.setForeground(color);
		password_JLabel.setFont(font);
		panel.add(password_JLabel);

		confirmpassword_JLabel.setBounds(0, 180, 100, 50);
		confirmpassword_JLabel.setForeground(color);
		confirmpassword_JLabel.setFont(font);
		panel.add(confirmpassword_JLabel);

		tel_JLabel.setBounds(0, 260, 100, 50);
		tel_JLabel.setForeground(color);
		tel_JLabel.setFont(font);
		panel.add(tel_JLabel);

		birthday_JLabel.setBounds(0, 340, 100, 50);
		birthday_JLabel.setForeground(color);
		birthday_JLabel.setFont(font);
		panel.add(birthday_JLabel);

		image_JLabel.setBounds(0, 420, 100, 50);
		image_JLabel.setForeground(color);
		image_JLabel.setFont(font);
		panel.add(image_JLabel);

		ImageIcon icon3 = new ImageIcon(Individualregister_JFrame.class.getResource("image/ninthday.png"));
		ninthday_logo.setBounds(300, 10, 400, 150);
		ninthday_logo.setIcon(icon3);
		this.add(ninthday_logo);

		name_TextField.setBounds(100, 20, 300, 50);
		panel.add(name_TextField);

		registerInfoBesideName.setBounds(420, 20, 200, 50);
		registerInfoBesideName.setForeground(Color.RED);
		registerInfoBesideName.setFont(font);
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
							registerInfoBesideName.setText("用户名格式错误！");
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
							registerInfoBesideName.setText("用户名格式错误！");
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
							registerInfoBesideName.setText("用户名格式错误！");
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

		password_TextField.setBounds(100, 100, 300, 50);
		panel.add(password_TextField);
		registerInfoBesidePassword.setBounds(420, 100, 200, 50);
		registerInfoBesidePassword.setForeground(Color.RED);
		registerInfoBesidePassword.setFont(font);
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
							registerInfoBesidePassword.setText("密码格式错误！");
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
							registerInfoBesidePassword.setText("密码格式错误！");
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
							registerInfoBesidePassword.setText("密码格式错误！");
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

		confirmpassword_TextField.setBounds(100, 180, 300, 50);
		panel.add(confirmpassword_TextField);

		registerInfoBesideSecondPassword.setBounds(420, 180, 200, 50);
		registerInfoBesideSecondPassword.setForeground(Color.RED);
		registerInfoBesideSecondPassword.setFont(font);
		panel.add(registerInfoBesideSecondPassword);

		tel_TextField.setBounds(100, 260, 300, 50);
		panel.add(tel_TextField);
		registerInfoBesideTel.setBounds(420, 260, 200, 50);
		registerInfoBesideTel.setForeground(Color.RED);
		registerInfoBesideTel.setFont(font);
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
							registerInfoBesideTel.setText("联系方式格式错误！");
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
							registerInfoBesideTel.setText("联系方式格式错误！");
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
							registerInfoBesideTel.setText("联系方式格式错误！");
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

		// JPanel jp=new JPanel();
		// jp.setBounds(400, 450, 300, 50);
		// jp.setLayout(null);

		confirm_button.setText("确定");
		confirm_button.setBounds(400, 630, 100, 30);
		confirm_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				registerInfoBesideBirth.setText("");
				registerInfoBesideSecondPassword.setText("");
				if (birthday_TextField.getText().trim().equals("") || birthday_TextField.getText().equals("--请选择日期--")
						|| p.getReturnDateStr() == null || p.getReturnDateStr().equals("")
						|| (!birthday_TextField.getText().matches("^\\d{4}-\\d{1,2}-\\d{1,2}"))) {
					registerInfoBesideBirth.setText("请选择生日！");
				} else if ((confirmpassword_TextField.getText().equals("--再次输入密码--"))
						|| (!confirmpassword_TextField.getText().equals(password_TextField.getText()))) {
					registerInfoBesideSecondPassword.setText("两次密码输入不一致！");
				} else if (nameValid && telephoneValid && passwordValid) {
					Date birth = new Date(TransHelper.stringToDate(p.getReturnDateStr()));
					PersonDetailVO vo = new PersonDetailVO(null, name_TextField.getText(), password_TextField.getText(),
							imageIcon, tel_TextField.getText(), 0, birth, null, CustomerType.INDIVIDUAL, null,
							UserType.Customer);
					ResultMessage resultMessage = personnelDistributionController.addPerson(vo);
					if (resultMessage == ResultMessage.SUCCESS) {
						SaveSuccess_JFrame saveSuccess_JFrame = new SaveSuccess_JFrame();
						dispose();
					} else {
						SaveFail_JFrame saveFail_JFrame = new SaveFail_JFrame();
					}
				}
			}
		});
		this.add(confirm_button);

		cancle_button.setText("取消");
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
		image_button.setBounds(280, 570, 120, 30);
		panel.add(image_button);
		
		//实现选择图片文件
		image_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path=FileChooseHelper.fileChoose();
				if(path!=null){
					imagePath=path;
					imageIcon=new ImageIcon(Individualregister_JFrame.class.getResource(imagePath));
					imageIcon=ImageTool.getScaledImage(imageIcon, 150);
					realimage_JLabel.setIcon(imageIcon);
					Individualregister_JFrame.this.realimage_JLabel.updateUI();
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
		ImageIcon img = new ImageIcon(Individualregister_JFrame.class.getResource("image/bg3.png"));
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

	}

	 public static void main(String[] args){
	
	 new Individualregister_JFrame();
	
	
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
