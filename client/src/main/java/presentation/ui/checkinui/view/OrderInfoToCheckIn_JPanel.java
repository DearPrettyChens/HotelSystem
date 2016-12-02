package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;

/**
 * 
 * 入住退房时出现的订单信息
 * @author cy
 * @version 1.0
 * 
 */
public class OrderInfoToCheckIn_JPanel  extends JPanel{
	
	
	private MyButton confirmjb=new MyButton();
	
	private JComboBox comboBox=new JComboBox();
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	private String ordernumber="";
	private String clientname="";
	private String clienttel="";
	private String bedtype="";
	private String orderstate="";
	private String plannedcheckintime="";
	private int price=0;
	
	
	private JLabel ordernumberjl=new JLabel("订单号：");
	private JLabel clientnamejl=new JLabel("顾客：");
	private JLabel clientteljl=new JLabel("联系方式：");
	private JLabel bedtypejl=new JLabel("床型：");
	private JLabel orderstatejl=new JLabel("订单状态：");
	private JLabel plannedcheckintimejl=new JLabel("预计入住时间：");
	private JLabel pricejl=new JLabel("应付金额：");
	
	
	
	
	public OrderInfoToCheckIn_JPanel(String ordernumber,String clientname,String clienttel,String bedtype,String orderstate,String plannedcheckintime,
			int price){
		
		
		this.ordernumber=ordernumber;
		this.clientname=clientname;
		this.clienttel=clienttel;
		this.bedtype=bedtype;
		this.orderstate=orderstate;
		this. plannedcheckintime= plannedcheckintime;
		this.price=price;
		
		this.setSize(800,400);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
		
		
	}
	
	
	public OrderInfoToCheckIn_JPanel(){
		
		this.setSize(800,400);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
	}
	
	
	
	public void addComp(){
		
		
		ordernumberjl=new JLabel("订单号："+ordernumber);
	    clientnamejl=new JLabel("顾客："+clientname);
		clientteljl=new JLabel("联系方式："+clienttel);
		bedtypejl=new JLabel("床型："+bedtype);
		orderstatejl=new JLabel("订单状态：");
		plannedcheckintimejl=new JLabel("预计入住时间："+plannedcheckintime);
		pricejl=new JLabel("应付金额："+price);
		
		
		ordernumberjl.setBounds(50,20,300,50);
		ordernumberjl.setFont(font);
		this.add(ordernumberjl);
		
		clientnamejl.setBounds(50,100,300,50);
		clientnamejl.setFont(font);
		this.add(clientnamejl);
		
		clientteljl.setBounds(420,100,300,50);
		clientteljl.setFont(font);
		this.add(clientteljl);
		
		bedtypejl.setBounds(50,180,300,50);
		bedtypejl.setFont(font);
		this.add(bedtypejl);
		
		orderstatejl.setBounds(420,180,300,50);
		orderstatejl.setFont(font);
		this.add(orderstatejl);
		
		plannedcheckintimejl.setBounds(50,260,500,50);
		plannedcheckintimejl.setFont(font);
		this.add(plannedcheckintimejl);
		
		pricejl.setBounds(50,340,500,50);
		pricejl.setFont(font);
		this.add(pricejl);
		
		comboBox.addItem("全部订单");
		comboBox.addItem("已执行");
		comboBox.addItem("未执行");
		comboBox.addItem("异常订单");
		comboBox.addItem("已撤销");
		
		comboBox.setBounds(500,180,200,50);
		this.add(comboBox);
		
		confirmjb.setText("确认并填写住房信息");
		confirmjb.setBounds(500,400,200,30);
		this.add(confirmjb);
	}
	
	
	

}
