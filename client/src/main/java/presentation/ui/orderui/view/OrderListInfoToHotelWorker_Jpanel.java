package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.personnelui.view.Personlistinfo_JPanel;
import presentation.ui.tools.MyButton;

/**
 * 酒店工作人员查看的订单列表信息
 * 大小应该是600*90
 * @author cy
 * @version 1.0
 * 
 */
public class OrderListInfoToHotelWorker_Jpanel extends Personlistinfo_JPanel {
	
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private  JLabel ordernumberjl=new JLabel();
	private  JLabel orderstatejl=new JLabel();
	
	private  JLabel clientnamejl=new JLabel();
	private  JLabel bedtypejl=new JLabel();
	
	JLabel backjl=new JLabel();
	
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
	
	private OrderDetailInfoToHotelWorker_JPanel detailjp;
	
	
	private  MyButton moreinfojb=new MyButton();
	
	
	public OrderListInfoToHotelWorker_Jpanel( String ordernumber,String clientnumber,String tel,String bedtype,String ordertime,String orderstate,String latestcheckintime
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
		
		
		detailjp=new OrderDetailInfoToHotelWorker_JPanel( ordernumber,clientnumber, tel, bedtype, ordertime, orderstate, latestcheckintime
				, checkouttime, price,  checkintime, isremarked);
		this.setLayout(null);
		
		
		addComp();
		setListener();
		
	}
	
	
	
	
	/**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	
    	ordernumberjl.setText("订单号："+ordernumber);
    	ordernumberjl.setFont(font);
    	ordernumberjl.setBounds(120,10,200,30);
		this.add(ordernumberjl);
    	
		
		orderstatejl.setText("订单状态："+orderstate);
    	orderstatejl.setFont(font);
    	orderstatejl.setBounds(120,50,200,30);
		this.add(orderstatejl);
		
		
		clientnamejl.setText("顾客姓名："+clientnumber);
		clientnamejl.setFont(font);
		clientnamejl.setBounds(320,10,200,30);
		this.add(clientnamejl);
		
		
		bedtypejl.setText("床型："+bedtype);
		bedtypejl.setFont(font);
		bedtypejl.setBounds(320,50,200,30);
		this.add(bedtypejl);
		
		
		moreinfojb.setText("详情");
		moreinfojb.setBounds(500,20,80,20);
		this.add(moreinfojb);
		
		
		
    	
    	ImageIcon iconback=new ImageIcon("image//listback.png");
		backjl.setIcon(iconback);
		backjl.setBounds(0,0,600,90);
		this.add(backjl);
    	
		detailjp.setBounds(200,100,800,600);
		
		//this.add(detailjp);
		
    	
    }
	
   
   
 public void setListener(){
    	
    	
    	moreinfojb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				OrderListInfoToHotelWorker_Jpanel.this.add(detailjp);
				
				
			}
    		
    	});
    	
    	
    

}
}
