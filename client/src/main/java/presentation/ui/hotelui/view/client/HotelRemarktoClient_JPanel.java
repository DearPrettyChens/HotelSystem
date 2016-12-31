package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.NewClient_JLabel;

/**
 * 顾客看到的所有的该酒店的评论信息
 * 
 * 
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class HotelRemarktoClient_JPanel  extends JPanel{
	private ArrayList<SingleHotelRemarktoClient_JPanel > singleinfos=new ArrayList<SingleHotelRemarktoClient_JPanel >();
	private ArrayList<String > remarkDetailInfos;
	private double score=5.0;
	private JLabel scorejl=new JLabel("评分：");
	private JLabel scorejl1=new JLabel();
	private JLabel remarkjl=new JLabel("评论：");
	private JLabel remarkNumberjl=new JLabel();
	private int number;
	private Color color=new Color(234,119,93);
	private Color color1=new Color(148,208,169);
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	public HotelRemarktoClient_JPanel(ArrayList<String > remarkDetailInfo,double remarkNumber){
		
		this.score=remarkNumber;
		this.remarkDetailInfos=remarkDetailInfo;
	    this.number=remarkDetailInfo.size();
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
	}
	
	
	public void addComp(){
		

    	
		scorejl.setBounds(120,25,100,30);
    	scorejl.setFont(font);
    	this.add(scorejl);
    	
    	scorejl1.setText(score+"");
    	scorejl1.setBounds(170,25,50,30);
    	scorejl1.setFont(font);
    	scorejl1.setForeground(color);
    	this.add(scorejl1);
    	
    	
		remarkjl.setBounds(120,60,100,30);
    	remarkjl.setFont(font);
    	this.add(remarkjl);
    	
    	remarkNumberjl.setText(number+"条");
    	remarkNumberjl.setBounds(170,60,50,30);
    	remarkNumberjl.setFont(font);
//    	remarkNumberjl.setForeground(color);
    	this.add(remarkNumberjl);
		
		for(String s:remarkDetailInfos){
			SingleHotelRemarktoClient_JPanel singleHotelRemarktoClient_JPanel=new SingleHotelRemarktoClient_JPanel(s);
	        singleinfos.add(singleHotelRemarktoClient_JPanel);
		}
		
		int size=singleinfos.size();
		for(int i=0;i<size;i++){
			
			SingleHotelRemarktoClient_JPanel tempinfo=singleinfos.get(i);
			tempinfo.setBounds(0,100+100*i,800,100);
			this.add(tempinfo);
			
		}
		
		this.setSize(700, 100+100*size);
		
	}
	

}
