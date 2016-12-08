package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
	
	    public MyTextfield(String s){
	    	

	    	  
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
		
		
		
		
	}
	
	
	
	


