package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.UserType;

/**
 * 网站营销人员搜索订单的搜索栏面板
 * 
 * 获取订单类型的列表的订单
 * 
 * @author cy
 * @version 1.0
 * 
 * 
 */
public class Searchorder_JPanel extends JPanel {
	private Font font = new Font("宋体", Font.PLAIN, 16);
	private JLabel ordertypejl = new JLabel("订单类型");
	private JLabel begintimejl = new JLabel("时间：  从");
	private JLabel endtimejl = new JLabel("到");
	private JComboBox comboBox = new JComboBox();
	private Color backgroundcolor = new Color(148, 221, 184);

	private UserType userType;// 查看订单列表的人的类型

	public Searchorder_JPanel(UserType type) {
		this.userType = type;

		this.setBackground(Color.white);
		this.setSize(800, 100);
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
		ordertypejl.setBounds(110, 50, 120, 30);
		ordertypejl.setFont(font);
		ordertypejl.setForeground(Color.black);
		this.add(ordertypejl);

		comboBox.setBounds(210, 50, 180, 30);
		comboBox.addItem("异常订单");
		comboBox.addItem("未执行订单");
		comboBox.addItem("已执行订单");
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});;
		
		this.add(comboBox);
	}

}