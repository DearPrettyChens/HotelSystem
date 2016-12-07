package presentation.ui.orderui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.orderui.viewcontroller.HotelWorkerOrderViewController;
import presentation.ui.orderui.viewcontroller.ManageOrderViewController;
import presentation.ui.personnelui.view.Personlistinfo_JPanel;
import presentation.ui.tools.MyButton;
import util.OrderState;
import util.TransHelper;
import vo.hotelvo.HotelOrderVO;
import vo.ordervo.OrderListVO;
/**
 * 酒店人员查看的订单列表面板 大小应该是600*90
 * 
 * 撤销按钮还未实现
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class OrderListInfoToHotelWorker_JPanel extends Personlistinfo_JPanel{

	private Font font = new Font("宋体", Font.BOLD, 16);

	private JLabel ordernumberjl = new JLabel();
	private JLabel orderstatejl = new JLabel();

	private JLabel clientnamejl = new JLabel();
	private JLabel orderTimejl = new JLabel();

	JLabel backjl = new JLabel();

	private String ordernumber;
	private String clientname;
	private String orderstate;
     private String reserveTime;//下订单的时间
	
     private OrderState state;
    private Date orderTime;
	private MyButton moreinfojb = new MyButton();
	
	
	private HotelWorkerOrderViewController hotelWorkerOrderViewController=HotelWorkerOrderViewController.getInstance(null);
	private OrderDistributionController orderDistributionController = OrderDistributionController.getInstance();
	
	public OrderListInfoToHotelWorker_JPanel(HotelOrderVO orderListVO) {

		this.ordernumber = orderListVO.getOrderID();
		this.clientname = orderListVO.getCustomerName();
		this.state = orderListVO.getState();
		this.orderstate = state.toChinese();
        this.orderTime=orderListVO.getReserveTime();
        this.reserveTime=TransHelper.timeToString(orderTime);
		
		this.setBounds(0, 0, 800, 120);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		setListener();

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

		orderTimejl.setText("订单时间：" + reserveTime);
		orderTimejl.setFont(font);
		orderTimejl.setBounds(20, 45, 400, 30);
		this.add(orderTimejl);

		moreinfojb.setText("详情");
		moreinfojb.setBounds(500, 30, 80, 30);
		this.add(moreinfojb);



		ImageIcon iconback = new ImageIcon("image//listback.png");
		backjl.setIcon(iconback);
		backjl.setBounds(0, 0, 600, 90);
		this.add(backjl);

	}

	public void setListener() {

		moreinfojb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hotelWorkerOrderViewController.showOrderDetailInfo(ordernumber);
			}

		});

	}
	
}