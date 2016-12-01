package presentation.ui.hotelstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 单条的特殊时期优惠
 * @author cy
 * @version 1.0
 * 
 */
public class SingleHotelSpecialTimeStr  extends JPanel{
	private String time="";
	private int count;
	
	
	private Font font=new Font("宋体",Font.BOLD, 18);
	
	
	private JLabel timejl=new JLabel("时间:");
	private JTextField timejtf=new JTextField();
	
	private JLabel countjl=new JLabel("折扣值:");
	private JTextField countjtf=new JTextField();
	
	public SingleHotelSpecialTimeStr(String time,int count){
		this.time=time;
		this.count=count;
		timejtf.setText(time);
		countjtf.setText(count+"");
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
		
		
	}
	
	
	public SingleHotelSpecialTimeStr(){
		
		
		
		
		this.setLayout(null);
		this.setBackground(Color.white);
		addComp();
		
		
		
		
		
	}
	
	
	
	public void addComp(){
		
		
		
		timejl.setFont(font);
		timejl.setBounds(50,10,200,30);
		this.add(timejl);
		
		timejtf.setFont(font);
		timejtf.setBounds(150,10,200,30);
		this.add(timejtf);
		
		
		countjl.setFont(font);
		countjl.setBounds(400,10,100,30);
		this.add(countjl);
		
		
		countjtf.setFont(font);
		countjtf.setBounds(500,10,100,30);
		this.add(countjtf);
		
	}
	
}
