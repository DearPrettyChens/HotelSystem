package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * 酒店工作人员入住退房时，搜索订单的面板
 * @author cy
 * @version 1.0
 * 
 * 
 * 
 */
public class SearchOrderToCheckIn_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private JLabel ordernumberjl=new JLabel("输入订单号：");
	private JTextField ordernumberjtf=new JTextField();
	
	private JLabel searchimagejl=new JLabel(new ImageIcon("image//search1.png"));
	
	
	
	
	public SearchOrderToCheckIn_JPanel(){
		
	this.setSize(800,100);
	this.setLayout(null);
	this.setBackground(Color.white);
		
		
		
		
	addComp();
	
		
		
		
		
		
		
	}
	
	
	
	public void addComp(){
		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(50,30,150,40);
		this.add(ordernumberjl);
		
		
		ordernumberjtf.setBounds(200,30,150,40);
		this.add(ordernumberjtf);
		
		 searchimagejl.setBounds(400,30,40,40);
		 this.add(searchimagejl);
		 
		
		
		
	}
	

}
