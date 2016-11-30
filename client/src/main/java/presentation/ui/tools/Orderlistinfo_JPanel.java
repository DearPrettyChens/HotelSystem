package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.personnelui.view.Personlistinfo_JPanel;

/**
 * 网站营销人员列表信息面板 
 * 大小应该是600*90
 * @author cy
 * @version 1.0
 * 
 */
public class Orderlistinfo_JPanel extends Personlistinfo_JPanel {
	
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private  JLabel ordernumberjl=new JLabel();
	private  JLabel orderstatejl=new JLabel();
	
	private  JLabel clientnamejl=new JLabel();
	private  JLabel hotelnamejl=new JLabel();
	
	JLabel backjl=new JLabel();
	
	private String ordernumber;
	private String clientname;
	private String clienttel;
	private String ordertime;
	private String latestcheckintime;
	private String realcheckintime;
	private String checkouttime;
	private String orderstate;
	private String hotelname;
	private String hoteltel;
	private String payment;
	private String roomtype;
	private String bedtype;
	
	private Orderdetailinfo_JPanel detailjp;
	
	
	private  MyButton moreinfojb=new MyButton();
	private  MyButton canclejb=new MyButton();
	
	
	public Orderlistinfo_JPanel( String ordernumber,String clientname,String clienttel,String ordertime
			,String latestcheckintime,String realcheckintime,String checkouttime,String orderstate,String hotelname
			, String hoteltel,String payment,String roomtype,String bedtype){
		
		this.ordernumber=ordernumber;
		this.clientname=clientname;
		this.clienttel=clienttel;
		this.ordertime=ordertime;
		this.latestcheckintime=latestcheckintime;
		this.realcheckintime=realcheckintime;
		this.checkouttime=checkouttime;
		this.orderstate=orderstate;
		this.hotelname=hotelname;
		this.hoteltel=hoteltel;
		this.payment=payment;
		this.roomtype=roomtype;
		this.bedtype=bedtype;
		
		
		detailjp=new Orderdetailinfo_JPanel(ordernumber, clientname, clienttel, ordertime
				, latestcheckintime, realcheckintime, checkouttime, orderstate,hotelname
				,  hoteltel, payment, roomtype, bedtype);
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
		
		
		clientnamejl.setText("顾客姓名："+clientname);
		clientnamejl.setFont(font);
		clientnamejl.setBounds(320,10,200,30);
		this.add(clientnamejl);
		
		
		hotelnamejl.setText("酒店名字："+hotelname);
		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(320,50,200,30);
		this.add(hotelnamejl);
		
		
		moreinfojb.setText("详情");
		moreinfojb.setBounds(500,20,80,20);
		this.add(moreinfojb);
		
		
		canclejb.setText("撤销");
		canclejb.setBounds(500,60,80,20);
		this.add(canclejb);
    	
    	
    	ImageIcon iconback=new ImageIcon("image//listback.png");
		backjl.setIcon(iconback);
		backjl.setBounds(0,0,600,90);
		this.add(backjl);
    	
		detailjp.setBounds(200,100,800,600);
		detailjp.setVisible(true);
		this.add(detailjp);
		
    	
    }
	
   
   
 public void setListener(){
    	
    	
    	moreinfojb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				detailjp.setVisible(true);
				
			}
    		
    	});
    	
    	
    

}
}
