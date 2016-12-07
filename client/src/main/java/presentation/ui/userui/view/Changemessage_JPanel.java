package presentation.ui.userui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.ui.tools.MyButton;
import presentation.ui.tools.MyTextfield;



public class Changemessage_JPanel extends JPanel {
	
	private Font font=new Font("宋体",Font.BOLD, 16);
	
	private JLabel name=new JLabel("XXX");
	private JLabel teljl=new JLabel("联系方式:");
	private JLabel birthdayjl=new JLabel("生  日:");
	private JLabel creditjl=new JLabel("信用值 :");
	private JLabel leveljl=new JLabel("会员等级:");
	private MyTextfield tel=new MyTextfield("");
	private JLabel birthday=new JLabel("");
	private JLabel credit=new JLabel("");
	private JLabel level=new JLabel("");
	
	private JLabel image=new JLabel();
	
	private JLabel editimg=new JLabel();
	
	public Changemessage_JPanel(){
		
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
    	
    	
      name.setBounds(100,350,200,50);
      name.setFont(font);
      this.add(name);
      
    	
      teljl.setBounds(300,100,300,50);
      teljl.setFont(font);
      this.add(teljl);
      
      birthdayjl.setBounds(300,200,300,50);
      birthdayjl.setFont(font);
      this.add(birthdayjl);
      
      creditjl.setBounds(300,300,300,50);
      creditjl.setFont(font);
      this.add(creditjl);
      
      leveljl.setBounds(300,400,300,50);
      leveljl.setFont(font);
      this.add(leveljl);
      
    	
      tel.setBounds(400,100,200,50);
      tel.setEditable(false);
      this.add(tel);
      
      ImageIcon icon=new ImageIcon ("image//edit.png");
      image.setIcon(icon);
      image.setBounds(500,100,30,30);
      this.add(image);
      
      
      image.addMouseListener(new MouseAdapter(){
    	  
    	  @Override
          public void mouseEntered(MouseEvent e) {
         	 
          }

          @Override
       public void mouseExited(MouseEvent e) {
         	 
          }
          
         public void mouseClicked(MouseEvent e) {
        	  tel.setEditable(true);
          }
      });
    	  
      
    	
    }
	
	

}
