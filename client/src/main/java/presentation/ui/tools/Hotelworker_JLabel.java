package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

/**
 * 酒店工作人员左边的选择栏
 * @author cy
 * @version 1.0
 * 
 */
public class Hotelworker_JLabel  extends JLabel{
	 public Hotelworker_JLabel (String s){
		 this.setText(s);
//		 Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
		 Hotelworker_JLabel.this.setForeground(Color.GRAY);
		 Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 16));
		 this.addMouseListener(new MouseAdapter() {
	            @Override
	             public void mouseEntered(MouseEvent e) {
//	            	Hotelworker_JLabel.this.setForeground(Color.GRAY);
//	            	Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
	            	 Hotelworker_JLabel.this.setForeground(Color.BLACK);
	            	Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 18));
	            	
	             }
	 
	             @Override
	          public void mouseExited(MouseEvent e) {
	            	 Hotelworker_JLabel.this.setForeground(Color.GRAY);
//	            	 Hotelworker_JLabel.this.setForeground(new Color(255, 255, 255));
	            	 Hotelworker_JLabel. this.setFont(new Font("宋体",Font.BOLD, 16));
	             }
	         });
	    }
		 
		 
		 
		 
	 }
	
	


