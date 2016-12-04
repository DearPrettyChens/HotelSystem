package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 顾客确认优惠信息的面板
 * @author cy
 * @version 1.0
 * 
 */
public class ConfirmCounttoClient_JPanel  extends JPanel{
	
	private int count=0;;
	private String strname="";
	private double price=0;
	
	
	private JLabel countjl=new JLabel();
	private JLabel strnamejl=new JLabel();
	private JLabel pricejl=new JLabel();
	
	
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	private Color color=new Color(148, 221, 184);
	
	public ConfirmCounttoClient_JPanel (){
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,300);
		addComp();
		
		
		
		
		
		
	}
	
	
   public ConfirmCounttoClient_JPanel (String strname,int count,double price){
	   this.count=count;
	   this.strname=strname;
	   this.price=price;
	   
		
	 this.setLayout(null);
	 this.setBackground(Color.white);
	 this.setSize(800,300);
	 addComp();
	 
	   
	   
		
		
		
	}
	
	
	public void addComp(){
		
		
		strnamejl.setText("您享有"+strname+",");
		countjl.setText("享受"+count+"折优惠,");
		pricejl.setText("现价为"+price+"元。");
		
		strnamejl.setBounds(300,100,200,30);
		strnamejl.setFont(font);
	    this.add(strnamejl);
	    
	    countjl.setBounds(300,130,200,30);
	    countjl.setFont(font);
	    this.add(countjl);
	    
	    pricejl.setBounds(300,160,200,30);
	    pricejl.setFont(font);
	    this.add(pricejl);
		
		
	}

}
