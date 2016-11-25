package presentation.ui.personnelui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;
import presentation.ui.tools.close_JButton;
import presentation.ui.tools.narrow_JButton;

/**
 * 注册企业会员时的界面
 * @author cy
 * @version 1.0
 * 
 */
public class Enterpriseregister_JFrame extends JFrame{
	
	private Font font=new Font("宋体",Font.BOLD, 20);
	private Color color = new Color(69,140,116);
	//private Color color=Color.BLACK;
	
	private close_JButton close_jbutton=new close_JButton();
	private narrow_JButton narrow_jbutton=new narrow_JButton(this);
	
	private JLabel ninthday_logo=new JLabel();
	
	private JLabel individualtab_JLabel=new JLabel("企业会员注册");
	private JLabel name_JLabel=new JLabel("用户名");
	private JLabel password_JLabel=new JLabel("密码");
	private JLabel confirmpassword_JLabel=new JLabel("确认密码");
	private JLabel tel_JLabel=new JLabel("联系方式");
	private JLabel birthday_JLabel=new JLabel("企业名称");
	private JLabel image_JLabel=new JLabel("头像");
	private JLabel enterprisename_JLabel=new JLabel("企业名称");
	private JLabel realimage_JLabel=new JLabel();
	

	private MyTextfield name_TextField=new MyTextfield("--2-8位字母、数字或中文--");
	private MyTextfield password_TextField=new MyTextfield("--4-10位字母或数字--");
	private MyTextfield confirmpassword_TextField=new MyTextfield("--再次输入密码--");
	private MyTextfield tel_TextField=new MyTextfield("--11位手机号--");
	private MyTextfield enterprisename_TextField=new MyTextfield("--企业名称--");
	
	private MyButton confirm_button=new MyButton();
	private MyButton cancle_button=new MyButton();
	private MyButton image_button=new MyButton();
	
	
	
   
	
	
	public Enterpriseregister_JFrame(){

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
    	
    	realimage_JLabel.setBounds(400,500,100,100);
      	ImageIcon icon2=new ImageIcon("image//clientimage.png");
      	realimage_JLabel.setIcon(icon2);
      	//this.add(realimage_JLabel);
      	this.getContentPane().add(realimage_JLabel);
   	   
    	close_jbutton.setBounds(970,10,20,20);
      	this.add(close_jbutton);
      	narrow_jbutton.setBounds(930,10,20,20);
      	this.add(narrow_jbutton);
      	
      	
      	
      	individualtab_JLabel.setFont(new Font("宋体",Font.BOLD, 30));
      	individualtab_JLabel.setForeground(color);
      	individualtab_JLabel.setBounds(400,180,200,70);
      	this.add(individualtab_JLabel);
      	
      	name_JLabel.setBounds(300,250,100,50);
      	name_JLabel.setForeground(color);
      	name_JLabel.setFont(font);
      	this.add(name_JLabel);
      	
      	password_JLabel.setBounds(300,300,100,50);
      	password_JLabel.setForeground(color);
      	password_JLabel.setFont(font);
      	this.add(password_JLabel);
      	
      	confirmpassword_JLabel.setBounds(300,350,100,50);
      	confirmpassword_JLabel.setForeground(color);
      	confirmpassword_JLabel.setFont(font);
      	this.add(confirmpassword_JLabel);
      	
      	tel_JLabel.setBounds(300,400,100,50);
      	tel_JLabel.setForeground(color);
      	tel_JLabel.setFont(font);
      	this.add(tel_JLabel);
      	
//      	birthday_JLabel.setBounds(300,450,100,50);
//      	birthday_JLabel.setForeground(color);
//      	birthday_JLabel.setFont(font);
//      	this.add(birthday_JLabel);
      	
      	image_JLabel.setBounds(300,500,100,50);
      	image_JLabel.setForeground(color);
      	image_JLabel.setFont(font);
      	this.add(image_JLabel);
      	
      	enterprisename_JLabel.setBounds(300,450,100,50);
      	enterprisename_JLabel.setForeground(color);
      	enterprisename_JLabel.setFont(font);
      	this.add(enterprisename_JLabel);
      	
      	
      	
      	
      	 ImageIcon icon3=new ImageIcon("image//ninthday.png");
       	 ninthday_logo.setBounds(300,10,400,150);
       	 ninthday_logo.setIcon(icon3);
      	 this.add(ninthday_logo);
      	
      	
      	name_TextField.setBounds(400,250,300,50);
      	this.add(name_TextField);
      	
      	password_TextField.setBounds(400,300,300,50);
      	this.add(password_TextField);
      	
      	confirmpassword_TextField.setBounds(400,350,300,50);
      	this.add(confirmpassword_TextField);
      	
      	tel_TextField.setBounds(400,400,300,50);
      	this.add(tel_TextField);
      	
      	enterprisename_TextField.setBounds(400,450,300,50);
      	this.add(enterprisename_TextField);
      	
      	
        
        confirm_button.setText("确定");
        confirm_button.setBounds(400,630,100,30);
        this.add(confirm_button);
        cancle_button.setText("取消");
        cancle_button.setBounds(600,630,100,30);
      	this.add(cancle_button);
      	image_button.setText("选取头像");
      	image_button.setBounds(550,570,120,30);
      	this.add(image_button);
    }


    
    
    
    
    


     /**
      * 设置背景图片
    * @param
    * @return
    * @throws 未定
    */
   public void setBak(){ 
	
	
     ((JPanel)this.getContentPane()).setOpaque(false); 
      ImageIcon img = new ImageIcon("image//bg3.png"); 
      JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
      background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 

     } 

   
	
	
	
//	public static void main(String[] args){
//		
//		new Enterpriseregister_JFrame();
//		
//	
//	}
	
	
	
	
	
	
	
	
	
	

}
