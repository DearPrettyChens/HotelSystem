package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 酒店工作人员看的订单细节信息
 * @author cy
 * @version 1.0
 * 
 */
public class OrderToCheckIn_JPanel  extends JPanel{
	
	
	  private Font font=new Font("宋体",Font.BOLD, 18);
	
	
	private String ordernumber="";
	private String clientnumber="";
	private String tel="";
	private String bedtype="";
	private  String ordertime="";
	private String orderstate="";
	private String latestcheckintime="";
	private String checkouttime="";
	private double price=0;
	private String checkintime="";
	private String isremarked="";
	
	
	private JLabel ordernumberjl;
	private JLabel clientnumberjl;
	private JLabel teljl;
	private JLabel bedtypejl;
	private JLabel ordertimejl;
	private JLabel orderstatejl;
	private JLabel latestcheckintimejl;
	private JLabel checkouttimejl;
	private JLabel pricejl;
	private JLabel checkintimejl;
	private JLabel isremarkedjl;
	
	
	
	
	public  OrderToCheckIn_JPanel(String ordernumber,String clientnumber,String tel,String bedtype,String ordertime,String orderstate,String latestcheckintime
			,String checkouttime,double price, String checkintime,String isremarked){
		
		
		
		
		
		this.ordernumber=ordernumber;
		this.clientnumber=clientnumber;
		this.tel=tel;
		this.bedtype=bedtype;
		this.ordertime=ordertime;
		this.orderstate=orderstate;
		this.latestcheckintime=latestcheckintime;
		this.checkintime=checkintime;
		this.price=price;
		this.checkintime=checkintime;
		this.isremarked=isremarked;
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
		
	}
	
	
	public  OrderToCheckIn_JPanel(){
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
	}
	
 
	public void addComp(){
		
		ordernumberjl.setFont(font);
		ordernumberjl.setText("订单号："+ordernumber);
		ordernumberjl.setBounds(50,50,300,30);
		this.add(ordernumberjl);
		
		clientnumberjl.setFont(font);
		clientnumberjl.setText("入住人："+clientnumber);
		clientnumberjl.setBounds(50,50,300,30);
		this.add(clientnumberjl);
		
		teljl.setFont(font);
		teljl.setText("联系方式："+tel);
		teljl.setBounds(50,50,300,30);
		this.add(teljl);
		
		
		ordernumberjl.setFont(font);
		ordernumberjl.setText("床型："+ordernumber);
		ordernumberjl.setBounds(50,50,300,30);
		this.add(ordernumberjl);
		
		
		orderstatejl.setFont(font);
		orderstatejl.setText("订单状态："+orderstate);
		orderstatejl.setBounds(50,50,300,30);
		this.add(orderstatejl);
		
		
		ordertimejl.setFont(font);
		ordertimejl.setText("下单时间："+ordertime);
		ordertimejl.setBounds(50,50,300,30);
		this.add(ordertimejl);
		
		
		
		
		latestcheckintimejl.setFont(font);
		latestcheckintimejl.setText("最晚入住时间："+latestcheckintime);
		latestcheckintimejl.setBounds(50,50,300,30);
		this.add(latestcheckintimejl);
		
		
		
		
		
		pricejl.setFont(font);
		pricejl.setText("应付金额："+price);
		pricejl.setBounds(50,50,300,30);
		this.add(pricejl);
		
		checkintimejl.setFont(font);
		checkintimejl.setText("实际入住时间："+checkintime);
		checkintimejl.setBounds(50,50,300,30);
		this.add(checkintimejl);
		
		checkintimejl.setFont(font);
		checkintimejl.setText("实际离开时间："+checkintime);
		checkintimejl.setBounds(50,50,300,30);
		this.add(checkintimejl);
		
		isremarkedjl.setFont(font);
		isremarkedjl.setText("是否评价："+isremarked);
		isremarkedjl.setBounds(50,50,300,30);
		this.add(isremarkedjl);
		
		
		
	}
	
	
	
	
}
