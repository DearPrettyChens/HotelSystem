package presentation.ui.loginui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.creditui.view.Clientdeposite_JPanel;
import presentation.ui.creditui.view.DepositPanel;
import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
import presentation.ui.tools.Arrow_JButton;
import presentation.ui.tools.Basic_JPanel;
import presentation.ui.tools.HeadPanel;
import presentation.ui.tools.Home_JButton;
import presentation.ui.tools.Reflesh_JButton;
import presentation.ui.tools.RightContainerPanel;
import presentation.ui.tools.close_JButton;
import presentation.ui.tools.Narrow_JButton;
import presentation.ui.creditui.view.ClientDepositeSearch_JPanel;
import presentation.ui.webstrategyui.view.Clientlevelrule_JPanel;
import presentation.ui.webstrategyui.view.Makewebstr_JPanel;
import util.UserType;

/**
 * 
 * 网站管理人员主界面
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class WebMarketMan_JFrame extends JFrame {
	
	
	
	private boolean isDragged = false;
	private Point tmp;
	private Point loc;

	// 关于网站营销人员基本信息
	private String webMarketManID;
	private String webMarketManName;

	// 关于界面

	private RightContainerPanel rightContainerPanel = new RightContainerPanel();//右边界面的容器

	private close_JButton close_jbutton = new close_JButton();
	private Narrow_JButton narrow_jbutton = new Narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton = new Reflesh_JButton();
	private Home_JButton home_JButton = new Home_JButton();
	private Arrow_JButton arrow_JButton = new Arrow_JButton(this);
	private JLabel line = new JLabel(new ImageIcon(WebMarketMan_JFrame.class.getResource("image/line.png")));

	ArrayList<Basic_JPanel> allpanel = new ArrayList<Basic_JPanel>();

	private Basic_JPanel jp1;
	private Basic_JPanel jp2;
	private Basic_JPanel jp3 ;
	private Basic_JPanel jp4 ;

	private HeadPanel headPanel;

	private JLabel namejl;

	private Color backgroundcolor = new Color(148, 221, 184);
	private JPanel abovepanel = new JPanel();
	private JPanel sidepanel = new JPanel();
	
	private OrderPanelInWebMarketMan orderPanelInWebMarketMan=OrderPanelInWebMarketMan.getInstance();
	
	public WebMarketMan_JFrame(String userName,String userID) {
		this.webMarketManName=userName;
		this.webMarketManID=userID;
		this.namejl=new JLabel(webMarketManName);
		this.jp1 = new Basic_JPanel("管理订单", "image/search.png", 0, allpanel, rightContainerPanel,this.webMarketManName,this.webMarketManID,UserType.WebMarketMan);
		this.jp2 = new Basic_JPanel("信用充值", "image/touzichanpin.png", 1, allpanel, rightContainerPanel,this.webMarketManName,this.webMarketManID,UserType.WebMarketMan);
		this.jp3= new Basic_JPanel("会员等级", "image/zizhi-2.png", 2, allpanel, rightContainerPanel,this.webMarketManName,this.webMarketManID,UserType.WebMarketMan);
		this.jp4= new Basic_JPanel("营销策略", "image/bulb.png", 3, allpanel, rightContainerPanel,this.webMarketManName,this.webMarketManID,UserType.WebMarketMan);
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(null);

		allpanel.add(jp1);
		allpanel.add(jp2);
		allpanel.add(jp3);
		allpanel.add(jp4);

		setBak(); // 调用背景方法
		addComp();// 调用添加组件方法
		addHeadImage();// 添加头像
		 this.setDragable();
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

		namejl.setBounds(90, 40, 200, 30);
		namejl.setFont(new Font("宋体", Font.BOLD, 16));
		namejl.setForeground(Color.white);
		abovepanel.add(namejl);

		abovepanel.setBackground(backgroundcolor);
		abovepanel.setBounds(0, 0, 1000, 100);
		abovepanel.setLayout(null);
		this.add(abovepanel);

		jp1.setBounds(0, 140, 200, 80);
		this.add(jp1);
		jp2.setBounds(0, 260, 200, 80);
		this.add(jp2);
		jp3.setBounds(0, 380, 200, 80);
		this.add(jp3);
		jp4.setBounds(0, 500, 200, 80);
		this.add(jp4);
		sidepanel.setBackground(backgroundcolor);
		sidepanel.setBounds(0, 100, 200, 600);
		sidepanel.setLayout(null);
		this.add(sidepanel);
         
     	//用于界面初始化左边栏的第一项和右边的管理订单panel
			
	    rightContainerPanel.add(orderPanelInWebMarketMan);
 		getContentPane().add(rightContainerPanel);
 		jp1.init();
	}

	/**
	 * 添加头像
	 */
	public void addHeadImage() {
		headPanel = new HeadPanel(null, UserType.WebMarketMan);
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

		new WebMarketMan_JFrame("俐俐","000820");

	}
	public void setDragable() {
		this.addMouseListener(new MouseAdapter() {

			public void mouseReleased(MouseEvent e) {
				isDragged = false;
			}

			public void mousePressed(MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}

		});

		this.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				if (isDragged) {
					loc = new Point(getLocation().x + e.getX() - tmp.x, getLocation().y + e.getY() - tmp.y);
					setLocation(loc);
				}
			}
		});
	}
}
