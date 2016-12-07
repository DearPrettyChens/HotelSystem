package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.ManageOrderViewController;
import presentation.ui.personnelui.view.Personlistinfo_JPanel;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.newclient_JLabel;
import util.OrderState;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;

/**
 * 网站营销人员查看的订单列表面板 大小应该是600*90
 * 
 * 撤销按钮还未实现
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Orderlistinfo_JPanel extends Personlistinfo_JPanel {

	private Font font = new Font("宋体", Font.BOLD, 16);

	private JLabel ordernumberjl = new JLabel();
	private JLabel orderstatejl = new JLabel();

	private JLabel clientnamejl = new JLabel();
	private JLabel hotelnamejl = new JLabel();

	JLabel backjl = new JLabel();

	private String ordernumber;
	private String clientname;
	private String orderstate;
	private String hotelname;
	private OrderState state;

	private MyButton moreinfojb = new MyButton();
	private MyButton canclejb = new MyButton();
	
	private ManageOrderViewController manageOrderViewController=ManageOrderViewController.getInstance(null);
	
	private OrderDistributionController orderDistributionController = OrderDistributionController.getInstance();
	
	public Orderlistinfo_JPanel(OrderListVO orderListVO) {

		this.ordernumber = orderListVO.getOrderNumber();
		this.clientname = orderListVO.getCustomerName();
		this.state = orderListVO.getState();
		this.orderstate = state.toChinese();
        this.hotelname=orderListVO.getHotelName();
		
		this.setBounds(0, 0, 800, 120);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		setListener();
		setCancleListener();

	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		ordernumberjl.setText("订单号：" + ordernumber);
		ordernumberjl.setFont(font);
		ordernumberjl.setBounds(20, 15, 300, 30);
		this.add(ordernumberjl);

		orderstatejl.setText("订单状态：" + orderstate);
		orderstatejl.setFont(font);
		orderstatejl.setBounds(310, 45, 200, 30);
		this.add(orderstatejl);

		clientnamejl.setText("顾客姓名：" + clientname);
		clientnamejl.setFont(font);
		clientnamejl.setBounds(310, 15, 200, 30);
		this.add(clientnamejl);

		hotelnamejl.setText("酒店名字：" + hotelname);
		hotelnamejl.setFont(font);
		hotelnamejl.setBounds(20, 45, 300, 30);
		this.add(hotelnamejl);

		moreinfojb.setText("详情");
		moreinfojb.setBounds(500, 20, 80, 20);
		this.add(moreinfojb);

		canclejb.setText("撤销");
		canclejb.setBounds(500, 50
				
				, 80, 20);
		this.add(canclejb);

		ImageIcon iconback = new ImageIcon("image//listback.png");
		backjl.setIcon(iconback);
		backjl.setBounds(0, 0, 600, 90);
		this.add(backjl);

	}

	public void setListener() {

		moreinfojb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				manageOrderViewController.showOrderDetailInfo(ordernumber);
			}

		});

	}
	
	public void setCancleListener(){
		canclejb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				manageOrderViewController.cancelOrder(ordernumber);
			}
			
		});
	}
}
