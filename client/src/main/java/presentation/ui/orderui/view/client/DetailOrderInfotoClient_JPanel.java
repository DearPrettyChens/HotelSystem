package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.CustomerOrderViewController;
import presentation.ui.tools.NewClient_JLabel;
import util.BedType;
import util.Children;
import util.OrderState;
import util.TransHelper;
import vo.ordervo.OrderInfoVO;

/**
 * 顾客查看的详细订单信息
 * 
 * @author cy
 * @version 1.0
 * 
 */

public class DetailOrderInfotoClient_JPanel extends JPanel {

	private Color color = new Color(148, 221, 184);
	private Font font = new Font("宋体", Font.BOLD, 16);

	private JPanel titlejp = new JPanel();
	private JPanel linejp = new JPanel();
	private JLabel titlejl = new JLabel("订单详细信息", JLabel.CENTER);

	private JLabel backjl = new JLabel("< 返回订单列表页面");

	private String ordernumber = "";
	private String orderstate = "";
	private String clientname = "";
	private String clienttel = "";

	private String haschild = "";
	private String checkintime = "";// 预计
	private String checkouttime = "";
	private String hotelname = "";
	private String roomtype = "";
	private String hoteltel = "";
	private String bedtype = "";
	private int roomnumber = 1;
	private String latestcheckintime = "";
	private String realcheckintime = "";
	private String realcheckouttime = "";
	private String makeordertime = "";
	private double price;

	private OrderState orderState2;
	private Children children;
	private Date expectedCheckinTimeInDate;
	private Date expectedCheckoutTimeInDate;
	private Date latestcheckintimeInDate;
	private Date realcheckintimeInDate;
	private Date realcheckouttimeInDate;
	private Date orderTimeInDate;
	private BedType bedType2;

	private JLabel ordernumberjl = new JLabel();
	private JLabel orderstatejl = new JLabel();
	private JLabel clientnamejl = new JLabel();
	private JLabel clientteljl = new JLabel();

	private JLabel haschildjl = new JLabel();
	private JLabel checkintimejl = new JLabel();
	private JLabel checkouttimejl = new JLabel();
	private JLabel hotelnamejl = new JLabel();
	private JLabel roomtypejl = new JLabel();
	private JLabel hotelteljl = new JLabel();
	private JLabel bedtypejl = new JLabel();
	private JLabel roomnumberjl = new JLabel();
	private JLabel latestcheckintimejl = new JLabel();
	private JLabel realcheckintimejl = new JLabel();
	private JLabel realcheckouttimejl = new JLabel();
	private JLabel makeordertimejl = new JLabel();
	private JLabel pricejl = new JLabel();
	private JPanel shuline = new JPanel();

	private JLabel peoplemessagejl = new JLabel("入住人");

	private JLabel roommessagejl = new JLabel("客房信息");
	private JLabel checkinmessagejl = new JLabel("入住信息");
	private JLabel othermessagejl = new JLabel("其他信息");

	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private ImageIcon image1 = new ImageIcon(DetailOrderInfotoClient_JPanel.class.getResource("image/longxuxian.png"));
	private JLabel bg1 = new JLabel(image1);
	private JLabel bg2 = new JLabel(image1);
	private JLabel bg3 = new JLabel(image1);
	private JLabel bg4 = new JLabel(image1);

	private OrderDistributionController orderDistributionController = OrderDistributionController.getInstance();
    private CustomerOrderViewController customerOrderViewController=CustomerOrderViewController.getInstance(null);

    public DetailOrderInfotoClient_JPanel(){
    	
    }
    
