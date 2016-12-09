package presentation.ui.tools;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterAbortException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.bl.orderbl.Order;
import po.HotelListPO;
import presentation.ui.checkinui.view.CheckInInfo_JPanel;
import presentation.ui.searchhotelui.view.ChooseArea_JPanel;
import presentation.ui.searchhotelui.view.Searchhotel_JPanel;
import presentation.ui.checkinui.view.CheckInInfo_JPanel;
import presentation.ui.checkinui.view.SearchOrderToCheckIn_JPanel;
import presentation.ui.checkinui.view.SingleAvailableRoomInfo_JPanel;
import presentation.ui.creditui.view.ClientCreditInfos_JPanel;
import presentation.ui.creditui.view.SingleCreditinfo_JPanel;
import presentation.ui.hotelui.view.client.ChooseCityandEnterprise_JPanel;
import presentation.ui.hotelui.view.client.HotelHasOrdered_JPanel;
import presentation.ui.hotelui.view.client.HotelListInfo_JPanel;
import presentation.ui.hotelui.view.client.RoomInfotoClient_JPanel;
import presentation.ui.hotelui.view.client.SearchHotelPane_JPanel;
import presentation.ui.hotelui.view.client.SearchHoteltoClient_JPanel;
import presentation.ui.hotelui.view.client.SingleHotelRemarktoClient_JPanel;
import presentation.ui.hotelui.view.client.SingleRoomInfotoClient_JPanel;
import presentation.ui.orderui.view.ViewOrderToHotelWorker_JPanel;
import presentation.ui.orderui.view.client.ChooseOrderTypetoClient_JPanel;
import presentation.ui.orderui.view.client.ConfirmCounttoClient_JPanel;
import presentation.ui.orderui.view.client.DetailOrderInfotoClient_JPanel;
import presentation.ui.orderui.view.client.MakeOrdertoClient_JPanel;
import presentation.ui.orderui.view.client.OrderListPanel_JPanel;
import presentation.ui.orderui.view.client.RemarkHoteltoClient_JPanel;
import presentation.ui.orderui.view.client.SingleOrderListInfotoClient;
import presentation.ui.orderui.view.client.WriteOrdertoClient_JPanel;
import presentation.ui.searchhotelui.view.ChooseArea_JPanel;
import presentation.ui.userui.view.Changemessage_JPanel;
import presentation.ui.userui.view.Changepassword_JPanel;
import util.City;
import util.OrderState;
import util.TradingArea;
import util.UserType;
import vo.creditvo.CreditVO;
import vo.ordervo.OrderListVO;
import vo.searchhotelvo.HotelListVO;
import vo.searchhotelvo.HotelSearchInfoVO;

