package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.creditui.view.Clientdeposite_JPanel;
import presentation.ui.creditui.view.DepositPanel;
import presentation.ui.orderui.view.OrderPanelInWebMarketMan;
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
	// 关于网站营销人员基本信息
	private String webMarketManID = "000820";
	private String webMarketManName = "营销员：俐俐";

	// 关于界面

	private RightContainerPanel rightContainerPanel = new RightContainerPanel();

	private close_JButton close_jbutton = new close_JButton();
	private narrow_JButton narrow_jbutton = new narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton = new Reflesh_JButton();
	private Home_JButton home_JButton = new Home_JButton();
	private Arrow_JButton arrow_JButton = new Arrow_JButton();
	private JLabel line = new JLabel(new ImageIcon("image//line.png"));

	ArrayList<Basic_JPanel> allpanel = new ArrayList<Basic_JPanel>();

	private Basic_JPanel jp1 = new Basic_JPanel("管理订单", "image//search.png", 0, allpanel, rightContainerPanel);
	private Basic_JPanel jp2 = new Basic_JPanel("信用充值", "image//touzichanpin.png", 1, allpanel, rightContainerPanel);
	private Basic_JPanel jp3 = new Basic_JPanel("会员等级", "image//zizhi-2.png", 2, allpanel, rightContainerPanel);
	private Basic_JPanel jp4 = new Basic_JPanel("营销策略", "image//bulb.png", 3, allpanel, rightContainerPanel);

	private HeadPanel headPanel;

	private JLabel namejl = new JLabel(webMarketManName);

	private Color backgroundcolor = new Color(148, 221, 184);
	private JPanel abovepanel = new JPanel();
	private JPanel sidepanel = new JPanel();
	
	private Clientlevelrule_JPanel clientlevelrule_JPanel=new Clientlevelrule_JPanel();
    private Makewebstr_JPanel makewebstr_JPanel=new Makewebstr_JPanel();
	private DepositPanel depositPanel=DepositPanel.getInstance();
	private OrderPanelInWebMarketMan orderPanelInWebMarketMan=OrderPanelInWebMarketMan.getInstance();
	
	public WebMarketMan_JFrame() {

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
		
//		depositPanel.setBounds(200, 100, 800, 600);
//	    this.add(depositPanel);
//        clientdepositelistinfo_JPanel.setBounds(200, 100, 800, 600);
//		this.add(clientdepositelistinfo_JPanel);
//        clientlevelrule_JPanel.setBounds(200, 100, 800, 600);
//		this.add(clientlevelrule_JPanel);
//		 makewebstr_JPanel.setBounds(200, 100, 800, 600);
//			this.add(makewebstr_JPanel);
//		 orderPanelInWebMarketMan.setBounds(200, 100, 800, 600);
//			this.add(orderPanelInWebMarketMan);
         
     	//用于界面初始化左边栏的第一项和右边的营销人员
			
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

		new WebMarketMan_JFrame();

	}

}
