package presentation.ui.tools;

import java.awt.AlphaComposite;
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD
=======
import presentation.ui.hotelstrategyui.view.ChooseHotelStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelBirthStr_JPanel;
import presentation.ui.hotelstrategyui.view.HotelOverThreeStr_Jpanel;
import presentation.ui.hotelstrategyui.view.SingleHotelEnterpriseStr_JPanel;
>>>>>>> origin/master
import presentation.ui.userui.view.Changepassword_JPanel;
import util.UserType;

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

	private Basic_JPanel jp1 = new Basic_JPanel("预订酒店", "image//Conduc.png", 0, allpanel);
	private Basic_JPanel jp2 = new Basic_JPanel("我的信息", "image//edit.png", 1, allpanel);
	private Basic_JPanel jp3 = new Basic_JPanel("修改密码", "image//key.png", 2, allpanel);
	private Basic_JPanel jp4 = new Basic_JPanel("我的订单", "image//note.png", 3, allpanel);
	private Basic_JPanel jp5 = new Basic_JPanel("我的足迹", "image//shop.png", 4, allpanel);
	private Basic_JPanel jp6 = new Basic_JPanel("我的信用", "image//star.png", 5, allpanel);

	private HeadPanel headPanel;
	
<<<<<<< HEAD
	// private Basic_JPanel jp1=new Basic_JPanel();
	private JLabel namejl = new JLabel(customerName);
	private JLabel vipjl= new JLabel(new ImageIcon("image//vip.png"));
	private JLabel line = new JLabel(new ImageIcon("image//line.png"));

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
=======
	
	private JLabel line =new JLabel(new ImageIcon("image//line.png"));
	
    
	
	//private Changepassword_JPanel cp=new Changepassword_JPanel();
	//private Changemessage_JPanel cp=new Changemessage_JPanel();
	//private SingleCreditinfo_JPanel cp=new SingleCreditinfo_JPanel("4.19", "wjbce", "wobc", "owfbnc", "+1000");
	//private Clientlistinfo_JPanel cp=new Clientlistinfo_JPanel("120374", "22039482", "jcie", "lknfrce", "jbvcekj", "fvbcejnevj");
	//Searchperson_JPanel cp=new Searchperson_JPanel();
	//Searchoradd_JPanel cp=new Searchoradd_JPanel();
	//Orderlistinfo_JPanel cp=new Orderlistinfo_JPanel("", "", "","", "", "");
	//Orderlistinfo_JPanel cp=new Orderlistinfo_JPanel("120374", "120374", "120374", "120374", "120374", "120374", "120374", "120374", "120374", "120374", "120374", "120374", "120374");
	//Clientdeposite_JPanel cp=new Clientdeposite_JPanel("enwf","enwf","enwf","enwf");
	//private Hotelworkerlistinfo_JPanel cp=new Hotelworkerlistinfo_JPanel("fw","120374", "22039482", "jcie", "lknfrce", "jbvcekj", "fvbcejnevj");
	
//	 Singlewebclientlevelstr_Jpanel jphh=new Singlewebclientlevelstr_Jpanel(1,2);
//	 Singlewebclientlevelstr_Jpanel jphhh=new Singlewebclientlevelstr_Jpanel(3,4);
//	 
//	 Singlewebspecialtimestr_JPanel jpc=new Singlewebspecialtimestr_JPanel("bd","ougd",9);
//	 Singlewebvipstr_Jpanel jpa=new  Singlewebvipstr_Jpanel("wejfb",9);
//	 
//	 ArrayList<Singlewebclientlevelstr_Jpanel > arry;
//	 ArrayList< Singlewebspecialtimestr_JPanel > arry1;
//	 ArrayList<Singlewebvipstr_Jpanel > arry2;
//	 Webvipstr_JPanel  vipstr;Webclientlevelstr_Jpanel clientlevelstr;Webspecialtimestr_JPanel specialtimestr;
//	 
//	Makewebstr_JPanel cp;
//	 
//	 
	SingleHotelEnterpriseStr_JPanel cp=new  SingleHotelEnterpriseStr_JPanel();
	public Client_JFrame(){
//		
//		arry=new ArrayList<Singlewebclientlevelstr_Jpanel >();
//		arry.add(jphh);
//		arry.add(jphhh);
//		
//		arry1=new ArrayList<Singlewebspecialtimestr_JPanel >();
//		arry1.add(jpc);
//		
//		
//		arry2=new ArrayList<Singlewebvipstr_Jpanel >();
//		arry2.add(jpa);
//		
//		
//		clientlevelstr=new Webclientlevelstr_Jpanel(arry);
//		
//		vipstr=new Webvipstr_JPanel(arry2);
//		specialtimestr=new Webspecialtimestr_JPanel(arry1);
//		cp=new Makewebstr_JPanel(vipstr,clientlevelstr,specialtimestr);
		//Webclientlevelstr_Jpanel cp=new Webclientlevelstr_Jpanel(arry);
>>>>>>> origin/master
		
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

	}

	/**
<<<<<<< HEAD
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
=======
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	
    	close_jbutton.setBounds(970,40,20,20);
    	abovepanel.add(close_jbutton);
      	narrow_jbutton.setBounds(930,40,20,20);
      	abovepanel.add(narrow_jbutton);
      	arrow_JButton.setBounds(850,40,20,20);
      	abovepanel.add(arrow_JButton);
      	home_JButton.setBounds(810,40,20,20);
      	abovepanel.add(home_JButton);
      	reflesh_JButton.setBounds(770,40,20,20);
      	abovepanel.add(reflesh_JButton);
      	line.setBounds(885,35,30,30);
      	abovepanel.add(line);
      	
      	
      	namejl.setBounds(30,70,200,30);
      	namejl.setFont(new Font("宋体",Font.BOLD, 16));
      	namejl.setForeground(Color.white);
      	abovepanel.add(namejl);
    	
      	abovepanel.setBackground( backgroundcolor);
      	abovepanel.setBounds(0,0,1000,100);
      	abovepanel.setLayout(null);
	     this.add(abovepanel);
      	
      	
	     
	   
	    
      	   
	     
	     jp1.setBounds(0,100,200,80);
	     this.add(jp1);
		 jp2.setBounds(0,180,200,80);
		 this.add(jp2);
		 jp3.setBounds(0,260,200,80);
		 this.add(jp3);
		 jp4.setBounds(0,340,200,80);
		 this.add(jp4);
		 jp5.setBounds(0,420,200,80);
		 this.add(jp5);
		 jp6.setBounds(0,500,200,80);
		 this.add(jp6);
			
		 sidepanel.setBackground(backgroundcolor);
	     sidepanel.setBounds(0,580, 200, 140);
	     this.add(sidepanel);
	     
	     
      	
        cp.setBounds(200,100,800,50);
         this.add(cp);
         
   	
    }
    
    
    
    
    
    
    /**
     * 设置背景图片
   * @param
   * @return
   * @throws 未定
   */
  public void setBak(){ 
	
	  
	  
	  
	
    
    } 
   
  
 
>>>>>>> origin/master

	}

	public static void main(String[] args) {

		new Client_JFrame();

	}

}
