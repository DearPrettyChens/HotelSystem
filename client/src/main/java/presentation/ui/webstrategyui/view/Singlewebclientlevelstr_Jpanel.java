package presentation.ui.webstrategyui.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 修改网站营销策略时，单条的会员等级策略
 * @author cy
 * @version 1.0
 * 
 */
public class Singlewebclientlevelstr_Jpanel  extends JLabel{
	private Font font=new Font("宋体",Font.BOLD, 20);
	private int level;
	private int count;
	private JLabel leveljl=new JLabel("会员等级："); 
	private JLabel countjl=new JLabel("折扣值："); 
	private JTextField leveljtf=new JTextField(); 
	private JTextField countjtf=new JTextField(); 
	Singlewebclientlevelstr_Jpanel(int level,int cout){
		this.level=level;
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
	    	leveljl.setBounds(200,15,200,30);
	    	leveljl.setFont(font);
	    	this.add(leveljl);
	    	
	    	leveljtf.setBounds(300,15,100,30);
	    	leveljtf.setText(level+"");
	    	this.add(leveljtf);
	    	
	    	
	    	countjl.setBounds(430,15,200,30);
	    	countjl.setFont(font);
	    	this.add(countjl);
	    	
	    	countjtf.setBounds(500,15,100,30);
	    	countjtf.setText(count+"");
	    	this.add(countjtf);
	    	
	    	
	    	
	    }
	
	
	
	
}
