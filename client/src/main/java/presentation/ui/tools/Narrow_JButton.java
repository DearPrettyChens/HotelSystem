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
 * 右上角最小化按钮
 * @author cy
 * @version 1.0
 * 
 */
public class Narrow_JButton extends JButton {
	private ImageIcon icon=new ImageIcon(Narrow_JButton.class.getResource("image/narrow.jpg"));
	
	 private JFrame jf;
	 
	 public Narrow_JButton(JFrame jf){
		
		 this.jf=jf;
		 this.setIcon(icon);
		 this.setBorderPainted(false);
		 this.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  jf.setExtendedState(JFrame.ICONIFIED);
	            	
	                
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
