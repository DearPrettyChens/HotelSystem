package presentation.ui.personnelui.view.hotelworker;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import presentation.ui.personnelui.view.client.Clientdetailinfo_JFrame;
import presentation.ui.tools.MyButton;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

/**
 * 酒店工作人员详细信息面板
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Hotelworkerdetailinfo_JFrame extends JFrame {

	private Font font = new Font("宋体", Font.BOLD, 16);

	private String id;
	private String name;
	private String tel;
	private UserType type;
	private String password;
	private String hotelname;
	private ImageIcon image;
	
	private static boolean canSave=true;
	
	private JLabel typejl = new JLabel("职务：   ");
	private JLabel idjl = new JLabel("I   D:   ");
	private JLabel namejl = new JLabel("姓名：   ");
	private JLabel teljl = new JLabel("电话：   ");
	private JLabel passwordjl = new JLabel("密码：   ");
	private JLabel hotelnamejl = new JLabel("酒店：   ");

	private JLabel idjtx = new JLabel();
	private JLabel namejtx = new JLabel();
	private JTextField teljtx = new JTextField();
	private JLabel typejtx = new JLabel();
	private JTextField passwordjtx = new JTextField();
	private JLabel hotelnamejtx = new JLabel();

	private MyButton editjb = new MyButton();
	private MyButton confirmjb = new MyButton();

	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();

	private ManageHotelWorkerPanel manageHotelWorkerPanel=ManageHotelWorkerPanel.getInstance();
	
	public Hotelworkerdetailinfo_JFrame(String personID) {

		PersonDetailVO personDetailVO = personnelDistributionController.getPersonDetail(personID);

		this.id = personDetailVO.getId();
		this.name = personDetailVO.getName();
		this.tel = personDetailVO.getTelephone();
		this.type = personDetailVO.getUserType();
		this.password = personDetailVO.getPassword();
		this.hotelname = personDetailVO.getHotelName();
		this.image = personDetailVO.getImage();

		typejtx.setText("酒店人员");
		idjtx.setText(id);
		namejtx.setText(name);
		teljtx.setText(tel);
		hotelnamejtx.setText(hotelname);

		passwordjtx.setText(password);

		this.setLayout(null);
		this.setBounds(600, 300, 350, 400);

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

		hotelnamejl.setBounds(50, 270, 200, 30);
		hotelnamejl.setFont(font);
		this.add(hotelnamejl);
		hotelnamejtx.setBounds(100, 270, 200, 30);
		hotelnamejtx.setFont(font);
		this.add(hotelnamejtx);

		editjb.setBounds(50, 330, 250, 30);
		editjb.setText("编辑");
		editjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				passwordjtx.setEditable(true);
				teljtx.setEditable(true);
				Hotelworkerdetailinfo_JFrame.this.remove(editjb);
				Hotelworkerdetailinfo_JFrame.this.add(confirmjb);

			}

		});
		this.add(editjb);

		JLabel telErrorJl=new JLabel("请输入11位的手机号码");
		telErrorJl.setForeground(Color.RED);
		telErrorJl.setFont(font);
		telErrorJl.setBounds(100, 200, 200, 20);
		telErrorJl.setVisible(false);
		Hotelworkerdetailinfo_JFrame.this.add(telErrorJl);
		
		JLabel telErrorJl2=new JLabel("不能为空");
		telErrorJl2.setForeground(Color.RED);
		telErrorJl2.setFont(font);
		telErrorJl2.setBounds(100, 200, 200, 20);
		Hotelworkerdetailinfo_JFrame.this.add(telErrorJl2);
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
						canSave=false;
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						telErrorJl.setVisible(false);
						canSave=true;
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
						canSave=false;
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						telErrorJl.setVisible(false);
						canSave=true;
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
						canSave=false;
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						telErrorJl.setVisible(false);
						canSave=true;
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
		Hotelworkerdetailinfo_JFrame.this.add(passwordErrorJl);
		passwordErrorJl.setVisible(false);
		
		JLabel passwordErrorJl2=new JLabel("不能为空");
		passwordErrorJl2.setForeground(Color.RED);
		passwordErrorJl2.setFont(font);
		passwordErrorJl2.setBounds(100, 250, 200, 20);
		Hotelworkerdetailinfo_JFrame.this.add(passwordErrorJl2);
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
						canSave=false;
					}
					else if(personnelDistributionController.checkPassword(s)==ResultMessage.SUCCESS){
						passwordErrorJl.setVisible(false);
						canSave=true;
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
						canSave=false;
					}
					else if(personnelDistributionController.checkPassword(s)==ResultMessage.SUCCESS){
						passwordErrorJl.setVisible(false);
						canSave=true;
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
						canSave=false;
					}
					else if(personnelDistributionController.checkPassword(s)==ResultMessage.SUCCESS){
						passwordErrorJl.setVisible(false);
						canSave=true;
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		JLabel saveError=new JLabel("保存失败");
		saveError.setForeground(Color.RED);
		saveError.setFont(font);
		saveError.setBounds(50,280,150,30);
		Hotelworkerdetailinfo_JFrame.this.add(saveError);
		saveError.setVisible(false);
		
		confirmjb.setBounds(50, 330, 250, 30);
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
				if(!passwordjtx.getText().equals("")&&!teljtx.getText().equals("")&&canSave){
					tel=teljtx.getText();
					password=passwordjtx.getText();
					PersonDetailVO personDetailVO = new PersonDetailVO(id, name, password, image, tel, 0, null, null, null,
							hotelname, type);
					if(personnelDistributionController.setPerson(personDetailVO)==ResultMessage.SUCCESS){
						manageHotelWorkerPanel.initHotelWorkerList();
						Hotelworkerdetailinfo_JFrame.this.setVisible(false);
					}
					else{
						saveError.setVisible(true);
					}
				}
			}

		});

	}

}
