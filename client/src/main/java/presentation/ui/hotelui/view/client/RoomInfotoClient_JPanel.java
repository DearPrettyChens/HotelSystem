package presentation.ui.hotelui.view.client;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.CalendarPanel;
import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;

/**
 * 顾客查看房型列表的面板
 * @author cy
 * @version 1.0
 * 
 */
public class RoomInfotoClient_JPanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Color color =new Color(148,221,184);
	
	private MyTextfield fromtimejtf=new MyTextfield("请选择日期");
	private MyTextfield totimejtf=new MyTextfield("请选择日期");
	

	
	private CalendarPanel p1 = new CalendarPanel(fromtimejtf, "yyyy/MM/dd");  
	private CalendarPanel p2 = new CalendarPanel(totimejtf, "yyyy/MM/dd");  
	
	private MyButton  searchjb=new MyButton();
	
	
	private ArrayList<SingleRoomInfotoClient_JPanel> singleinfos=new ArrayList<SingleRoomInfotoClient_JPanel>();
	
	private JPanel titlejp=new JPanel();
	private JLabel roomtypejl=new JLabel("房型");
	private JLabel bedtypejl=new JLabel("床型");
	private JLabel pricejl=new JLabel("价格");
	
	private JLabel checkinjl=new JLabel("入住");
	private JLabel checkoutjl=new JLabel("退房");
	
	
	
	public RoomInfotoClient_JPanel(ArrayList<SingleRoomInfotoClient_JPanel> singleinfos){
		
		this.singleinfos=singleinfos;
		
		this.setSize(800,100);
    	this.setLayout(null);
    	this.setBackground(Color.white);
    	addComp();
		
	}
	
    public RoomInfotoClient_JPanel(){
		
    	this.setSize(800,600);
    	this.setLayout(null);
    	this.setBackground(Color.white);
    	addComp();
    	
		
	}
	
    
    public void addComp(){
    	
fromtimejtf.setBounds(140,10,150,30);
       	
       	this.add(fromtimejtf);
       	
       	p1.initCalendarPanel(); 
       	JLabel l1 = new JLabel("日历面板");  
        p1.add(l1);  
        this.add(p1);  
     
        checkinjl.setBounds(100,10,100,30);
        checkinjl.setFont(font);
        this.add(checkinjl);
        
         
        totimejtf.setBounds(340,10,150,30);
       	
       	this.add(totimejtf);
       
       	p2.initCalendarPanel(); 
       	JLabel l2 = new JLabel("日历面板");  
        p2.add(l2);  
        this.add(p2);  
         
        checkoutjl.setBounds(300,10,100,30);
        checkoutjl.setFont(font);
        this.add(checkoutjl);
    	
    	titlejp.setBackground(color);
    	titlejp.setLayout(null);
    	titlejp.setBounds(50,50,700,50);
    	this.add(titlejp);
    	
    	roomtypejl.setFont(font);
    	roomtypejl.setBounds(50,10,100,30);
    	titlejp.add(roomtypejl);
    	
    	bedtypejl.setFont(font);
    	bedtypejl.setBounds(150,10,100,30);
    	titlejp.add(bedtypejl);
    	
    	pricejl.setFont(font);
    	pricejl.setBounds(250,10,100,30);
    	titlejp.add(pricejl);
    	
    	
    	searchjb.setText("搜索");
    	searchjb.setBounds(500,10,100,30);
    	this.add(searchjb);
    	
    	
    	int size=singleinfos.size();
    	for(int i=0;i<size;i++){
    		
    		SingleRoomInfotoClient_JPanel tempinfo=singleinfos.get(i);
    		tempinfo.setBounds(0,100+i*50,800,50);
    		this.add(tempinfo);
    		
    		
    		
    	}
    	
    }
    
    

	
	
	
}
