package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;

/**
 * 
 * 特殊时期策略策略
 * @author cy
 * @version 1.0
 * 
 */
public class HotelSpecialTimeStr_JPanel   extends JPanel {
	    
	  
	    private JLabel titlejl=new JLabel("合作企业顾客折扣策略");
	    
	    private Font font=new Font("宋体",Font.BOLD, 18);
	    
	    
	    private MyButton canclejb=new MyButton();
		private MyButton confirmjb=new MyButton();
		private MyButton addjb=new MyButton();
		
		
	    
	    ArrayList<SingleHotelSpecialTimeStr> singleinfos=new  ArrayList<SingleHotelSpecialTimeStr>();
	    
	     public HotelSpecialTimeStr_JPanel(){
	    	 
	    	 //this.singleinfos=到逻辑层拿
	    	 
	    	 
	   this.setLayout(null); 
	   this.setBackground(Color.white);
	   addComps(); 
	    	 
	     }
	
	void addComps(){
		
		canclejb.setText("取消");
		canclejb.setBounds(600,500,80,30);
		this.add(canclejb);
		
		confirmjb.setText("确定");
		confirmjb.setBounds(500,500,80,30);
		this.add(confirmjb);
		
		addjb.setText("增加");
		addjb.setBounds(400,500,80,30);
		addjb.addActionListener(new ActionListener(){
			
			
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				SingleHotelSpecialTimeStr newinfo=new SingleHotelSpecialTimeStr();
				HotelSpecialTimeStr_JPanel.this.singleinfos.add(newinfo);
				newinfo.setBounds(0,100+HotelSpecialTimeStr_JPanel.this.singleinfos.size()*50,800,50);
				HotelSpecialTimeStr_JPanel.this.add(newinfo);
				HotelSpecialTimeStr_JPanel.this.repaint();
				
			}
			
		});
		this.add(addjb);
		
		titlejl.setFont(font);
		titlejl.setBounds(20,30,300,50);
		this.add(titlejl);
		
		
		for(int i=0;i<singleinfos.size();i++){
			SingleHotelSpecialTimeStr tempinfo=singleinfos.get(i);
			
			tempinfo.setBounds(0,100+50*i,800,50);
			this.add(tempinfo);
			
			
			
		}
		
	}

	
	
	
}
