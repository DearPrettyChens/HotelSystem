package businesslogic.blservice.searchhotelblservice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;

/**
 * 录入客房信息的界面
 * @author cy
 * @version 1.0
 * 
 */
public class RoomInfo_JPanel  extends JPanel {
	
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private JLabel title=new JLabel("录入客房信息");
	
	private MyButton confirmjb=new MyButton();
	private MyButton canclejb=new MyButton();
	private MyButton addjb=new MyButton();
	
	ArrayList<SingleRoomInfo_JPanel> singleinfos=new ArrayList<SingleRoomInfo_JPanel>();
	
	public RoomInfo_JPanel(ArrayList<SingleRoomInfo_JPanel> singleinfos){
		
		this.singleinfos=singleinfos;
		
		
		this.setSize(800,50);
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
	}

	
	public void addComp(){
		
		
		title.setFont(font);
		title.setBounds(20,10,200,30);
		this.add(title);
		
		
		for(int i=0;i<singleinfos.size();i++){
			
			SingleRoomInfo_JPanel tempinfo=singleinfos.get(i);
			
			tempinfo.setBounds(0,50+i*50,800,50);
			this.add(tempinfo);
			
			
			
		}
		
		addjb.setText("增加");
		addjb.setBounds(400,550,30,80);
		this.add(addjb);
		
		canclejb.setText("取消");
		canclejb.setBounds(500,550,30,80);
		this.add(canclejb);
		
		confirmjb.setText("确认");
		confirmjb.setBounds(600,550,30,80);
		confirmjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SingleRoomInfo_JPanel newsingleinfo=new SingleRoomInfo_JPanel();
				singleinfos.add(newsingleinfo);
				int size=singleinfos.size();
				newsingleinfo.setBounds(0,size*50+50,800,50);
				RoomInfo_JPanel.this.add(newsingleinfo);
				RoomInfo_JPanel.this.repaint();
			}
			
		});
		this.add(confirmjb);
		
		
		
	}
	
	
	
}
