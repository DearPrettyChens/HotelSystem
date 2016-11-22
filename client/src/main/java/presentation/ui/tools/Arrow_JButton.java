
package presentation.ui.tools;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 右上角箭头按钮
 * @author cy
 * @version 1.0
 * 
 */
public class Arrow_JButton extends JButton{
	 private ImageIcon icon=new ImageIcon("image//tuiguang.png");
	 //private JFrame jf;
	 
	 public Arrow_JButton(){
		
		 
		 this.setIcon(icon);
		 this.setBorderPainted(false);
		 this.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            //未写
	            	
	                
	            }
	        });
		 
		 
		 
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
				//newclient_JLabel.this.setForeground( new Color(112,255,0));
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
				//	newclient_JLabel.this.setForeground(c);
				}
			});
	 }
	 
	 
	 
	 
	 
	
	

}
