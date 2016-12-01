package presentation.ui.availableroomui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * 单条的房间信息
 * @author cy
 * @version 1.0
 * 
 */
public class SingleRoomInfo_JPanel  extends JPanel{
	
	private String bedtype;
	private String roomtype;
	private int number;
	private int price;
	
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private JLabel bedtypejl=new JLabel("床型:");
	private JLabel roomtypejl=new JLabel("房型:");
	private JLabel numberjl=new JLabel("数量:");
	private JLabel pricejl=new JLabel("价格:");
	
	
	private JTextField bedtypejtf=new JTextField();
	private JTextField roomtypejtf=new JTextField();
	private JTextField numberjtf=new JTextField();
	private JTextField pricejtf=new JTextField();
	
	
	
	
	public SingleRoomInfo_JPanel(){
		
		
		bedtypejtf.setText(bedtype);
		roomtypejtf.setText(roomtype);
		numberjtf.setText(number+"");
		pricejtf.setText(price+"");
		
		this.setSize(800,50);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
	}
	
	public SingleRoomInfo_JPanel(String bedtype,String roomtype, int number,int price){
		this.bedtype=bedtype;
		this.roomtype=roomtype;
		this.number=number;
		this.price=price;
		
		bedtypejtf.setText(bedtype);
		roomtypejtf.setText(roomtype);
		numberjtf.setText(number+"");
		pricejtf.setText(price+"");
		
		this.setSize(800,50);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
	}
	
	
	
	public void addComp(){
		
		bedtypejl.setBounds(20,10,80,30);
		bedtypejl.setFont(font);
		this.add(bedtypejl);
		
		roomtypejl.setBounds(220,10,80,30);
		roomtypejl.setFont(font);
		this.add(roomtypejl);
		
		numberjl.setBounds(420,10,80,30);
		numberjl.setFont(font);
		this.add(numberjl);
		
		pricejl.setBounds(620,10,80,30);
		pricejl.setFont(font);
		this.add(pricejl);
		
		
		bedtypejtf.setBounds(100,10,80,30);
		bedtypejtf.setFont(font);
		this.add(bedtypejtf);
		
		roomtypejtf.setBounds(300,10,80,30);
		roomtypejtf.setFont(font);
		this.add(roomtypejtf);
		
		numberjtf.setBounds(500,10,80,30);
		numberjtf.setFont(font);
		this.add(numberjtf);
		
		pricejtf.setBounds(700,10,80,30);
		pricejtf.setFont(font);
		this.add(pricejtf);
		
		
	}
	

}
