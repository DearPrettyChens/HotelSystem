package presentation.ui.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 左边的选择栏
 * @author cy
 * @version 1.0
 * 
 */
public class Basic_JPanel extends JPanel{
	
	 private JLabel jl4=new JLabel();
	 
	 ArrayList <Basic_JPanel>   allpanel;
	 int tab;
	
	public Basic_JPanel(String s,String image,int tab, ArrayList <Basic_JPanel>   allpanel){
		 this.tab=tab;
		 this.allpanel=allpanel;
		 JLabel jl1=new JLabel();
		 jl1.setText(s);
		 jl1.setFont(new Font("宋体",Font.BOLD, 16));
		 jl1.setForeground(Color.white);
		 
		 ImageIcon icon=new ImageIcon(image);
		 JLabel jl2=new JLabel(icon);
		 jl2.setBounds(20,20,30,30);
		 this.add(jl2);
		 
		 ImageIcon icon1=new ImageIcon("image//triangle.png");
		 jl4.setIcon(icon1);
		 jl4.setBounds(180,30,20,20);
		 this.add(jl4);
		 jl4.setVisible(false);
		 
		 
		 
		 
		 jl1.setBounds(60, 0,120, 80);
		 //jl1.setOpaque(true);
		
        
      	this.setBackground( new Color(148,221,184));
      	
      	this.setLayout(null);
      	this.add(jl1);
this.addMouseListener(new MouseListener(){

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Basic_JPanel.this.setBackground(new Color(133,196,163));
		Basic_JPanel.this.jl4.setVisible(true);
		for(int i=0;i<allpanel.size();i++){
		    if(i!=Basic_JPanel.this.tab){
		    	
		    	allpanel.get(i).setBackground(new Color(148,221,184));
		    	
		    	allpanel.get(i).jl4.setVisible(false);
		    	
		    }
			
			
		}
		
		
		
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
		// TODO Auto-generated method stub
		jl1.setFont(new Font("宋体",Font.BOLD, 17));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		jl1.setFont(new Font("宋体",Font.BOLD, 16));
	}
	
});
      	
		
		
		
		
		
	}
	
	
	
	
	
	

}
