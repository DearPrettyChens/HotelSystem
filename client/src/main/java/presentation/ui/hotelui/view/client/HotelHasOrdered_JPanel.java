package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import businesslogic.bl.orderbl.Order;
import presentation.ui.orderui.view.client.ChooseOrderTypetoClient_JPanel;
import presentation.ui.orderui.view.client.DetailOrderInfotoClient_JPanel;
import presentation.ui.orderui.view.client.OrderListPanel_JPanel;
import presentation.ui.orderui.view.client.RemarkHoteltoClient_JPanel;
import presentation.ui.orderui.view.client.SingleOrderListInfotoClient;
import presentation.ui.orderui.viewcontroller.CustomerOrderViewController;
import util.OrderState;
import util.ViewTag;
import vo.ordervo.OrderListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 顾客查看预订过的酒店，界面上是酒店列表信息
 * @author cy
 * @version 1.0
 * 
 */
public class HotelHasOrdered_JPanel  extends JPanel{
	
	private Font font = new Font("宋体", Font.PLAIN, 18);
	private Color color = new Color(148, 221, 184);

	private JLabel allorderjl = new JLabel("所有酒店", JLabel.CENTER);
	private JLabel excutedoderjl = new JLabel("已执行订单", JLabel.CENTER);
	private JLabel unexcutedjl = new JLabel("未执行订单", JLabel.CENTER);
	private JLabel cancledjl = new JLabel("已撤销订单", JLabel.CENTER);
	private JLabel unusualjl = new JLabel("异常订单", JLabel.CENTER);

	private ImageIcon shuline = new ImageIcon("image//shuline.png");
	private ImageIcon hengling = new ImageIcon("image//hengline.png");
	private JLabel shuline1 = new JLabel(shuline);
	private JLabel shuline2 = new JLabel(shuline);
	private JLabel shuline3 = new JLabel(shuline);
	private JLabel shuline4 = new JLabel(shuline);
	private JLabel hengline = new JLabel(hengling);

	private String userID;

	private HotelListPane_JPanel hotelListPane_JPanel;
	private JScrollPane scrollPane=new JScrollPane();
	private JPanel panel=new JPanel();
	
   private ViewTag viewTag;
	
    private  static HotelHasOrdered_JPanel hotelHasOrdered_JPanel;
    
    public static HotelHasOrdered_JPanel getInstance(String userID,ViewTag viewTag) {
		if(hotelHasOrdered_JPanel==null){
			hotelHasOrdered_JPanel=new HotelHasOrdered_JPanel(userID,viewTag);
		}
		return hotelHasOrdered_JPanel;
	}
    
    private HotelHasOrdered_JPanel(String userID,ViewTag viewTag) {
		this.viewTag=viewTag;
    	this.userID = userID;
		this.setSize(800, 600);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();

		
	}

	
	public void addComp() {
		
		
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
		allorderjl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				allorderjl.setForeground(color);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
				changeHotelList(null);
			}

		});
		this.add(allorderjl);

		excutedoderjl.setFont(font);
		excutedoderjl.setBounds(190, 40, 140, 30);
		excutedoderjl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(color);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
				changeHotelList(OrderState.EXECUTED);
			}

		});
		this.add(excutedoderjl);

		unexcutedjl.setFont(font);
		unexcutedjl.setBounds(330, 40, 140, 30);
		unexcutedjl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(color);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(Color.black);
				changeHotelList(OrderState.NOTEXECUTED);
			}


		});
		this.add(unexcutedjl);

		cancledjl.setFont(font);
		cancledjl.setBounds(470, 40, 140, 30);
		cancledjl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(color);
				unusualjl.setForeground(Color.black);
				changeHotelList(OrderState.HASCANCELED);
			}

		});
		this.add(cancledjl);

		unusualjl.setFont(font);
		unusualjl.setBounds(610, 40, 140, 30);
		unusualjl.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				allorderjl.setForeground(Color.black);
				excutedoderjl.setForeground(Color.black);
				unexcutedjl.setForeground(Color.black);
				cancledjl.setForeground(Color.black);
				unusualjl.setForeground(color);
				changeHotelList(OrderState.UNUSUAL);

			}

		});
		this.add(unusualjl);
		
		HotelSearchInfoVO hotelSearchInfoVO=new HotelSearchInfoVO();
		hotelSearchInfoVO.setCustomerID(userID);
		hotelListPane_JPanel=new HotelListPane_JPanel(hotelSearchInfoVO,viewTag);
		hotelListPane_JPanel.setPreferredSize(new Dimension(780, hotelListPane_JPanel.getHeight() ));
		scrollPane.setBounds(0, 80, 800, 520);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(hotelListPane_JPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}

    public void changeHotelList(OrderState orderState) {
    	scrollPane.remove(hotelListPane_JPanel);
		HotelSearchInfoVO hotelSearchInfoVO=new HotelSearchInfoVO();
		if(orderState==OrderState.EXECUTED){
			ArrayList<OrderState>orderStates=new ArrayList<OrderState>();
			orderStates.add(OrderState.HASREMARKED);
			orderStates.add(OrderState.NOTREMARKED);
			hotelSearchInfoVO.setOrderStates(orderStates);
			hotelSearchInfoVO.setCustomerID(userID);
		}else{
			hotelSearchInfoVO=new HotelSearchInfoVO(orderState, userID);
		}
		hotelListPane_JPanel=new HotelListPane_JPanel(hotelSearchInfoVO,viewTag);
		hotelListPane_JPanel.setPreferredSize(new Dimension(780, hotelListPane_JPanel.getHeight() ));
		scrollPane.setViewportView(hotelListPane_JPanel);
	}
	
}
