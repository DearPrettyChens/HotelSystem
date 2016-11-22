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
 * 网站营销人员的左上角所有
 * @author cy
 * @version 1.0
 * 
 */
public class Webstrmaker_JFrame extends JFrame{
	
	
	
	
	
	private close_JButton close_jbutton=new close_JButton();
	private narrow_JButton narrow_jbutton=new narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton=new Reflesh_JButton();
	private Home_JButton home_JButton=new Home_JButton();
	private Arrow_JButton arrow_JButton=new Arrow_JButton();
	private JLabel line =new JLabel(new ImageIcon("image//line.png"));
	
	ArrayList <Basic_JPanel>   allpanel=new   ArrayList < Basic_JPanel>();
	
	
	
	private Basic_JPanel jp1=new Basic_JPanel("搜索和浏览酒店","image//search.png",0,allpanel);
	private Basic_JPanel jp2=new Basic_JPanel("信用充值","image//touzichanpin.png",1,allpanel);
	private Basic_JPanel jp3=new Basic_JPanel("会员等级规则","image//zizhi-2.png",2,allpanel);
	private Basic_JPanel jp4=new Basic_JPanel("网站营销策略","image//bulb.png",3,allpanel);
	
	
	private JLabel namejl=new JLabel("网站营销人员:XXX");
	

	
	
	
	

	
	
	
	private Color backgroundcolor =new Color(148,221,184);
	private JPanel abovepanel=new JPanel();
	private JPanel sidepanel=new JPanel();
	
	
	
	
	 public Webstrmaker_JFrame(){
		 
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
		     
		     
		     
		     
		     jp1.setBounds(0,100,200,80);
		     this.add(jp1);
			 jp2.setBounds(0,220,200,80);
			 this.add(jp2);
			 jp3.setBounds(0,340,200,80);
			 this.add(jp3);
			 jp4.setBounds(0,460,200,80);
			 this.add(jp4);
			 sidepanel.setBackground(backgroundcolor);
		     sidepanel.setBounds(0,100, 200, 600);
		     sidepanel.setLayout(null);
		     this.add(sidepanel);
	      	
	    
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
		  
		  new Webstrmaker_JFrame();
		  
		  
	  }
	

}
