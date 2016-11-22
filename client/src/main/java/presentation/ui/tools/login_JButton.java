package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * 
 * 
 * 登录界面的登录按钮
 * @author cy
 * @version 1.0
 * 
 */
public class login_JButton extends MyButton{
	Color c=new Color(69,140,116);
	public login_JButton(){
		
		
		this.setFont(new Font("宋体",Font.BOLD, 16));
		this.setText("登录");
		this.setForeground(c);
		this.setBorderPainted(false);
		 
		    this.addMouseListener(new MouseListener(){
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
									
					
					
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					
					//login_JButton.this.setForeground( new Color(112,255,0));
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					login_JButton.this.setForeground(c);
				}
			});
	}
	

}
