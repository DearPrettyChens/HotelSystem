package presentation.ui.checkinui.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * 酒店工作人员进行线下入住退房管理
 * @author cy
 * @version 1.0
 * 
 */
public class OfflineCheckIn_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private JLabel  titlejl=new JLabel("可用客房数量修改");
	private ArrayList< SingleAvailableRoomInfo_JPanel > singleinfos=new ArrayList< SingleAvailableRoomInfo_JPanel >();
	
	
	public OfflineCheckIn_JPanel(ArrayList< SingleAvailableRoomInfo_JPanel > singleinfos ){
		
		this.singleinfos=singleinfos ;
		this.setLayout(null);
		this.setSize(800,600);
		this.setBackground(Color.white);
		addComp();
		
	}
	
	
    public OfflineCheckIn_JPanel(){
		
		this.setLayout(null);
		this.setSize(800,600);
		this.setBackground(Color.white);
		addComp();
		
	}
    
    public void addComp(){
    	
    	titlejl.setFont(font);
    	titlejl.setBounds(50,10,300,30);
    	this.add(titlejl);
    	
    	int size=singleinfos.size();
    	
    	
    	for(int i=0;i<size;i++){
    		SingleAvailableRoomInfo_JPanel tempsingleinfo=singleinfos.get(i);
    		tempsingleinfo.setBounds(0,50+50*i,800,50);
    		this.add(tempsingleinfo);
    		
    		
    		
    		
    	}
    	
    	
    	
    	
    	
    }
    
	

}
