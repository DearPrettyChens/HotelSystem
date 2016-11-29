package presentation.ui.tools;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 
 * 
 * 制定网站营销策略时，包含所有的特殊商圈策略面板
 * @author cy
 * @version 1.0
 * 
 */
public class Webspecialtimestr_JPanel  extends JPanel{
	
	private MyButton addjb=new MyButton();
	private MyButton confirmjb=new MyButton();
	 private ArrayList<Singlewebspecialtimestr_JPanel> singleinfo=new  ArrayList<Singlewebspecialtimestr_JPanel>();
	 
	
	public Webspecialtimestr_JPanel(ArrayList<Singlewebspecialtimestr_JPanel> singleinfo){
		this.singleinfo=singleinfo;
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,500);
		
		addComp();
		
		
	
		
		
	}
	
	
	/**
	    * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    	
	    	
	    	int size=singleinfo.size();
	    	System.out.print(size);
	    	for(int i=0;i<size;i++){
	    		
	    		Singlewebspecialtimestr_JPanel tempsinglieinfo=	singleinfo.get(i);
	    		tempsinglieinfo.setBounds(0,50*i,800,50);
	    		this.add(tempsinglieinfo);
	    		
	    		System.out.print("xixi");
	    		
	    	}
	    
	    addjb.setText("增加");
	    addjb.setBounds(600,400,100,30);
	    addjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Singlewebspecialtimestr_JPanel newsingleinfo=new Singlewebspecialtimestr_JPanel("","",0);
				singleinfo.add(newsingleinfo);
				
				newsingleinfo.setBounds(0,(singleinfo.size()-1)*50,800,50);
				Webspecialtimestr_JPanel.this.add(newsingleinfo);
				Webspecialtimestr_JPanel.this.repaint();
			}
	    	
	    	
	    });
	    this.add(addjb);
	    
	    	
	    confirmjb.setText("确认");
	    confirmjb.setBounds(600,450,100,30);
	    this.add(confirmjb);
	    
	    }
	
	

}
