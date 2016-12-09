package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 顾客看到的所有的该酒店的评论信息
 * @author cy
 * @version 1.0
 * 
 */
public class HotelRemarktoClient_JPanel  extends JPanel{
	private ArrayList<SingleHotelRemarktoClient_JPanel > singleinfos=new ArrayList<SingleHotelRemarktoClient_JPanel >();
	
	public HotelRemarktoClient_JPanel(){
		
		this.setSize(800,400);
		this.setLocation(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
	}
	
	public HotelRemarktoClient_JPanel(ArrayList<SingleHotelRemarktoClient_JPanel > singleinfos){
		
		this.singleinfos=singleinfos;
		this.setSize(800,400);
		this.setLocation(null);
		this.setBackground(Color.white);
		addComp();
		
	}
	
	
	public void addComp(){
		
		int size=singleinfos.size();
		for(int i=0;i<size;i++){
			
			SingleHotelRemarktoClient_JPanel tempinfo=singleinfos.get(i);
			tempinfo.setBounds(0,100*i,800,100);
			this.add(tempinfo);
			
			
		}
		
		
		
	};
	

}
