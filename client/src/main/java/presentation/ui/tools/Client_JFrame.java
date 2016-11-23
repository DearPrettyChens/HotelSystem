package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.personnelui.view.Changemessage_JPanel;
import presentation.ui.userui.view.Changepassword_JPanel;

/**
 * 顾客客户端左上不变的地方
 * @author cy
 * @version 1.0
 * 
 */
public class Client_JFrame  extends JFrame{
	
	
	
	private Color backgroundcolor =new Color(148,221,184);
	private JPanel abovepanel=new JPanel();
	private JPanel sidepanel=new JPanel();
	
	
	
	
	private close_JButton close_jbutton=new close_JButton();
	private narrow_JButton narrow_jbutton=new narrow_JButton(this);
	private Reflesh_JButton reflesh_JButton=new Reflesh_JButton();
	private Home_JButton home_JButton=new Home_JButton();
	private Arrow_JButton arrow_JButton=new Arrow_JButton();
	
	ArrayList <Basic_JPanel>   allpanel=new   ArrayList < Basic_JPanel>();
	
	private Basic_JPanel jp1=new Basic_JPanel("预订酒店","image//Conduc.png",0,allpanel);
	private Basic_JPanel jp2=new Basic_JPanel("我的信息","image//edit.png",1,allpanel);
	private Basic_JPanel jp3=new Basic_JPanel("修改密码","image//key.png",2,allpanel);
	private Basic_JPanel jp4=new Basic_JPanel("我的订单","image//note.png",3,allpanel);
	private Basic_JPanel jp5=new Basic_JPanel("预订过的酒店","image//shop.png",4,allpanel);
	private Basic_JPanel jp6=new Basic_JPanel("我的信用记录","image//star.png",5,allpanel);
	
	 
	private JLabel namejl=new JLabel("顾客:XXX");

	
	
	private JLabel line =new JLabel(new ImageIcon("image//line.png"));
	
    
	
	private Changepassword_JPanel cp=new Changepassword_JPanel();
	//private Changemessage_JPanel cp=new Changemessage_JPanel();
	//private SingleCreditinfo_JPanel cp=new SingleCreditinfo_JPanel("4.19", "wjbce", "wobc", "owfbnc", "wjebfc");
	
	
	public Client_JFrame(){
		
		
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
	      allpanel.add(jp5);
	      allpanel.add(jp6);
	      
	      
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
	     
	     
      	
         cp.setBounds(200,100,800,600);
         this.add(cp);
         
//    	
    }
    
    
    
    
    
    
    /**
     * 设置背景图片
   * @param
   * @return
   * @throws 未定
   */
  public void setBak(){ 
	
	
    
    } 
  
  
 

	    

  
	
	
	
//	public static void main(String[] args){
//		
//		new Client_JFrame();
//		
//	
//	}
	
	

}