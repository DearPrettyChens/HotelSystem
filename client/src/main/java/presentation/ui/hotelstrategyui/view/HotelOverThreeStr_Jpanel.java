package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyTextfield;

public class HotelOverThreeStr_Jpanel extends JPanel{
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	private Color color =new Color(148,221,184);
	
	
	private JLabel title=new JLabel("三间级以上策略");
	private int  roomnumber;
	private int count;
	
	
	private JLabel roomnumberjl=new JLabel("满足该策略的最小房间数量：");
	private JLabel countjl=new JLabel("折扣值");
	
	
	private MyTextfield roomnumberjtf=new MyTextfield("");
	private MyTextfield countjtf=new MyTextfield("");
	
	
	
	
	public HotelOverThreeStr_Jpanel(int roomunber,int count){
		this.roomnumber=roomnumber;
		this.count=count;
		
		roomnumberjtf.setText(""+roomnumber);
		
		countjtf.setText(""+count);
		
		
		
		
	}
	
	
	public HotelOverThreeStr_Jpanel(){
		
		this.setLayout(null);
		this.setBackground(Color.white);
	
		this.setSize(800,500);
		
		
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
    	title.setBounds(100,200,300,50);
    	this.add(title);
    	
    	
    	
    	
    	
    
    }

}
