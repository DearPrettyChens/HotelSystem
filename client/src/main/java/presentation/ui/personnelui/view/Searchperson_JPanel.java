package presentation.ui.personnelui.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.ui.tools.MyTextfield;

/**
 * 网站管理人员搜索的面板
 * @author cy
 * @version 1.0
 * 
 */
public class Searchperson_JPanel extends JPanel{
	private JButton searchjb=new JButton();
	private MyTextfield searchjtf=new MyTextfield("用户名/编号/联系方式");
	
	
	 public Searchperson_JPanel(){
	 this.setBackground(new Color(148,221,184));
	 this.setSize(600,50);
	 this.setLayout(null);
	 addComp();
	 
	
	
	 }
	 
	 
	 /**
	    * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    	
	    	searchjtf.setBounds(10,5,550,40);
	    	this.add(searchjtf);
	    	
	    	
	    	
	    	
	    	searchjb.setBounds(550, 10, 40, 40);
	        ImageIcon icon5 = new ImageIcon("image//search1.png");
	        searchjb.setIcon(icon5);
	        
	        searchjb.setBorderPainted(false);
	        searchjb.setOpaque(false);
	        
	        
	        searchjb.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        	
	        });
	    	
	    	this.add(searchjb);
	    	
	    	
	    	
	    }
	    
	    

}
