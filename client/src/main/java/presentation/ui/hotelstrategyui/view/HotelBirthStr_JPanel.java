package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.ui.tools.MyButton;

/**
 * 生日特惠策略
 * @author cy
 * @version 1.0
 * 
 */
public class HotelBirthStr_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	private JLabel titlejl=new JLabel("生日特惠策略");
	private JLabel countjl=new JLabel("折扣值：");
	private JTextField countjtf=new  JTextField ();
	
	private MyButton canclejb=new MyButton();
	private MyButton confirmjb=new MyButton();
	
	private int count;
	
	
	public  HotelBirthStr_JPanel (){
		//this.count=问逻辑层拿
		
		countjtf.setText(count+"");
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		
		addComp();
		
		
		
	}
	
	public void  addComp(){
		
		
		canclejb.setText("取消");
		canclejb.setBounds(600,500,80,30);
		this.add(canclejb);
		
		confirmjb.setText("确定");
		confirmjb.setBounds(500,500,80,30);
		this.add(confirmjb);
		
		titlejl.setFont(font);
		titlejl.setBounds(20,50,200,30);
		this.add(titlejl);
		
		countjl.setFont(font);
		countjl.setBounds(220,200,100,50);
		this.add(countjl);
		
		countjtf.setText(count+"");
		countjtf.setBounds(320,200,200,50);
		this.add(countjtf);
		
		
		
		
		
	}

}
