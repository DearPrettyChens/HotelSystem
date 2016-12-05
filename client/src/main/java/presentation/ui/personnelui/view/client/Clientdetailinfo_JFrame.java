package presentation.ui.personnelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.personnelui.view.webmarketman.WebMarketManAdd_JPanel;
import presentation.ui.tools.MyButton;
import util.CustomerType;
import util.ResultMessage;
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

	private Color backgroundcolor = new Color(148, 221, 184);
	
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

		JLabel telErrorJl=new JLabel("请输入11位的手机号码");
		telErrorJl.setForeground(Color.RED);
		telErrorJl.setFont(font);
		telErrorJl.setBounds(100, 200, 200, 20);
		telErrorJl.setVisible(false);
		Clientdetailinfo_JFrame.this.add(telErrorJl);
		
		JLabel telErrorJl2=new JLabel("不能为空");
		telErrorJl2.setForeground(Color.RED);
		telErrorJl2.setFont(font);
		telErrorJl2.setBounds(100, 200, 200, 20);
		Clientdetailinfo_JFrame.this.add(telErrorJl2);
		telErrorJl2.setVisible(false);
		/**
		 * 实现联系方式的实时检查
		 */
		Document telDoc=teljtx.getDocument();
		telDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				telErrorJl2.setVisible(false);
				Document doc = e.getDocument();
				try {

					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkTel(s)==ResultMessage.FAIL){
						telErrorJl.setVisible(true);
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						telErrorJl.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				telErrorJl2.setVisible(false);
				Document doc = e.getDocument();
				try {

					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkTel(s)==ResultMessage.FAIL){
						telErrorJl.setVisible(true);
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						telErrorJl.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				telErrorJl2.setVisible(false);
				Document doc = e.getDocument();
				try {

					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkTel(s)==ResultMessage.FAIL){
						telErrorJl.setVisible(true);
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						telErrorJl.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		JLabel passwordErrorJl=new JLabel("4-10位的数字或字母");
		passwordErrorJl.setForeground(Color.RED);
		passwordErrorJl.setFont(font);
		passwordErrorJl.setBounds(100, 250, 200, 20);
		Clientdetailinfo_JFrame.this.add(passwordErrorJl);
		passwordErrorJl.setVisible(false);
		
		JLabel passwordErrorJl2=new JLabel("不能为空");
		passwordErrorJl2.setForeground(Color.RED);
		passwordErrorJl2.setFont(font);
		passwordErrorJl2.setBounds(100, 250, 200, 20);
		Clientdetailinfo_JFrame.this.add(passwordErrorJl2);
		passwordErrorJl2.setVisible(false);
		/**
		 * 实现密码的实时检查
		 */
		Document passwordDoc=passwordjtx.getDocument();
		passwordDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				passwordErrorJl2.setVisible(false);
				Document doc = e.getDocument();
				try {

					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkPassword(s)==ResultMessage.PASSWORDFORMATERROR){
						passwordErrorJl.setVisible(true);
					}
					else if(personnelDistributionController.checkPassword(s)==ResultMessage.SUCCESS){
						passwordErrorJl.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				passwordErrorJl2.setVisible(false);
				Document doc = e.getDocument();
				try {

					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkPassword(s)==ResultMessage.PASSWORDFORMATERROR){
						passwordErrorJl.setVisible(true);
					}
					else if(personnelDistributionController.checkPassword(s)==ResultMessage.SUCCESS){
						passwordErrorJl.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				passwordErrorJl2.setVisible(false);
				Document doc = e.getDocument();
				try {

					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkPassword(s)==ResultMessage.PASSWORDFORMATERROR){
						passwordErrorJl.setVisible(true);
					}
					else if(personnelDistributionController.checkPassword(s)==ResultMessage.SUCCESS){
						passwordErrorJl.setVisible(false);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		editjb.setBounds(50, 390, 250, 30);
		editjb.setText("编辑");
		editjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				passwordjtx.setEditable(true);
				teljtx.setEditable(true);
				Clientdetailinfo_JFrame.this.remove(editjb);
				Clientdetailinfo_JFrame.this.add(confirmjb);
			}

		});
		this.add(editjb);

		JLabel saveError=new JLabel("保存失败");
		saveError.setForeground(Color.RED);
		saveError.setFont(font);
		saveError.setBounds(50,350,150,30);
		Clientdetailinfo_JFrame.this.add(saveError);
		saveError.setVisible(false);
		
		confirmjb.setBounds(50, 390, 250, 30);
		confirmjb.setText("确定");
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if(passwordjtx.getText().equals("")){
					passwordErrorJl2.setVisible(false);
				}
				if(teljtx.getText().equals("")){
					teljtx.setVisible(false);
				}
				if(!passwordjtx.getText().equals("")&&!teljtx.getText().equals("")){
					PersonDetailVO personDetailVO = new PersonDetailVO(id, name, password, image, tel, credit,
							birthdayByDate, enterpriseName, customerType, null, type);
					if(personnelDistributionController.setPerson(personDetailVO)==ResultMessage.SUCCESS){
						Clientdetailinfo_JFrame.this.setVisible(false);
					}
					else{
						saveError.setVisible(true);
					}
				}
				
			}

		});

		//TODO
		//能不能实现点任意一个地方，使保存失败不显示
	}

}
