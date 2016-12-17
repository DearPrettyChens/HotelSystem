package presentation.ui.tools;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 登入界面进度条
 * @author Cy88352988
 *
 */
public class Logingif_JFrame   extends JFrame{
	
	private JLabel gif=new JLabel(new ImageIcon("image/loginback.gif"));
	
	//private close_JButton close_jbutton = new close_JButton();// 关闭窗口按钮
	private narrow_JButton narrow_jbutton = new narrow_JButton(this);// 最小化窗口按钮
	
	public  Logingif_JFrame (){
		
		
		
		
		this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 1000) / 2,
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 700) / 2); // 定位框架位置
		this.setSize(1000, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
        
		this.setLayout(null);

		//setBak(); // 调用背景方法
		addComp();// 调用添加组件方法
		setBak(); // 调用背景方法

		this.setVisible(true);

		
		
		
	}
	
	public void addComp() {
		
		
		//close_jbutton.setBounds(970, 10, 20, 20);
		//this.add(close_jbutton);
		narrow_jbutton.setBounds(930, 10, 20, 20);
		this.add(narrow_jbutton);
		
		
		gif.setBounds(200,400,600,200);
		this.add(gif);
		
	}
	
	public void setBak() {

		((JPanel) this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("image//bg2.png");
		JLabel background = new JLabel(img);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
  this.add(background);
  
	}
	
	
	
	public static void main(String[] args){
		new Logingif_JFrame();
		
	}
	

}