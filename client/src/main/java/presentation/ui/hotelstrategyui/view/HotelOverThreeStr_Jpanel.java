package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;

/**
 * 三间及三间以上策略
 * @author cy
 * @version 1.0
 * 
 */
public class HotelOverThreeStr_Jpanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 20);
	
	
	
	private JLabel title=new JLabel("三间级以上策略");
	private int  roomnumber;
	private int count;
	
	
	private JLabel roomnumberjl=new JLabel("满足该策略的最小房间数量:");
	private JLabel countjl=new JLabel("折扣值:");
	
	
	private MyTextfield roomnumberjtf=new MyTextfield("");
	private MyTextfield countjtf=new MyTextfield("");
	
	private MyButton canclejb=new MyButton();
	private MyButton confirmjb=new MyButton();

	
	
	
	public HotelOverThreeStr_Jpanel(int roomunber,int count){
		this.roomnumber=roomnumber;
		this.count=count;
		
		roomnumberjtf.setText(""+roomnumber);
		
		countjtf.setText(""+count);
		
		this.setLayout(null);
		this.setBackground(Color.white);
	
		this.setSize(800,600);
		
		
		addComp();
		
		
		
	}
	
	
	public HotelOverThreeStr_Jpanel(){
		
		this.setLayout(null);
		this.setBackground(Color.white);
	
		this.setSize(800,600);
		
		
		addComp();
		
		
	}
	
	
	
	
	 /**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	title.setFont(font);
    	title.setBounds(20,50,300,50);
    	this.add(title);
    	
    	
    	roomnumberjl.setFont(font);
    	roomnumberjl.setBounds(200,200,300,50);
    	this.add(roomnumberjl);
    	
    	
    	
    	roomnumberjtf.setFont(font);
    	roomnumberjtf.setBounds(500,200,200,50);
    	roomnumberjtf.setText(roomnumber+"");
    	this.add(roomnumberjtf);
    	
    	countjl.setFont(font);
    	countjl.setBounds(200,300,200,50);
    	this.add(countjl);
    	
    	countjtf.setFont(font);
    	countjtf.setBounds(300,300,200,50);
    	countjtf.setText(count+"");
    	this.add(countjtf);
    	
    	canclejb.setText("取消");
		canclejb.setBounds(600,500,80,30);
		this.add(canclejb);
		
		confirmjb.setText("确定");
		confirmjb.setBounds(500,500,80,30);
		this.add(confirmjb);
    	
    	
    	
    
    }

}
