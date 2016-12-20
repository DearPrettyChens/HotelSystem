package presentation.ui.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Clientbasic_JButton  extends JButton{
	private ImageIcon icon1;
	private ImageIcon icon2;
	public Clientbasic_JButton(String s1,String s2){
		icon1=new ImageIcon(Clientbasic_JButton.class.getResource(s1));
		icon2=new ImageIcon(Clientbasic_JButton.class.getResource(s2));
		
		
		this.setSize(200,200);
		this.setIcon(icon1);
		this.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Clientbasic_JButton.this.setIcon(icon2);
            	
            
                
            }
        });
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
