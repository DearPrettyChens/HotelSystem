package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.ManageOrderViewController;
import presentation.ui.tools.MyButton;
import util.BedType;
import util.OrderState;
import util.TransHelper;
import vo.ordervo.OrderInfoVO;

/**
 * 
 * 网站营销人员查看的订单详细信息界面
 * @author cy
 *
 */
public class Orderdetailinfo_JPanel  extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Color color =new Color(148,221,184);
	
	
	
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
	
	private Date ordertimeInDate;
	private Date latestcheckintimeInDate;
	private Date realcheckintimeInDate;
	private Date checkouttimeInDate;
	private OrderState state;
	private double price;
	private BedType bedType2;
	
	private JLabel ordernumberjl;
	private JLabel clientnamejl;
	private JLabel clientteljl;
	private JLabel ordertimejl;
	private JLabel latestcheckintimejl;
	private JLabel realcheckintimejl;
	private JLabel checkouttimejl;
	private JLabel orderstatejl;
	private JLabel hotelnamejl;
	private JLabel hotelteljl;
	private JLabel paymentjl;
	private JLabel roomtypejl;
	private JLabel bedtypejl;
	
	
    private JLabel title=new JLabel();
    
    private MyButton backjb=new MyButton();
    
	private OrderDistributionController orderDistributionController=OrderDistributionController.getInstance();
	private ManageOrderViewController manageOrderViewController =ManageOrderViewController.getInstance(null);
	
	public Orderdetailinfo_JPanel(String orderID){
		OrderInfoVO orderInfoVO = orderDistributionController.getOrderInfo(orderID);
		
		this.ordernumber=orderInfoVO.getOrderID();
		this.clientname=orderInfoVO.getCustomerName();
		this.clienttel=orderInfoVO.getLiveinPersonTelephone();
		this.ordertimeInDate=orderInfoVO.getOrderTime();
		this.ordertime=TransHelper.dateToString(ordertimeInDate);
		this.latestcheckintimeInDate=orderInfoVO.getLateCheckInTime();
		this.latestcheckintime=TransHelper.dateToString(latestcheckintimeInDate);
		this.realcheckintimeInDate=orderInfoVO.getExpectedCheckInTime();
		this.realcheckintime=TransHelper.dateToString(realcheckintimeInDate);
		this.checkouttimeInDate=orderInfoVO.getExpectedCheckOutTime();
		this.checkouttime=TransHelper.dateToString(checkouttimeInDate);
		this.state= orderInfoVO.getState();
		this.orderstate= state.toChinese();
		this.hotelname=orderInfoVO.getHotelName();
		this.hoteltel=orderInfoVO.getHotelTelephone();
		this.price=orderInfoVO.getPrice();
		this.payment=String.valueOf(price);
		this.roomtype=orderInfoVO.getRoomType();
		this.bedType2=orderInfoVO.getBedType();
		this.bedtype=bedType2.toChinese();
		
		
		ordernumberjl=new JLabel("订单号："+ordernumber);
		clientnamejl=new JLabel("入住人姓名："+clientname);
		clientteljl=new JLabel("联系方式："+clienttel);
		ordertimejl=new JLabel("下单时间："+ordertime);
		latestcheckintimejl=new JLabel("最晚入住时间："+latestcheckintime);
		realcheckintimejl=new JLabel("实际入住时间："+realcheckintime);
		checkouttimejl=new JLabel("实际离开时间："+checkouttime);
		orderstatejl=new JLabel("订单状态："+orderstate);
		hotelnamejl=new JLabel("酒店名称："+hotelname);
		hotelteljl=new JLabel("酒店联系方式："+hoteltel);
		paymentjl=new JLabel("应付金额："+payment);
		roomtypejl=new JLabel("房型："+roomtype);
		bedtypejl=new JLabel("床型："+bedtype);
		
		
		this.setSize(800,600);
		this.setLayout(null);
		this.setBackground(Color.white);
		
		
		 addComp();
		
		
	}
	
	
	/**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	ordernumberjl.setFont(font);
    	ordernumberjl.setBounds(120,120,200,50);
    	this.add(ordernumberjl);
    	
    	clientnamejl.setFont(font);
    	clientnamejl.setBounds(120,180,200,50);
    	this.add(clientnamejl);
    	
    	clientteljl.setFont(font);
    	clientteljl.setBounds(120,240,200,50);
    	this.add(clientteljl);
    	
    	ordertimejl.setFont(font);
    	ordertimejl.setBounds(120,300,200,50);
    	this.add(ordertimejl);
    	
    	latestcheckintimejl.setFont(font);
    	latestcheckintimejl.setBounds(120,360,200,50);
    	this.add(latestcheckintimejl);
    	
    	realcheckintimejl.setFont(font);
    	realcheckintimejl.setBounds(120,420,200,50);
    	this.add(realcheckintimejl);
    	
    	checkouttimejl.setFont(font);
    	checkouttimejl.setBounds(120,480,200,50);
    	this.add(checkouttimejl);
    	
    	
    	paymentjl.setFont(font);
    	paymentjl.setBounds(420,120,200,50);
    	this.add(paymentjl);
    	
    	
    	orderstatejl.setFont(font);
    	orderstatejl.setBounds(420,180,200,50);
    	this.add(orderstatejl);
    	
    	
    	hotelnamejl.setFont(font);
    	hotelnamejl.setBounds(420,240,200,50);
    	this.add(hotelnamejl);
    	
    	
    	hotelteljl.setFont(font);
    	hotelteljl.setBounds(420,300,200,50);
    	this.add(hotelteljl);
    	
    	
    	roomtypejl.setFont(font);
    	roomtypejl.setBounds(420,360,200,50);
    	this.add(roomtypejl);
    	
    	
    	bedtypejl.setFont(font);
    	bedtypejl.setBounds(420,420,200,50);
    	this.add(bedtypejl);
    	
    	
    	ImageIcon icon=new ImageIcon ("image//orderdetailinfo.png");
    	title.setIcon(icon);
        title.setBounds(0,0,800,100);
        this.add(title);
        
    	
    	backjb.setText("返回");
    	backjb.setBounds(600,500,100,30);
    	this.add(backjb);
    	backjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manageOrderViewController.jumpToMainFrame();
				
			}
		});
    	
    }
    
	
	

}
