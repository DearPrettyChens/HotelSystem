package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.tools.MyTextfield;

/**
 * 
 * 酒店工作人员入住时，搜索订单的面板
 * 
 * @author cy
 * @version 1.0
 * 
 * 
 * 
 */
public class SearchOrderToCheckIn_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);

	private JLabel ordernumberjl = new JLabel("请输入订单号：");
	private MyTextfield ordernumberjtf = new MyTextfield("请输入订单号");

	private JLabel titlejl = new JLabel("线上入住办理");
	
	private JLabel searchimagejl = new JLabel(new ImageIcon("image//search1.png"));

	private OrderInfoToCheckIn_JPanel orderInfoToCheckIn_JPanel;
	
	public SearchOrderToCheckIn_JPanel() {

		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.white);

		addComp();

	}

	public void addComp() {
		
		titlejl.setFont(new Font("宋体", Font.BOLD, 20));
		titlejl.setBounds(40, 30, 800, 50);
		this.add(titlejl);
		
		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(100, 110, 200, 40);
		this.add(ordernumberjl);

		ordernumberjtf.setBounds(225, 110, 400, 40);
		this.add(ordernumberjtf);

		searchimagejl.setBounds(650, 110, 40, 40);
		this.add(searchimagejl);
        searchimagejl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String hotelID=ordernumberjtf.getText();
				if((hotelID!=null)&&(hotelID.matches("[0-9]+"))){
						orderInfoToCheckIn_JPanel=new OrderInfoToCheckIn_JPanel(hotelID);
						SearchOrderToCheckIn_JPanel.this.add(orderInfoToCheckIn_JPanel);
						SearchOrderToCheckIn_JPanel.this.updateUI();
				}
			    
			}
		});
	}

}
