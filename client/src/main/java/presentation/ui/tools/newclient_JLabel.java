package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JLabel;


/**
 * 登录界面“还没有账户？"标签
 * @author cy
 * @version 1.0
 * 
 */
public class newclient_JLabel extends JLabel {
	Color c=new Color(69,140,116);
	
	
			
	
	public newclient_JLabel(){
		
		this.setFont(new Font("宋体",Font.BOLD, 16));
		this.setText("还没有账户？");
		this.setForeground(c);
		 
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
				newclient_JLabel.this.setForeground( new Color(112,255,0));
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					newclient_JLabel.this.setForeground(c);
				}
			});
			
			
		
	}
	
	
	
	
	

}