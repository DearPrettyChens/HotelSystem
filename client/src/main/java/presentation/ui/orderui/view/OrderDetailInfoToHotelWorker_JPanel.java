package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.hotelui.distributecontroller.HotelDistributionController;
import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.HotelWorkerOrderViewController;
import presentation.ui.tools.MyButton;
import util.BedType;
import util.Children;
import util.OrderState;
import util.Remark;
import util.TransHelper;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;
import vo.ordervo.OrderInfoVO;

/**
 * 酒店工作人员看的订单细节信息
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class OrderDetailInfoToHotelWorker_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);

	private String ordernumber = "";
	private String clientname = "";
	private String tel = "";
//	private String bedtype = "";
	private String roomType="";
	private String ordertime = "";
	private String orderstate = "";
	private String latestcheckintime = "";
	private String checkouttime = "";
	private double price = 0;
	private String checkintime = "";
//	private String isremarked = "";
	private String hasChild="";

//	private BedType bedType2;
	private OrderState orderState2;
	private Date orderTimeInDate;
	private Date latestcheckintimeInDate;
	private Date checkouttimeInDate;
	private Date checkintimeInDate;
//	private boolean remark;
    private Children children;
	
	private JLabel ordernumberjl;
	private JLabel clientnamejl;
	private JLabel teljl;
//	private JLabel bedtypejl;
	private JLabel roomTypejl;
	private JLabel ordertimejl;
	private JLabel orderstatejl;
	private JLabel latestcheckintimejl;
	private JLabel checkouttimejl;
	private JLabel pricejl;
	private JLabel checkintimejl;
//	private JLabel isremarkedjl;
	private JLabel hasChildjl;

	private MyButton backjb = new MyButton();

	private HotelDistributionController hotelDistributionController = HotelDistributionController.getInstance();
	private HotelWorkerOrderViewController hotelWorkerOrderViewController = HotelWorkerOrderViewController
			.getInstance(null);

	public OrderDetailInfoToHotelWorker_JPanel(String ordernumber) {

		HotelOrderInfoVO orderInfoVO = hotelDistributionController.getHotelOrderInfo(ordernumber);

		this.ordernumber = orderInfoVO.getOrderId();
		this.clientname = orderInfoVO.getCustomerName();
		this.tel = orderInfoVO.getLodgerTel();

//		this.bedType2 = orderInfoVO.getBedType();
//		this.bedtype = bedType2.toChinese();

		this.roomType=orderInfoVO.getRoomType();
		
		this.orderState2 = orderInfoVO.getOrderState();
		this.orderstate = orderState2.toChinese();

		this.orderTimeInDate = orderInfoVO.getOrderTime();
		this.ordertime = TransHelper.timeToString(orderTimeInDate);

		this.latestcheckintimeInDate = orderInfoVO.getLateCheckInTime();
		this.latestcheckintime =  TransHelper.timeToString(latestcheckintimeInDate);

		this.checkintimeInDate = orderInfoVO.getActualCheckInTime();
		if (checkintimeInDate == null) {
			checkintime = "无";
		} else {
			this.checkintime = TransHelper.timeToString(checkintimeInDate);
		}

		this.checkouttimeInDate = orderInfoVO.getActualCheckOutTime();
		if (checkouttimeInDate == null) {
			checkouttime = "无";
		} else {
			this.checkouttime =  TransHelper.timeToString(checkouttimeInDate);
		}

		this.price = orderInfoVO.getPrice();

		this.children = orderInfoVO.getHasChild();
		this.hasChild=children.toChinese();

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setBounds(0, 0, 800, 600);
		addComp();

	}

	public void addComp() {
		ordernumberjl=new JLabel("订单号："+ordernumber);
		clientnamejl=new JLabel("入住人姓名："+clientname);
		teljl=new JLabel("联系方式："+tel);
		ordertimejl=new JLabel("下单时间："+ordertime);
		latestcheckintimejl=new JLabel("最晚入住时间："+latestcheckintime);
		checkintimejl=new JLabel("实际入住时间："+checkintime);
		checkouttimejl=new JLabel("实际离开时间："+checkouttime);
		orderstatejl=new JLabel("订单状态："+orderstate);
		pricejl=new JLabel("应付金额："+price);
		roomTypejl=new JLabel("房型："+roomType);
		hasChildjl=new JLabel("有无儿童:  "+hasChild);
		
		ordernumberjl.setFont(font);
		ordernumberjl.setText("订单号：" + ordernumber);
		ordernumberjl.setBounds(60, 60, 400, 30);
		this.add(ordernumberjl);

		orderstatejl.setFont(font);
		orderstatejl.setBounds(460, 60, 300, 30);
		this.add(orderstatejl);
		
		clientnamejl.setFont(font);
		clientnamejl.setBounds(60, 130, 300, 30);
		this.add(clientnamejl);

		teljl.setFont(font);
		teljl.setBounds(460, 130, 300, 30);
		this.add(teljl);
        
		ordertimejl.setFont(font);
		ordertimejl.setBounds(60, 200, 350, 30);
		this.add(ordertimejl);
		
		roomTypejl.setFont(font);
		roomTypejl.setBounds(460, 200, 300, 30);
		this.add(roomTypejl);

		latestcheckintimejl.setFont(font);
		latestcheckintimejl.setBounds(60, 270, 400, 30);
		this.add(latestcheckintimejl);


		checkintimejl.setFont(font);
		checkintimejl.setBounds(60, 340, 400, 30);
		this.add(checkintimejl);

		checkouttimejl.setFont(font);
		checkouttimejl.setBounds(60, 410, 400, 30);
		this.add(checkouttimejl);

		pricejl.setFont(font);
		pricejl.setBounds(460, 270, 300, 30);
		this.add(pricejl);
		
		hasChildjl.setFont(font);
		hasChildjl.setBounds(460, 340, 300, 30);
		this.add(hasChildjl);

		backjb.setText("返回");
		backjb.setBounds(600, 500, 100, 30);
		this.add(backjb);
		backjb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hotelWorkerOrderViewController.jumpToMainFrame();

			}
		});

	}

}
