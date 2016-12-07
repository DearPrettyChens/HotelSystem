package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.availableroomui.view.RoomInfo_JPanel;
import presentation.ui.checkinui.view.CheckOutInfo_JPanel;
import presentation.ui.checkinui.view.CheckOutPanel;
import presentation.ui.checkinui.view.OfflineCheckIn_JPanel;
import presentation.ui.checkinui.view.SearchOrderToCheckIn_JPanel;
import presentation.ui.hotelstrategyui.view.ChooseHotelStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelBirthStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelEnterpriseStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelOverThreeStr_Jpanel;
import presentation.ui.hotelstrategyui.view.HotelSpecialTimeStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelStrategyPanel;
import presentation.ui.hotelui.view.MaintainHotelBasicInfoPanel;
import presentation.ui.orderui.view.LookOrderPanelInHotelWorker_JPanel;
import presentation.ui.orderui.view.OrderDetailInfoToHotelWorker_JPanel;
import util.UserType;

/**
 * 酒店工作人员左上角的所有面板
 * 
 * 注意！！！！
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class Hotelworker_JFrame extends JFrame {
	// 关于顾客基本信息
	private String hotelWorkerID = "";
	private String hotelName = "南京金鹰国际酒店";
	// private String hotelWorkerName="工作员：菲菲";
	private ImageIcon imageIcon = null;

	// 关于界面
	private close_JButton close_jbutton = new close_JButton();
	private narrow_JButton narrow_jbutton = new narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton = new Reflesh_JButton();
	private Home_JButton home_JButton = new Home_JButton();
	private Arrow_JButton arrow_JButton = new Arrow_JButton();
	private JLabel line = new JLabel(new ImageIcon("image//line.png"));

	ArrayList<Basic_JPanel> allpanel = new ArrayList<Basic_JPanel>();

	private JLabel namejl1 = new JLabel(hotelName);
	// private JLabel namejl2=new JLabel(hotelWorkerName);

	private JLabel myhotel_Jlabel = new JLabel("我的酒店");
	private JLabel myorder_Jlabel = new JLabel("我的订单");
	private JLabel mystr_Jlabel = new JLabel("我的策略");
	private JLabel checkin_Jlabel = new JLabel("入住退房");

	private JLabel myhotelimg_Jlabel = new JLabel();
	private JLabel myorderimg_Jlabel = new JLabel();
	private JLabel mystrimg_Jlabel = new JLabel();
	private JLabel checkinimg_Jlabel = new JLabel();

	ArrayList<Hotelworker_JLabel> allLabels=new ArrayList<Hotelworker_JLabel>();
	
	private RightContainerPanel rightContainerPanel=new RightContainerPanel();
	private Hotelworker_JLabel myhotel_Jlabel1 = new Hotelworker_JLabel("● 维护酒店信息",0,allLabels,rightContainerPanel);
	private Hotelworker_JLabel myhotel_Jlabel2 = new Hotelworker_JLabel("● 录入客房信息",1,allLabels,rightContainerPanel);
	private Hotelworker_JLabel myorder_Jlabel1 = new Hotelworker_JLabel("● 浏览订单列表",2,allLabels,rightContainerPanel);
	private Hotelworker_JLabel mystr_Jlabel1 = new Hotelworker_JLabel("● 制定酒店策略",3,allLabels,rightContainerPanel);
	private Hotelworker_JLabel checkin_Jlabel1 = new Hotelworker_JLabel("● 线上入住办理",4,allLabels,rightContainerPanel);
	private Hotelworker_JLabel checkin_Jlabel2 = new Hotelworker_JLabel("● 线上退房办理",5,allLabels,rightContainerPanel);
	private Hotelworker_JLabel checkin_Jlabel3 = new Hotelworker_JLabel("● 线下入住退房",6,allLabels,rightContainerPanel);

	private Color backgroundcolor = new Color(148, 221, 184);
	private JPanel abovepanel = new JPanel();
	private JPanel sidepanel = new JPanel();
	private HeadPanel headPanel;

	private String hotelID="";
	
	private MaintainHotelBasicInfoPanel maintainHotelBasicInfoPanel;
	 
	public Hotelworker_JFrame() {

//		this.hotelID=...  注意应该是传信息进来初始化的
		maintainHotelBasicInfoPanel=new MaintainHotelBasicInfoPanel(hotelID);
		
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(null);

		allLabels.add(myhotel_Jlabel1);
		allLabels.add(myhotel_Jlabel2);
		allLabels.add(myorder_Jlabel1);
		allLabels.add(mystr_Jlabel1);
		allLabels.add(checkin_Jlabel1);
		allLabels.add(checkin_Jlabel2);
		allLabels.add(checkin_Jlabel3);
		
		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法

		addHeadImage();// 添加头像

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

		namejl1.setBounds(90, 37, 200, 30);
		namejl1.setFont(new Font("宋体", Font.BOLD, 16));
		namejl1.setForeground(Color.white);
		abovepanel.add(namejl1);

		// namejl2.setBounds(90,52,200,30);
		// namejl2.setFont(new Font("宋体",Font.BOLD, 16));
		// namejl2.setForeground(Color.white);
		// abovepanel.add(namejl2);

		abovepanel.setBackground(backgroundcolor);
		abovepanel.setBounds(0, 0, 1000, 100);
		abovepanel.setLayout(null);
		this.add(abovepanel);

		sidepanel.setBackground(backgroundcolor);
		sidepanel.setBounds(0, 100, 200, 600);
		sidepanel.setLayout(null);
		this.add(sidepanel);

		myhotel_Jlabel.setFont(new Font("宋体", Font.BOLD, 18));
		myhotel_Jlabel.setForeground(Color.white);
		myhotel_Jlabel.setBounds(60, 20, 100, 30);
		sidepanel.add(myhotel_Jlabel);

		ImageIcon icon1 = new ImageIcon("image//user.png");
		myhotelimg_Jlabel.setIcon(icon1);
		myhotelimg_Jlabel.setBounds(15, 20, 30, 30);
		sidepanel.add(myhotelimg_Jlabel);

		myorder_Jlabel.setFont(new Font("宋体", Font.BOLD, 18));
		myorder_Jlabel.setForeground(Color.white);
		myorder_Jlabel.setBounds(60, 120, 100, 30);
		sidepanel.add(myorder_Jlabel);

		ImageIcon icon2 = new ImageIcon("image//star.png");
		myorderimg_Jlabel.setIcon(icon2);
		myorderimg_Jlabel.setBounds(15, 120, 30, 30);
		sidepanel.add(myorderimg_Jlabel);

		mystr_Jlabel.setFont(new Font("宋体", Font.BOLD, 18));
		mystr_Jlabel.setForeground(Color.white);
		mystr_Jlabel.setBounds(60, 220, 100, 30);
		sidepanel.add(mystr_Jlabel);

		ImageIcon icon3 = new ImageIcon("image//note.png");
		mystrimg_Jlabel.setIcon(icon3);
		mystrimg_Jlabel.setBounds(15, 220, 30, 30);
		sidepanel.add(mystrimg_Jlabel);

		checkin_Jlabel.setFont(new Font("宋体", Font.BOLD, 18));
		checkin_Jlabel.setForeground(Color.white);
		checkin_Jlabel.setBounds(60, 320, 100, 30);
		sidepanel.add(checkin_Jlabel);

		ImageIcon icon4 = new ImageIcon("image//shop.png");
		checkinimg_Jlabel.setIcon(icon4);
		checkinimg_Jlabel.setBounds(15, 320, 30, 30);
		sidepanel.add(checkinimg_Jlabel);

		myhotel_Jlabel1.setBounds(60, 50, 180, 30);
		sidepanel.add(myhotel_Jlabel1);
		myhotel_Jlabel2.setBounds(60, 80, 180, 30);
		sidepanel.add(myhotel_Jlabel2);

		myorder_Jlabel1.setBounds(60, 150, 180, 30);
		sidepanel.add(myorder_Jlabel1);

		mystr_Jlabel1.setBounds(60, 250, 180, 30);
		sidepanel.add(mystr_Jlabel1);

		checkin_Jlabel1.setBounds(60, 350, 180, 30);
		sidepanel.add(checkin_Jlabel1);
		checkin_Jlabel2.setBounds(60, 380, 180, 30);
		sidepanel.add(checkin_Jlabel2);
		checkin_Jlabel3.setBounds(60, 410, 180, 30);
		sidepanel.add(checkin_Jlabel3);

		
		rightContainerPanel.add(maintainHotelBasicInfoPanel);
		this.add(rightContainerPanel);
		myhotel_Jlabel1.init();
	}

	/**
	 * 添加头像
	 */
	public void addHeadImage() {
		headPanel = new HeadPanel(imageIcon, UserType.HotelWorker);
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

		new Hotelworker_JFrame();

	}

}
