package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.bl.checkinbl.CheckinController;
import presentation.ui.checkinui.distributecontroller.CheckinDistributionController;
import presentation.ui.checkinui.viewcontroller.OnlineCheckinViewController;
import presentation.ui.checkinui.viewcontroller.OnlineCheckoutViewController;
import presentation.ui.hotelui.distributecontroller.HotelDistributionController;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.NewClient_JLabel;
import util.OrderState;
import util.TransHelper;
import vo.checkinvo.CheckinInfoVO;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;
import vo.ordervo.OrderInfoVO;

/**
 * 
 * 入住退房时出现的订单信息
 * 
 * 可以给信息加个绿色的框
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class OrderInfoToCheckIn_JPanel extends JPanel {

	private MyButton confirmjb = new MyButton();
	private MyButton canclejb = new MyButton();

	private JComboBox comboBox = new JComboBox();

	private Font font = new Font("宋体", Font.PLAIN, 16);

	private String ordernumber = "";
	private String clientname = "";
	private String clienttel = "";
	private String roomtype = "";
	private String orderstate = "";
	private String plannedcheckintime = "";
	private String acturalcheckintime;
	private double price = 0;
	private String hotelID;

	private OrderState orderState2;
	private Date plannedcheckintimeInDate;
	private Date acturalcheckintimeInDate;
    private Date acturalcheckouttimeInDate;
	
	private JLabel ordernumberjl = new JLabel("订单号：");
	private JLabel clientnamejl = new JLabel("顾客：");
	private JLabel clientteljl = new JLabel("联系方式：");
	private JLabel roomtypejl = new JLabel("房型：");
	private JLabel orderstatejl = new JLabel("订单状态：");
	private JLabel plannedcheckintimejl = new JLabel("预计入住时间：");
	private JLabel acturalcheckintimejl = new JLabel("实际入住时间：");
	private JLabel pricejl = new JLabel("应付金额：");

	private CheckinDistributionController checkinDistributionController = CheckinDistributionController.getInstance();
	private OnlineCheckinViewController onlineCheckinViewController ;
	private OnlineCheckoutViewController onlineCheckoutViewController;
	private OrderInfoVO orderInfoVO;
    public JLabel orderError=new JLabel("无该订单信息!");
	public OrderInfoToCheckIn_JPanel(String orderID,String hotelID) {
		this.hotelID=hotelID;
		
	 onlineCheckinViewController = OnlineCheckinViewController.getInstance(CheckInPanel.getInstance(hotelID));
	 onlineCheckoutViewController=OnlineCheckoutViewController.getInstance( CheckOutPanel.getInstance(hotelID));
		
		
		orderInfoVO = checkinDistributionController.getOrderInfo(orderID);
		if(orderInfoVO==null){
		
			
			orderError.setForeground(Color.red);
			orderError.setFont(font);
			orderError.setBounds(300,0,200,50);
			this.add(orderError);
			orderError.setVisible(true);
			
		} else {
			this.ordernumber = orderInfoVO.getOrderID();
			this.clientname = orderInfoVO.getCustomerName();
			this.clienttel = orderInfoVO.getLiveinPersonTelephone();
			this.roomtype = orderInfoVO.getRoomType();

			this.orderState2 = orderInfoVO.getState();
			this.orderstate = orderState2.toChinese();

			this.plannedcheckintimeInDate = orderInfoVO.getExpectedCheckInTime();
			this.plannedcheckintime = TransHelper.timeToString(plannedcheckintimeInDate);

			this.acturalcheckintimeInDate = orderInfoVO.getActualCheckInTime();
			
			
			//这里的判断是因为入住和住房是共用的这个panel，但是根据是否有实际入住时间来判断是哪种，入住的时候还没有实际入住时间，退房的时候就有了
			if (acturalcheckintimeInDate != null) {
				acturalcheckintime = TransHelper.timeToString(acturalcheckintimeInDate);
			} else {
				acturalcheckintime = null;
			}

			this.price = orderInfoVO.getPrice();
			addComp();
		}

		this.setBounds(0, 180, 800, 400);
		this.setLayout(null);
		this.setBackground(Color.white);

	}

	public void addComp() {

		ordernumberjl = new JLabel("订单号：" + ordernumber);
		clientnamejl = new JLabel("顾客：" + clientname);
		clientteljl = new JLabel("联系方式：" + clienttel);
		roomtypejl = new JLabel("房型：" + roomtype);
		orderstatejl = new JLabel("订单状态：" + orderstate);
		plannedcheckintimejl = new JLabel("预计入住时间：" + plannedcheckintime);
		acturalcheckintimejl=new JLabel("实际入住时间： "+acturalcheckintime);
		pricejl = new JLabel("应付金额：" + price);
		
		ordernumberjl.setBounds(100, 20, 400, 50);
		ordernumberjl.setFont(font);
		this.add(ordernumberjl);

		clientnamejl.setBounds(100, 80, 300, 50);
		clientnamejl.setFont(font);
		this.add(clientnamejl);

		clientteljl.setBounds(420, 80, 300, 50);
		clientteljl.setFont(font);
		this.add(clientteljl);

		roomtypejl.setBounds(100, 140, 300, 50);
		roomtypejl.setFont(font);
		this.add(roomtypejl);

		orderstatejl.setBounds(420, 140, 400, 50);
		orderstatejl.setFont(font);
		this.add(orderstatejl);

		//入住和退房时显示的信息不一样
		//这里的判断是因为入住和住房是共用的这个panel，但是根据是否有实际入住时间来判断是哪种，入住的时候还没有实际入住时间，退房的时候就有了
		if (acturalcheckintimeInDate != null) {
			acturalcheckintimejl.setBounds(100, 200, 500, 50);
			acturalcheckintimejl.setFont(font);
			this.add(acturalcheckintimejl);
		} else {
			plannedcheckintimejl.setBounds(100, 200, 500, 50);
			plannedcheckintimejl.setFont(font);
			this.add(plannedcheckintimejl);
		}

		pricejl.setBounds(420, 20, 300, 50);
		pricejl.setFont(font);
		this.add(pricejl);

		

		confirmjb.setText("填写住房信息");
		confirmjb.setBounds(360, 320, 200, 30);
		this.add(confirmjb);
		confirmjb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//这里的判断是因为入住和住房是共用的这个panel，但是根据是否有实际入住时间来判断是哪种，入住的时候还没有实际入住时间，退房的时候就有了
				
				if((acturalcheckintimeInDate==null)&&(acturalcheckouttimeInDate==null)){
					
					OrderInfoToCheckIn_JPanel.this.onlineCheckinViewController
					
					.jumpToHotelCheckInfoView(OrderInfoToCheckIn_JPanel.this.orderInfoVO,hotelID);
				}else{
					if((acturalcheckintimeInDate!=null)&&(acturalcheckouttimeInDate==null)){
					CheckinInfoVO checkinInfoVO=checkinDistributionController.getCheckinInfo(ordernumber);
					
       OrderInfoToCheckIn_JPanel.this.onlineCheckoutViewController.jumpToHotelCheckInfoView(checkinInfoVO, hotelID);
					
					}
				}
				
				
			}
		});

		canclejb.setText("取消");
		canclejb.setBounds(600, 320, 80, 30);
		this.add(canclejb);
		canclejb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderInfoToCheckIn_JPanel.this.setVisible(false);

			}
		});

	}

}
