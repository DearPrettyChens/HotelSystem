package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SingleRoomInfo_JPanel  extends JPanel{
	
	private String bedtype;
	private String roomtype;
	private int number;
	private int price;
	
	
	private Font font=new Font("宋体",Font.BOLD, 20);
	
	private JLabel bedtypejl=new JLabel("床型：");
	private JLabel roomtypejl=new JLabel("房型：");
	private JLabel numberjl=new JLabel("数量：");
	private JLabel pricejl=new JLabel("价格：");
	
	private JTextField bedtypejtf=new JTextField();
	private JTextField roomtypejtf=new JTextField();
	private JTextField numberjtf=new JTextField();
	private JTextField pricejtf=new JTextField();
	
	
	public SingleRoomInfo_JPanel(String bedtype,String roomtype, int number,int price){
		this.bedtype=bedtype;
		this.roomtype=roomtype;
		this.number=number;
		this.price=price;
		
		
		bedtypejtf.setText(bedtype);
		roomtypejtf.setText(roomtype);
		numberjtf.setText(number+"");
		pricejtf.setText(price+"");
		
		
		
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,50);
		addComp();
		
		
		
		
	}

	public SingleRoomInfo_JPanel(){
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,50);
		addComp();
		
		
	}
	
	
	
	public void addComp(){
		
		bedtypejl.setFont(font);
		bedtypejl.setBounds(20,10,80,30);
		this.add(bedtypejl);
		
		bedtypejtf.setFont(font);
		bedtypejtf.setBounds(100,10,80,30);
		this.add(bedtypejtf);
		
		roomtypejl.setFont(font);
		roomtypejl.setBounds(120,10,80,30);
		this.add(roomtypejl);
		
		roomtypejtf.setFont(font);
		roomtypejtf.setBounds(200,10,80,30);
		this.add(roomtypejtf);
		
		numberjl.setFont(font);
		numberjl.setBounds(20,10,80,30);
		this.add(numberjl);
		
		bedtypejtf.setFont(font);
		bedtypejtf.setBounds(100,10,80,30);
		this.add(bedtypejtf);
		
		bedtypejl.setFont(font);
		bedtypejl.setBounds(20,10,80,30);
		this.add(bedtypejl);
		
		bedtypejtf.setFont(font);
		bedtypejtf.setBounds(100,10,80,30);
		this.add(bedtypejtf);
		
		
		this.setLayout(null);
		
		
	}
	
	
}
