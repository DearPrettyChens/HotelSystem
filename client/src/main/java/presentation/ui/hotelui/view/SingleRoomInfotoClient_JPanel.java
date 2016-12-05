package presentation.ui.hotelui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;

/**
 * 顾客查看酒店信息时的单条房型信息
 * @author cy
 * @version 1.0
 * 
 */
public class SingleRoomInfotoClient_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Color color =new Color(148,221,184);
	
	private  String roomtype="";
	private String bedtype="";
	private double price=0;
	
	private JLabel roomtypejl=new JLabel();
	private JLabel bedtypejl=new JLabel();
	private JLabel pricejl=new JLabel();
	
	private JLabel checkinjl=new JLabel("入住");
	private JLabel checkoutjl=new JLabel("退房");
	
	
	
	
	private JLabel bgjl=new JLabel(new ImageIcon("image/underline.png"));
	
	
	private MyButton searchjb=new MyButton();
	private MyButton makeorderjb=new MyButton();
	
	public SingleRoomInfotoClient_JPanel(String roomtype,String bedtype,double price){
		
		
		
		
		this.roomtype=roomtype;
		this.bedtype=bedtype;
		this.price=price;
		
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,50);
		setBack();
		addComp();
		
	}
	
	
    public SingleRoomInfotoClient_JPanel(){
		
    	this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,50);
		setBack();
		addComp();
		
		
		
	}
	
	
	
	
	public void setBack(){
		
		
		bgjl.setBounds(50,0,700,50);
		this.add(bgjl);
		
		
	}
	
	
    public void addComp(){
		
    	roomtypejl.setFont(font);
    	roomtypejl.setText(roomtype);
    	roomtypejl.setBounds(100,10,100,30);
    	this.add(roomtypejl);
    	
    	bedtypejl.setFont(font);
    	bedtypejl.setText(bedtype);
    	bedtypejl.setBounds(200,10,100,30);
    	this.add(bedtypejl);
    	
    	pricejl.setFont(font);
    	pricejl.setText(price+"");
    	pricejl.setBounds(300,10,100,30);
    	pricejl.setForeground(new Color(234,119,93));
    	this.add(pricejl);
    	
    	makeorderjb.setText("预定");
    	makeorderjb.setBounds(600,10,100,30);
    	this.add(makeorderjb);
    	
    	
	}
	

}
