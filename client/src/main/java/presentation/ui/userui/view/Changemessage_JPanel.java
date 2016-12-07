package presentation.ui.userui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.mapping.PersistentClassVisitor;

import presentation.ui.tools.ImageTool;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.newclient_JLabel;
import presentation.ui.userui.distributecontroller.UserDistributeController;
import util.CustomerType;
import util.TransHelper;
import vo.personnelvo.PersonDetailVO;

/**
 * 顾客界面维护个人信息
 * 
 * 缺少confirm的controller调用
 * 
 * @author cy
 *
 */

public class Changemessage_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);

	private String userName;
	private String userTel;
	private ImageIcon userImage;
	private String userBirth;
	private String userEnterprise;
	private double userCredit;
	private int userGrade;// 用户等级
	private CustomerType customerType;

	Date birthdayInDate;

	private JLabel name = new JLabel("XXX");
	private JLabel teljl = new JLabel("联系方式: ");
	private JLabel birthdayjl = new JLabel("生       日: ");
	private JLabel enterprisejl = new JLabel("企       业: ");
	private JLabel creditjl = new JLabel("信 用 值 :");
	private JLabel leveljl = new JLabel("会员等级: ");

	private JLabel userteljl = new JLabel();
	private JTextField tel = new JTextField("");
	private JLabel birthday = new JLabel("");
	private JLabel enterprise = new JLabel("");
	private JLabel credit = new JLabel("");
	private JLabel level = new JLabel("");

	private JLabel image = new JLabel();

	private JLabel editing = new JLabel();

	private JLabel confirm = new JLabel();
	private UserDistributeController userDistributeController = UserDistributeController.getInstance();

	public Changemessage_JPanel(String userID) {
		PersonDetailVO personDetailVO = userDistributeController.getDetailInfo(userID);
		userName = personDetailVO.getName();
		userTel = personDetailVO.getTelephone();
		userImage = personDetailVO.getImage();
		customerType = personDetailVO.getVIPType();
		userCredit = personDetailVO.getCredit();
		userGrade = userDistributeController.getGrade(userID);
		switch (customerType) {
		case ENTERPRISE:
			userEnterprise = personDetailVO.getEnterpriseName();
			break;
		case INDIVIDUAL:
			birthdayInDate = personDetailVO.getBirthday();
			userBirth = TransHelper.dateToString(birthdayInDate);
			break;
		default:
			break;

		}

		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBounds(0, 0, 800, 600);

		addComp();

	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		name.setText(userName);
		name.setBounds(180, 350, 200, 50);
		name.setFont(font);
		this.add(name);

		userImage = ImageTool.getScaledImage(userImage, 150);
		image.setIcon(userImage);
		image.setBounds(130, 180, 150, 150);
		this.add(image);

		teljl.setBounds(400, 100, 300, 50);
		teljl.setFont(font);
		this.add(teljl);

		userteljl.setText(userTel);
		userteljl.setFont(font);
		userteljl.setBounds(500, 100, 200, 50);

		switch (customerType) {
		case ENTERPRISE:

			enterprisejl.setBounds(400, 200, 300, 50);
			enterprisejl.setFont(font);
			this.add(enterprisejl);

			enterprise.setText(userEnterprise);
			enterprise.setBounds(500, 200, 300, 50);
			enterprise.setFont(font);
			this.add(enterprise);

			break;
		case INDIVIDUAL:

			birthdayjl.setBounds(400, 200, 300, 50);
			birthdayjl.setFont(font);
			this.add(birthdayjl);

			birthday.setText(userBirth);
			birthday.setBounds(500, 200, 300, 50);
			birthday.setFont(font);
			this.add(birthday);

			break;
		default:
			break;
		}

		creditjl.setBounds(400, 300, 300, 50);
		creditjl.setFont(font);
		this.add(creditjl);

		credit.setText(String.valueOf(userCredit));
		credit.setBounds(500, 300, 300, 50);
		credit.setFont(font);
		this.add(credit);

		leveljl.setBounds(400, 400, 300, 50);
		leveljl.setFont(font);
		this.add(leveljl);

		level.setText(String.valueOf(userGrade));
		level.setBounds(500, 400, 300, 50);
		level.setFont(font);
		this.add(level);

		this.add(userteljl);

		ImageIcon icon = new ImageIcon("image//blackEdit.png");
		editing.setIcon(icon);
		editing.setBounds(650, 110, 30, 30);
		this.add(editing);

		editing.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent e) {
				showTelTextField();
	
			}
		});

		
		 confirm.addMouseListener(new MouseAdapter() {
		
		 @Override
		 public void mouseEntered(MouseEvent e) {
		
		 }
		
		 @Override
		 public void mouseExited(MouseEvent e) {
		
		 }
		
		 public void mouseClicked(MouseEvent e) {
		 String text=tel.getText();
		
		 //此处缺少调用controller
		 
		 
		showTelLabel();
		 	 }
		 });
		
	}

	/**
	 * 显示联系方式的label
	 */
	public void showTelLabel() {
        
		userTel=tel.getText();
		
		this.remove(tel);
        this.remove(confirm);
		
		userteljl.setText(userTel);
		userteljl.setFont(font);
		userteljl.setBounds(500, 100, 200, 50);
		this.add(userteljl);

		ImageIcon icon = new ImageIcon("image//blackEdit.png");
		editing.setIcon(icon);
		editing.setBounds(650, 110, 30, 30);
		this.add(editing);
		
		this.updateUI();
		
	}

	/**
	 * 显示联系方式的输入框
	 *
	 */
	public void showTelTextField() {
		this.remove(userteljl);
		this.remove(editing);
		
		tel.setText(userTel);;
		tel.setBounds(500, 110, 120, 30);
		this.add(tel);

		ImageIcon icon2 = new ImageIcon("image//confirm.png");
		confirm.setIcon(icon2);
		confirm.setBounds(650, 110, 30, 30);
		this.add(confirm);

		this.updateUI();
	}

}
