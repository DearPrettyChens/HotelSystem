package presentation.ui.tools;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * 登录时输入姓名区域
 * @author cy
 * @version 1.0
 * 
 */
public class Name_JTextField extends JTextField implements FocusListener {

	
	    private ImageIcon icon;  
	  
	    public Name_JTextField() {  
       // 获取当前路径下的图片  
	        icon = new ImageIcon(getClass().getResource("image/name.png")); 
	        
	        Insets insets = new Insets(50, 20, 20, 0);  
	        //设置文本输入距左边20  
	        this.setMargin(insets); 
	        
	        //设置光标距离
	        this.setPreferredSize(new Dimension(200, 25));
	        Border empty = new EmptyBorder(0, 50, 0, 0);
	        CompoundBorder border = new CompoundBorder(this.getBorder(), empty);
	        this.setBorder(border);
	  
	    }  


	    @Override  
	    public void paintComponent(Graphics g) {  
	        Insets insets = getInsets();  
	        super.paintComponent(g);  
	        int iconWidth = icon.getIconWidth();  
	        int iconHeight = icon.getIconHeight();  
	        int Height = this.getHeight();  
	        //在文本框中画上之前图片  
	        icon.paintIcon(this, g, (insets.left - iconWidth)/2, (Height - iconHeight) / 2);  
	    }

		@Override
		public void focusGained(FocusEvent e) {
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			
		}  
		
		
		
		
		


	}  


   





