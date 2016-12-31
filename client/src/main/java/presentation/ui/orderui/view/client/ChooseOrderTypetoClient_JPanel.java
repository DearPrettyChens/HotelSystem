package presentation.ui.orderui.view.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import po.OrderInfoPO;
import presentation.ui.orderui.viewcontroller.CustomerOrderViewController;
import presentation.ui.tools.NewClient_JLabel;
import util.BedType;
import util.Children;
import util.OrderState;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;

/**
 * 
 * 顾客选择订单类型的面板，在下面放订单列表信息
 * 
 * 注：重新p图，线条颜色不搭
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class ChooseOrderTypetoClient_JPanel extends JPanel {

	private ArrayList<SingleOrderListInfotoClient> singleinfos = new ArrayList<SingleOrderListInfotoClient>();

	private Font font = new Font("宋体", Font.PLAIN, 18);
	private Color color = new Color(148, 221, 184);

	private JLabel allorderjl = new JLabel("所有订单", JLabel.CENTER);
	private JLabel excutedoderjl = new JLabel("已执行订单", JLabel.CENTER);
	private JLabel unexcutedjl = new JLabel("未执行订单", JLabel.CENTER);
	private JLabel cancledjl = new JLabel("已撤销订单", JLabel.CENTER);
	private JLabel unusualjl = new JLabel("异常订单", JLabel.CENTER);

	private ImageIcon shuline = new ImageIcon(ChooseOrderTypetoClient_JPanel.class.getResource("image/shuline.png"));
	private ImageIcon hengling = new ImageIcon(ChooseOrderTypetoClient_JPanel.class.getResource("image/hengline.png"));
	private JLabel shuline1 = new JLabel(shuline);
	private JLabel shuline2 = new JLabel(shuline);
	private JLabel shuline3 = new JLabel(shuline);
	private JLabel shuline4 = new JLabel(shuline);
	private JLabel hengline = new JLabel(hengling);

	private String userID;
	private String hotelID;

	private OrderListPanel_JPanel orderListPanel_JPanel;
    private DetailOrderInfotoClient_JPanel detailOrderInfotoClient_JPanel;
	private RemarkHoteltoClient_JPanel remarkHoteltoClient_JPanel;
	
    private CustomerOrderViewController customerOrderViewController=CustomerOrderViewController.getInstance(this);
	
    private  static ChooseOrderTypetoClient_JPanel chooseOrderTypetoClient_JPanel;
    
  
    
    public ChooseOrderTypetoClient_JPanel(String userID,String hotelID) {
		this.userID = userID;
		this.hotelID=hotelID;
		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();

		
	}

	
	public void addComp() {
		orderListPanel_JPanel=new OrderListPanel_JPanel(null, userID,hotelID);
        orderListPanel_JPanel.setBounds(0, 100, 800, 500);
        this.add(orderListPanel_JPanel);
		
		
		shuline1.setBounds(175, 42, 20, 26);
		this.add(shuline1);

		shuline2.setBounds(320, 42, 20, 26);
		this.add(shuline2);

		shuline3.setBounds(460, 42, 20, 26);
		this.add(shuline3);

		shuline4.setBounds(605, 42, 20, 26);
		this.add(shuline4);

		hengline.setBounds(50, 60, 700, 30);
		this.add(hengline);

		allorderjl.setFont(font);
		allorderjl.setBounds(50, 40, 140, 30);
		allorderjl.setForeground(color);
		allorderjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				allorderjl.setForeground(color);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
                changeToOrderListPanel(null);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});
		this.add(allorderjl);

		excutedoderjl.setFont(font);
		excutedoderjl.setBounds(190, 40, 140, 30);
		excutedoderjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				ChooseOrderTypetoClient_JPanel.this.allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(color);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
				changeToOrderListPanel(OrderState.EXECUTED);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});
		this.add(excutedoderjl);

		unexcutedjl.setFont(font);
		unexcutedjl.setBounds(330, 40, 140, 30);
		unexcutedjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ChooseOrderTypetoClient_JPanel.this.allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(color);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
                changeToOrderListPanel(OrderState.NOTEXECUTED);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});
		this.add(unexcutedjl);

		cancledjl.setFont(font);
		cancledjl.setBounds(470, 40, 140, 30);
		cancledjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				ChooseOrderTypetoClient_JPanel.this.allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(color);
				unusualjl.setForeground(Color.black);
                changeToOrderListPanel(OrderState.HASCANCELED);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});
		this.add(cancledjl);

		unusualjl.setFont(font);
		unusualjl.setBounds(610, 40, 140, 30);
		unusualjl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				ChooseOrderTypetoClient_JPanel.this.allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(color);
				changeToOrderListPanel(OrderState.UNUSUAL);

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

		});
		this.add(unusualjl);

	}

	public void changeToOrderListPanel(OrderState orderState) {
	        if(remarkHoteltoClient_JPanel!=null){
	        	this.remove(remarkHoteltoClient_JPanel);
	        }
	        if(detailOrderInfotoClient_JPanel!=null){
	        	this.remove(detailOrderInfotoClient_JPanel);
	        }
		    this.remove(orderListPanel_JPanel);
            orderListPanel_JPanel=new OrderListPanel_JPanel(orderState, userID, hotelID);
            orderListPanel_JPanel.setBounds(0, 100, 800, 500);
            this.add(orderListPanel_JPanel);
            this.updateUI();
	}
	
	public void changeToRemarkPanel(OrderListVO orderListVO) {
	    this.remove(orderListPanel_JPanel);
        remarkHoteltoClient_JPanel=new RemarkHoteltoClient_JPanel(orderListVO);
        remarkHoteltoClient_JPanel.setBounds(0, 100, 800, 500);
        this.add(remarkHoteltoClient_JPanel);
        this.updateUI();
}

	public void changeToDetailPanel(String orderID) {
	    this.remove(orderListPanel_JPanel);
        detailOrderInfotoClient_JPanel=new DetailOrderInfotoClient_JPanel(orderID);
        detailOrderInfotoClient_JPanel.setBounds(0, 100, 800, 500);
        this.add(detailOrderInfotoClient_JPanel);
        this.updateUI();
}
	
	public void returnToOrderListPanelFromRemark() {
	    this.remove(remarkHoteltoClient_JPanel);
        orderListPanel_JPanel.setBounds(0, 100, 800, 500);
        this.add(orderListPanel_JPanel);
        this.updateUI();
    }

	public void returnToOrderListPanelFromDetail() {
	    this.remove(detailOrderInfotoClient_JPanel);
        orderListPanel_JPanel.setBounds(0, 100, 800, 500);
        this.add(orderListPanel_JPanel);
        this.updateUI();
    }
	
	public void returnToOrderListPanelFromCancel(){
        orderListPanel_JPanel.setBounds(0, 100, 800, 500);
        this.add(orderListPanel_JPanel);
        this.updateUI();
	}
}
