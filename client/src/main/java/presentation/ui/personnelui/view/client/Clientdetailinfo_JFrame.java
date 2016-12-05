package presentation.ui.personnelui.view.client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.tools.MyButton;
import util.CustomerType;
import util.TransHelper;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

/**
 * 顾客详细信息窗口
 * 
 * 未实现时时检查，还没有保存成功失败的窗口，以及处理
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Clientdetailinfo_JFrame extends JFrame {
	private Font font = new Font("宋体", Font.BOLD, 16);

	private String id;
	private String name;
	private String tel;
	private UserType type;
	private String password;
	private int credit;
	private String enterpriseName;
	private Date birthdayByDate;
	private String birthday;
	private ImageIcon image;
	private CustomerType customerType;

	private JLabel typejl = new JLabel("身份：   ");
	private JLabel idjl = new JLabel("I   D:   ");
	private JLabel namejl = new JLabel("姓名：   ");
	private JLabel teljl = new JLabel("电话：   ");
	private JLabel passwordjl = new JLabel("密码：   ");
	private JLabel creditjl = new JLabel("信用:   ");
	private JLabel enterpriseNamejl = new JLabel("企业:   ");
	private JLabel birthdayjl = new JLabel("生日:   ");

	private JLabel idjtx = new JLabel();
	private JLabel namejtx = new JLabel();
	private JTextField teljtx = new JTextField();
	private JLabel typejtx = new JLabel();
	private JTextField passwordjtx = new JTextField();
	private JLabel creditjtx = new JLabel();
	private JLabel enterpriseNamejtx = new JLabel();
	private JLabel birthdayjtx = new JLabel();

	private MyButton editjb = new MyButton();
	private MyButton confirmjb = new MyButton();
	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();

	public Clientdetailinfo_JFrame(String id) {
		PersonDetailVO personDetailVO = personnelDistributionController.getPersonDetail(id);

		this.id = personDetailVO.getId();
		this.name = personDetailVO.getName();
		this.tel = personDetailVO.getTelephone();
		this.type = personDetailVO.getUserType();
		this.password = personDetailVO.getPassword();
		this.credit = personDetailVO.getCredit();
		this.birthdayByDate = personDetailVO.getBirthday();
		this.birthday = TransHelper.dateToString(birthdayByDate);
		this.enterpriseName = personDetailVO.getEnterpriseName();
		this.customerType = personDetailVO.getVIPType();

		this.image = personDetailVO.getImage();

		switch (customerType) {
		case ENTERPRISE:
			typejtx.setText("企业会员");
			enterpriseNamejtx.setText(enterpriseName);
			break;
		case INDIVIDUAL:
			typejtx.setText("普通会员");
			birthdayjtx.setText(birthday);
			break;
		}

		idjtx.setText(id);
		namejtx.setText(name);
		teljtx.setText(tel);
		passwordjtx.setText(password);
		creditjtx.setText(String.valueOf(credit));

		this.setLayout(null);
		this.setBounds(600, 200, 350, 480);

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

		typejl.setBounds(50, 20, 200, 30);
		typejl.setFont(font);
		this.add(typejl);
		typejtx.setBounds(100, 20, 200, 30);
		typejtx.setFont(font);
		//typejtx.setEditable(false);
		this.add(typejtx);

		idjl.setBounds(50, 70, 200, 30);
		idjl.setFont(font);
		this.add(idjl);
		idjtx.setBounds(100, 70, 200, 30);
		idjtx.setFont(font);
		this.add(idjtx);

		namejl.setBounds(50, 120, 200, 30);
		namejl.setFont(font);
		this.add(namejl);
		namejtx.setBounds(100, 120, 200, 30);
		namejtx.setFont(font);
		//namejtx.setEditable(false);
		this.add(namejtx);

		teljl.setBounds(50, 170, 200, 30);
		teljl.setFont(font);
		this.add(teljl);
		teljtx.setBounds(100, 170, 200, 30);
		teljtx.setFont(font);
		teljtx.setEditable(false);
		this.add(teljtx);

		passwordjl.setBounds(50, 220, 200, 30);
		passwordjl.setFont(font);
		this.add(passwordjl);
		passwordjtx.setBounds(100, 220, 200, 30);
		passwordjtx.setFont(font);
		passwordjtx.setEditable(false);
		this.add(passwordjtx);

		creditjl.setBounds(50, 270, 200, 30);
		creditjl.setFont(font);
		this.add(creditjl);
		creditjtx.setBounds(100, 270, 200, 30);
		creditjtx.setFont(font);
		//creditjtx.setEditable(false);
		this.add(creditjtx);

		switch (customerType) {
		case ENTERPRISE:
			enterpriseNamejl.setBounds(50, 320, 200, 30);
			enterpriseNamejl.setFont(font);
			this.add(enterpriseNamejl);
			enterpriseNamejtx.setBounds(100, 320, 200, 30);
			enterpriseNamejtx.setFont(font);
			//enterpriseNamejtx.setEditable(false);
			this.add(enterpriseNamejtx);
			break;
		case INDIVIDUAL:
			birthdayjl.setBounds(50, 320, 200, 30);
			birthdayjl.setFont(font);
			this.add(birthdayjl);
			birthdayjtx.setBounds(100, 320, 200, 30);
			birthdayjtx.setFont(font);
			//birthdayjtx.setEditable(false);
			this.add(birthdayjtx);
			break;
		}

		editjb.setBounds(50, 390, 250, 30);
		editjb.setText("编辑");
		editjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				passwordjtx.setEditable(true);
				teljtx.setEditable(true);
				Clientdetailinfo_JFrame.this.remove(editjb);
				Clientdetailinfo_JFrame.this.add(confirmjb);
				// !!!!!!!!!这里没有实现时时检查？？？
				// TODO
			}

		});
		this.add(editjb);

		confirmjb.setBounds(50, 390, 250, 30);
		confirmjb.setText("确定");
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 此处还未写什么保存成功之类的
				//TODO
				Clientdetailinfo_JFrame.this.setVisible(false);
				PersonDetailVO personDetailVO = new PersonDetailVO(id, name, password, image, tel, credit,
						birthdayByDate, enterpriseName, customerType, null, type);
				personnelDistributionController.setPerson(personDetailVO);

			}

		});

	}

}
