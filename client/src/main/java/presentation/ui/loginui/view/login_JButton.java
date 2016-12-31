package presentation.ui.loginui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import presentation.ui.loginui.viewcontroller.LoginViewController;
import presentation.ui.loginui.viewcontroller.LoginViewControllerService;
import presentation.ui.tools.MyButton;

/**
 * 
 * 
 * 登录界面的登录按钮
 * @author cy
 * @version 1.0
 * 
 */
public class Login_JButton extends MyButton{
	Color c=new Color(69,140,116);
//	login_JFrame frame;
//	LoginViewControllerService controller;
	public Login_JButton(){
		
		this.setFont(new Font("宋体",Font.BOLD, 16));
		this.setText("登录");
		this.setForeground(c);
		this.setBorderPainted(false);
		 
		    this.addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					
					//login_JButton.this.setForeground( new Color(112,255,0));
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					Login_JButton.this.setForeground(c);
				}
			});
	}
	

}
