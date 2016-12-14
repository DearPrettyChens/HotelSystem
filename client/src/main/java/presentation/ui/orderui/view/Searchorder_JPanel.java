package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.OrderState;
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
	private LookOrderPanelInWeb_JPanel panel;

	private UserType userType;// 查看订单列表的人的类型

	public Searchorder_JPanel(UserType type,LookOrderPanelInWeb_JPanel panel) {
		this.userType = type;
		this.panel=panel;
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
		comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				int position = comboBox.getSelectedIndex();
				switch (position) {
				case 0:panel.initOrderList(OrderState.UNUSUAL);
					break;
				case 1:panel.initOrderList(OrderState.NOTEXECUTED);
				    break;
				case 2:panel.initOrderList(OrderState.EXECUTED);
					break;
				default:
					break;
				}
			}
		});
		this.add(comboBox);
	}

}
