package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 给顾客看的单条订单信息面板 大小800*100
 * @author cy
 * @version 1.0
 * 
 */
public class SingleOrderListInfotoClient extends JPanel{
	
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	private String image="";
	private String hotelname="";
    private String ordernumber="";
	private String ordertime="";
	private String orderstate="";
	private String operation="";
	
	private ImageIcon image1=new ImageIcon("image/longxuxian.png");
	private ImageIcon image2=new ImageIcon("image/shuxuxian.png");
	
	private JLabel imagejl=new JLabel();
	private JLabel hotelnamejl =new JLabel();
	private JLabel ordernumberjl=new JLabel();
	private JLabel ordertimejl=new JLabel();
	private JLabel orderstatejl=new JLabel();
	private JLabel moreinfojl=new JLabel("详情");
	private JLabel operationjl=new JLabel();
	private JLabel bg=new JLabel(image1);
	private JLabel bg1=new JLabel(image2);
	private JLabel bg2=new JLabel(image2);
	private JLabel bg3=new JLabel(image2);
	private JLabel bg4=new JLabel(image2);
	
	public SingleOrderListInfotoClient(String image,String hotelname,String ordernumber,String ordertime,String orderstate,String operation){
		this.image=image;
		this.hotelname=hotelname;
		this.ordernumber=ordernumber;
		this.ordertime=ordertime;
		this.orderstate=orderstate;
		this.operation=operation;
		
		imagejl.setIcon(new ImageIcon(image));
		hotelnamejl.setText(hotelname);
		ordernumberjl.setText(ordernumber);
		ordertimejl.setText(ordertime);
		orderstatejl.setText(orderstate);
		operationjl.setText(operation);
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,600);
		addComp();
		
		
		
		
		
		
	}
	
	
	public SingleOrderListInfotoClient(){
		
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,600);
		addComp();
	}
	
	
	public void addComp(){
		
		
		
		 
		
		hotelnamejl.setBounds(50,60,140,30);
		hotelnamejl.setFont(font);;
		this.add(hotelnamejl);
		
		bg1.setBounds(180,0,10,100);
		this.add(bg1);
		
		ordernumberjl.setBounds(190,30,140,40);
		ordernumberjl.setFont(font);;
		this.add(ordernumberjl);
		
		bg2.setBounds(320,0,10,100);
		this.add(bg2);
		
		ordertimejl.setBounds(330,30,140,40);
		ordertimejl.setFont(font);;
		this.add(ordertimejl);
		
		bg3.setBounds(460,0,10,100);
		this.add(bg3);
		
		orderstatejl.setBounds(470,30,140,40);
		orderstatejl.setFont(font);;
		this.add(orderstatejl);
		
		bg4.setBounds(600,0,10,100);
		this.add(bg4);
		
		operationjl.setBounds(610,10,140,40);
		operationjl.setFont(font);;
		this.add(operationjl);
		
		moreinfojl.setBounds(610,50,140,40);
		moreinfojl.setFont(font);;
		this.add(moreinfojl);
		
		
		bg.setBounds(0,0,800,100);
		this.add(bg);
	}
	
	
	

}
