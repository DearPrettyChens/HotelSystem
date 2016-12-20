package presentation.ui.loginui.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.control.Button;
import presentation.ui.loginui.viewcontroller.RegisterViewController;
import presentation.ui.loginui.viewcontroller.RegisterViewControllerService;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.close_JButton;
import presentation.ui.tools.narrow_JButton;
/**
 * 选择企业会员还是普通会员的主面板
 * @author cy
 * @version 1.0
 * 
 */
public class newclient_JFrame  extends JFrame{
	private boolean isDragged = false;
	private Point tmp;
	private Point loc;

	
	private close_JButton close_jbutton=new close_JButton();
	private narrow_JButton narrow_jbutton=new narrow_JButton(this);
	private JLabel individual_logo=new JLabel();
	private JLabel enterprise_logo=new JLabel();
	private JLabel ninthday_logo=new JLabel();
	private MyButton individual_button=new MyButton();
	private MyButton enterprise_button=new MyButton();
	
	
	
	private MyButton returnButton=new MyButton();
	
	
	private RegisterViewControllerService registerViewController = RegisterViewController.getInstance();
	
	
	
	
	
	public newclient_JFrame(){

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
          
	     
	     this.setDragable();
          
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
   	 
   	 
   	 ImageIcon icon1=new ImageIcon(newclient_JFrame.class.getResource("image/clientlogo.png"));
   	 individual_logo.setBounds(250,300,150,150);
   	 individual_logo.setIcon(icon1);
   	 this.add(individual_logo);
   	 
   	 
   	 
   	 ImageIcon icon2=new ImageIcon(newclient_JFrame.class.getResource("image/enterpriselogo.png"));
   	 enterprise_logo.setBounds(600,300,150,150);
   	 enterprise_logo.setIcon(icon2);
   	 this.add(enterprise_logo);
   	 
   	 
   	 ImageIcon icon3=new ImageIcon(newclient_JFrame.class.getResource("image/ninthday.png"));
   	 ninthday_logo.setBounds(300,50,400,150);
   	 ninthday_logo.setIcon(icon3);
  	 this.add(ninthday_logo);
   	 
  	 individual_button.setBounds(250,500,150,40);
  	 individual_button.setText("普通会员");
  	 individual_button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			registerViewController.jumpToIndividualRegisterView();
			dispose();
		}
	});
  	 this.add(individual_button);
  	 
  	 enterprise_button.setBounds(600, 500, 150, 40);
  	 enterprise_button.setText("企业会员");
  	 enterprise_button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			registerViewController.jumpToEnterpriseRegisterView();
			dispose();
		}
	});
  	 this.add(enterprise_button);
  	 
  	 returnButton.setBounds(450,600,100,40);
  	 returnButton.setText("返回");
  	 returnButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			registerViewController.jumpToLoginView();
//			dispose();
		}
	});
  	 this.add(returnButton);
   	 
    }




     /**
      * 设置背景图片
    * @param
    * @return
    * @throws 未定
    */
   public void setBak(){ 
	
	
     ((JPanel)this.getContentPane()).setOpaque(false); 
      ImageIcon img = new ImageIcon(newclient_JFrame.class.getResource("image/bg.png")); 
      JLabel background = new JLabel(img);this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
      background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 

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
//	
//	public static void main(String[] args){
//		
//		new newclient_JFrame();
//		
//	
//	}
	
   
}
