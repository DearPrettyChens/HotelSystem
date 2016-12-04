package presentation.ui.personnelui.view.webmarketman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;

/**
 * 网站管理人员添加酒店工作人员的面板
 * 
 * 还未实现时时更新，还未和逻辑层链接
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class WebMarketManAdd_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);

	private String id;
	private String name;
	private String tel;
	// private String type;
	private String password;

	// private JLabel typejl=new JLabel("职务： ");
	// private JLabel idjl=new JLabel("I D: ");
	private JLabel namejl = new JLabel("姓名：   ");

	private JLabel teljl = new JLabel("电话：   ");
	private JLabel passwordjl = new JLabel("密码：   ");

	// private JTextField idjtx=new JTextField("");
	private MyTextfield namejtx = new MyTextfield("请输入姓名");

	private MyTextfield teljtx = new MyTextfield("请输入联系方式");
	// private JTextField typejtx=new JTextField();
	private MyTextfield passwordjtx = new MyTextfield("请输入密码");

	private MyButton canclejb = new MyButton();
	private MyButton confirmjb = new MyButton();

	public WebMarketManAdd_JPanel() {
		// this.id=id;
		this.setBackground(Color.white);

		this.setLayout(null);

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

		// idjl.setFont(font);
		// idjl.setBounds(300,110,100,50);
		// idjtx.setText(id);
		// idjtx.setEditable(false);
		// this.add(idjl);
		// idjtx.setFont(font);
		// idjtx.setBounds(350,110,200,50);
		// this.add(idjtx);
		//

		namejl.setFont(font);
		namejl.setBounds(280, 80, 100, 50);
		this.add(namejl);
		namejtx.setBounds(330, 80, 200, 50);
		this.add(namejtx);

		teljl.setFont(font);
		teljl.setBounds(280, 180, 100, 50);
		this.add(teljl);
		teljtx.setBounds(330, 180, 200, 50);
		this.add(teljtx);

		passwordjl.setFont(font);
		passwordjl.setBounds(280, 280, 100, 50);
		this.add(passwordjl);
		passwordjtx.setBounds(330, 280, 200, 50);
		this.add(passwordjtx);

		confirmjb.setText("确定");
		confirmjb.setBounds(280, 390, 100, 30);
		this.add(confirmjb);

		canclejb.setText("取消");
		canclejb.setBounds(430, 390, 100, 30);
		this.add(canclejb);

		confirmjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 确认按钮此处用来添加人员信息，未实现时时更新？？？
				// TODO Auto-generated method stub

			}
		});

	}

}
