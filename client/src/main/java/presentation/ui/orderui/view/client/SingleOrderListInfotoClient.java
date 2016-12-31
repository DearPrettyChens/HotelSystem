package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.orderui.viewcontroller.CustomerOrderViewController;
import presentation.ui.tools.ImageTool;
import presentation.ui.tools.JLabelTool;
import presentation.ui.tools.NewClient_JLabel;
import util.OrderState;
import util.TransHelper;
import vo.ordervo.OrderListVO;

/**
 * 给顾客看的单条订单信息面板 大小800*100
 * 
 * 注：点击订单号的时候可以查看详情
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class SingleOrderListInfotoClient extends JPanel {

	private Font font = new Font("宋体", Font.BOLD, 15);

	private ImageIcon image;
	private String hotelname = "";
	private String ordernumber = "";
	private String ordertime = "";
	private String orderstate = "";
	private String operation = "";

	private Date date;
	private OrderState state;

	private ImageIcon image1 = new ImageIcon(SingleOrderListInfotoClient.class.getResource("image/longxuxian.png"));
	private ImageIcon image2 = new ImageIcon(SingleOrderListInfotoClient.class.getResource("image/shuxuxian.png"));

	private JLabel imagejl = new JLabel();
	private JLabel hotelnamejl = new JLabel();
	private JLabel ordernumberjl = new JLabel();
	private JLabel ordertimejl = new JLabel();
	private JLabel orderstatejl = new JLabel();
	private JLabel operationjl = new JLabel();
	private JLabel bg = new JLabel(image1);
	private JLabel bg1 = new JLabel(image2);
	private JLabel bg2 = new JLabel(image2);
	private JLabel bg3 = new JLabel(image2);
	private JLabel bg4 = new JLabel(image2);
	
	private OrderListVO orderListVO;

	private Color color=new Color(148, 221, 184);
	private String orderID;
	private CustomerOrderViewController customerOrderViewController=CustomerOrderViewController.getInstance(null);
	
	public SingleOrderListInfotoClient(OrderListVO orderListVO) {
		this.orderListVO=orderListVO;
		this.orderID=orderListVO.getOrderNumber();
		this.image = orderListVO.getHotelIcon();
		this.hotelname = orderListVO.getHotelName();
		this.ordernumber = orderListVO.getOrderNumber();
		this.date = orderListVO.getReserveTime();
		this.ordertime = TransHelper.timeToString(date);
		this.state = orderListVO.getState();
		this.orderstate = state.toChinese();
		this.operation = state.getOperation();
		if(image!=null){
			image = ImageTool.getScaledImage(image, 100);
			imagejl.setIcon(image);
		}
		hotelnamejl.setText(hotelname);
		ordernumberjl.setText(ordernumber);
		ordertimejl.setText(ordertime);
		orderstatejl.setText(orderstate);
		operationjl.setText(operation);

		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800, 220);
		addComp();
        addListener();
	}

	public void addComp() {

		try {
			imagejl.setBounds(65, 30, 100, 100);
			this.add(imagejl);

			hotelnamejl.setBounds(65, 110, 100, 100);
			hotelnamejl.setFont(font);
			JLabelTool.JlabelSetText(hotelnamejl, hotelname);
			this.add(hotelnamejl);

			bg1.setBounds(175, 10, 10, 180);
			this.add(bg1);

			ordernumberjl.setBounds(210, 50, 100, 100);
			ordernumberjl.setFont(font);
			JLabelTool.JlabelSetText(ordernumberjl, ordernumber);
			this.add(ordernumberjl);

			bg2.setBounds(320, 10, 10, 180);
			this.add(bg2);

			ordertimejl.setBounds(350, 50, 100, 100);
			ordertimejl.setFont(font);
			JLabelTool.JlabelSetText(ordertimejl,ordertime);
			this.add(ordertimejl);

			bg3.setBounds(460, 10, 10, 180);
			this.add(bg3);

			orderstatejl.setBounds(510, 80, 140, 40);
			orderstatejl.setFont(font);
			this.add(orderstatejl);

			bg4.setBounds(605, 10, 10, 180);
			this.add(bg4);

			operationjl.setBounds(655, 80, 140, 40);
			operationjl.setFont(font);
			this.add(operationjl);


			bg.setBounds(50, 200, 700, 5);
			this.add(bg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void addListener(){
		
		ordernumberjl.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				customerOrderViewController.changeToDetailPanel(orderID);
			}

			public void mouseExited(MouseEvent e) {
				SingleOrderListInfotoClient.this.ordernumberjl.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				SingleOrderListInfotoClient.this.ordernumberjl.setForeground(color);
				
			}
			
		});
		
		operationjl.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				SingleOrderListInfotoClient.this.operationjl.setForeground(Color.BLACK);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				SingleOrderListInfotoClient.this.operationjl.setForeground(color);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				String text=operationjl.getText();
				switch (text) {
				case "撤     销":
					customerOrderViewController.jumpCancleJFrame(orderID);
					break;

				case "追加评价":
					customerOrderViewController.changeToRemarkPanel(orderListVO);
					break;
				default:
					break;
				}
			}
		});
	}

}