	public DetailOrderInfotoClient_JPanel(String orderID) {
		OrderInfoVO orderInfoVO = orderDistributionController.getOrderInfo(orderID);

		this.ordernumber = orderInfoVO.getOrderID();

		this.orderState2 = orderInfoVO.getState();
		this.orderstate = orderState2.toChinese();

		this.clientname = orderInfoVO.getCustomerName();
		this.clienttel = orderInfoVO.getLiveinPersonTelephone();

		this.children = orderInfoVO.getHasChild();
		this.haschild = children.toChinese();

		this.expectedCheckinTimeInDate = orderInfoVO.getExpectedCheckInTime();
		this.checkintime = TransHelper.dateToString(expectedCheckinTimeInDate);
		this.expectedCheckoutTimeInDate = orderInfoVO.getExpectedCheckOutTime();
		this.checkouttime = TransHelper.dateToString(expectedCheckoutTimeInDate);

		this.hotelname = orderInfoVO.getHotelName();
		// this.hotelloc=orderInfoVO.get;
		this.hoteltel = orderInfoVO.getHotelTelephone();

		this.bedType2 = orderInfoVO.getBedType();
		this.bedtype = bedType2.toChinese();

		this.roomtype = orderInfoVO.getRoomType();
		this.roomnumber = orderInfoVO.getAmount();

		this.latestcheckintimeInDate = orderInfoVO.getLateCheckInTime();
		this.latestcheckintime = TransHelper.timeToString(latestcheckintimeInDate);

		this.realcheckintimeInDate = orderInfoVO.getActualCheckInTime();
		if (realcheckintimeInDate != null) {
			this.realcheckintime = TransHelper.timeToString(realcheckintimeInDate);

		}

		this.realcheckouttimeInDate = orderInfoVO.getActualCheckOutTime();
		if (realcheckouttimeInDate != null) {
			this.realcheckouttime = TransHelper.timeToString(realcheckouttimeInDate);

		}

		this.orderTimeInDate = orderInfoVO.getOrderTime();
		this.makeordertime = TransHelper.timeToString(orderTimeInDate);
		;
		this.price = orderInfoVO.getPrice();

		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800, 600);
		addComp();

	}

	public void addComp() {

		panel.setLayout(null);

		titlejp.setBounds(50, 10, 135, 30);
		titlejp.setBackground(color);
		this.add(titlejp);

		linejp.setBounds(50, 38, 700, 2);
		linejp.setBackground(color);
		this.add(linejp);

		titlejl.setForeground(Color.white);
		titlejl.setFont(font);
		titlejl.setBounds(0, 20, 200, 30);
		titlejp.add(titlejl);

		ordernumberjl.setText("订单号：" + ordernumber);
		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(220, 10, 300, 30);
		this.add(ordernumberjl);

		orderstatejl.setText("订单状态：" + orderstate);
		orderstatejl.setFont(font);
		orderstatejl.setBounds(580, 10, 300, 30);
		this.add(orderstatejl);

		clientnamejl.setText("姓名：" + clientname);
		clientnamejl.setFont(font);
		clientnamejl.setBounds(220, 10, 300, 30);
		panel.add(clientnamejl);

		clientteljl.setText("联系方式：" + clienttel);
		clientteljl.setFont(font);
		clientteljl.setBounds(220, 50, 300, 30);
		panel.add(clientteljl);

		haschildjl.setText("有无儿童：" + haschild);
		haschildjl.setFont(font);
		haschildjl.setBounds(220, 90, 300, 30);
		panel.add(haschildjl);

		checkintimejl.setText("入住时间：" + checkintime);
		checkintimejl.setFont(font);
		checkintimejl.setBounds(220, 170, 300, 30);
		panel.add(checkintimejl);

		checkouttimejl.setText("至         " + checkouttime);
		checkouttimejl.setFont(font);
		checkouttimejl.setBounds(450, 170, 300, 30);
		panel.add(checkouttimejl);

		hotelnamejl.setText("入住酒店：" + hotelname);
		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(220, 210, 300, 30);
		panel.add(hotelnamejl);

		roomtypejl.setText("房间类型：：" + roomtype);
		roomtypejl.setFont(font);
		roomtypejl.setBounds(220, 290, 300, 30);
		panel.add(roomtypejl);

		hotelteljl.setText("酒店电话：" + hoteltel);
		hotelteljl.setFont(font);
		hotelteljl.setBounds(220, 250, 300, 30);
		panel.add(hotelteljl);

		bedtypejl.setText("床    型：" + bedtype);
		bedtypejl.setFont(font);
		bedtypejl.setBounds(220, 330, 300, 30);
		panel.add(bedtypejl);

		roomnumberjl.setText("房间数量：" + roomnumber);
		roomnumberjl.setFont(font);
		roomnumberjl.setBounds(220, 370, 300, 30);
		panel.add(roomnumberjl);

		latestcheckintimejl.setText("最晚入住时间：" + latestcheckintime);
		latestcheckintimejl.setFont(font);
		latestcheckintimejl.setBounds(220, 450, 300, 30);
		panel.add(latestcheckintimejl);

		realcheckintimejl.setText("实际入住时间：" + realcheckintime);
		realcheckintimejl.setFont(font);
		realcheckintimejl.setBounds(220, 490, 300, 30);
		panel.add(realcheckintimejl);

		realcheckouttimejl.setText("实际退房时间：" + realcheckouttime);
		realcheckouttimejl.setFont(font);
		realcheckouttimejl.setBounds(220, 530, 300, 30);
		panel.add(realcheckouttimejl);

		makeordertimejl.setText("下单时间：" + makeordertime);
		makeordertimejl.setFont(font);
		makeordertimejl.setBounds(220, 610, 300, 30);
		panel.add(makeordertimejl);

		pricejl.setText("订单价格：" + price);
		pricejl.setFont(font);
		pricejl.setBounds(220, 650, 300, 30);
		panel.add(pricejl);

		// peoplemessagejl.setText("订单号"+ordernumber);
		peoplemessagejl.setFont(font);
		peoplemessagejl.setBounds(80, 50, 200, 30);
		panel.add(peoplemessagejl);

		// roommessagejl.setText("订单号"+ordernumber);
		roommessagejl.setFont(font);
		roommessagejl.setBounds(80, 275, 150, 30);
		panel.add(roommessagejl);

		// ordernumberjl.setText("订单号"+ordernumber);
		checkinmessagejl.setFont(font);
		checkinmessagejl.setBounds(80, 490, 200, 30);
		panel.add(checkinmessagejl);

		// ordernumberjl.setText("订单号"+ordernumber);
		othermessagejl.setFont(font);
		othermessagejl.setBounds(80, 635, 200, 30);
		panel.add(othermessagejl);

		backjl.setForeground(color);
		backjl.setBounds(50, 735, 150, 30);
		backjl.setFont(new Font("宋体", Font.BOLD, 15));
		backjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
			customerOrderViewController.returnToOrderListFromDetail();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				backjl.setFont(font);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				backjl.setFont(new Font("宋体", Font.BOLD, 15));
			}

		});
		panel.add(backjl);

		shuline.setBounds(183, 0, 2, 695);
		shuline.setBackground(color);
		panel.add(shuline);

		bg1.setBounds(50, 145, 700, 5);
		panel.add(bg1);
		bg2.setBounds(50, 425, 700, 5);
		panel.add(bg2);
		bg3.setBounds(50, 585, 700, 5);
		panel.add(bg3);
		bg4.setBounds(50, 705, 700, 5);
		panel.add(bg4);

		scrollPane.setBounds(0, 50, 800, 450);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(700, 800));
		panel.updateUI();
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);

	}

}
