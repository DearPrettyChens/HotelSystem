package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.hibernate.loader.entity.EntityJoinWalker;

import presentation.ui.personnelui.view.Clientlistinfo_JPanel;
import util.UserType;

/**
 * 管理员左上角所有
 * @author cy
 * @version 1.0
 * 
 */
public class Webmannger_JFrame extends JFrame{
	//关于网站管理人员基本信息
		
		private String managerName="管理员：悦悦";
		
		
	private	Clientlistinfo_JPanel panel= new Clientlistinfo_JPanel("image//customer.png","123456", "小豆", "123456789", UserType.Customer.name(), "123456");
	
	//关于界面
	private close_JButton close_jbutton=new close_JButton();
	private narrow_JButton narrow_jbutton=new narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton=new Reflesh_JButton();
	private Home_JButton home_JButton=new Home_JButton();
	private Arrow_JButton arrow_JButton=new Arrow_JButton();
	private JLabel line =new JLabel(new ImageIcon("image//line.png"));
	
	ArrayList <Basic_JPanel>   allpanel=new   ArrayList < Basic_JPanel>();
	
	
	 
	private Basic_JPanel jp1=new Basic_JPanel("营销人员","image//user.png",0,allpanel);
	private Basic_JPanel jp2=new Basic_JPanel("顾客会员","image//user2.png",1,allpanel);
	private Basic_JPanel jp3=new Basic_JPanel("酒店人员","image//shop.png",2,allpanel);
	private Basic_JPanel jp4=new Basic_JPanel("修改密码","image//password.png",3,allpanel);

	private HeadPanel headPanel;//头像部分
	
	private JLabel namejl=new JLabel(managerName);

	
	private Color backgroundcolor =new Color(148,221,184);
	private JPanel abovepanel=new JPanel();
	private JPanel sidepanel=new JPanel();
	
	
	
	
	 public Webmannger_JFrame(){
		 
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
		      
		      

		      allpanel.add(jp1);
		      allpanel.add(jp2);
		      allpanel.add(jp3);
		      allpanel.add(jp4);
		      
			
		      setBak(); //调用背景方法
	          addComp();//调用添加组件方法
	          addHeadImage();//添加头像
		     
		     
	          
		      this.setVisible(true);
		 
	 }
	 
	 
	 
	 
	 
	 /**
	     * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    	
	    	
	    	
	    	
	    	

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
	      	
	      	
	      	namejl.setBounds(90,40,200,30);
	      	namejl.setFont(new Font("宋体",Font.BOLD, 16));
	      	namejl.setForeground(Color.white);
	      	abovepanel.add(namejl);
	    	
	      	abovepanel.setBackground( backgroundcolor);
	      	abovepanel.setBounds(0,0,1000,100);
	      	abovepanel.setLayout(null);
		     this.add(abovepanel);
		     
		     
		     
		     
		     
		     
		     jp1.setBounds(0,140,200,80);
		     this.add(jp1);
			 jp2.setBounds(0,260,200,80);
			 this.add(jp2);
			 jp3.setBounds(0,380,200,80);
			 this.add(jp3);
			 jp4.setBounds(0,500,200,80);
			 this.add(jp4);
			
			 sidepanel.setBackground(backgroundcolor);
			 sidepanel.setBounds(0,100, 200, 600);
		     sidepanel.setLayout(null);
		     this.add(sidepanel);
		     
		    //各个面板设置进来进行观察
		     panel.setBounds(200,100,800,600);
				getContentPane().add(panel);
		     
	    
	    }
	    
	    /**
		 * 添加头像
		 */
		public void addHeadImage() {
			headPanel=new HeadPanel(null, UserType.WebMarketMan);
			headPanel.setBounds(15, 20, 65, 65);
			getContentPane().add(headPanel);
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
		  
		  new Webmannger_JFrame();
		  
		  
	  }
	

}
