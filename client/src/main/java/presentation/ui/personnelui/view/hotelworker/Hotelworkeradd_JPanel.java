package presentation.ui.personnelui.view.hotelworker;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.personnelui.view.webmarketman.WebMarketManAdd_JPanel;
import presentation.ui.personnelui.viewcontroller.PersonnelControllerImpl;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.newclient_JLabel;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

/**
 * 网站管理人员添加酒店工作人员的面板
 * 
 * 还未实现时时更新，还未和逻辑层链接
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Hotelworkeradd_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);

	// private String id;
	private String name;
	private String tel;
	// private String type;
	private String password;
	private String hotelname;

	// private JLabel typejl=new JLabel("职务： ");
	// private JLabel idjl=new JLabel("I D: ");
	private JLabel namejl = new JLabel("姓名：   ");
	private JLabel hotelnamejl = new JLabel("酒店：   ");
	private JLabel teljl = new JLabel("电话：   ");
	private JLabel passwordjl = new JLabel("密码：   ");

	// private JTextField idjtx=new JTextField("");
	private MyTextfield namejtx = new MyTextfield("请输入姓名");
	private MyTextfield hotelnamejtx = new MyTextfield("请输入所属酒店名称");
	private MyTextfield teljtx = new MyTextfield("请输入联系方式");
	// private JTextField typejtx=new JTextField();
	private MyTextfield passwordjtx = new MyTextfield("请输入密码");

	private MyButton canclejb = new MyButton();
	private MyButton confirmjb = new MyButton();
	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();

	public Hotelworkeradd_JPanel() {
		// this.id=id;
		this.setBackground(Color.white);

		this.setLayout(null);

		this.setSize(800, 550);
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
		//
		// idjl.setFont(font);
		// idjl.setBounds(300,110,100,50);
		// idjtx.setText(id);
		// idjtx.setEditable(false);
		// this.add(idjl);
		// idjtx.setFont(font);
		// idjtx.setBounds(350,110,200,50);
		// this.add(idjtx);

		namejl.setFont(font);
		namejl.setBounds(280, 80, 100, 50);
		this.add(namejl);
		namejtx.setBounds(330, 80, 200, 50);
		this.add(namejtx);

		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(280, 160, 100, 50);
		this.add(hotelnamejl);
		hotelnamejtx.setBounds(330, 160, 200, 50);
		this.add(hotelnamejtx);

		teljl.setFont(font);
		teljl.setBounds(280, 240, 100, 50);
		this.add(teljl);
		teljtx.setBounds(330, 240, 200, 50);
		this.add(teljtx);

		passwordjl.setFont(font);
		passwordjl.setBounds(280, 320, 100, 50);
		this.add(passwordjl);
		passwordjtx.setBounds(330, 320, 200, 50);
		this.add(passwordjtx);

		confirmjb.setText("确定");
		confirmjb.setBounds(280, 430, 100, 30);
		this.add(confirmjb);

		canclejb.setText("取消");
		canclejb.setBounds(430, 430, 100, 30);
		this.add(canclejb);
		
		/**
		 * 实现用户名的实时检查
		 */
		Document nameDoc=namejtx.getDocument();
		nameDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				Document doc = e.getDocument();
				try {
					JLabel nameErrorJl1=new JLabel("用户名已存在");
					nameErrorJl1.setForeground(Color.RED);
					nameErrorJl1.setFont(font);
					nameErrorJl1.setBounds(540,80,200,50);
					JLabel nameErrorJl2=new JLabel("2-8位字母数字或中文");
					nameErrorJl2.setForeground(Color.RED);
					nameErrorJl2.setFont(font);
					nameErrorJl2.setBounds(540,80,250,50);
					JLabel nameErrorJl3=new JLabel();
					nameErrorJl3.setForeground(Color.RED);
					nameErrorJl3.setFont(font);
					nameErrorJl3.setBounds(540,80,250,50);
					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkTel(s)==ResultMessage.USEREXISTED){
						Hotelworkeradd_JPanel.this.add(nameErrorJl1);
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.USERFORMATERROR){
						Hotelworkeradd_JPanel.this.add(nameErrorJl2);
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						Hotelworkeradd_JPanel.this.add(nameErrorJl3);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}

			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
			
		});
		
		/**
		 * 实现联系方式的实时检查
		 */
		Document telDoc=teljtx.getDocument();
		telDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				Document doc = e.getDocument();
				try {
					JLabel telErrorJl=new JLabel("请输入11位的手机号码");
					telErrorJl.setForeground(Color.RED);
					telErrorJl.setFont(font);
					telErrorJl.setBounds(540,240,200,50);
					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkTel(s)==ResultMessage.FAIL){
						Hotelworkeradd_JPanel.this.add(telErrorJl);
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						Hotelworkeradd_JPanel.this.remove(telErrorJl);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
			
		});
		/**
		 * 实现密码的实时检查
		 */
		Document passwordDoc=passwordjtx.getDocument();
		passwordDoc.addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				Document doc = e.getDocument();
				try {
					JLabel passwordErrorJl=new JLabel("4-10位的数字或字母");
					passwordErrorJl.setForeground(Color.RED);
					passwordErrorJl.setFont(font);
					passwordErrorJl.setBounds(540,320,200,50);
					String s = doc.getText(0, doc.getLength());
					if(personnelDistributionController.checkTel(s)==ResultMessage.PASSWORDFORMATERROR){
						Hotelworkeradd_JPanel.this.add(passwordErrorJl);
					}
					else if(personnelDistributionController.checkTel(s)==ResultMessage.SUCCESS){
						Hotelworkeradd_JPanel.this.remove(passwordErrorJl);
					}
				} catch (BadLocationException e1) {
					e1.printStackTrace();
				}
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
			
		});
		/**
		 * 点击确认按钮，添加人员
		 */
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PersonDetailVO detail=new PersonDetailVO(null,namejtx.getText(),passwordjtx.getText(),
						null,teljtx.getText(),0,null,null,null,hotelnamejtx.getText(),UserType.HotelWorker);
				if(personnelDistributionController.addPerson(detail)==ResultMessage.SUCCESS){
					//保存成功
					//TODO
				}
			}
		});
		/**
		 * 点击取消按钮，清空输入框
		 */
		canclejb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Hotelworkeradd_JPanel.this.remove(namejtx);
				namejtx= new MyTextfield("请输入姓名");
				namejtx.setBounds(330, 80, 200, 50);
				Hotelworkeradd_JPanel.this.add(namejtx);
				
				Hotelworkeradd_JPanel.this.remove(hotelnamejtx);
				hotelnamejtx= new MyTextfield("请输入所属酒店名称");
				hotelnamejtx.setBounds(330, 160, 200, 50);
				Hotelworkeradd_JPanel.this.add(hotelnamejtx);
				
				Hotelworkeradd_JPanel.this.remove(teljtx);
				teljtx= new MyTextfield("请输入联系方式");
				teljtx.setBounds(330, 240, 200, 50);
				Hotelworkeradd_JPanel.this.add(teljtx);
				
				Hotelworkeradd_JPanel.this.remove(passwordjtx);
				passwordjtx= new MyTextfield("请输入密码");
				passwordjtx.setBounds(330, 320, 200, 50);
				Hotelworkeradd_JPanel.this.add(passwordjtx);
			}
			
		});
	}

}
