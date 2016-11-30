package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 修改网站营销策略时，单条的特殊时期策略
 * @author cy
 * @version 1.0
 * 
 */
public class Singlewebspecialtimestr_JPanel  extends JLabel{
	private Font font=new Font("宋体",Font.BOLD, 20);
	private String begintime;
	private String endtime;
	private int count;
	private JLabel begintimejl=new JLabel("起始时间：");
	private JLabel endtimejl=new JLabel("结束时间：");
	private JLabel countjl=new JLabel("折扣值："); 
	private JTextField begintimejtf=new JTextField(); 
	private JTextField endtimejtf=new JTextField();
	private JTextField countjtf=new JTextField();
	Singlewebspecialtimestr_JPanel(String begintime,String endtime,int cout){
		this.begintime=begintime;
		this.endtime=endtime;
		this.count=count;
		this.setLayout(null);
		this.setBackground(Color.white);
	    
	    this.setSize(800,50);
		addComp();
		
	}
	

	
	 /**
	    * 添加组件
	    * @param
	    * @return
	    * @throws 未定
	    */
	    public void addComp(){
	    	begintimejl.setBounds(100,15,200,30);
	    	begintimejl.setFont(font);
	    	this.add(begintimejl);
	    	
	    	begintimejtf.setBounds(200,15,100,30);
	    	begintimejtf.setText(begintime+"");
	    	this.add(begintimejtf);
	    	
	    	
	    	endtimejl.setBounds(300,15,200,30);
	    	endtimejl.setFont(font);
	    	this.add(endtimejl);
	    	
	    	endtimejtf.setBounds(400,15,100,30);
	    	endtimejtf.setText(endtime+"");
	    	this.add(endtimejtf);
	    	
	    	
	    	countjl.setBounds(500,15,200,30);
	    	countjl.setFont(font);
	    	this.add(countjl);
	    	
	    	countjtf.setBounds(600,15,100,30);
	    	countjtf.setText(count+"");
	    	this.add(countjtf);
	    	
	    	
	    	
	    }
	
	
	
	
}
