package presentation.ui.hotelui.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import presentation.ui.orderui.view.SingleOrderListInfotoClient;

/**
 * 顾客浏览酒店时，看到的自己在该酒店的订单
 * @author cy
 * @version 1.0
 * @param <SingleOrderListInfotoClient>
 * 
 */
public class HotelOrdertoClient_JPanel  extends JPanel{
      
	private ArrayList<SingleOrderListInfotoClient> singleinfos=new ArrayList<SingleOrderListInfotoClient>();
	
	
	public  HotelOrdertoClient_JPanel(ArrayList<SingleOrderListInfotoClient> singleinfos){
		
		
		this.singleinfos=singleinfos;
		this.setSize(800,400);
		this.setLocation(null);
		this.setBackground(Color.white);
		addComp();
		
		
	}
	
    public  HotelOrdertoClient_JPanel(){
		
    	this.setSize(800,400);
		this.setLocation(null);
		this.setBackground(Color.white);
		addComp();
		
	}
	
    
    public void addComp(){
    	
    	
    	

		int size=singleinfos.size();
		for(int i=0;i<size;i++){
			
			SingleOrderListInfotoClient tempinfo=singleinfos.get(i);
			tempinfo.setBounds(0,100*i,800,100);
			this.add(tempinfo);
			
			
		}
		
		
		
	};
	
    }
	

