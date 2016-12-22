package ui.tools;

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
public class NarrowButton extends JButton {
	private ImageIcon icon=new ImageIcon(NarrowButton.class.getResource("narrow.jpg"));
	
	 private JFrame jf;
	 
	 public NarrowButton(JFrame jf){
		
		 this.jf=jf;
		 this.setIcon(icon);
		 this.setBorderPainted(false);
		 this.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  jf.setExtendedState(JFrame.ICONIFIED);
	            }
	        });
	 }
}
