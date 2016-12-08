package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

/**
 * JTextfield的样式
 * 很多JTextField的父类
 * @author cy
 * @version 1.0
 * 
 */
public class MyTextfield  extends JTextField implements FocusListener{
	
	
	
	  private  String hint;
	  private boolean showingHint;

	  private static final long serialVersionUID = -2631585163797279638L;
	    private int arcH = 15 ;
	    private int arcW = 15 ;
	    Shape shape ;
	
	    public MyTextfield(String s){
	    	
	    	 setBorder(null);
 	        setBackground(new Color(0, 0, 0, 0));
	    	  
	    	    this.hint=s;
	    	   
	    	    this.hint = hint;
	    	    this.setText(hint);
	    	    this.setFont(new Font("宋体",Font.BOLD, 16));
	    	    this.setForeground(Color.GRAY);
	    	    this.showingHint = true;
	    	 
	    	    super.addFocusListener(this);
	    	  }

	    	  @Override
	    	  public void focusGained(FocusEvent e) {
	    	    if(this.getText().equals(hint)) {
	    	      super.setText("");
	    	      this.setForeground(Color.black);
	    	      showingHint = false;
	    	    }
	    	  }
	    	  @Override
	    	  public void focusLost(FocusEvent e) {
	    	    if(this.getText().equals(hint)) {
	    	      super.setText(hint);
	    	      this.setForeground(Color.GRAY);
	    	      showingHint = true;
	    	    }
	    	  }

	    	  @Override
	    	  public String getText() {
	    	    return showingHint ? hint : super.getText();
	    	  }
		
	    	   
	    	    @Override
	    	    public boolean contains(int x, int y) {
	    	        shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight() , 15 , 15) ;
	    	        return shape.contains(x, y);
	    	    }
	    	    @Override
	    	    protected void paintComponent(Graphics g) {
	    	        super.paintComponent(g);
	    	        Graphics2D g2 = (Graphics2D) g ;
	    	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    	        g2.setColor(Color.gray);
	    	        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
	    	        g2.setColor(new Color(0, 0, 0, 0));
	    	        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arcW, arcH);
	    	    }
		
		
	}
	
	
	
	


