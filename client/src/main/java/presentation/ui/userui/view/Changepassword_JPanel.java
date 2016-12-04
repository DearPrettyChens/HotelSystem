package presentation.ui.userui.view;
import presentation.ui.tools.*;
import util.UserType;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Changepassword_JPanel  extends JPanel{
	private UserType userType;
	
	private MyTextfield oldpasswordfield=new MyTextfield("请输入旧密码");
	private MyTextfield newpasswordfield=new MyTextfield("请输入新密码");
	private JLabel oldpasswordJl=new JLabel("旧密码");
	private JLabel newpasswordJl=new JLabel("新密码");
	private JLabel makechangeJl=new JLabel("修改密码成功！");
    private ImageIcon icon1=new ImageIcon("image//yuan1.png");
    private ImageIcon icon2=new ImageIcon("image//yuan2.png");
    private ImageIcon icon3=new ImageIcon("image//xuxian2.png");
    
    private  MyButton button1=new MyButton();
    private  MyButton button2=new MyButton();
    
    private JLabel circle1=new JLabel(icon1);
    private JLabel circle2=new JLabel(icon2);
    private JLabel circle3=new JLabel(icon2);
    private JLabel line1=new JLabel(icon3);
    private JLabel line2=new JLabel(icon3);
    
    private JLabel oldpasswordjl=new JLabel("旧密码");
    private JLabel newpasswordjl=new JLabel("新密码");
    private JLabel makechangejl=new JLabel("修改成功");
    
    private Font font=new Font("宋体",Font.BOLD, 16);
    
    
	public Changepassword_JPanel(UserType type){
		this.userType=type;
		this.setBackground(Color.white);
		this.setLayout(null);
		
		addComp();
		this.setBounds(0, 0, 800, 600);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	 
    /**
     * 添加组件
    * @param
    * @return
    * @throws 未定
    */
    public void addComp(){
    	
    	
    	circle1.setBounds(150,100,100,100);
    	this.add(circle1);
    	circle2.setBounds(350,100,100,100);
    	this.add(circle2);
    	circle3.setBounds(550,100,100,100);
    	this.add(circle3);
    	line1.setBounds(250,100,100,100);
    	this.add(line1);
    	line2.setBounds(450,100,100,100);
    	this.add(line2);
    	
    	oldpasswordjl.setBounds(175,100,100,100);
    	oldpasswordjl.setFont(font);
    	this.add(oldpasswordjl);
    	newpasswordjl.setBounds(375,100,100,100);
    	newpasswordjl.setFont(font);
    	this.add(newpasswordjl);
    	makechangejl.setBounds(570,100,100,100);
    	makechangejl.setFont(font);
    	this.add(makechangejl);
    	
    	makechangeJl.setFont(font);
    	makechangeJl.setForeground(Color.red);
    	makechangeJl.setBounds(350,300,200,50);
    	//this.add(makechangeJl);
    	
    	
    	button1.setText("下一步，输入新密码");
    	button1.setBounds(300,400,200,50);
    	button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Changepassword_JPanel.this.remove(button1);
				Changepassword_JPanel.this.add(button2);
				Changepassword_JPanel.this.remove(oldpasswordfield);
				Changepassword_JPanel.this.add(newpasswordfield);
				Changepassword_JPanel.this.remove(oldpasswordJl);
				Changepassword_JPanel.this.add(newpasswordJl);
				Changepassword_JPanel.this.circle1.setIcon(icon2);
				Changepassword_JPanel.this.circle2.setIcon(icon1);
				Changepassword_JPanel .this.repaint();
			}
    		
    	});
    	this.add(button1);
    	
    	button2.setText("确认新密码");
    	button2.setBounds(300,400,200,50);
    	button2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				Changepassword_JPanel.this.circle2.setIcon(icon2);
				Changepassword_JPanel.this.circle3.setIcon(icon1);
				Changepassword_JPanel.this.remove(newpasswordfield);
				Changepassword_JPanel.this.remove(newpasswordJl);
				Changepassword_JPanel.this.remove(button2);
				Changepassword_JPanel.this.add(makechangeJl);
				Changepassword_JPanel .this.repaint();
			}
			
    	});
    	//this.add(button2);
    	
    	
    	oldpasswordJl.setFont(font);
    	oldpasswordJl.setBounds(230,300,200,50);
    	this.add(oldpasswordJl);
    	
    	newpasswordJl.setFont(font);
    	newpasswordJl.setBounds(230,300,200,50);
    	//this.add(oldpasswordJl);
    	
    	
    	oldpasswordfield.setBounds(300,300,200,50);
    	this.add(oldpasswordfield);
    	newpasswordfield.setBounds(300,300,200,50);
    	//this.add(oldpasswordfield);
    	
	
    	
    	
    	
    	
	
	
    }
	
    
   
    
	

}