/**
 * 顾客客户端左上不变的地方
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Client_JFrame extends JFrame {
    //关于顾客基本信息
	private String customerID="";
	private String customerName="陈小豆";
    private ImageIcon imageIcon=null;
    


	//private SingleHotelRemarktoClient_JPanel  cp=new  SingleHotelRemarktoClient_JPanel ("iwuefbw",5.5,"uicbwiuve我IEvbwiiebiqv全部地区企划vwdqhc近期活动去强化基础去");


	

	private SingleHotelRemarktoClient_JPanel  cp=new  SingleHotelRemarktoClient_JPanel ("iwuefbw",5.5,"uicbwiuve我IEvbwiiebiqv全部地区企划vwdqhc近期活动去强化基础去");

//	private ConfirmCounttoClient_JPanel  cp=new  ConfirmCounttoClient_JPanel ();

	//private OrderToCheckIn_JPanel  cp=new  OrderToCheckIn_JPanel ();

    private RightContainerPanel rightContainerPanel=new RightContainerPanel();


//    private SearchHoteltoClient_JPanel searchHoteltoClient_JPanel=new SearchHoteltoClient_JPanel("","");
   
    private HotelHasOrdered_JPanel hotelHasOrdered_JPanel=HotelHasOrdered_JPanel.getInstance("") ;
    // private SingleOrderListInfotoClient  cp=new SingleOrderListInfotoClient ("uebhwurbhi","uebhwurbhi","uebhwurbhi","uebhwurbhi","uebhwurbhi","uebhwurbhi");
    
	//关于界面
	private Font font = new Font("宋体", Font.BOLD, 16);
	private Color backgroundcolor = new Color(148, 221, 184);
	private JPanel abovepanel = new JPanel();
	private JPanel sidepanel = new JPanel();
	private close_JButton close_jbutton = new close_JButton();
	private narrow_JButton narrow_jbutton = new narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton = new Reflesh_JButton();
	private Home_JButton home_JButton = new Home_JButton();
	private Arrow_JButton arrow_JButton = new Arrow_JButton();

	ArrayList<Basic_JPanel> allpanel = new ArrayList<Basic_JPanel>();

	private Basic_JPanel jp1 = new Basic_JPanel("预订酒店", "image//Conduc.png", 0, allpanel,rightContainerPanel);
	private Basic_JPanel jp2 = new Basic_JPanel("我的信息", "image//edit.png", 1, allpanel,rightContainerPanel);
	private Basic_JPanel jp3 = new Basic_JPanel("我的密码", "image//key.png", 2, allpanel,rightContainerPanel);
	private Basic_JPanel jp4 = new Basic_JPanel("我的订单", "image//note.png", 3, allpanel,rightContainerPanel);
	private Basic_JPanel jp5 = new Basic_JPanel("我的足迹", "image//shop.png", 4, allpanel,rightContainerPanel);
	private Basic_JPanel jp6 = new Basic_JPanel("我的信用", "image//star.png", 5, allpanel,rightContainerPanel);

	private HeadPanel headPanel;

	// private Basic_JPanel jp1=new Basic_JPanel();
	private JLabel namejl = new JLabel(customerName);
	private JLabel vipjl= new JLabel(new ImageIcon("image//vip.png"));
	private JLabel line = new JLabel(new ImageIcon("image//line.png"));

	private ChooseArea_JPanel panel=new ChooseArea_JPanel();
	
    private Changemessage_JPanel changemessage_JPanel=new Changemessage_JPanel("");
    private ClientCreditInfos_JPanel clientCreditInfos_JPanel=new ClientCreditInfos_JPanel("");
   	private ChooseOrderTypetoClient_JPanel chooseOrderTypetoClient_JPanel=ChooseOrderTypetoClient_JPanel.getInstance("", "");
//	private ChooseCityandEnterprise_JPanel chooseCityandEnterprise_JPanel=new ChooseCityandEnterprise_JPanel();
	private SearchHotelPane_JPanel searchHoteltoClient_JPanel2;
   	
	public Client_JFrame() {
	
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		getContentPane().setLayout(null);

		allpanel.add(jp1);
		allpanel.add(jp2);
		allpanel.add(jp3);
		allpanel.add(jp4);
		allpanel.add(jp5);
		allpanel.add(jp6);

		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法
        addHeadImage();//添加头像

		
		this.setVisible(true);
	}

	/**
	 * 添加组件
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void addComp() {

		close_jbutton.setBounds(950, 40, 24, 24);
		abovepanel.add(close_jbutton);
		narrow_jbutton.setBounds(910, 40, 24, 24);
		abovepanel.add(narrow_jbutton);
		arrow_JButton.setBounds(830, 40, 24, 24);
		abovepanel.add(arrow_JButton);
		home_JButton.setBounds(780, 40, 24, 24);
		abovepanel.add(home_JButton);
		reflesh_JButton.setBounds(730, 40, 24, 24);
		abovepanel.add(reflesh_JButton);
		line.setBounds(875, 38, 32, 32);
		abovepanel.add(line);

		

		abovepanel.setBackground(backgroundcolor);
		abovepanel.setBounds(0, 0, 1000, 100);
		abovepanel.setLayout(null);
		getContentPane().add(abovepanel);
		
		int i=customerName.length();
        namejl.setBounds(90, 40, 18*i, 30);
		namejl.setFont(new Font("宋体", Font.BOLD, 16));
		namejl.setForeground(Color.white);
		abovepanel.add(namejl);
		
		vipjl.setBounds(90+18*i, 40, 30, 30);
		abovepanel.add(vipjl);
		
		jp1.setBounds(0, 100, 200, 80);
		getContentPane().add(jp1);
		jp2.setBounds(0, 180, 200, 80);
		getContentPane().add(jp2);
		jp3.setBounds(0, 260, 200, 80);
		getContentPane().add(jp3);
		jp4.setBounds(0, 340, 200, 80);
		getContentPane().add(jp4);
		jp5.setBounds(0, 420, 200, 80);
		getContentPane().add(jp5);
		jp6.setBounds(0, 500, 200, 80);
		getContentPane().add(jp6);

		sidepanel.setBackground(backgroundcolor);
		sidepanel.setBounds(0, 580, 200, 140);
		getContentPane().add(sidepanel);
		
		 ArrayList<OrderState> orderStates=new ArrayList<OrderState>();
		 	orderStates.add(OrderState.NOTEXECUTED);
			orderStates.add(OrderState.HASCANCELED);
			orderStates.add(OrderState.HASREMARKED);
			orderStates.add(OrderState.UNUSUAL);
		  
			HotelSearchInfoVO hotelSearchInfoVO=new HotelSearchInfoVO();
			hotelSearchInfoVO .setCity(City.NANJING);
			hotelSearchInfoVO.setTradingArea(TradingArea.HUNANLU);
			hotelSearchInfoVO.setCustomerID("333");
		searchHoteltoClient_JPanel2=new SearchHotelPane_JPanel(hotelSearchInfoVO);
			
		searchHoteltoClient_JPanel2.setBounds(200, 100, 800, 600);
		this.add(searchHoteltoClient_JPanel2);
		
//			hotelHasOrdered_JPanel.setBounds(200, 100, 800, 600);
//			this.add(hotelHasOrdered_JPanel);
//			
//		rightContainerPanel.add(chooseOrderTypetoClient_JPanel);
//		this.add(rightContainerPanel);

//		panel.setBounds(200,100,800,600);
//
//	    SingleRoomInfotoClient_JPanel  cp1=new  SingleRoomInfotoClient_JPanel ("bcoe","oeirv",8);
//	    ArrayList<SingleRoomInfotoClient_JPanel> singleinfos=new ArrayList<SingleRoomInfotoClient_JPanel>();
//	    singleinfos.add(cp1);
//		RoomInfotoClient_JPanel  cp=new  RoomInfotoClient_JPanel (singleinfos);
//		cp.setBounds(200,100,800,400);
//		this.add(cp);
//
//		panel.setBounds(200,100,800,50);
//
//		getContentPane().add(panel);


	}

	/**
	 * 添加头像
	 */
	public void addHeadImage() {
		headPanel=new HeadPanel(imageIcon, UserType.Customer);
		headPanel.setBounds(15, 20, 65, 65);
		getContentPane().add(headPanel);
	}
	/**
	 * 设置背景图片
	 * 
	 * @param
	 * @return
	 * @throws 未定
	 */
	public void setBak() {


	}

	public static void main(String[] args) {

		new Client_JFrame();
	
        
		
		
	}

}
