package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 酒店工作人员左上角的所有面板
 * @author cy
 * @version 1.0
 * 
 */
public class Hotelworker_JFrame extends JFrame{
	
	
	
	
	
	private close_JButton close_jbutton=new close_JButton();
	private narrow_JButton narrow_jbutton=new narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton=new Reflesh_JButton();
	private Home_JButton home_JButton=new Home_JButton();
	private Arrow_JButton arrow_JButton=new Arrow_JButton();
	private JLabel line =new JLabel(new ImageIcon("image//line.png"));
	
	ArrayList <Basic_JPanel>   allpanel=new   ArrayList < Basic_JPanel>();
	
	private JLabel namejl=new JLabel("酒店工作人员:XXX");
	 
	

	private JLabel myhotel_Jlabel=new JLabel("我的酒店");
	private JLabel myorder_Jlabel=new JLabel("我的订单");
	private JLabel mystr_Jlabel=new JLabel("我的策略");
	private JLabel checkin_Jlabel=new JLabel("入住退房");
	
	private JLabel myhotelimg_Jlabel=new JLabel();
	private JLabel myorderimg_Jlabel=new JLabel();
	private JLabel mystrimg_Jlabel=new JLabel();
	private JLabel checkinimg_Jlabel=new JLabel();
	
	
	private JLabel myhotel_Jlabel1=new  Hotelworker_JLabel("维护酒店信息");
	private JLabel myhotel_Jlabel2=new  Hotelworker_JLabel("录入客房信息");
	private JLabel myorder_Jlabel1=new  Hotelworker_JLabel("浏览订单列表");
	private JLabel mystr_Jlabel1=new  Hotelworker_JLabel("制定酒店策略");
	private JLabel checkin_Jlabel1=new  Hotelworker_JLabel("线上入住办理");
	private JLabel checkin_Jlabel2=new  Hotelworker_JLabel("线上退房办理");
	private JLabel checkin_Jlabel3=new  Hotelworker_JLabel("线下入住退房");
	
	

	
	
	
	private Color backgroundcolor =new Color(148,221,184);
	private JPanel abovepanel=new JPanel();
	private JPanel sidepanel=new JPanel();
	
	
	
	
	 public Hotelworker_JFrame(){
		 
		 this.setLocation
	        ( 
	           (int) (Toolkit.getDefaultToolkit().getScreenSize().
	                  getWidth() - 1000) / 2,
	           (int) (Toolkit.getDefaultToolkit().getScreenSize().
	                  getHeight() - 700) / 2
	            ); //定位框架位置
		      this.setSize(1000, 700);
		      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		      this.setUndecorated(true);
		      this.setLayout(null);
		      
		      
		     
			
		      setBak(); //调用背景方法
	          addComp();//调用添加组件方法
	        
		     
		     
	          
		      this.setVisible(true);
		 
	 }
	 
	 
	 
	 
	 
	 /**
	     * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    	
	    	
	    	
	    	
	    	

	    	close_jbutton.setBounds(970,10,20,20);
	    	abovepanel.add(close_jbutton);
	      	narrow_jbutton.setBounds(930,10,20,20);
	      	abovepanel.add(narrow_jbutton);
	      	arrow_JButton.setBounds(850,10,20,20);
	      	abovepanel.add(arrow_JButton);
	      	home_JButton.setBounds(810,10,20,20);
	      	abovepanel.add(home_JButton);
	      	reflesh_JButton.setBounds(770,10,20,20);
	      	abovepanel.add(reflesh_JButton);
	      	line.setBounds(885,5,30,30);
	      	abovepanel.add(line);
	    	
	      	
	      	
	      	namejl.setBounds(30,70,200,30);
	      	namejl.setFont(new Font("宋体",Font.BOLD, 16));
	      	namejl.setForeground(Color.white);
	      	abovepanel.add(namejl);
	      	
	      	
	      	abovepanel.setBackground( backgroundcolor);
	      	abovepanel.setBounds(0,0,1000,100);
	      	abovepanel.setLayout(null);
		     this.add(abovepanel);
		     
		     
		     sidepanel.setBackground(backgroundcolor);
		     sidepanel.setBounds(0,100, 200, 600);
		     sidepanel.setLayout(null);
		     this.add(sidepanel);
		     
		     
		     myhotel_Jlabel.setFont(new Font("宋体",Font.BOLD, 18));
		     myhotel_Jlabel.setForeground(Color.white);
		     myhotel_Jlabel.setBounds(80,0,100,30);
		     sidepanel.add(myhotel_Jlabel);
		     
		     ImageIcon icon1=new ImageIcon("image//user.png");
		     myhotelimg_Jlabel.setIcon(icon1);
		     myhotelimg_Jlabel.setBounds(40,0,30,30);
		     sidepanel.add(myhotelimg_Jlabel);
		     
		     myorder_Jlabel.setFont(new Font("宋体",Font.BOLD, 18));
		     myorder_Jlabel.setForeground(Color.white);
		     myorder_Jlabel.setBounds(80,100,100,30);
		     sidepanel.add(myorder_Jlabel);
		     
		     ImageIcon icon2=new ImageIcon("image//star.png");
		     myorderimg_Jlabel.setIcon(icon2);
		     myorderimg_Jlabel.setBounds(40,100,30,30);
		     sidepanel.add(myorderimg_Jlabel);
		     
		     mystr_Jlabel.setFont(new Font("宋体",Font.BOLD, 18));
		     mystr_Jlabel.setForeground(Color.white);
		     mystr_Jlabel.setBounds(80,200,100,30);
		     sidepanel.add(mystr_Jlabel);
		     
		     ImageIcon icon3=new ImageIcon("image//note.png");
		     mystrimg_Jlabel.setIcon(icon3);
		     mystrimg_Jlabel.setBounds(40,200,30,30);
		     sidepanel.add(mystrimg_Jlabel);
		     
		     checkin_Jlabel.setFont(new Font("宋体",Font.BOLD, 18));
		     checkin_Jlabel.setForeground(Color.white);
		     checkin_Jlabel.setBounds(80,300,100,30);
		     sidepanel.add(checkin_Jlabel);
		     
		     ImageIcon icon4=new ImageIcon("image//shop.png");
		     checkinimg_Jlabel.setIcon(icon4);
		     checkinimg_Jlabel.setBounds(40,300,30,30);
		     sidepanel.add(checkinimg_Jlabel);
		     
		     
		     myhotel_Jlabel1.setBounds(80,30,180,30);
		     sidepanel.add(myhotel_Jlabel1);
		     myhotel_Jlabel2.setBounds(80,60,180,30);
		     sidepanel.add(myhotel_Jlabel2);
		     
		     myorder_Jlabel1.setBounds(80,130,180,30);
		     sidepanel.add(myorder_Jlabel1);
		     
		     mystr_Jlabel1.setBounds(80,230,180,30);
		     sidepanel.add(mystr_Jlabel1);
	      	
		     checkin_Jlabel1.setBounds(80,330,180,30);
		     sidepanel.add(checkin_Jlabel1);
		     checkin_Jlabel2.setBounds(80,360,180,30);
		     sidepanel.add(checkin_Jlabel2);
		     checkin_Jlabel3.setBounds(80,390,180,30);
		     sidepanel.add(checkin_Jlabel3);
	    
	    }
	    
	    
	    
	    
	    
	    
	    /**
	     * 设置背景图片
	   * @param
	   * @return
	   * @throws 未定
	   */
	  public void setBak(){ 
		
		
	    
	    } 
	  
	  
	  
	  
	  public static void main(String[] args){
		  
		  new Hotelworker_JFrame();
		  
		  
	  }
	

}
