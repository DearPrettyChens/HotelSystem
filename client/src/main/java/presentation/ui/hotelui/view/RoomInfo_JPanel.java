package presentation.ui.hotelui.view;

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
 * 所有房间信息的面板，供酒店工作人员录入客房信息时增加或修改
 * @author cy
 * @version 1.0
 * 
 */
public class RoomInfo_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 20);
	
	private JLabel titlejl=new JLabel("录入客房信息");
	
	private MyButton addjb=new MyButton();
	
	private MyButton canclejb=new MyButton();
	
	private MyButton confirmjb=new MyButton();
	
	
	private ArrayList<SingleRoomInfo_JPanel> singleinfo=new ArrayList<SingleRoomInfo_JPanel>();
	
	public RoomInfo_JPanel(ArrayList<SingleRoomInfo_JPanel> singleinfo){
		this.singleinfo=singleinfo;
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,600);

		
		
		addComp();
		
		
		
		
		
		
		
	}
	
	
	public RoomInfo_JPanel(){
		
		this.setLayout(null);
		this.setBackground(Color.white);
		this.setSize(800,600);

		
		
		addComp();
		
		
	}
	
	
	
	public void addComp(){
		
		titlejl.setFont(font);
		titlejl.setBounds(0,0,800,50);
		this.add(titlejl);
		
		
		int size=singleinfo.size();
		for(int i=0;i<size;i++){
			
			
			SingleRoomInfo_JPanel tempinfo=singleinfo.get(i);
			
			tempinfo.setBounds(0,50+50*i,800,50);
			this.add(tempinfo);
			
			
		}
		
		
		
		addjb.setText("增加");
		addjb.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SingleRoomInfo_JPanel newsingleinfo=new SingleRoomInfo_JPanel();
				RoomInfo_JPanel.this.singleinfo.add(newsingleinfo);
				int size=RoomInfo_JPanel.this.singleinfo.size();
				
				newsingleinfo.setBounds(0,50+50*size,800,50);
				RoomInfo_JPanel.this.add(newsingleinfo);
				RoomInfo_JPanel.this.repaint();
				
				
			}
			
		});
		addjb.setBounds(600,550,80,30);
		this.add(addjb);
		
		canclejb.setText("取消");
		canclejb.setBounds(700,550,80,30);
		this.add(canclejb);
		
		confirmjb.setText("确认");
		confirmjb.setBounds(800,550,80,30);
		this.add(confirmjb);
		
	}
	
	
	
	

}
