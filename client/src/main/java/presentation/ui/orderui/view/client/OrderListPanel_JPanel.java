package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.jhlabs.composite.AddComposite;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.tools.NewClient_JLabel;
import presentation.ui.webstrategyui.view.Singlewebclientlevelstr_Jpanel;
import util.OrderState;
import util.UserType;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

/**
 * 
 * 订单列表界面
 * 
 * @author csy
 *
 */
public class OrderListPanel_JPanel extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 18);
	private Color color = new Color(148, 221, 184);

	private JPanel backgroundjp = new JPanel();

	private JLabel hoteljl = new JLabel("入住酒店", JLabel.CENTER);
	private JLabel ordernumberjl = new JLabel("订单号", JLabel.CENTER);
	private JLabel ordertimejl = new JLabel("下单时间", JLabel.CENTER);
	private JLabel orderstatejl = new JLabel("订单状态", JLabel.CENTER);
	private JLabel operationjl = new JLabel("订单操作", JLabel.CENTER);

	private ArrayList<SingleOrderListInfotoClient> singleinfo = new ArrayList<SingleOrderListInfotoClient>();
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();

	private OrderState orderState;
	private String userID;
	private String hotelID;
	private OrderDistributionController orderDistributionController = OrderDistributionController.getInstance();

	public OrderListPanel_JPanel(OrderState orderState, String userID,String hotelID) {

		this.userID = userID;
		this.hotelID=hotelID;
		this.orderState = orderState;

		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
	}

	public void addComp() {

		addScrollPane();

		backgroundjp.setLayout(null);
		backgroundjp.setBackground(color);
		backgroundjp.setBounds(50, 0, 700, 50);
		this.add(backgroundjp);

		hoteljl.setForeground(Color.white);
		hoteljl.setFont(font);
		hoteljl.setBounds(0, 10, 140, 30);
		backgroundjp.add(hoteljl);

		ordernumberjl.setForeground(Color.white);
		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(140, 10, 140, 30);
		backgroundjp.add(ordernumberjl);

		ordertimejl.setForeground(Color.white);
		ordertimejl.setFont(font);
		ordertimejl.setBounds(280, 10, 140, 30);
		backgroundjp.add(ordertimejl);

		orderstatejl.setForeground(Color.white);
		orderstatejl.setFont(font);
		orderstatejl.setBounds(420, 10, 140, 30);
		backgroundjp.add(orderstatejl);

		operationjl.setForeground(Color.white);
		operationjl.setFont(font);
		operationjl.setBounds(560, 10, 140, 30);
		backgroundjp.add(operationjl);
	}

	/**
	 * 增加滚动条面板
	 */
	public void addScrollPane() {
		scrollPane.setBounds(0, 50, 800, 450);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);

		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		initList();
		this.add(scrollPane);
	}

	public void initList() {
		ArrayList<OrderListVO> orderListVOs = new ArrayList<OrderListVO>();
		if (orderState == OrderState.EXECUTED) {
			TypeInfoVO typeInfoVO = new TypeInfoVO(UserType.Customer, OrderState.HASREMARKED, userID);
			orderListVOs = orderDistributionController.getOrderList(typeInfoVO);
			typeInfoVO = new TypeInfoVO(UserType.Customer, OrderState.NOTREMARKED, userID);
			orderListVOs.addAll(orderDistributionController.getOrderList(typeInfoVO));

		} else {
			TypeInfoVO typeInfoVO = new TypeInfoVO(UserType.Customer, orderState, userID);
			orderListVOs = orderDistributionController.getOrderList(typeInfoVO);
		}

		if(hotelID!=null){
			for (OrderListVO orderListVO : orderListVOs) {
				if(!orderListVO.getHotelID().equals(hotelID)){
					orderListVOs.remove(orderListVO);
				}
			}
		}
		
		for (OrderListVO orderListVO : orderListVOs) {
			SingleOrderListInfotoClient singleOrderListInfotoClient = new SingleOrderListInfotoClient(orderListVO);
			singleinfo.add(singleOrderListInfotoClient);
		}

		for (int i = 0; i < singleinfo.size(); i++) {
			SingleOrderListInfotoClient singleOrderListInfotoClient = singleinfo.get(i);
			singleOrderListInfotoClient.setBounds(0, 200 * i, 800, 220);
			panel.add(singleOrderListInfotoClient);
		}
		panel.setPreferredSize(new Dimension(700, 50 + 200 * singleinfo.size()));
		panel.updateUI();
		scrollPane.setViewportView(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	}

}
