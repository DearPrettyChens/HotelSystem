package presentation.ui.loginui.view;

import java.awt.Container;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener; 
import presentation.ui.tools.*;

/**
 * 登录界面
 * @author cy
 * @version 1.0
 * 
 */
public class login_JFrame extends JFrame { 
	
	private name_JTextField name=new name_JTextField();//登录时姓名填写区域
	private password_JPasswordFeild password=new password_JPasswordFeild();//密码区域
	private close_JButton close_jbutton=new close_JButton();//关闭窗口按钮
	private narrow_JButton narrow_jbutton=new narrow_JButton(this);//最小化窗口按钮
	private login_JButton jb=new login_JButton();//登录按钮
	private newclient_JLabel jl=new newclient_JLabel();//是否没有账户标签
	
			
	
	

     public login_JFrame() { 
	  
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
    	 this.add(close_jbutton);
    	 narrow_jbutton.setBounds(930,10,20,20);
    	 this.add(narrow_jbutton);
    	 
    	 
    	 name.setBounds(400,450,200,40);
    	 this.add(name);
    	 password.setBounds(400,500,200,40);
    	 this.add(password);
    	 jb.setBounds(400,550,200,40);
    	 this.add(jb);
    	 
    	 jl.setBounds(500,590,200,40);
    	 this.add(jl);
    	 
    	 
    	 
     }




      /**
       * 设置背景图片
     * @param
     * @return
     * @throws 未定
     */
    public void setBak(){ 
	
	
      ((JPanel)this.getContentPane()).setOpaque(false); 
       ImageIcon img = new ImageIcon("image//bg2.png"); 
       JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
       background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 

      } 

    
      
      
      public static void main(String[] args) { 
    	  login_JFrame s = new login_JFrame(); 
               
} 

}

