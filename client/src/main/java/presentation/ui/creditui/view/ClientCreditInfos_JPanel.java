package presentation.ui.creditui.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * 顾客用来存放单条信用记录的面板
 * @author cy
 * @version 1.0
 * 
 */
public class ClientCreditInfos_JPanel  extends JPanel{
	
	private ArrayList< SingleCreditinfo_JPanel> singleinfos=new ArrayList< SingleCreditinfo_JPanel>();
	
	public ClientCreditInfos_JPanel(ArrayList< SingleCreditinfo_JPanel> singleninfos){
		
		this.singleinfos=singleinfos;
		
		this.setBackground(Color.white);
		this.setLayout(null);
		addComp();
		
		
		
	}
	
	
	
	public ClientCreditInfos_JPanel(){
		
		
		
		this.setBackground(Color.white);
		this.setLayout(null);
		addComp();
		
		
	}
	
	
	
	public void addComp(){
		int size=singleinfos.size();
		
		
		for(int i=0;i<size;i++ ){
			int locy=i/2;
			int locx=i%2;
			
			
			SingleCreditinfo_JPanel tempinfo=singleinfos.get(i);
			 tempinfo.setBounds(locx*400,locy*300,400,300);
			 this.add(tempinfo);
			 
			
		}
		
		
		
	}

}
