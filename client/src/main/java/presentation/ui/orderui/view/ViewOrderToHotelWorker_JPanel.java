package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 酒店工作人员查看订单信息的面板
 * 
 * 未加订单选择的监听
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class ViewOrderToHotelWorker_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);

	private JLabel ordertypejl = new JLabel("订单类型:");
	private JComboBox comboBox = new JComboBox();

	public ViewOrderToHotelWorker_JPanel() {
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800, 100);

		addComp();

	}

	public void addComp() {

		ordertypejl.setBounds(110, 50, 120, 30);
		ordertypejl.setFont(font);
		this.add(ordertypejl);

		comboBox.addItem("全部订单");
		comboBox.addItem("已执行");
		comboBox.addItem("未执行");
		comboBox.addItem("异常订单");
		comboBox.addItem("已撤销");

		comboBox.setBounds(210, 50, 180, 30);
		this.add(comboBox);
	}

	public JComboBox getStateSelect(){
		return this.comboBox;
	}
}
