package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyTextfield;
/**
 * 
 * 酒店工作人员退房时，搜索订单的面板
 * 
 * @author cy
 * @version 1.0
 * 
 * 
 * 
 */
public class SearchOrderToCheckOut_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);

	private JLabel ordernumberjl = new JLabel("请输入订单号：");
	private MyTextfield ordernumberjtf = new MyTextfield("请输入订单号");

	private JLabel titlejl = new JLabel("线上退房办理");
	
	private JLabel searchimagejl = new JLabel(new ImageIcon("image//search1.png"));

	private OrderInfoToCheckIn_JPanel orderInfoToCheckIn_JPanel;
	
	private String hotelID;
	
	public SearchOrderToCheckOut_JPanel(String hotelID) {
		this.hotelID=hotelID;
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
				String orderID=ordernumberjtf.getText();
				if((orderID!=null)&&(orderID.length()==18)){
						orderInfoToCheckIn_JPanel=new OrderInfoToCheckIn_JPanel(orderID,hotelID);
						SearchOrderToCheckOut_JPanel.this.add(orderInfoToCheckIn_JPanel);
						SearchOrderToCheckOut_JPanel.this.updateUI();
				}
			    
			}
		});
	}

}

