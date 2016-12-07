package presentation.ui.hotelui.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 顾客查看预订过的酒店，界面上是酒店列表信息
 * @author cy
 * @version 1.0
 * 
 */
public class HotelHasOrdered_JPanel  extends JPanel{
	
	private ArrayList <HotelListInfo_JPanel> singleinfos=new ArrayList <HotelListInfo_JPanel> ();
	
	public HotelHasOrdered_JPanel( ArrayList <HotelListInfo_JPanel> singleinfos){
		
		this.singleinfos=singleinfos;
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(800,600);
		addComp();
		
		
		
		
	}
	
	public void addComp(){
	    int size=singleinfos.size();
		
		for(int i=0;i<size;i++){
			HotelListInfo_JPanel tempinfo=singleinfos.get(i);
			tempinfo.setBounds(0,100*i,800,100);
			
			
		}
		
		
		
		
	}
	
	
}
