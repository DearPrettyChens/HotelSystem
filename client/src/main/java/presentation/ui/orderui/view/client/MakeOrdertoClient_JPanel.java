package presentation.ui.orderui.view.client;

import presentation.ui.hotelui.viewcontroller.MyFootViewController;
import presentation.ui.hotelui.viewcontroller.ReserveHotelViewController;
import presentation.ui.orderui.distributecontroller.OrderDistributionController;
import presentation.ui.tools.*;
import presentation.ui.userui.view.Changepassword_JPanel;
import util.HotelStrategyType;
import util.ViewTag;
import util.WebStrategyType;
import vo.hotelstrategyvo.HotelBestStrVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.StrategyVO;
import vo.webstrategyvo.WebBestStrVO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

/**
 * 两个确认按钮都未添加监听调用，见下方注释
 * 
 * 顾客进行酒店预订的操作
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class MakeOrdertoClient_JPanel extends JPanel {

	private ConfirmCounttoClient_JPanel confirmcountjp;// 确认优惠信息的面板
														// ，大小为800*300，放在0*200位置下面
	private WriteOrdertoClient_JPanel writeorderjp;// 填写订单的面板，同上

	private ImageIcon icon1 = new ImageIcon(MakeOrdertoClient_JPanel.class.getResource("image/yuan1.png"));
	private ImageIcon icon2 = new ImageIcon(MakeOrdertoClient_JPanel.class.getResource("image/yuan2.png"));
	private ImageIcon icon3 = new ImageIcon(MakeOrdertoClient_JPanel.class.getResource("image/xuxian2.png"));

	private JLabel successjl = new JLabel("预订成功！");

	private MyButton button1 = new MyButton();
	private MyButton button2 = new MyButton();

	private JLabel circle1 = new JLabel(icon1);
	private JLabel circle2 = new JLabel(icon2);
	private JLabel circle3 = new JLabel(icon2);
	private JLabel line1 = new JLabel(icon3);
	private JLabel line2 = new JLabel(icon3);

	private JLabel oldpasswordjl = new JLabel("填写订单");
	private JLabel newpasswordjl = new JLabel("优惠信息");
	private JLabel makechangejl = new JLabel("预订成功");
	private JLabel return1 = new JLabel("< 返回酒店页面");
	private JLabel return3 = new JLabel("< 返回酒店页面");
	private JLabel return2 = new JLabel("< 返回订单填写页面");

	private Font font = new Font("宋体", Font.BOLD, 16);

	private OrderInfoVO orderInfoVO;
	private String hotelID;
	private String userID;
	private String hotelTel;
	private String customerName;
	private ViewTag tag;

	private ReserveHotelViewController reserveHotelViewController=ReserveHotelViewController.getInstance(null);
    private MyFootViewController myFootViewController=MyFootViewController.getInstance(null);
	
    private OrderDistributionController orderDistributionController = OrderDistributionController.getInstance();
    
	public MakeOrdertoClient_JPanel(String hotelID, String userID,String customerName,ViewTag tag) {
		this.hotelTel=hotelTel;
		this.tag=tag;
		this.userID = userID;
		this.hotelID = hotelID;
		this.customerName=customerName;
		this.writeorderjp = new WriteOrdertoClient_JPanel(hotelID, userID);

		this.setBackground(Color.white);
		this.setLayout(null);

		addComp();

		writeorderjp.setBounds(0, 130, 800, 360);
		this.add(writeorderjp);
		this.setSize(800, 600);
	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		circle1.setBounds(150, 20, 100, 100);
		this.add(circle1);
		circle2.setBounds(350, 20, 100, 100);
		this.add(circle2);
		circle3.setBounds(550, 20, 100, 100);
		this.add(circle3);
		line1.setBounds(250, 20, 100, 100);
		this.add(line1);
		line2.setBounds(450, 20, 100, 100);
		this.add(line2);

		oldpasswordjl.setBounds(175, 20, 100, 100);
		oldpasswordjl.setFont(font);
		this.add(oldpasswordjl);
		newpasswordjl.setBounds(375, 20, 100, 100);
		newpasswordjl.setFont(font);
		this.add(newpasswordjl);

		makechangejl.setBounds(570, 20, 100, 100);
		makechangejl.setFont(font);
		this.add(makechangejl);

		successjl.setFont(font);
		successjl.setForeground(Color.red);
		successjl.setBounds(350, 300, 200, 50);
		// this.add(makechangeJl);

		button1.setText("下一步，确认优惠信息");
		button1.setBounds(280, 520, 240, 40);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				orderInfoVO = writeorderjp.getOrderInfo();
				if(orderInfoVO!=null){
					StrategyVO strategyVO = orderDistributionController.next(orderInfoVO);
					// 需要在此处调用controller获得策略信息和最低价格，并且新建一个confirmcountpanel，
					orderInfoVO.setPrice(strategyVO.getPrice());
					orderInfoVO.setCustomerName(customerName);
				    confirmcountjp=new ConfirmCounttoClient_JPanel(strategyVO);
					confirmcountjp.setBounds(0, 130, 800, 300);
					MakeOrdertoClient_JPanel.this.add(confirmcountjp);

					MakeOrdertoClient_JPanel.this.remove(button1);
					MakeOrdertoClient_JPanel.this.add(button2);

					MakeOrdertoClient_JPanel.this.remove(writeorderjp);
					
					MakeOrdertoClient_JPanel.this.remove(return1);
					MakeOrdertoClient_JPanel.this.add(return2);
					MakeOrdertoClient_JPanel.this.circle1.setIcon(icon2);
					MakeOrdertoClient_JPanel.this.circle2.setIcon(icon1);
					MakeOrdertoClient_JPanel.this.repaint();
				}
			}

		});
		this.add(button1);

		button2.setText("确认");
		button2.setBounds(300, 500, 200, 40);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				orderDistributionController.confirmAddOrder(orderInfoVO);
				MakeOrdertoClient_JPanel.this.circle2.setIcon(icon2);
				MakeOrdertoClient_JPanel.this.circle3.setIcon(icon1);
				MakeOrdertoClient_JPanel.this.remove(confirmcountjp);

				MakeOrdertoClient_JPanel.this.remove(return2);
				MakeOrdertoClient_JPanel.this.add(return3);
				MakeOrdertoClient_JPanel.this.remove(button2);
				MakeOrdertoClient_JPanel.this.add(successjl);
				MakeOrdertoClient_JPanel.this.repaint();
			}

		});

		return1.setFont(new Font("宋体", Font.BOLD, 14));
		return1.setForeground(new Color(148, 221, 184));
		return1.setBounds(50, 530, 200, 20);
		this.add(return1);
		return1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				switch (tag) {
				case HOTELRESERVERSION:
					reserveHotelViewController.returnToHotelListView();;
					break;
				case MYHOTEL:
					myFootViewController.returnToHotelListView();
					break;
				default:
					break;
				
				}
			}

		});

		return2.setBounds(50, 510, 250, 20);
		return2.setFont(new Font("宋体", Font.BOLD, 14));
		return2.setForeground(new Color(148, 221, 184));
		return2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				MakeOrdertoClient_JPanel.this.circle2.setIcon(icon2);
				MakeOrdertoClient_JPanel.this.circle1.setIcon(icon1);

				MakeOrdertoClient_JPanel.this.remove(confirmcountjp);
				MakeOrdertoClient_JPanel.this.add(writeorderjp);
				MakeOrdertoClient_JPanel.this.remove(button2);
				MakeOrdertoClient_JPanel.this.add(button1);
				MakeOrdertoClient_JPanel.this.add(return1);
				MakeOrdertoClient_JPanel.this.remove(successjl);
				MakeOrdertoClient_JPanel.this.remove(return2);
				MakeOrdertoClient_JPanel.this.circle3.setIcon(icon2);
				MakeOrdertoClient_JPanel.this.repaint();

			}

		});

		return3.setFont(new Font("宋体", Font.BOLD, 14));
		return3.setForeground(new Color(148, 221, 184));
		return3.setBounds(50, 500, 200, 20);
		return3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				switch (tag) {
				case HOTELRESERVERSION:
					reserveHotelViewController.returnToHotelListView();;
					break;
				case MYHOTEL:
					myFootViewController.returnToHotelListView();
					break;
				default:
					break;
				
				}
			}

		});

	}

}
