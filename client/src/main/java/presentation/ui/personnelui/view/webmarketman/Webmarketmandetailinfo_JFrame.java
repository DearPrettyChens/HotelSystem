package presentation.ui.personnelui.view.webmarketman;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import presentation.ui.personnelui.distributecontroller.PersonnelDistributionController;
import presentation.ui.tools.MyButton;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

/**
 * 网站营销人员详细信息面板
 * 
 * 还未写保存成功之类的，还未实现时时更新检查
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Webmarketmandetailinfo_JFrame extends JFrame {

	private Font font = new Font("宋体", Font.BOLD, 16);

	private String id;
	private String name;
	private String tel;
	private UserType type;
	private String password;

	private JLabel typejl = new JLabel("职务：   ");
	private JLabel idjl = new JLabel("I   D:   ");
	private JLabel namejl = new JLabel("姓名：   ");
	private JLabel teljl = new JLabel("电话：   ");
	private JLabel passwordjl = new JLabel("密码：   ");

	private JTextField idjtx = new JTextField();
	private JTextField namejtx = new JTextField();
	private JTextField teljtx = new JTextField();
	private JTextField typejtx = new JTextField();
	private JTextField passwordjtx = new JTextField();

	private MyButton editjb = new MyButton();
	private MyButton confirmjb = new MyButton();

	private PersonnelDistributionController personnelDistributionController = PersonnelDistributionController
			.getInstance();

	public Webmarketmandetailinfo_JFrame(String id) {

		PersonDetailVO personDetailVO = personnelDistributionController.getPersonDetail(id);

		this.id = personDetailVO.getId();
		this.name = personDetailVO.getName();
		this.tel = personDetailVO.getTelephone();
		this.type = personDetailVO.getUserType();
		this.password = personDetailVO.getPassword();

		typejtx.setText("营销人员");
		idjtx.setText(id);
		namejtx.setText(name);
		teljtx.setText(tel);

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
		typejtx.setEditable(false);
		this.add(typejtx);

		idjl.setBounds(50, 70, 200, 30);
		idjl.setFont(font);
		this.add(idjl);
		idjtx.setBounds(100, 70, 200, 30);
		idjtx.setFont(font);
		idjtx.setEditable(false);
		this.add(idjtx);

		namejl.setBounds(50, 120, 200, 30);
		namejl.setFont(font);
		this.add(namejl);
		namejtx.setBounds(100, 120, 200, 30);
		namejtx.setFont(font);
		namejtx.setEditable(false);
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

		editjb.setBounds(50, 270, 250, 30);
		editjb.setText("编辑");
		editjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				passwordjtx.setEditable(true);
				teljtx.setEditable(true);
				Webmarketmandetailinfo_JFrame.this.remove(editjb);
				Webmarketmandetailinfo_JFrame.this.add(confirmjb);
				// !!!!!!!!!这里没有实现时时检查？？？

			}

		});
		this.add(editjb);

		confirmjb.setBounds(50, 270, 250, 30);
		confirmjb.setText("确定");
		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// 此处还未写什么保存成功之类的
				Webmarketmandetailinfo_JFrame.this.setVisible(false);
				PersonDetailVO personDetailVO = new PersonDetailVO(id, name, password, null, tel, 0, null, null, null,
						null, type);
				personnelDistributionController.setPerson(personDetailVO);
			}

		});

	}

}
