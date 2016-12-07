package presentation.ui.orderui.view.client;
import presentation.ui.tools.*;
import presentation.ui.userui.view.Changepassword_JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * 
 * 顾客进行酒店预订的操作
 * @author cy
 * @version 1.0
 * 
 */
public class MakeOrdertoClient_JPanel  extends JPanel{
	
	private ConfirmCounttoClient_JPanel  confirmcountjp ;//确认优惠信息的面板 ，大小为800*300，放在0*200位置下面
	private WriteOrdertoClient_JPanel  writeorderjp;//填写订单的面板，同上
	
	
	
    private ImageIcon icon1=new ImageIcon("image//yuan1.png");
    private ImageIcon icon2=new ImageIcon("image//yuan2.png");
    private ImageIcon icon3=new ImageIcon("image//xuxian2.png");
    
    private JLabel successjl=new JLabel("预订成功！");
    
    private  MyButton button1=new MyButton();
    private  MyButton button2=new MyButton();
    
    private JLabel circle1=new JLabel(icon1);
    private JLabel circle2=new JLabel(icon2);
    private JLabel circle3=new JLabel(icon2);
    private JLabel line1=new JLabel(icon3);
    private JLabel line2=new JLabel(icon3);
    
    private JLabel oldpasswordjl=new JLabel("填写订单");
    private JLabel newpasswordjl=new JLabel("优惠信息");
    private JLabel makechangejl=new JLabel("预订成功");
    
    private Font font=new Font("宋体",Font.BOLD, 16);
    
    
	public MakeOrdertoClient_JPanel(ConfirmCounttoClient_JPanel  confirmcountjp,WriteOrdertoClient_JPanel  writeorderjp){
		
		
		this.setBackground(Color.white);
		this.setLayout(null);
		
		addComp();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public MakeOrdertoClient_JPanel(){
		this.setBackground(Color.white);
		this.setLayout(null);
		
		addComp();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	 
    /**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	
    	circle1.setBounds(150,20,100,100);
    	this.add(circle1);
    	circle2.setBounds(350,20,100,100);
    	this.add(circle2);
    	circle3.setBounds(550,20,100,100);
    	this.add(circle3);
    	line1.setBounds(250,20,100,100);
    	this.add(line1);
    	line2.setBounds(450,20,100,100);
    	this.add(line2);
    	
    	oldpasswordjl.setBounds(175,20,100,100);
    	oldpasswordjl.setFont(font);
    	this.add(oldpasswordjl);
    	newpasswordjl.setBounds(375,20,100,100);
    	newpasswordjl.setFont(font);
    	this.add(newpasswordjl);
    	
    	makechangejl.setBounds(570,20,100,100);
    	makechangejl.setFont(font);
    	this.add(makechangejl);
    	
    	
    	successjl.setFont(font);
    	successjl.setForeground(Color.red);
    	successjl.setBounds(350,300,200,50);
    	//this.add(makechangeJl);
    	
    	
    	button1.setText("下一步，确认优惠信息");
    	button1.setBounds(300,500,200,30);
    	button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MakeOrdertoClient_JPanel.this.remove(button1);
				MakeOrdertoClient_JPanel.this.add(button2);
				
				
				MakeOrdertoClient_JPanel.this.circle1.setIcon(icon2);
				MakeOrdertoClient_JPanel.this.circle2.setIcon(icon1);
				MakeOrdertoClient_JPanel .this.repaint();
			}
    		
    	});
    	this.add(button1);
    	
    	button2.setText("确认");
    	button2.setBounds(300,500,200,30);
    	button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				MakeOrdertoClient_JPanel.this.circle2.setIcon(icon2);
				MakeOrdertoClient_JPanel.this.circle3.setIcon(icon1);
				
				
				MakeOrdertoClient_JPanel.this.remove(button2);
				MakeOrdertoClient_JPanel.this.add(successjl);
				MakeOrdertoClient_JPanel .this.repaint();
			}
			
    	});
    	//this.add(button2);
    	
    	
    	
    	
    	
    	
    	//this.add(oldpasswordJl);
    	
    	
    	
    	//this.add(oldpasswordfield);
    	
	
    	
    	
    	
    	
	
	
    }
	
    
   
    
	

}
