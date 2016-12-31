
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
 * 右上角关闭按钮
 * @author cy
 * @version 1.0
 * 
 */
public class Reflesh_JButton extends JButton{
	 private ImageIcon icon=new ImageIcon(Reflesh_JButton.class.getResource("image/reflesh.png"));
	 
	 public Reflesh_JButton(){
		
		 
		 this.setIcon(icon);
		 this.setBorderPainted(false);
		 this.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            }
	        });
		 
		 
		 
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
					
				}
				@Override
				public void mouseExited(MouseEvent e) {

				}
			});
	 }
	 
	 
	 
	 
	 
	
	

}
